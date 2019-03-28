package com.curry.service.shop;

import com.curry.Dao.shop.ShopDao;
import com.curry.Dao.shop.ShopDaoImpl;
import com.curry.pojo.Shop;

import java.util.List;

/**
 * Created by Administrator on 2019/3/13 0013.
 */
public class ShopServiceImpl implements ShopService {
    ShopDao shopDao = new ShopDaoImpl();
    @Override
    public List<Shop> list() {
        return shopDao.list();
    }

    @Override
    public int add(Shop shop) {
        return shopDao.add(shop);
    }

    @Override
    public int update(Shop shop) {
        return shopDao.update(shop);
    }

    @Override
    public int delete(int id) {
        return shopDao.delete(id);
    }

    @Override
    public Shop getShopById(int id) {
        return shopDao.getShopById(id);
    }

    @Override
    public int reback(int id) {
        return shopDao.reback(id);
    }
}
