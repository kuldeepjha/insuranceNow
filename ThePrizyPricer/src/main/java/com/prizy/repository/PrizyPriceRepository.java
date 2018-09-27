package com.prizy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prizy.model.ProductLoaderModel;

@Repository
public interface PrizyPriceRepository extends JpaRepository<ProductLoaderModel, Long>{
	
	@Query("SELECT plm FROM ProductLoaderModel plm WHERE plm.id = :id")
	public ProductLoaderModel findById(@Param("id") int id);
	
	@Query("SELECT avg(plm.price) FROM ProductLoaderModel plm WHERE plm.productBarCode = :productBarCode")
	public double findAvgPrice(@Param("productBarCode") String productBarCode);
	
	@Query("SELECT max(plm.price) FROM ProductLoaderModel plm WHERE plm.productBarCode = :productBarCode")
	public double findMaxprice(@Param("productBarCode") String productBarCode);

	@Query("SELECT min(plm.price) FROM ProductLoaderModel plm WHERE plm.productBarCode = :productBarCode")
	public double findMinprice(@Param("productBarCode") String productBarCode);

}
