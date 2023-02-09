
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Done extends HttpServlet {
    int x=1;
   
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
       
       
         PrintWriter out=response.getWriter();
        try{
                Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineSurvey? useSSL = false","root","root");
                Statement st=con.createStatement();
                while(x!=10){
                    String y=""+x;
                 String p=request.getParameter(y);
             if(p.isEmpty()){
                 break;
             }
             else {st.executeUpdate("insert into Ans values('"+x+"','"+p+"')");
             
             x++;
             y="";
             }
                }
             
             
                
              
                out.println("<html>");
         out.println("<head>");
         out.println("<script type=\"text/javascript\">");
         out.println("alert('Thankyou for your time .Survey submitted !')");
         out.println("location='survey';");
          out.println("</script>");
               con.close();
                  }
        
            catch(Exception e1){
                 out.println("<script type=\"text/javascript\">");
                out.println("alert('Thankyou for your time .Survey submitted !')");
         out.println("location='survey';");
         out.println("</script>");
          
            }
       
           out.println("</head>");
            out.println("</head>");
              out.println("</html>");
           
    }
}

   
