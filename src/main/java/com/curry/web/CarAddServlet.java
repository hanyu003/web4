package com.curry.web;

import com.curry.pojo.Car;
import com.curry.pojo.Shop;
import com.curry.service.car.CarService;
import com.curry.service.car.CarServiceImpl;
import com.curry.service.shop.ShopService;
import com.curry.service.shop.ShopServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2019/3/13 0013.
 */
@WebServlet("/car/add")
public class CarAddServlet extends HttpServlet {
    ShopService shopService = new ShopServiceImpl();
    CarService carService = new CarServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        Shop shop = shopService.getShopById(id);
        Car car = carService.getCarBySid(shop.getId());
        if(car==null) {
            car = new Car();
            car.setS_id(shop.getId());
            car.setName(shop.getName());
            car.setType(shop.getType());
            car.setBrand(shop.getBrand());
            car.setPrice(shop.getPrice());
            carService.add(car);
        }else{
            carService.update(car);
        }
        resp.sendRedirect("list");
    }
}
