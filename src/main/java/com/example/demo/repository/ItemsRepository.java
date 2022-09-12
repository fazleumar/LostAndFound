package com.example.demo.repository;

import com.example.demo.items.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemsRepository extends JpaRepository<Items, Integer> {

    @Query(value = "SELECT * FROM items e WHERE e.title like %:keyword% or e.report_type like %:keyword%", nativeQuery = true)
    List<Items> findByKeyword(@Param("keyword") String keyword);
}