<%@page import="cpDatos.*"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	 <div class="container">

	<form class="form-signin" name="game" action="game" method="post">
      
	   	<%=request.getAttribute("DniBlancas")%>
		<%=request.getAttribute("ApellidoBlancas")%>
		<%=request.getAttribute("NombreBlancas")%>
		<%=request.getAttribute("DniNegras")%>
		<%=request.getAttribute("ApellidoNegras")%>
		<%=request.getAttribute("NombreNegras")%>
		<br>
			
		<% 
		ArrayList<String> arrayPiezas = new ArrayList<String>();
		HashMap<String, Piezas> map;
		map = (HashMap<String, Piezas>)session.getAttribute("tablero");
		for (String key: map.keySet()){
		%>
		
			<%=map.get(key).getNombre()%>
			
		<%
		}
		%>
			

		
      </form>

    </div>
	 

</body>
</html>