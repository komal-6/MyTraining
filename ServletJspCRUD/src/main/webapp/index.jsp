<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.*,com.ignek.crud.user.dao.*,com.ignek.crud.servlet.*,com.ignek.crud.db.connection.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<title>Insert title here</title>
<script>  
  
 function onDelete()
{
	alert("Are you sure want to delete?");
  }
</script> 
  <script>
    function myFunction()
    {
       //swal("Good job!", "You clicked the button!", "success");
    	alert("Your data are inserted successfully");
    }
</script>
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
    .main2 a button
    {
      width:80px;
    }
    table
    {
       align:center;
    }
    table, th, td
  	{
     	border: 1px solid black;
  	 	border-collapse: collapse;
  	 	text-align: center;
  	 	padding: 15px;
  	}
  
 	table tr th
 	{
    	font-size: 18px;
    	background-color:skyblue;
 	}

	 table tr td a
 	{
     	font-weight:bold;
 	}
</style>	
</head>
<body>

<div class="main">
<form action="<%=request.getContextPath()%>/InsertServlet" method="post" style="margin-left:500px;">
    <h1>USER CREATION</h1><br><br>
   
    <input type="hidden" name="id">
    <span>Name:</span><input type="text" name="name"><br>
    <span>Email:</span><input type="text" name="email"><br>
    <span>Phone No:</span><input type="text" name="phoneno"><br><br>
    
    <span>Hobbies:</span><br>
    Dance <input type="checkbox" name="hobby" value="Dance">
    <br>
    
    Travelling <input type="checkbox" name="hobby" value="Travelling">
    <br>
    
    Music <input type="checkbox" name="hobby" value="Music">
    <br>
    
    Sports <input type="checkbox" name="hobby" value="Sports">
    <br><br>
    
    <span>Gender:</span><br>
    Male <input type="radio" name="gender" value="Male">
    <br>
    Female <input type="radio" name="gender" value="Female">
    <br>
    Transgender <input type="radio" name="gender" value="Transgender">
    <br><br>
     
    <button  type="submit" onClick="myFunction()" style="color:black;" id="submit" value="submit" name="submit" class="btn btn-success">SUBMIT</button>
    
    <br><br> 
    <button  type="reset" style="color:black;" value="Reset" name="reset" class="btn btn-info">RESET</button>
    
    </form>
  </div>


<hr>
 <div class="main2">
   <h1 style="text-align:center;">TABLE DATA</h1>
   <table width="93%" style="margin-left:50px; margin-right:50px; margin-top:20px;">
    <tr>
    <th>ID</th>
    <th>NAME</th>
    <th>EMAIL</th>
    <th>PHONE NO</th>
    <th>HOBBIES</th>
    <th>GENDER</th>
    <th>ACTION</th>
    </tr>
     <% 
     try
     {
     	 
     SelectData.fetchAllDataForTable();
     while(SelectData.rs.next()){ %>
     <tr>
      <td><%= SelectData.rs.getInt(1)%></td>
      <td><%= SelectData.rs.getString(2)%></td>
      <td><%= SelectData.rs.getString(3)%></td>
      <td><%= SelectData.rs.getString(4)%></td>
      <td><%= SelectData.rs.getString(5)%></td>
      <td><%= SelectData.rs.getString(6)%></td>
      <td>
      
      
      <a href= "<%=request.getContextPath()%>/SelectServlet?id=<%= SelectData.rs.getInt("ID") %>">
         <button class="btn btn-primary">EDIT</button>
      </a>
      <a href ="<%=request.getContextPath()%>/DeleteServlet?id=<%= SelectData.rs.getInt("ID") %>">
        <button onClick="onDelete()" name="delete" class="btn btn-danger">DELETE</button>
        </a>
      </td>
      </tr>
    
    <%}}
     catch(Exception e)
     {
    	 e.printStackTrace();
     }
     %>
</table>
</div> 

</body>
</html>