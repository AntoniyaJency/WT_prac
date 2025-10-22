import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ex8b extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(); // create or get user session
        Integer count = (Integer) session.getAttribute("count");

        if (count == null) {
            count = 1; // first visit
        } else {
            count = count + 1; // next visits
        }

        session.setAttribute("count", count);

        out.println("<html><body>");
        out.println("<h2>Individual Page Visit Counter</h2>");
        out.println("<p>You have visited this page " + count + " times.</p>");
        out.println("</body></html>");
    }
}
