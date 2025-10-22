import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ex6 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("username");

        out.println("<html><body>");
        out.println("<h2>Hello, " + name + "!</h2>");
        out.println("<p>This is your Servlet response.</p>");
        out.println("</body></html>");
    }
}
