package cc.jiangxin.test;

import io.undertow.UndertowOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.undertow.UndertowEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Configuration
@RestController
public class SpringBootHttpApplication {

    @Bean
    public EmbeddedServletContainerCustomizer tomcatCustomizer() {
        return (container) -> {
            if (container instanceof UndertowEmbeddedServletContainerFactory) {
                ((UndertowEmbeddedServletContainerFactory) container)
                        .addBuilderCustomizers((connector) -> connector.setServerOption(UndertowOptions.ENABLE_HTTP2, true));
            }
        };
    }

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String test() {
        return "success!";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootHttpApplication.class, args);
    }
}
