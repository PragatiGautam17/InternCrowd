/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class TRegister extends HttpServlet {
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String s1=request.getParameter("tx1");
       String s2=request.getParameter("tx2");
        String s3=request.getParameter("tx3");
        
         PrintWriter out=response.getWriter();
        try{
                Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineSurvey? useSSL = false","root","root");
                Statement st=con.createStatement();
                  ResultSet rs = st.executeQuery("select * from TRegister where EMAIL='"+s2+"'");
              if(rs.next()){
              
           out.println("<html>");
         out.println("<head>");
         out.println("<script type=\"text/javascript\">");
         out.println("alert('account already exits with corresponding email')");
         out.println("location='TRegister.html';");
          out.println("</script>");
           out.println("</head>");
            out.println("</head>");
              out.println("</html>");
              }
              else{
               st.executeUpdate("insert into Tregister values('"+s1+"','"+s2+"','"+s3+"')");
              
              con.close();
               
        
        out.println("<html>");
         out.println("<body>");
          out.println("<h1>Registration Successfull</h1>");
          out.println("<h1>Login to continue</h1>");
          response.sendRedirect("TLogin.html");
            out.println("</body>");
              out.println("</html>");
    
    }
        }
         catch(Exception e1){
               out.println(e1);
            }
}
}

   
