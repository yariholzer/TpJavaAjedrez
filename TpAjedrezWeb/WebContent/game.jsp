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
      	<label for="TurnoActual" class="sr-only">Turno act</label>
      	<input name="TurnoAct" id="turnoActual" class="form-control" placeholder="Turno jugador" required="" autofocus="" type="TurnoActual">
      	</header>
		<tablero>

		<h4 class="form-signin">Tablero</h4>
		<table border=1><td>Columna #1</td><td>Columna #2</td><tr><td>Contenido
		Bajo Columna#1<td>Cont Columna#2</td></table>
		
		</tablero>
	

		
	
       	
        <button class="btn btn-lg btn-primary btn-block" type="submit">Jugar</button>
      </form>

    </div>

</body>
</html>