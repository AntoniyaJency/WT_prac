import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class prac1 extends HttpServlet {

    int count = 0;   // static counter for submissions

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        count++;  // Increase count on each form submit

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h2>Form Submitted Successfully!</h2>");
        out.println("<h3>Total Submissions So Far: " + count + "</h3>");
    }
}
