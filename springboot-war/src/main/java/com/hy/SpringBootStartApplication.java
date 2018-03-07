package com.hy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 部署到tomcat时的启动类
 */
/*@Configuration
@ComponentScan
@EnableAutoConfiguration*/
@SpringBootApplication
@Controller
@MapperScan("com.hy.mapper")
@EnableScheduling
public class SpringBootStartApplication extends SpringBootServletInitializer{
	/**
     * 如果要发布到自己的Tomcat中的时候，需要继承SpringBootServletInitializer类，并且增加如下的configure方法。
     * 如果不发布到自己的Tomcat中的时候，就无需上述的步骤
     */
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder application) {
        //return application.sources(Application.class);
        return application.sources(SpringBootStartApplication.class);
    }
    @RequestMapping("/hello")
    @ResponseBody
    public String greeting() {
        return "Hello World SpringBootStartApplication !";
    }
    
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String loginGet() {
        return "index";//返回index.jsp
    }

    
    /**
     * @return 自定义错误页面
     * 默认目录 src/main/resources/static
     
    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {

        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
            	
                ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/401.html");
                ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
                ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html");

                container.addErrorPages(error401Page, error404Page, error500Page);
            }
        };
    }*/
}
