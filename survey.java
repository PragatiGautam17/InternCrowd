
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
 
public class survey extends HttpServlet {
    int qid=0;
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
         PrintWriter out=response.getWriter();
        try{
                Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineSurvey? useSSL = false","root","root");
                Statement st=con.createStatement();
            //  ResultSet rs = st.executeQuery("select * from Ques where QID='"+qid+"'");
             out.println("<html>");
              out.println(" <style type=\"text/css\">\n" +
"            body{\n" +
"                background-image: url('wood.png');\n" +
                      "\nfont-size:30px;\n"+
"            }\n" +
                     " div{\n"
                      + "margin-left:250px;\n" +
                       "}\n" +
                      ".tx{background-color: rgba(0,0,0,0.2);border-radius:50px 50px 50px 50px;text-align: center;width: 250px; height: 50px; }"
                  +
               
              
           
"        </style>");
             ResultSet rs = st.executeQuery("select * from Ques");
             out.println("<form action='Done'>");
              out.println("<div>");
              while(rs.next()){
                    out.println("<p>Question : "+rs.getString(1)+"</p>");
                    out.println("<p>Question : "+rs.getString(2)+"</p>");
                     out.println("<p>Option 1 : "+rs.getString(3)+"</p>");
                      out.println("<p>Option 2 : "+rs.getString(4)+"</p>");
                       out.println("<p>Option 3 : "+rs.getString(5)+"</p>");
                        out.println("<p>Option 4 : "+rs.getString(6)+"</p>");
                        ++qid;
                         out.println("<p>Your Answer : <input type='text' class='tx' name=" +qid+ " id="+qid+" required></p>");
                         
                       
//                          out.println("<input type='text' class='tx'>");
              }
             out.println("<input type='submit' value='SUBMIT'>");
              
             qid=0;
//             out.println("<p id='p' name='p' value="+qid+"></p>");
                  out.println("</div>");
out.println("</form>");
              out.println("</html>");
              
              con.close();
                  }
            catch(Exception e1){
               out.println(e1);
            }
       
           
    }
}

   
