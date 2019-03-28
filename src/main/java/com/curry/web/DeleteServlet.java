package com.curry.web;

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
@WebServlet("/shop/del")
public class DeleteServlet extends HttpServlet {
    ShopService shopService = new ShopServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        int flag = Integer.valueOf(req.getParameter("flag"));
        if(flag==1)
            shopService.delete(id);
        else
            shopService.reback(id);
        resp.sendRedirect("list");
    }
}
