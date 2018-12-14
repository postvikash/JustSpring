package thor.stormbreaker.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DisplayPrice {
    private String currency;
    private String value;

    public String toString() {
        return currency+" "+value;
    }
}
