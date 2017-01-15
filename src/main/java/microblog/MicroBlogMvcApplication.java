package microblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*loads default configuration settings for our Spring Boot application
(finds and loads all entities, controllers, UI templates and other application assets)*/

@SpringBootApplication
public class MicroBlogMvcApplication
{
    public static void main(String[] args)
    {
        //runs the embedded Tomcat server
        SpringApplication.run(MicroBlogMvcApplication.class, args);
    }
}