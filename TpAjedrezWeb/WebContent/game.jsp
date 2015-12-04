<%@page import="com.sun.org.apache.bcel.internal.generic.IFNONNULL"%>
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
<link href="bootstrap.min.css" rel="stylesheet">
<title>Juego ajedrez Java 2015</title>
</head>
<body>
	<div class="container">

	<form class="" name="game" action="play" method="post">
      	<header> 
      	<h2 class="form-signin-heading">Pantalla de juego</h2>
      	<label h3><u>Jugadores </u></label> 
      	<br>
      	<b>Blancas:</b>
      
		<%=session.getAttribute("ApellidoBlancas")%>
		<%=session.getAttribute("NombreBlancas")%>
		<br>
		<b>Negras  :</b>
	
		<%=session.getAttribute("ApellidoNegras")%>
		<%=session.getAttribute("NombreNegras")%>
		<br>
		<label h3>Turno Actual  </label>
		<%=session.getAttribute("ApellidoTAct")%>
		<%=session.getAttribute("NombreTAct")%>
      	
      	<label h3>Resultado  </label> 
      	<%=session.getAttribute("resultado") %>
      	</header>

			<h4 class="form-signin" id="centrado">Tablero</h4>

			<% 
			HashMap<String, Piezas> map;
			map = (HashMap<String, Piezas>)session.getAttribute("tablero");
			final String[][] posiciones = {
												{"a1","a2","a3","a4","a5","a6","a7","a8"}, 
												{"b1","b2","b3","b4","b5","b6","b7","b8"},
												{"c1","c2","c3","c4","c5","c6","c7","c8"},
												{"d1","d2","d3","d4","d5","d6","d7","d8"},
												{"e1","e2","e3","e4","e5","e6","e7","e8"},
												{"f1","f2","f3","f4","f5","f6","f7","f8"},
												{"g1","g2","g3","g4","g5","g6","g7","g8"},
												{"h1","h2","h3","h4","h5","h6","h7","h8"}
										  	};
			
			%>
			<table border="1" id="tablero" align="center">
			<%
				String pieza = "";
				for(int i = 0; i < 8; i++) {
					%>
					<tr>
						<%
						for(int j = 0; j < 8; j++) {
									if(map.containsKey(posiciones[j][i])) {
										pieza = map.get(posiciones[j][i]).getNombre();
										
										if (map.get(posiciones[j][i]).getColor().equals("BLANCO")) {
											%>
											<td width="25px" height="25px" align="center" valign="middle">
												<font color="#fff">
													<%=pieza%>
												</font>
											<%
										}
										else
										{
											%>
											<td width="25px" height="25px" align="center" valign="middle">
												<font color="#000">
													<%=pieza%>
												</font>
											<%
										}
									}
									else {
										%>
										<td width="25px" height="25px">
										<%
									}
								%>
							</td>
							<%
						}
						%>
					</tr>
					<%
				}
			%>
			
			
			</table>
			<div class="col-md-4 col-lg-4 col-md-offset-4 col-lg-offset-4">
				<br>
				<label h3>Posicion de origen  </label> 
				<br>
				<input name="posOrigen" id="PosicionOrigen" class="form-control" placeholder="" required autofocus type="posOrigen">
				<label h3>Posicion de destino  </label>
				<input name="posDestino" id="PosicionDestino" class="form-control" placeholder="" required type="posDestino">
				<button class="margensuperior btn btn-lg btn-primary btn-block" type="submit">Mover</button>
			</div>

	        
      </form>
      <br>
      <form class="form-signin" name="save" action="save" method="post">
      <br>
		 <button class="btn btn-lg btn-primary btn-block margensuperior" id="salir" type="submit">guardar y salir</button>
			
		
      </form>

    </div>

</body>
</html>