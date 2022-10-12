package buba.com.cn.controller;

import buba.com.cn.dao.Impl.SoliderDaoImpl;
import buba.com.cn.dao.SoliderDao;
import buba.com.cn.entity.Service;
import buba.com.cn.service.Impl.ServiceDaoImpl;
import buba.com.cn.service.ServiceDao;
import buba.com.cn.utils.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class serviceservlet extends ViewBaseServlet {
  protected SoliderDao soliderDao=new SoliderDaoImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
     resp.setContentType("text/html;charset=utf-8");
       if (req.getParameter("method").equals("findAllSoldiers")){
           this.findAllSoldiers(req,resp);
       }
       if (req.getParameter("method").equals("addSoldiers")){
           this.addSoldiers(req,resp);
       }
       if (req.getParameter("method").equals("add")){
           this.add(req,resp);
       }
       if (req.getParameter("method").equals("delSoldier")){
           this.delSoldier(req,resp);
       }  if (req.getParameter("method").equals("upd")){
           this.upd(req,resp);
       }if (req.getParameter("method").equals("addkk")){
           this.addkk(req,resp);
       }

    }
    protected void findAllSoldiers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Service> allSoldiers = soliderDao.findAllSoldiers();
        req.setAttribute("allSoldiers",allSoldiers);
        processTemplate("list",req,resp);

    }
    protected void addSoldiers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processTemplate("add",req,resp);
    }
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid = req.getParameter("sid");
        String department = req.getParameter("department");
        String sname = req.getParameter("sname");
        String province = req.getParameter("province");
        String numbera = req.getParameter("numbera");
        String slock = req.getParameter("slock");
        Service solider = new Service(Integer.valueOf(sid),  Integer.valueOf(department), sname,province,Integer.valueOf(numbera),slock);
        System.out.println(solider);
        soliderDao.addSoldiers(solider);
        this.findAllSoldiers(req,resp);


    }
    protected void upd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid = req.getParameter("sid");
        String department = req.getParameter("department");
        String sname = req.getParameter("sname");
        String province = req.getParameter("province");
        String numbera = req.getParameter("numbera");
        String slock = req.getParameter("slock");
        Service solider = new Service(Integer.valueOf(sid),  Integer.valueOf(department), sname,province,Integer.valueOf(numbera),slock);
        System.out.println("修改后的值"+solider);
        soliderDao.updateSoldier(solider);
        this.findAllSoldiers(req,resp);


    }  protected void addkk(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.findAllSoldiers(req,resp);


    }


    protected void delSoldier(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String[] ids = req.getParameterValues("id");
        String[] names = req.getParameterValues("name");
        System.out.println(names);
        System.out.println(ids);
//    req.setAttribute("ids",req,resp);
        for (String name:names
             ) {
            if (name.equals("删除")){

                for (String itemm:ids
                ) {
                    System.out.println(itemm);
                    soliderDao.delSoldier(Integer.valueOf(itemm));}
                this.findAllSoldiers(req,resp);
            }
            if (name.equals("编辑")){
                for (String itemm:ids) {
                    System.out.println(itemm);
                    Service dept = soliderDao.dept(Integer.valueOf(itemm));
                    System.out.println(dept);
                    req.setAttribute("dept",dept);
                }
                processTemplate("update",req,resp);
            }


        }

    }
}
