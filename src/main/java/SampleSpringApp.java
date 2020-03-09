import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.client.RestTemplate;
import thor.stormbreaker.avengers.Avenger;
import thor.stormbreaker.avengers.Impl.CaptainAmerica;
import thor.stormbreaker.model.Joke;

public class SampleSpringApp {

    public static void main(String[] args) {
        ApplicationContext appContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Avenger avenger = appContext.getBean("captainAmerica", CaptainAmerica.class);
        avenger.highlightSpecialPower();
        String url = "https://safe-falls-22549.herokuapp.com/random_joke";
        RestTemplate restTemplate = appContext.getBean("springRestTemplate", RestTemplate.class);
        Joke response = restTemplate.getForObject(url, Joke.class);
        System.out.println(response);
    }
}
