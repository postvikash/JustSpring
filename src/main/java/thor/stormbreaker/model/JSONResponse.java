package thor.stormbreaker.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class JSONResponse {
    private String httpStatusCode;
    private String status;
    private ArrayList<Item> resources;

    public String toString() {
        return resources.toString();
    }
}
