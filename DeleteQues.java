/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DeleteQues extends HttpServlet {
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String s1=request.getParameter("text");
      
        
         PrintWriter out=response.getWriter();
        try{
                Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineSurvey? useSSL = false","root","root");
                Statement st=con.createStatement();
                
               st.executeUpdate("delete from Ans where QID='"+s1+"'");
               st.executeUpdate("delete from Ques where QID='"+s1+"'");

              con.close();
               
        
        out.println("<html>");
         out.println("<head>");
         out.println("<script type=\"text/javascript\">");
         out.println("alert('Question Deleted succesfully')");
         out.println("location='DeleteQues.html';");
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

   
