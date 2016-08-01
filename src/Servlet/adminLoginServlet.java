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
 * Time: 19:09
 */
@WebServlet("/adminLoginServlet")
public class adminLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO userDAO=new UserDAO();
        HttpSession session=request.getSession();
        PrintWriter pw=response.getWriter();
        String loginName=request.getParameter("loginName");
        String password=request.getParameter("password");
        User user=userDAO.loginSelect(loginName,password);
        if(null == user.getName() || 0 == user.getTag()){
            pw.println("failure");
        }else{
            session.setAttribute("user",user);
            pw.println("success");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
