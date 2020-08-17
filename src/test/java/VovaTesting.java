import com.github.tomakehurst.wiremock.WireMockServer;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Arrays;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class VovaTesting {

    @Test
    public void test(){
        Response response = RestAssured
                .given()
                .baseUri("https://swapi.dev")
                .when()
                .get("/api/people/?page=1");

        People peoples = parse(response);

        int count = peoples.results().length;
        Assert.assertEquals(count, 10, "People count is wrong(expected 10)");

        String homeworld = Arrays.stream(peoples.results())
                .filter(x -> x.name().equals("Luke Skywalker"))
                .map(Result::homeworld)
                .findFirst()
                .orElseThrow(()-> new RuntimeException(" Luke Skywalker is not founded"));


        Response response2 = RestAssured
                .get(homeworld);

        String result2 = response2.jsonPath().getString("name");
        Assert.assertEquals(result2, "Tatooine", "Homeworld is not 'Tatooine'");

    }



    @Test
    public void testMock() {
        WireMockServer wireMockServer = new WireMockServer();
        wireMockServer.start();
        configureFor("localhost", 8080);
        stubFor(get(urlEqualTo("/api/people/?page=1")).willReturn(aResponse().withStatus(503)));

        Response response3 = RestAssured
                .get("http://localhost:8080/api/people/?page=1");

        response3.getStatusCode();

        Assert.assertEquals(response3.getStatusCode(), 504, "status code should be 504.");

        wireMockServer.stop();
    }

    @Test
    public void testMock2() {
        WireMockServer wireMockServer = new WireMockServer();
        wireMockServer.start();
        stubFor(get(urlEqualTo("/api/people/?page=1")).willReturn(aResponse().withStatus(404)));

        Response response3 = RestAssured
                .get("http://localhost:8080/api/people/?page=1");

        response3.getStatusCode();

        Assert.assertEquals(response3.getStatusCode(), 404, "status code should be 404.");

//        wireMockServer.stop();
    }

    public People parse(Response response){

        return response.getBody().as(People.class);
    }
}


