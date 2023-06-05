package miu.edu.sa.UserLoginClient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ElementLoginClientApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ElementLoginClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		new ClientApp().runLogin();
	}
}
