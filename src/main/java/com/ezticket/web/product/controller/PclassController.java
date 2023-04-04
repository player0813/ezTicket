package com.ezticket.web.product.controller;

import com.ezticket.web.product.pojo.Pclass;
import com.ezticket.web.product.service.PclassService;
import com.ezticket.web.product.service.PcommentService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/PclassController")
public class PclassController extends HttpServlet {

    private PclassService pclassSvc;

    @Override
    public void init() throws ServletException {
        ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        pclassSvc = applicationContext.getBean(PclassService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action =req.getParameter("action");
        //取得所有類別
        if("productClassList".equals(action)){
            List<Pclass> pclassList = pclassSvc.getAllProductClass();
            list2json(pclassList,resp);
        }

    }

    public void list2json(List<Pclass> pclassList, HttpServletResponse resp) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(pclassList);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter pw = resp.getWriter();
        pw.print(json);
        pw.flush();
    }
}
