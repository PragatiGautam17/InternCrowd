
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ViewResult extends HttpServlet {
    int x=1;
    int serial=1;
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      PrintWriter out=response.getWriter();
        out.println("<html>");
              out.println(" <style type=\"text/css\">\n" +
"            body{\n" +
"                background-image: url('wood.png');\n" +
                      "\nfont-size:30px;\n"+
"            }\n" +
                     " div{\n"
                      + "margin-left:350px;\n" +
                       "}\n" +
                      ".tx{background-color: rgba(0,0,0,0.2);border-radius:50px 50px 50px 50px;text-align: center;width: 250px; height: 50px; }"
                  +
               
              
           
"        </style>");
        out.println("<div>");
        try{
                Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineSurvey? useSSL = false","root","root");
                Statement st=con.createStatement();
                while(x!=4){
              ResultSet rs = st.executeQuery("select * from Ans where QID='"+x+"'");
             out.println("<p>Answer for Question Id : "+x+"</p>");
             while(rs.next()){
                  
                    out.println("<p>"+serial+"-- : "+rs.getString(2)+"</p>");
                    serial++;
                   
              }
             x++;
             serial=1;
                }
                 out.println("</div>");
              con.close();
                  }
            catch(Exception e1){
               out.println(e1);
            }
       
           
    }
}

   
