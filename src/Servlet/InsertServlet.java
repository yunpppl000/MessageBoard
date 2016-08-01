package Servlet;

import Model.User;
import Util.MessageDAO;
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
 * Time: 20:25
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MessageDAO messageDAO=new MessageDAO();
        UserDAO userDAO=new UserDAO();
        PrintWriter pw=response.getWriter();
        HttpSession session=request.getSession();
        User user=(User)session.getAttribute("user");
        String content=request.getParameter("content");
        int id=user.getId();
        String author=user.getName();
        int limit=userDAO.getUserLimit(id);

        if(1==limit){
            pw.println("failure");
        }else{
            messageDAO.insertMessage(author,content);
            pw.println("success");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
