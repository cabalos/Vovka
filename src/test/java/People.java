import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@AllArgsConstructor
@Getter
@Accessors(fluent = true)
public class People {

    @JsonProperty(value= "count", required = true)
    private final int count;

    @JsonProperty(value= "next", required = true)
    private final String next;

    @JsonProperty(value= "previous", required = true)
    private final String previous;

    @JsonProperty(value= "results", required = true)
    private final Result[] results;


}
