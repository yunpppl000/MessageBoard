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
 * Time: 19:50
 */
@WebServlet( "/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO userDAO=new UserDAO();
        PrintWriter pw=response.getWriter();
        HttpSession session=request.getSession(false);
        User user=(User)request.getAttribute("user");
        int id=user.getId();
        String oldpassword=request.getParameter("oldpassword");
        String newpassword=request.getParameter("newpassword");
//        System.out.println(oldpassword+".............."+newpassword);
        if(userDAO.changePassword(id,oldpassword,newpassword)){
            session.invalidate();
            pw.println("success");
        }else{
            pw.println("failure");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
