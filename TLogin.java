
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class TLogin extends HttpServlet {
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String s1=request.getParameter("tx11");
       String s2=request.getParameter("tx22");
       
         PrintWriter out=response.getWriter();
        try{
                Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineSurvey? useSSL = false","root","root");
                Statement st=con.createStatement();
              ResultSet rs = st.executeQuery("select * from TRegister where NAME='"+s1+"' AND PWORD='"+s2+"'");
              if(rs.next()){
                   response.sendRedirect("survey");
              }
              else {
                  out.println("<html>");
         out.println("<head>");
         out.println("<script type=\"text/javascript\">");
         out.println("alert('Invalid username or password')");
         out.println("location='TLogin.html';");
          out.println("</script>");
           out.println("</head>");
            out.println("</head>");
              out.println("</html>");
              }
              con.close();
                  }
            catch(Exception e1){
               out.println(e1);
            }
       
           
    }
}

   
