package thinking.study.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaClientServerA {
	public static void main(String[] args) {
		SpringApplication.run(EurekaClientServerA.class, args);
	}
}
