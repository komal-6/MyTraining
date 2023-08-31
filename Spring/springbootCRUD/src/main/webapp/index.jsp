<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<form action="adduser" style="margin-left:500px;">
    <h1>USER CREATION</h1><br><br>
   
    <span>ID:</span><input type="text" name="uid"><br>
    <span>Name:</span><input type="text" name="uname"><br>
    <span>Email:</span><input type="text" name="uemail"><br>
    <span>Phone No:</span><input type="text" name="ucontact"><br><br>
  <!--   
    <span>Hobbies:</span><br>
    Dance <input type="checkbox" name="hobbies" value="Dance">
    <br>
    
    Travelling <input type="checkbox" name="hobbies" value="Travelling">
    <br>
    
    Music <input type="checkbox" name="hobbies" value="Music">
    <br>
    
    Sports <input type="checkbox" name="hobbies" value="Sports">
    <br><br>
    
    <span>Gender:</span><br>
    Male <input type="radio" name="gender" value="Male">
    <br>
    Female <input type="radio" name="gender" value="Female">
    <br>
    Transgender <input type="radio" name="gender" value="Transgender">
    <br><br>
      -->
    <button  type="submit" style="color:black;" class="btn btn-success">SUBMIT</button>
    
    <br><br> 
    <button  type="reset" style="color:black;" value="Reset" name="reset" class="btn btn-info">RESET</button>
   
    </form>
  </div>
    <hr>
 <div class="main2">
 <form action="getusers">
   <h1 style="text-align:center;">TABLE DATA</h1>
   <table width="93%" style="margin-left:50px; margin-right:50px; margin-top:20px;">
    <tr>
    <th>ID</th>
    <th>NAME</th>
    <th>EMAIL</th>
    <th>PHONE NO</th>
    </tr> 
    
    <tr th:each="user:${users}">
      <td th:text="${user.uid}"></td>
      <td th:text="${user.uname}"></td>
      <td th:text="${user.uemail}"></td>
      <td th:text="${user.ucontact}"></td>
     </tr>
     </table>
     </form>
     </div>
</body>
</html>