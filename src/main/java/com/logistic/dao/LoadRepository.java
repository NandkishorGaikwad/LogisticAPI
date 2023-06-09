package com.logistic.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.logistic.entity.Load;

import java.util.List;

@Repository
public interface LoadRepository extends JpaRepository<Load, Long> {
	List<Load> findByShipperId(String shipperId);
}
