<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*"%>
<%
String name=request.getParameter("name");

String email=request.getParameter("email");

String password=request.getParameter("password");
String address=request.getParameter("address");
String phone=request.getParameter("phone");
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "deeps", "deeps");
Statement st=conn.createStatement();
int i=st.executeUpdate("insert into cust_info(name,email,password,address,phone)values('"+name+"','"+email+"','"+password+"','"+address+"','"+phone+"')");
//out.println("Thank you for register ! Please <a href='index.html'>Login</a> to continue.");
//String site = new String("index.html");
//response.setStatus(response.SC_MOVED_TEMPORARILY);
//response.setHeader("Location", site); 
response.sendRedirect("restaurant.html");
}
catch(Exception e)
{
System.out.print(e);
e.printStackTrace();
}
%>