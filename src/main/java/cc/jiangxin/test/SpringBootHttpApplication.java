package cc.jiangxin.test;

import org.apache.coyote.http2.Http2Protocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootHttpApplication {

    @Bean
    public EmbeddedServletContainerCustomizer tomcatCustomizer() {
        return (container) -> {
            if (container instanceof TomcatEmbeddedServletContainerFactory) {
                ((TomcatEmbeddedServletContainerFactory) container)
                        .addConnectorCustomizers((connector) -> connector.addUpgradeProtocol(new Http2Protocol()));
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
