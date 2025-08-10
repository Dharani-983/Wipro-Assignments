package com.serviceImpl;

import com.service.CartValidator;

public class CartValidatorImpl implements CartValidator {

	@Override
	public boolean validateCart(String cartId) {
		// TODO Auto-generated method stub
		return cartId.equals("CART001");
	}

}
