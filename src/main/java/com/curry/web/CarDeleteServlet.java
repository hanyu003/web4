package com.curry.web;

import com.curry.service.car.CarService;
import com.curry.service.car.CarServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2019/3/13 0013.
 */
@WebServlet("/car/del")
public class CarDeleteServlet extends HttpServlet {
    CarService carService = new CarServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        carService.delete(id);
        resp.sendRedirect("list");
    }
}
