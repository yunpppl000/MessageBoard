package Servlet;

import Model.User;
import Util.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: YEN
 * Date: 2016/7/31
 * Time: 19:34
 */
@WebServlet("/userLoginServlet")
public class userLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO userDAO=new UserDAO();
        PrintWriter pw=response.getWriter();
        HttpSession session=request.getSession();
        String loginName=request.getParameter("loginName");
        String password=request.getParameter("password");
        User user=(User)userDAO.loginSelect(loginName,password);
//        System.out.println(loginName+"....................."+password);
//        System.out.println(user.getName()+"....................."+user.getTag()+"....................."+user.getId()+"....................."+user.getLimit());
        if(null!=user.getName() && 0==user.getTag()){
            session.setAttribute("user",user);
            pw.println("success");
        }else{
            pw.println("failure");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
