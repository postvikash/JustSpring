package thor.stormbreaker.model;

import lombok.Setter;

@Setter
public class Joke {
    private String id;
    private String type;
    private String setup;
    private String punchline;

    public String toString() {
        return "\n\n"+setup+"\n"+punchline;
    }
}
