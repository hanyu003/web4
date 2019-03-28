package com.curry.service.car;

import com.curry.Dao.car.CarDao;
import com.curry.Dao.car.CarDaoImpl;
import com.curry.pojo.Car;

import java.util.List;

/**
 * Created by Administrator on 2019/3/13 0013.
 */
public class CarServiceImpl implements CarService {
    CarDao carDao = new CarDaoImpl();
    @Override
    public List<Car> list() {
        return carDao.list();
    }

    @Override
    public int add(Car car) {
        return carDao.add(car);
    }

    @Override
    public int update(Car car) {
        return carDao.update(car);
    }

    @Override
    public int delete(int id) {
        return carDao.delete(id);
    }

    @Override
    public Car getCarBySid(int s_id) {
        return carDao.getCarBySid(s_id);
    }
}
