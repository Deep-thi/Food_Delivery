import Test.ShopSessionBeanLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
*
* @author hp
*/
public class ShopServlet extends HttpServlet {
    
ShopSessionBeanLocal shopSessionBean = lookupShopSessionBeanLocal1();


protected void processRequest(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
try (PrintWriter out = response.getWriter()) {
/* TODO output your page here. You may use following sample code. */
out.println("<!DOCTYPE html>");
out.println("<html>");
out.println("<head>");

  out.println("<meta charset=\"utf-8\">");  // escape the quote marks
  out.println("<title>order</title>");
  out.println("<style>");     // start style
  // enclose style attributes withing the <style> </style> elementsa {
  /*background-color: red;
  color: white;
  padding: 1em 1.5em;
  text-decoration: none;
  text-transform: uppercase;
} */
  out.println("h1 {");        // note leading brace
  out.println("color:white;");
  out.println("background-color:#398B93;");
  //out.println("border: 1px solid black;");
  out.println("}"); 
  out.println("a {");
  out.println("background-color:#398B93;");
  out.println("color:white;");
  out.println("padding: 1em 1.5em;");
  out.println("text-decoration: none;");
  out.println("text-transform: uppercase;");
  out.println("}");
  
   // note trailing brace for h1 style
  // add styles for other elements here using similar structure
  // note that separate lines are used for clarity -
  // all of the above could be one println
  out.println("</style>");  // terminate style
 

out.println("</head>");
out.println("<body>");
String action = request.getParameter("action");
if(action.equals("add"))
{
int pid = Integer.parseInt(request.getParameter("items"));
int amt=0;
 if(pid == 1001)
 {
 amt = 120;
 }
 else if(pid == 1002)
 {
 amt = 180;
 }
 else if(pid == 1003)
 {
 amt = 250;
 }
 else if(pid == 1004)
 {
 amt = 300;
 }
 else if(pid == 1005)
 {
 amt = 80;
 }
 else if(pid == 1006)
 {
 amt = 180;
 }else if(pid == 1007)
 {
 amt = 120;
 }
 


shopSessionBean.add(amt);
int total = shopSessionBean.check();
//out.print("<center><h1>Rupees &nbsp;"+amt+" deposited</h1></center><br><br>");
out.print("<center><h1>Total = "+total+" ruppees</h1><br><br><br><br><br><br><br><br></center>");

//request.getSession().setAttribute("total",total);
//request.getRequestDispatcher("buy.jsp").forward(request, response);
//request.setAttribute("total",total);
//request.getRequestDispatcher("buy.jsp").forward(request, response); 
HttpSession session=request.getSession();
session.setAttribute("total",total);

  
 out.println("<center><a href='buy.jsp'>Buy</a><br><br><br><br></center><");
 

out.println("<center><a href='indianaccent.html'>Order more</a></center>");
}
else if(action.equals("remove"))
  {
               int pid = Integer.parseInt(request.getParameter("items"));
               int amt=0;
                if(pid == 1001)
 {
 amt = 120;
 }
 else if(pid == 1002)
 {
 amt = 180;
 }
 else if(pid == 1003)
 {
 amt = 250;
 }
 else if(pid == 1004)
 {
 amt = 300;
 }
 else if(pid == 1005)
 {
 amt = 80;
 }
 else if(pid == 1006)
 {
 amt = 180;
 }else if(pid == 1007)
 {
 amt = 120;
 }
                shopSessionBean.remove(amt);
 int tot = shopSessionBean.check();
 //out.print("<center><h1>Product"+pid+" removed from cart</h1></center><br><br>");
 
 out.print("<center><h1>Total ="+tot+"rupees<h1></center>");
 
  request.getSession().setAttribute("total",tot);
request.getRequestDispatcher("buy.jsp").forward(request, response);

out.println("<center><a href='buy.jsp'>Buy</a></center>");
out.println("<center><a href='indianaccent'>Order more</a></center>");             
              
               
              
            }

out.println("</body>");
out.println("</html>");
}
}

 // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
/**
* Handles the HTTP <code>GET</code> method.
*
* @param request servlet request
* @param response servlet response
* @throws ServletException if a servlet-specific error occurs
* @throws IOException if an I/O error occurs
*/
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
processRequest(request, response);
}

 /**
* Handles the HTTP <code>POST</code> method.
*
* @param request servlet request
* @param response servlet response
* @throws ServletException if a servlet-specific error occurs
* @throws IOException if an I/O error occurs
*/
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
processRequest(request, response);
}

 /**
* Returns a short description of the servlet.
*
* @return a String containing servlet description
*/
@Override
public String getServletInfo() {
return "Short description";
}// </editor-fold>

 

    private ShopSessionBeanLocal lookupShopSessionBeanLocal1() {
        try {
            Context c = new InitialContext();
            return (ShopSessionBeanLocal) c.lookup("java:global/cart/cart-ejb/ShopSessionBean!Test.ShopSessionBeanLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}