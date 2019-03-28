package com.curry.Dao.car;

import com.curry.pojo.Car;


import java.util.List;

/**
 * Created by Administrator on 2019/3/13 0013.
 */

public interface CarDao {
    public List<Car> list();
    public int add(Car car);
    public int update(Car car);
    public int delete(int id);
    public Car getCarBySid(int s_id);
}
