package com.trendyol.shoppingcart;

import com.trendyol.shoppingcart.model.entity.Cart;
import com.trendyol.shoppingcart.model.entity.Category;
import com.trendyol.shoppingcart.model.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

@SpringBootApplication
@Transactional
public class ShoppingCardApplication implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(ShoppingCardApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
