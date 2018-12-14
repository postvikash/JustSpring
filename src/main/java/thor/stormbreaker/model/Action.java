package thor.stormbreaker.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Action {
    private String asin;
    private DisplayPrice displayedPrice;

    public String toString() {
        return ("ASIN:"+asin+"\tDisplayedPrice:"+displayedPrice);
    }

}
