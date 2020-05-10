package com.trendyol.shoppingcart.repository;

import com.trendyol.shoppingcart.model.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

   // Select * from A a  left join B b on a.id=b.id
   // @Query("SELECT c FROM CartItem c left join Product p ")
   // List<CartItem> findAllActiveUsers(@Param("ids") List<Long> ids);
}
