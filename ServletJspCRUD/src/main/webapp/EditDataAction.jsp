<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="java.sql.*, com.ignek.crud.user.dao.*,com.ignek.crud.servlet.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<title>Insert title here</title>

<style>
.main
    {
	   margin-left:50px;
	   margin-right:50px;
	   margin-top:15px;
	   margin-bottom:15px;
	   padding-bottom:10px;
       border: 1px dotted blue;
       background-color: rgb(208, 205, 248);
       padding-right:70px;
       align:center;
    }
   
    h1
    {
       color:blue;
       margin-top:40px;
       margin-bottom:5px;
       font-weight: bold;
       font-family: Verdana, sans-serif;
    }
    .main span
    {
       font-weight:bold;
       font-size:15px;
    }
    input[type="text"],[type="email"],[type="number"]
    {
       display: block;
       width: 300px;
       height:30px;
       border:none;
       border-radius:10px;
       
    }
    input[type="checkbox"],[type="radio"]
    {
      display:inline;
    }
    button
    {
       width:200px;
       height:40px;
       border:none;
       text-align:center;
       align:center;
       font-weight:100; 
       margin-left:50px;
    }
    </style>
    </head>
<body>

<%
 try
 {
	 
      while(SelectData.rs.next())
      {
    %>
 <div class="main">

    <form action="<%=request.getContextPath()%>/EditServlet?ID=<%= SelectData.rs.getInt("ID") %>" method="post" style="margin-left:500px;">
    <h1>USER CREATION</h1><br><br>
    
    <input type="hidden" name="id" value="<%= SelectData.rs.getString(1)%>">
    <span>Name:</span><input type="text" name="name" value="<%= SelectData.rs.getString(2)%>"><br>
    <span>Email:</span><input type="text" name="email" value="<%= SelectData.rs.getString(3)%>"><br>
    <span>Phone No:</span><input type="text" name="phoneno" value="<%= SelectData.rs.getString(4)%>"><br><br>
    
    <c:set var="habbiescheck" value="<%=SelectData.rs.getString(5)%>"></c:set>
    <span>Hobbies:</span><br>
    Dance <input type="checkbox" id="Dance" name="hobby" value="Dance" <c:if test="${fn:contains(habbiescheck,'Dance')}">checked</c:if>>
    <br>
    
    Travelling <input type="checkbox" id="Travelling" name="hobby" value="Travelling" <c:if test="${fn:contains(habbiescheck,'Travelling')}">checked</c:if>>
    <br>
    
    Music <input type="checkbox" id="Music" name="hobby" value="Music" <c:if test="${fn:contains(habbiescheck,'Music')}">checked</c:if>>
    <br>
    
    Sports <input type="checkbox" id="Sports" name="hobby" value="Sports" <c:if test="${fn:contains(habbiescheck,'Sports')}">checked</c:if>>
    <br><br>
    
    
    
    
    <span>Gender:</span><br>
    <c:set var="genderradiobutton" value="<%=SelectData.rs.getString(6)%>"></c:set>
    Male <input type="radio" name="gender" value="Male" <c:if test="${genderradiobutton=='Male'}">checked</c:if>> 
    <br>
    Female <input type="radio" name="gender" value="Female" <c:if test="${genderradiobutton=='Female'}">checked</c:if>>
    <br>
   
    Transgender <input type="radio" name="gender" value="Transgender" <c:if test="${genderradiobutton=='Transgender'}">checked</c:if>>
    <br><br>
    
    <button  type="submit" onClick="myFunction()" style="color:black;" id="submit" value="submit" name="submit" class="btn btn-success">SUBMIT</button>
    
    <br><br> 
    <button  type="reset" style="color:black;" value="Reset" name="reset" class="btn btn-info">RESET</button>
  </form>
  </div>
  <% }}
 catch(Exception e)
 {
	 e.printStackTrace();
 }
 %>
</body>
</html>