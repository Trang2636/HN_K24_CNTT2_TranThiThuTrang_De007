package org.example.brandservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BrandServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BrandServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner initData(BrandRepository brandRepository) {
        return args -> {
            if (brandRepository.count() == 0) {
                brandRepository.save(new Brand(null, "Apple"));
                brandRepository.save(new Brand(null, "Samsung"));
                brandRepository.save(new Brand(null, "Xiaomi"));
            }
        };
    }
}
