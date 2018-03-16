package com.spring.domain.promotion;

import com.spring.domain.product.ConsumerProduct;
import com.spring.domain.product.IndustrialProduct;


public class TradeFair {
	
	private IndustrialProduct industrialProduct;
	private ConsumerProduct consumerProduct;
	
	public int declareIndustrialProductPrice(IndustrialProduct industrialProduct) {
		return industrialProduct.calculatePrice();
	}
	
	public int declareConsumerProductPrice(ConsumerProduct consumerProduct) {
		return consumerProduct.calculatePrice();
	}
	
	public String specialPromotionalString() {
		String priceInfo = "Industrial product is priced at $" + declareIndustrialProductPrice(industrialProduct) + 
							"\nConsumer product is priced at $" + declareConsumerProductPrice(consumerProduct);
		
		return priceInfo;
	}
}
