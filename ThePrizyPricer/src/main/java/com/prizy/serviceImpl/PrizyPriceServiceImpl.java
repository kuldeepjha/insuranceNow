package com.prizy.serviceImpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.BooleanLiteral;

import com.prizy.dto.ProductLoaderInDto;
import com.prizy.dto.ProductLoaderOutDto;
import com.prizy.model.ProductLoaderModel;
import com.prizy.repository.PrizyPriceRepository;
import com.prizy.service.PrizyPriceService;

public class PrizyPriceServiceImpl implements PrizyPriceService{

	@Autowired
	PrizyPriceRepository prizyPriceRepository;
	
	@Autowired
	ProductLoaderModel productLoaderModel;
	
	@Autowired
	ProductLoaderOutDto productLoaderOutDto;
	
	@Override
	public String productLoader(ProductLoaderInDto productLoaderInDto) {
		
		BeanUtils.copyProperties(productLoaderInDto, productLoaderModel);
		prizyPriceRepository.save(productLoaderModel);
		return "Success";
	}

	@Override
	public List<ProductLoaderModel> productList() {
		return prizyPriceRepository.findAll();
	}

	@Override
	public ProductLoaderModel productView(int id) {
		
		productLoaderModel = prizyPriceRepository.findById(id);
		BeanUtils.copyProperties(productLoaderModel, productLoaderOutDto);
		productLoaderOutDto.setAvgPrice(prizyPriceRepository.findAvgPrice(productLoaderOutDto.getProductBarCode()));
		productLoaderOutDto.setHightPrice(prizyPriceRepository.findAvgPrice(productLoaderOutDto.getProductBarCode()));
		productLoaderOutDto.setLowestPrice(prizyPriceRepository.findMinprice(productLoaderOutDto.getProductBarCode()));
		productLoaderOutDto.setIdealPrice(idealPrice);
		productLoaderOutDto.getPricesCollected();
		return productLoaderModel;
	}

}
