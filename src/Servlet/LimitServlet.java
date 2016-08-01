package Servlet;

import Util.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: YEN
 * Date: 2016/7/31
 * Time: 22:59
 */
@WebServlet("/LimitServlet")
public class LimitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO userDAO=new UserDAO();
        int id=Integer.parseInt(request.getParameter("id"));
        String type=request.getParameter("tag");
        int tag=Integer.parseInt(type);
        if(userDAO.setUserLimit(id,tag)){
            response.sendRedirect("userManager.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
