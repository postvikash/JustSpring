package thor.stormbreaker.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Item {
    private Action action;

    public String toString() {
        return action.toString();
    }
}
