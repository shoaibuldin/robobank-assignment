package nl.rabobank;

import nl.rabobank.mongo.MongoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(MongoConfiguration.class)
public class RaboAssignmentApplication {
    public static void main(final String[] args) {
        System.setProperty("os.arch", "x86_64");
        SpringApplication.run(RaboAssignmentApplication.class, args);
    }
}
