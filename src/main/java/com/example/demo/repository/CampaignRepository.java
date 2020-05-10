package com.example.demo.repository;

import com.example.demo.model.entity.Campaign;
import com.example.demo.model.enums.DiscountType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignRepository extends CrudRepository<Campaign, Long> {

    @Query("SELECT c FROM Campaign c where c.discountType = :discountType and c.category.id in (:ids)")
    List<Campaign> findAllByCategoryIds(@Param("ids")List<Long> ids,@Param("discountType")DiscountType discountType);
}
