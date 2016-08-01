package Servlet;

import Util.MessageDAO;

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
 * Time: 20:49
 */
@WebServlet("/UpdataServlet")
public class UpdataServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MessageDAO messageDAO=new MessageDAO();
        PrintWriter pw=response.getWriter();
        int id=Integer.parseInt(request.getParameter("id"));
        String context = request.getParameter("context");
        if(messageDAO.updateMessage(id,context)){
            pw.println("success");
        } else {
            pw.println("failure");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
