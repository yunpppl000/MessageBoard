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
 * Time: 17:35
 */
@WebServlet("/SelectUserServlet")
public class SelectUserServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO userDAO=new UserDAO();
        request.setCharacterEncoding("UTF-8");
        String username=request.getParameter("user");
        if(null == username || "" == username){
            request.setAttribute("userList",userDAO.getAllUser());
        }else{
            request.setAttribute("userList",userDAO.selectUser(username));
        }
        request.getRequestDispatcher("userManager.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
