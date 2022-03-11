<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!--Responsive CSS-->
<link rel="stylesheet"
	media="screen and (max-width: 2100px) and (min-width:860px)"
	href="css/login.css">
<link rel="stylesheet"
	media="screen and (max-width: 860px) and (min-width:0px)"
	href="css/loginLarge.css">
<link rel="icon" type="img/png" href="img/curriculum/information.png">
<title>Login</title>
</head>

<body>

	<div class="mainBody">

		<div id="divBodyIzquierda">

			<div id="info">

				<h2>P�gina Acceso Gaming World</h2>

			</div>

		</div>

		<div id="divBodyDer">

			<h1>ERROR LOGIN</h1>

			<div id="divContentDer">

				<form action="loginServlet" method="get">
					<h2>Correo / Nombre de Usuario</h2>
					<span><input type="text" name="email"
						placeholder="Correo / Nombre de Usuario" required /></span>
					<h2>Contrase�a</h2>
					<span><input type="password" name="password"
						placeholder="Contrase�a" required /></span>
					<h2>Acceder</h2>
					<span><input type="submit" value="Acceder" /></span>


				</form>

			</div>

		</div>

	</div>

</body>

</html>