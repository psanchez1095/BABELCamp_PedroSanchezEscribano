<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!--Responsive CSS-->
<link rel="stylesheet"
	media="screen and (max-width: 2100px) and (min-width:860px)"
	href="css/index.css">
<link rel="stylesheet"
	media="screen and (max-width: 860px) and (min-width:0px)"
	href="css/indexLarge.css">
<link rel="icon" type="img/png" href="img/curriculum/information.png">
<title>Inicio</title>
</head>

<body>

	<div class="mainBody">

		<div id="divBodyIzquierda">

			<div id="info">

				<h2>Repositorio Web Java</h2>

				<div id="divImgsIzq">
				
					 <div id=userDiv>
					 	<p>Bienvenido ${param.email}</p>
					 	<img src="img/curriculum/contact.png">
					 </div>
					
					<p>Apache Tomcat v9</p>
					<img src="img/server.png">
					<p>HTML5</p>
					<img src="img/html.png">
					<p>CSS3</p>
					<img src="img/css.png">

				</div>


			</div>


		</div>

		<div id="divBodyDer">

			<h2>Páginas Web</h2>

			<div id="divWebsDer">

				<div class="enlaceWeb">
					<a class="enlace" href="indexGamingWorld.html">
						<p>GamingWorld</p> <img src="img/iconGB256.png">
					</a>
				</div>

				<div class=enlaceWeb>
					<a class="enlace" href="curriculum.html">
						<p>Curriculum</p> <img src="img/curriculum/curriculum.png">
					</a>
				</div>

			</div>

		</div>

	</div>

</body>

</html>