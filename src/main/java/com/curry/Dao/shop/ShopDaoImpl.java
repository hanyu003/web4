package com.curry.Dao.shop;

import com.curry.pojo.Shop;
import com.curry.util.JDBCUtil;

import java.util.List;

/**
 * Created by Administrator on 2019/3/13 0013.
 */
public class ShopDaoImpl implements ShopDao {
    @Override
    public List<Shop> list() {
        return JDBCUtil.executeQuery("select id,name,type,brand,price,is_del from shop",Shop.class,null);
    }

    @Override
    public int add(Shop shop) {
        return JDBCUtil.executeUpdate("insert into shop(name,type,brand,price,is_del) values(?,?,?,?,1)",shop.getName(),shop.getType(),shop.getBrand(),shop.getPrice());
    }

    @Override
    public int update(Shop shop) {
        return JDBCUtil.executeUpdate("update shop set name=?,type=?,brand=?,price=? where id=?",shop.getName(),shop.getType(),shop.getBrand(),shop.getPrice(),shop.getId());
    }

    @Override
    public int delete(int id) {
        return JDBCUtil.executeUpdate("update shop set is_del=0 where id=?",id);
    }

    @Override
    public Shop getShopById(int id) {
        Shop shop = null;
        List<Shop> list = JDBCUtil.executeQuery("select id,name,type,brand,price,is_del from shop where id=?",Shop.class,id);
        if(list.size()>0)
            shop = list.get(0);
        return shop;
    }

    @Override
    public int reback(int id) {
        return JDBCUtil.executeUpdate("update shop set is_del=1 where id=?",id);
    }

}
