<html>

<head>

<style>

.user
{
	font-family:Curlz MT;
	font-weight:bold;
	font-size:30px;
}

.main
{
	font-family:Impact;
	font-size:30px;
	font-weight: bold;
}

.sub
{
	font-family:Lucida Handwriting;
}

.link1
{
	font-family:Bahnschrift;
	background-color: goldenrod;
}

.link2
{
	font-family:papyrus;
	background-color: lightskyblue;
}

.link3
{
	font-family:MingLiU_HKSCS-ExtB;
	background-color: maroon;
}

.link4
{
	font-family:Century Gothic;
	background-color: sienna;
}

.bg-img
{
	background-image:url("mainposter.PNG");
	background-repeat:no-repeat;
	background-size:cover;	
}

a:link, a:visited {
  color: white;
  padding: 20px 485px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
}

a:hover, a:active {
  background-color: coral;
}

</style>

</head>

<body class="bg-img">                                                             
				
<pre>


																										<label class="user"><%="Welcome "+request.getParameter("UserName") %></label>



                                                                      <label class="main">FOOD EASE</label>	
 
   	<a href="rest1.html" class="link1">Barkaas...........................</a>
	<label class="sub">Non-veg/veg</label>

	

   	<a href="rest2.html" class="link2">Get Chilled.....................</a>
	<label class="sub">Non-veg/veg</label>



   	<a href="rest3.html" class="link3">Fried_Chick.........</a>
	<label class="sub">Non-veg/veg</label>



   	<a href="rest4.html" class="link4">ChennaiPeriya...........</a>
	<label class="sub">Pure-veg only</label>

</pre>

</body>

</html>