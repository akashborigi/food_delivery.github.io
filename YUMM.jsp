<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.io.*" import="javax.servlet.*" import="javax.servlet.http.*" import="java.sql.*"
	import="javax.servlet.annotation.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>

.a{
font-family:Colonna MT;
font-size:30px;
}

.b{
font-family:Bradley Hand ITC;
font-size:30px;
}

.c{
font-family:Jokerman;
font-size:30px;
}
.bg-img{
	background-image:url("TQ.PNG");
	min-height:800px;
	background-position:left center;
	background-repeat:no-repeat;
	background-size:50% 100%;
	position:relative;
}
</style>
</head>


	
<body class="bg-img">
<pre>

								
																		<label class="a">THANK YOU FOR ORDERING</label>	
	
								
																		<label class="b"><%= "Your selected item name is '"+request.getAttribute("str")+"'" %></label>	
								
								
			
			
			
			
			
			
			
			
			
			
																		<label class="b"><%= "Final price is '"+request.getAttribute("i")+"$'" %></label>
					
								
																		<label class="a">HOPE YOU ENJOYED</label>









								
								
								
							
								
																		
																		
																		
																		<a href="FOOD3.jsp"><label class="c">For re-order please click here</label></a>
</pre>
</body>
</html>











