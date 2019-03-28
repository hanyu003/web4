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
import java.math.BigDecimal;

/**
 * Created by Administrator on 2019/3/13 0013.
 */
@WebServlet("/shop/update")
public class UpdateServlet extends HttpServlet {
    ShopService shopService = new ShopServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        Shop shop = shopService.getShopById(id);
        req.setAttribute("shop",shop);
        req.getRequestDispatcher("/WEB-INF/pages/shop/update.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Shop shop = new Shop();
        shop.setId(Integer.valueOf(req.getParameter("id")));
        shop.setName(req.getParameter("name"));
        shop.setType(req.getParameter("type"));
        shop.setBrand(req.getParameter("brand"));
        shop.setPrice(new BigDecimal(req.getParameter("price")));
        shopService.update(shop);
        resp.sendRedirect("list");
    }
}
