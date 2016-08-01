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
 * Time: 16:37
 */
@WebServlet( "/SelectServlet")
public class SelectServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MessageDAO messageDAO=new MessageDAO();
        request.setCharacterEncoding("UTF-8");
        String author=request.getParameter("author");
        if(null == author || "" == author){
            request.setAttribute("messageList",messageDAO.getAllMessage());
        }else{
            request.setAttribute("messageList",messageDAO.selectByAuthor(author));
        }
        request.getRequestDispatcher("index.jsp").forward(request,response);        //页面转发
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
