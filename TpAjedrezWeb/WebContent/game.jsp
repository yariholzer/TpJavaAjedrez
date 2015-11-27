<%@page import="cpDatos.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="login.css" rel="stylesheet">
<title>Juego ajedrez Java 2015</title>
</head>
<body>
	<div class="container">

	<form class="" name="game" action="play" method="post">
      	<header> 
      	<h2 class="form-signin-heading">Pantalla de juego</h2>
      	<label h3>Jugadores  </label> 
      	<br>
      	<%=session.getAttribute("DniBlancas")%>
		<%=session.getAttribute("ApellidoBlancas")%>
		<%=session.getAttribute("NombreBlancas")%>
		<br>
		<%=session.getAttribute("DniNegras")%>
		<%=session.getAttribute("ApellidoNegras")%>
		<%=session.getAttribute("NombreNegras")%>
		<br>
		<label h3>Turno Actual  </label>
		<%=session.getAttribute("ApellidoTAct")%>
		<%=session.getAttribute("NombreTAct")%>
      	
      	<label h3>Resultado  </label> 
      	<%=session.getAttribute("resultado") %>
      	</header>
      	<content>
			<tablero>

			<h4 class="form-signin">Tablero</h4>
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
			
			</tablero>
			
			<sidebar>
			<br>
			<label h3>Posicion de origen  </label> 
			<br>
			<input name="posOrigen" id="PosicionOrigen" class="form-control" placeholder="" required="" type="posOrigen">
			<label h3>Posicion de destino  </label>
			<input name="posDestino" id="PosicionDestino" class="form-control" placeholder="" required="" type="posDestino">
			<button class="btn btn-lg btn-primary btn-block" type="submit">Mover</button>
			</sidebar>

		
	
       	
        
      </form>

    </div>

</body>
</html>