package com.hy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//https://pan.baidu.com/share/home?uk=487907638#category/type=0
/**
 * main启动
 */
@SpringBootApplication
/*=@Configuration
@EnableAutoConfiguration
@EnableWebMvc
@ComponentScan*/
@RestController //所有方法都返回数据，不包括jsp视图
@MapperScan("com.hy.mapper")//扫描mapper接口 ，多次扫描会报警告
public class Application {

    @RequestMapping("/")
    public String greeting() {
        return "Application Hello World!";
    }
    @RequestMapping("/users/{username}")
    public String userProfile(@PathVariable("username") String username) {
        return String.format("Application user %s", username);
    }

    @RequestMapping("/posts/{id}")
    public String post(@PathVariable("id") int id) {
        return String.format("Application post %d", id);
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGet() {
        return "Application Login Page";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPost() {
        return "Application Login Post Request";
    }
    
    
    
	public static void main(String[] args) {
    	// System.setProperty("spring.devtools.restart.enabled","false");
    	SpringApplication app=new SpringApplication(Application.class);
    	app.setBannerMode(Mode.OFF);//关闭启动时的图标
    	app.run(args);
    	
    	
    	
    	//SpringApplication.run(Application.class, args);
    }
    
    /**
     * @return 自定义错误页面
     * 默认目录 src/main/resources/static
     */
    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
            	
                ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/error/401.html");
                ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/error/404.html");
                ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500.html");

                container.addErrorPages(error401Page, error404Page, error500Page);
            }
        };
    }
    
    
    
    
    
    
    
	/** 参考
	 * //http://www.cnblogs.com/linux-wangkun/p/5709074.html
	 * 
	 * http://blog.csdn.net/yalishadaa/article/category/6384446
	 * 
	 * http://blog.csdn.net/catoop/article/details/50553714
	 * http://blog.csdn.net/catoop/article/category/5789635
	 * 
	 * https://www.tianmaying.com/tutorial/spring-boot-overview?cm_mc_uid=
	 * 10676213960114960728319&cm_mc_sid_50200000=1496072831
	 * 
	 * https://www.ibm.com/developerworks/cn/java/j-lo-spring-boot/#listing4
	 * 
	 * http://www.cnblogs.com/softidea/p/5699920.html
	 * 
	 * https://my.oschina.net/liuyuantao/blog/791884
	 * 
	 * http://blog.csdn.net/hotdust/article/category/6218779
	 * 
	 * //http://www.cnblogs.com/diegodu/p/5956339.html
	 * 
	 * http://blog.csdn.net/u010412719/article/category/6845978
	 * 自定义错误界面
	 * http://www.jianshu.com/p/6e7651705d29#
	 * maven scrop
	 * http://drizzlewalk.blog.51cto.com/2203401/665590
	 * logback
	 * https://my.oschina.net/u/1027043/blog/406558#comment-list
	 * 查看maven工程中依赖jar包源码
	 * http://blog.csdn.net/zhanghtkdum2/article/details/72528596
	 * http://www.cnblogs.com/longronglang/p/6182006.html
	 * 
	 * 配置
	 * http://www.itkeyword.com/doc/0422543459874141553/spring
	 * http://412887952-qq-com.iteye.com/blog/2307244
	 * http://www.tuicool.com/articles/EjAjM3m
	 * 
	 * http://blog.csdn.net/u013257425/article/details/52972775
	 *
	 *http://blog.csdn.net/albertfly/article/details/51527191
	 *http://blog.csdn.net/u013257425/article/details/52972775
	 */
    
}
    
