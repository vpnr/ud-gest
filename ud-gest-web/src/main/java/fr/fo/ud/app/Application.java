package fr.fo.ud.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ITemplateResolver;

@SpringBootApplication(scanBasePackages="fr.fo.ud")
@EnableJpaRepositories(basePackages= {"fr.fo.ud"})
@EntityScan(basePackages= {"fr.fo.ud"})
@ComponentScan(basePackages = {"fr.fo.ud"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(ApplicationContext ctx) { 
//		return args -> {
//			System.out.println("Beans thats spring boot provided");
//			String[] beanNames = ctx.getBeanDefinitionNames();
//			Arrays.sort(beanNames);
//			for (String beanName : beanNames) {
//				System.out.println(beanName);
//			}
//		};
//	}
	
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder app) {
//		return app.sources(Application.class);
//	}
}
