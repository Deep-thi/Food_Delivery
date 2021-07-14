<%@ page import ="java.sql.*" %>
<%
    String email = request.getParameter("email");    
    String password = request.getParameter("password");
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","deeps", "deeps");
    Statement st = con.createStatement();
    ResultSet rs;
    rs = st.executeQuery("select * from cust_info where email='" + email + "' and password='" + password + "'");
     
    if (rs.next()) {
        session.setAttribute("email", email);
        //out.println("welcome " + userid);
        //out.println("<a href='logout.jsp'>Log out</a>");
        response.sendRedirect("restaurant.html");
    } else {
        request.setAttribute("errorMessage", "Invalid user or password");
        request.getRequestDispatcher("/index.html").forward(request, response);
        //out.println("Invalid password <a href='index.jsp'>try again</a>");
    }
%>