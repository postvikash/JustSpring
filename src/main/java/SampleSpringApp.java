import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import thor.stormbreaker.avengers.Avenger;
import thor.stormbreaker.avengers.Impl.CaptainAmerica;

public class SampleSpringApp {
    public static void main(String[] args) {
        ApplicationContext appContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Avenger avenger = appContext.getBean("captainAmerica", CaptainAmerica.class);
        avenger.highlightSpecialPower();
    }
}
