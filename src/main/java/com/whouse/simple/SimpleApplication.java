package com.whouse.simple;

import com.whouse.simple.entity.Order;
import com.whouse.simple.entity.Person;
import com.whouse.simple.entity.Product;
import com.whouse.simple.repository.OrderRepository;
import com.whouse.simple.repository.PersonRepository;
import com.whouse.simple.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class SimpleApplication {

	private static final Logger log = LoggerFactory.getLogger(SimpleApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SimpleApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ProductRepository repository, PersonRepository pr, OrderRepository or) {
		return (args) -> {
			repository.save(new Product("Product-1", "article-p1", "until", 10.5 ));
			repository.save(new Product("Product-2", "article-p2", "until", 8.12 ));
			repository.save(new Product("Product-3", "article-p3", "until", 0.2 ));
			repository.save(new Product("Product-4", "article-p4", "until", 44.0 ));
			repository.save(new Product("Product-5", "article-p5", "until", 10.5 ));
			repository.save(new Product("Product-6", "article-p6", "until", 8.12 ));
			repository.save(new Product("Product-7", "article-p7", "until", 0.2 ));
			repository.save(new Product("Product-8", "article-p8", "until", 44.0 ));

			Product tProduct = new Product("T Product-1", "article-tp1", "until", 13.5 );
			repository.save(tProduct);

			Person tPerson = new Person("T.Person");
			pr.save(tPerson);

			Order tOrder = new Order(10, 245.0, tProduct, tPerson);
			or.save(tOrder);

			log.info("FindAll");
			log.info("-----------------------------");
			for(Product product: repository.findAll()) {
				log.info(product.toString());
			}
			log.info("");

			log.info("Find by id = 2");
			log.info("-----------------------------");
			Optional<Product> p = repository.findById(2L);
			log.info(p.toString());
			log.info("");

			log.info("Find by name = duct");
			log.info("-----------------------------");
			repository.findByNameContainsIgnoreCase("duct").forEach(
					item -> {
						log.info(item.toString());
					}
			);

//			log.info("-----------------------------");
//			for ( Product pr: repository.findByNameContains("1")) {
//				log.info(pr.toString());
//			}
//			log.info("");
		};
	}
}
