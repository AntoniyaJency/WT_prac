import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ex8a extends HttpServlet {
    int count = 0; // shared by all users

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        count++; // increase count each time page loads

        out.println("<html><body>");
        out.println("<h2>Common Page Visit Counter</h2>");
        out.println("<p>Total visits by all users: " + count + "</p>");
        out.println("</body></html>");
    }
}

