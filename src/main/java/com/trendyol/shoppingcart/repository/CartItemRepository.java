package com.trendyol.shoppingcart.repository;

import com.trendyol.shoppingcart.model.entity.CartItem;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends CrudRepository<CartItem, Long> {

    @Query("SELECT c FROM CartItem c left join Product p ")
     List<CartItem> findByIds(@Param("ids") List<Long> ids);
}
