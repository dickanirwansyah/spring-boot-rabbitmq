package id.corp.examplerabbitmqconsumer;

import id.corp.examplerabbitmqconsumer.model.Products;
import id.corp.examplerabbitmqconsumer.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class ExampleRabbitmqConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleRabbitmqConsumerApplication.class, args);
	}

}

//@Component
//class CommandData implements CommandLineRunner {
//
//	@Autowired
//	private ProductRepository productRepository;
//
//	@Override
//	public void run(String... args) throws Exception {
//		Products products = productRepository.findProductByCategoryId("c002");
//		System.out.println("HERE ---- > "+products);
//	}
//}
