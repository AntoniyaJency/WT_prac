import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ex9 extends HttpServlet {

    String url = "jdbc:mysql://localhost:3306/college";
    String user = "root";
    String password = ""; // Empty if no password

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();

            if (action == null) {
                out.println("<h3>Error: Action not specified!</h3>");
            } 


            else if (action.equals("insertDept")) {

                String deptId = request.getParameter("deptId");
                String deptName = request.getParameter("deptName");
                String nos = request.getParameter("nos");
                stmt.executeUpdate("INSERT INTO department VALUES('" + deptId + "', '" + deptName + "', " + nos + ")");
                out.println("<h3>Record inserted successfully!</h3>");
            } 


            else if ("updateDept".equals(action)) {
                String deptId = request.getParameter("deptId");
                String deptName = request.getParameter("deptName");
                String nos = request.getParameter("nos");

                stmt.executeUpdate("UPDATE department SET deptName='" + deptName + "', nos=" + nos + " WHERE deptId='" + deptId + "'");
                out.println("<h3>Record updated successfully!</h3>");
            }


            else if ("deleteMarks".equals(action)) {
                String regNo = request.getParameter("regNo");

                stmt.executeUpdate("DELETE FROM marks WHERE regNo='" + regNo + "'");
                out.println("<h3>Record deleted successfully!</h3>");
            }


            else if ("selectMarks".equals(action)) {

                String regNo = request.getParameter("regNo");
                ResultSet rs = stmt.executeQuery("SELECT * FROM marks where regNo='" + regNo + "'");
                out.println("<h2>Marks Table Data:</h2>");
                 while (rs.next()) {
            out.println("RegNo: " + rs.getString("RegNo") + "<br>" +
                        "Name: " + rs.getString("Name") + "<br>" +
                        "Dept: " + rs.getString("Dept") + "<br>" +
                        "CGPA: " + rs.getDouble("CGPA") + "<br>" +
                        "Scholarship: " + rs.getString("Scholarship") + "<br><br>");
        }
            }


            else {
                out.println("<h3>Error: Invalid action!</h3>");
            }

            con.close();
        } catch (Exception e) {
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
        }

        out.close();
    }
}
