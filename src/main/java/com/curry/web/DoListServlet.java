package com.curry.web;

import com.curry.pojo.Shop;
import com.curry.service.shop.ShopService;
import com.curry.service.shop.ShopServiceImpl;

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
@WebServlet("/shop/list")
public class DoListServlet extends HttpServlet {
    ShopService shopService = new ShopServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Shop> list = shopService.list();
        req.setAttribute("list",list);
        req.getRequestDispatcher("/WEB-INF/pages/shop/list.jsp").forward(req,resp);
    }
}
