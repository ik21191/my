package com.ecom.service;

import com.ecom.dao.RemoveCartItemDao;
import com.ecom.dao.RemoveCartItemDaoImpl;

public class RemoveCartItemServiceImpl implements RemoveCartItemService {

	@Override
	public boolean removeParentProductFromCart(long parentProductId, String sessionId) throws Exception {
		RemoveCartItemDao removeCartItemDao = new RemoveCartItemDaoImpl();
		return removeCartItemDao.removeParentProductFromCart(parentProductId, sessionId);
	}

	@Override
	public boolean removeAddonProductFromCart(long addonProductId, String sessionId) throws Exception {
		RemoveCartItemDao removeCartItemDao = new RemoveCartItemDaoImpl();
		return removeCartItemDao.removeAddonProductFromCart(addonProductId, sessionId);
	}

}
