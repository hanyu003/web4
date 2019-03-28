package com.curry.Dao.car;

import com.curry.pojo.Car;
import com.curry.util.JDBCUtil;

import java.util.List;

/**
 * Created by Administrator on 2019/3/13 0013.
 */
public class CarDaoImpl implements CarDao {
    @Override
    public List<Car> list() {
        return JDBCUtil.executeQuery("select id,s_id,name,type,brand,price,count from car",Car.class,null);
    }

    @Override
    public int add(Car car) {
        return JDBCUtil.executeUpdate("insert into car(s_id,name,type,brand,price,count) value(?,?,?,?,?,1)",car.getS_id(),car.getName(),car.getType(),car.getBrand(),car.getPrice());
    }

    @Override
    public int update(Car car) {
        return JDBCUtil.executeUpdate("update car set count=count+1 where id=?",car.getId());
    }

    @Override
    public int delete(int id) {
        return JDBCUtil.executeUpdate("delete from car where id=?",id);
    }

    @Override
    public Car getCarBySid(int s_id) {
        List<Car> list = JDBCUtil.executeQuery("select id,s_id,name,type,brand,price,count from car where s_id=?",Car.class,s_id);
        Car car = null;
        if(list.size()>0)
            car = list.get(0);
        return car;
    }

}
