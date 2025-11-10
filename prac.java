import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class prac extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String cpassword = request.getParameter("cpassword");

        out.println(
            "<html><body>"+
            "<h2>Registration Details</h2>"+
            "<p>Username: " + username + "</p>"+
            "<p>Password: " + password + "</p>"+
            "<p>Email: " + email + "</p>"+  
            "<p>Confirm Password: " + cpassword + "</p>"+
            "</body></html>"
        );
        out.close();
            }
        
}