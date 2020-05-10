package com.trendyol.shoppingcart;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@Transactional
public class ShoppingCartApplication implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(ShoppingCartApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
