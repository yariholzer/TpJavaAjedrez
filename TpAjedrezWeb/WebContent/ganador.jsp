<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Juego termiando</title>
</head>
<body>
	 <form class="form-signin" name="game" action="game" method="post">
		<h1>El ganador es  	</h1>
			<%=session.getAttribute("ApellidoTAct")%>
			<%=session.getAttribute("NombreTAct")%>
	
      </form>
</body>
</html>