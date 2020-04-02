package haust.vk;

import haust.vk.dubbo.CityDubboConsumerService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
		CityDubboConsumerService cityService =run.getBean(CityDubboConsumerService.class);
		cityService.printCity();
	}
}
