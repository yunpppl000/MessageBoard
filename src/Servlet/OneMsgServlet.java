package Servlet;

import Util.MessageDAO;

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
 * Time: 16:42
 */
@WebServlet("/OneMsgServlet")
public class OneMsgServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MessageDAO messageDAO=new MessageDAO();
        int id=Integer.parseInt(request.getParameter("id"));
        request.setAttribute("oneMessage",messageDAO.getOneMessage(id));
        request.getRequestDispatcher("update.jsp").forward(request,response);       //页面转发
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
