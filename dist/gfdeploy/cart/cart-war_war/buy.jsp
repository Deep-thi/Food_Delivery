<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*"%>
<html>  
 <head>
<title>Shop</title>
<style>
    
body {
   
   * { box-sizing: border-box; }
}

.header {
   background-color: #398B93;
   color: white;
   font-size: 1.5em;
   padding: 0.3rem;
   text-align: center;
   text-transform: uppercase;
}
.button {
  background-color: #398B93;
  border: none;
  color: white;
  padding: 12px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 1em;
  margin: 2px 2px;
  cursor: pointer;
}

img {
   border-radius: 50%;
   height: 60px;
   width: 60px;
}

.table-users {
   border: #398B93;
   border-radius: 10px;
   box-shadow: 3px 3px 0 rgba(0,0,0,0.1);
   max-width: calc(100% - 2em);
   margin: 1em auto;
   overflow: hidden;
   width: 800px;
}

table {
   width: 100%;
   
   td, th { 
      color: #398B93;
      padding: 10px; 
   }
   
   td {
      text-align: center;
      vertical-align: middle;
      
      &:last-child {
         font-size: 0.95em;
         line-height: 1.4;
         text-align: left;
      }
   }
   
   th { 
      background-color: #0C090A;
      font-weight: 300;
   }
   
   tr {     
      &:nth-child(2n) { background-color: white; }
      &:nth-child(2n+1) { background-color: #398B93 }
   }
}

@media screen and (max-width: 700px) {   
   table, tr, td { display: block; }
   
   td {
      &:first-child {
         position: absolute;
         top: 50%;
         transform: translateY(-50%);
         width: 100px;
      }

      &:not(:first-child) {
         clear: both;
         margin-left:100px;
         padding: 4px 20px 4px 90px;
         position: relative;
         text-align: left;

         &:before {
            color: #398B93;
            content: '';
            display: block;
            left: 0;
            position: absolute;
         }
      }

      &:nth-child(2):before { content: 'Name:'; }
      &:nth-child(3):before { content: 'Email:'; }
      &:nth-child(4):before { content: 'Phone:'; }
      &:nth-child(5):before { content: 'Comments:'; }
   }
   
   tr {
      padding:  10px;
      position: relative;
      &:first-child { display: none; }
   }
}

@media screen and (max-width: 500px) {
   .header {
      background-color: transparent;
      color: #398B93;
      font-size: 2em;
      font-weight: 700;
      padding: 0;
      text-shadow: 2px 2px 0 rgba(0,0,0,0.1);
   }
   
   img {
      border: 3px solid;
      border-color: #398B93;
      height:100px;
      margin: 0.5rem 0;
      width: 100px;
   }
   
   td {
      &:first-child { 
         background-color: #398B93;
         border-bottom: #398B93;
         border-radius: 10px 10px 0 0;
         position: relative;   
         top: 0;
         transform: translateY(0);
         width: 100%;
      }
      
      &:not(:first-child) {
         margin: 0;
         padding: 5px 1em;
         width: 100%;
         
         &:before {
            font-size: .8em;
            padding-top: 0.3em;
            position: relative;
         }
      }
      
      &:last-child  { padding-bottom: 1rem !important; }
   }
   
   tr {
      background-color: white !important;
      border: #398B93;
      border-radius: 10px;
      box-shadow: 2px 2px 0 rgba(0,0,0,0.1);
      margin: 0.5rem 0;
      padding: 0;
   }
   
   .table-users { 
      border: none; 
      box-shadow: none;
      overflow: visible;
   }
}
</style>
</head>
<body>
    <div class="table-users">
   <div class="header">Order Confirmed</div>
   
<table cellspacing="0">
<tr>
<td>ADDRESS</td>
<td>PHONE</td>

</tr>
<%
try
{
String email=(String)session.getAttribute("email");

Class.forName("com.mysql.jdbc.Driver");
String url="jdbc:mysql://localhost/test";
String username="deeps";
String password="deeps";

String query="select * from cust_info where email='"+email+"' ";
Connection conn=DriverManager.getConnection(url,username,password);
Statement stmt=conn.createStatement();
ResultSet rs=stmt.executeQuery(query);
while(rs.next())
{
%>
 <tr>
 <td><%=rs.getString("address") %></td>
 <td><%=rs.getString("phone") %></td>
 
 </tr>
 <%
}
%>
 </table>
    </div>
 <form action="restaurant.html">
     <center>
         <input type="submit" class="button" value="Go to Home"> </center>
 </form>
 <%
 rs.close();
 stmt.close();
 conn.close();
 }
catch(Exception e)
{
 e.printStackTrace();
 }
%>

</body>  
</html>  
