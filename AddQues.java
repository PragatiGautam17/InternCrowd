/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AddQues extends HttpServlet {
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String s1=request.getParameter("tx1");
       String s2=request.getParameter("tx2");
        String s3=request.getParameter("o1");
         String s4=request.getParameter("o2");
          String s5=request.getParameter("o3");
           String s6=request.getParameter("o4");
        
         PrintWriter out=response.getWriter();
        try{
                Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineSurvey? useSSL = false","root","root");
                Statement st=con.createStatement();
                
               st.executeUpdate("insert into Ques values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"')");
              
              con.close();
               
        
        out.println("<html>");
         out.println("<head>");
         out.println("<script type=\"text/javascript\">");
         out.println("alert('Question added succesfully')");
         out.println("location='AddQues.html';");
          out.println("</script>");
           out.println("</head>");
            out.println("</head>");
              out.println("</html>");
    
    
        }
         catch(Exception e1){
               out.println(e1);
            }
}
}

   
