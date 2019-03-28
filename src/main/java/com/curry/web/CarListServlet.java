package com.curry.web;

import com.curry.pojo.Car;
import com.curry.service.car.CarService;
import com.curry.service.car.CarServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2019/3/13 0013.
 */
@WebServlet("/car/list")
public class CarListServlet extends HttpServlet {
    CarService carService = new CarServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Car> list = carService.list();
        req.setAttribute("list",list);
        req.getRequestDispatcher("/WEB-INF/pages/car/list.jsp").forward(req,resp);
    }
}
