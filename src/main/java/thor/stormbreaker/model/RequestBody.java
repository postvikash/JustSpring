package thor.stormbreaker.model;

import lombok.Data;

@Data
public class RequestBody {
    final private String asin;
    final private int quantity;

    public RequestBody(String asin, int quantity) {
        this.asin = asin;
        this.quantity = quantity;
    }
}
