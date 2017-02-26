package cc.jiangxin.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootHttpApplication {

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String test() {
        return "success!";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootHttpApplication.class, args);
    }
}
