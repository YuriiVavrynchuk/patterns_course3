package ua.lviv.iot.tripadvisor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ua.lviv.iot.tripadvisor.service.DBLoaderService;

@SpringBootApplication
public class TripadvisorApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(TripadvisorApplication.class, args);
		context.getBean(DBLoaderService.class).dumpCsvToDB("data.csv");
	}
}
