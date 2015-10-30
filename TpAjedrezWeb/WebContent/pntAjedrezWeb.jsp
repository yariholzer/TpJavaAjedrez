<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="estilos.css" rel="stylesheet" type="text/css" >
<title> "Ajedrez 2015" </title>
</head>
	<body>
	
	// declarar todo dentro de un form
	<header> 
		<h1> Juego de ajedrez  </h1>
		<br>
		<h3>Ingreso de jugadores</h3>
		<br>
		<label for="Name">Dni jugador 1</label>
		<input type="text" id="Name" name="Name" />
		<br>
		<label for="Name">Dni jugador 2</label>
		<input type="text" id="Name" name="Name" />
		
		<button type="submit" onclick="buscaJugador();" >Jugar </button>
	</header>
	<content>
		<label for="Name">Turno</label>
		<input type="text" id="Name" name="Name" />
		<br>
		<img SRC="tableroAjedrez.jpg" ALT="tablero de ajedrez">
		<br>
	</content>
	
	<sidebar>
		<label for="Name">Posicion de origen</label><br>
		<input type="text" id="Name" name="Name" />
		<br>
		<label for="Name">Posicion de destino </label><br>
		<input type="text" id="Name" name="Name" />
		<br>
		<button type="submit"> Mover</button>
		
	</sidebar>
	
	</body>
</html>

