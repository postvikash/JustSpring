import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.JSONPObject;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import software.amazon.ion.IonValue;
import thor.stormbreaker.model.RequestBody;
import java.io.IOException;
import java.util.Arrays;

public class SampleSpringApp {

    public static void main(String[] args) throws IOException {
        ApplicationContext appContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        RestTemplate restTemplate = appContext.getBean("springRestTemplate", RestTemplate.class);
        HttpHeaders headers = constructHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject request = new JSONObject();
        try {
            request.put("asin", "BT00LQ4HTY");
            request.put("quantity", 1);
        } catch (Exception e) {

        }
        HttpEntity<?> entity = new HttpEntity<String>(request.toString(), headers);
        MappingJackson2HttpMessageConverter jsonHttpMessageConverter = new MappingJackson2HttpMessageConverter();
        jsonHttpMessageConverter.getObjectMapper().configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        restTemplate.getMessageConverters().add(jsonHttpMessageConverter);
        System.out.println(request.toString());
        try {
            String url = "http://ms-beta-eu.corp.amazon.com/collections/midgard/v1/bundles/Active/items";
            String response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class).getBody();
            System.out.println(response);
        } catch (HttpServerErrorException e) {
            e.printStackTrace();
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
        } catch (RestClientException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
           e.printStackTrace();
        }
    }

    public static HttpHeaders constructHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Amzn-Customer-Id", "A44B7NI0M04N2");
        headers.set("X-Amzn-Session-Id", "0");
        headers.set("X-Amzn-Marketplace-Id", "A2XZLSVIQ0F4JT");
        return headers;
    }

}
