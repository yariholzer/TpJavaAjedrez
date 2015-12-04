<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="login.css" rel="stylesheet">
<link href="bootstrap.min.css" rel="stylesheet">
<title>Juego termiando</title>
</head>
<body>
	 <form class="form-signin" name="game" action="game" method="post">
		<div class="ganador">
				
				<img src="trofeo.jpg" alt="Trofeo de victoria" style="width:304px;height:228px;">
				El ganador es
				<br>  	
				<%=session.getAttribute("ApellidoTAct")%>
				<%=session.getAttribute("NombreTAct")%>

				<br>
				<br>
				<br>
				<br>
				<br>
		</div>	
		
				 <a href="login.html" id="link">volver al inicio</a>
			
		
      </form>
     
</body>
</html>