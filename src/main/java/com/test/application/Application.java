package com.test.application;

import com.test.application.service.impl.ProjectService;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author invzbl3 on 12/15/2022
 * @project RestApiApplication
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class Application implements CommandLineRunner {

    private static Logger logger = Logger.getLogger(Application.class);
    private final ProjectService projectService;

    public Application(ProjectService projectService) {
        this.projectService = projectService;
    }

    public static void main(String[] args) throws IOException {
        String propFileName = "log4j.properties";
        InputStream inputStream = Application.class.getClassLoader().getResourceAsStream(propFileName);
        if (inputStream != null) {
            //PropertiesConfigurator is used to configure logger from properties file
            PropertyConfigurator.configure(inputStream);
            logger.debug("log line");
			/*String encoded = new BCryptPasswordEncoder().encode("12345");
			System.out.println(encoded);
			System.out.println(BCrypt.checkpw("12345", "$2a$10$C6Xf6F.QDm.oTdbdrh5T.uJACcnWlIBFnHBk9/LoZEgiwUsVy.b7m"));*/
            SpringApplication.run(Application.class, args);
        } else {
            throw new FileNotFoundException("property file " + propFileName + "not found");
        }
    }

    @Override
    public void run(String... args) throws Exception {
    }
}