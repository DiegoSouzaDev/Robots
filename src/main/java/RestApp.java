import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class RestApp {

    @RequestMapping("/Hi")
    String home() {
        return "Hello World!";
    }
    @RequestMapping("/date")
    String date() {
        return new Date().toString();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(RestApp.class, args);
    }

}