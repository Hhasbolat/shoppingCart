package com.example.demo.repository;

import com.example.demo.model.dto.CampaignDto;
import com.example.demo.model.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

   // Select * from A a  left join B b on a.id=b.id
   // @Query("SELECT c FROM CartItem c left join Product p ")
   // List<CartItem> findAllActiveUsers(@Param("ids") List<Long> ids);
}
