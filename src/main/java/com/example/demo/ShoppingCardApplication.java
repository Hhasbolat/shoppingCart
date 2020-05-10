package com.example.demo;

import com.example.demo.model.dummy.ProductCartItem;
import com.example.demo.model.entity.Cart;
import com.example.demo.model.entity.Category;
import com.example.demo.model.entity.Product;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@Transactional
public class ShoppingCardApplication implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(ShoppingCardApplication.class, args);
    }

    @Autowired
    private EntityManager em;

    @Override
    public void run(String... args) throws Exception {

        Category category = new Category();
        category.setTitle("food");

        Category category2 = new Category();
        category2.setTitle("electronic");


        Product product =new Product();
        product.setPrice(BigDecimal.valueOf(20));
        product.setTitle("ekmek");
        product.setCategory(category);

        Product product2 =new Product();
        product2.setPrice(BigDecimal.valueOf(20));
        product2.setTitle("sucuk");
        product2.setCategory(category);

        Product product3 =new Product();
        product3.setPrice(BigDecimal.valueOf(20));
        product3.setTitle("bilgisayar");
        product3.setCategory(category2);

        Cart cart = new Cart();
        em.persist(cart);

        em.persist(category);
        em.persist(category2);
        em.persist(product);
        em.persist(product2);
        em.persist(product3);

    }
}
