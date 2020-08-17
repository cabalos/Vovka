import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@AllArgsConstructor
@Getter
@Accessors(fluent = true)
public class Result {

    @JsonProperty(value = "name", required = true)
    private final String name;

    @JsonProperty(value = "height", required = true)
    private final String height;

    @JsonProperty(value = "mass", required = true)
    private final String mass;

    @JsonProperty(value = "hair_color", required = true)
    private final String hair_color;

    @JsonProperty(value = "skin_color", required = true)
    private final String skin_color;

    @JsonProperty(value = "eye_color", required = true)
    private final String eye_color;

    @JsonProperty(value = "birth_year", required = true)
    private final String birth_year;

    @JsonProperty(value = "gender", required = true)
    private final String gender;

    @JsonProperty(value = "homeworld", required = true)
    private final String homeworld;

    @JsonProperty(value = "films", required = true)
    private final String[] films;

    @JsonProperty(value = "species", required = true)
    private final String[] species;

    @JsonProperty(value = "vehicles", required = true)
    private final String[] vehicles;

    @JsonProperty(value = "starships", required = true)
    private final String[] starships;

    @JsonProperty(value = "created", required = true)
    private final String created;

    @JsonProperty(value = "edited", required = true)
    private final String edited;

    @JsonProperty(value = "url", required = true)
    private final String url;

}
