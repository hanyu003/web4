package com.curry.service.shop;

import com.curry.pojo.Shop;

import java.util.List;

/**
 * Created by Administrator on 2019/3/13 0013.
 */
public interface ShopService {
    public List<Shop> list();
    public int add(Shop shop);
    public int update(Shop shop);
    public int delete(int id);
    public Shop getShopById(int id);
    public int reback(int id);
}
