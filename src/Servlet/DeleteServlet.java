package Servlet;

import Util.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: YEN
 * Date: 2016/7/31
 * Time: 16:30
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {

    private static final long serialVersionUID=1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw=response.getWriter();
        UserDAO userDAO=new UserDAO();
        int id=Integer.parseInt(request.getParameter("id"));
        if(userDAO.deleteUser(id)){
            pw.println("success");
        }else{
            pw.println("failure");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
