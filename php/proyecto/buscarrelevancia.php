<?php 

include 'conexion.php';
	//$id = $_POST["id"];
	$id ="826";
	$result = array();
	$result['relevancia'] = array();
	$select= "SELECT * FROM registrardatosaplicativo r, tipodeaplicacion t WHERE r.tipoaplicativo = t.id AND r.id = '$id'";
	$responce = mysqli_query($conexion,$select);
	
	while($row = mysqli_fetch_array($responce))
		{
			$index['id']      = $row['0'];
			$index['tipoaplicativor'] = $row['3'];
			$index['tipoaplicativo'] = $row['7'];
			$index['tiempoinicio'] = $row['8'];//1
			$index['calculartiemporespuesta'] = $row['9'];
			$index['calculoram'] = $row['10'];
			$index['calculocpu'] = $row['11'];
			$index['calculobateria'] = $row['12'];
			$index['esfuerzo'] = $row['13'];
			$index['calculocostoeconomico'] = $row['14'];
			$index['calculoterminaciontarea'] = $row['15'];
			$index['calculoefectividad'] = $row['16'];
			$index['calculotiempo'] = $row['17'];
			$index['calculoextensibilidad'] = $row['18'];
			$index['calculoreusabilidad'] = $row['19'];
			$index['calculoescalabilidad'] = $row['20'];
			$index['rapidez'] = $row['21'];
			$index['dificultad'] = $row['22'];
			$index['aprendizaje'] = $row['23'];
			$index['facilidad'] = $row['24'];
			$index['productividad_inexperto'] = $row['25'];
			$index['estetica_general'] = $row['26'];
			$index['comodidad_visual'] = $row['27'];
			$index['informacion'] = $row['28'];
			$index['iconos'] = $row['29'];
			$index['eleccion'] = $row['30'];
			$index['busqueda'] = $row['31'];
			$index['videos'] = $row['32'];
			$index['recomendacion'] = $row['33'];
			$index['calculo_satisfaccion'] = $row['34'];
			$index['organizacion'] = $row['35'];
			$index['interfaz'] = $row['36'];
			$index['gusto'] = $row['37'];
			$index['herramientas'] = $row['38'];
			$index['satisfaccion'] = $row['39'];
			$index['lenguaje'] = $row['40'];
			$index['sobrecarga'] = $row['41'];
			$index['interfaz_limpia'] = $row['42'];
			$index['espacio'] = $row['43'];
			$index['longitud'] = $row['44'];
			$index['texto'] = $row['45'];
			$index['seguridad'] = $row['46'];
			$index['playstore'] = $row['47'];
			$index['calculofrecuenciaerrores'] = $row['48'];
			$index['mensajes'] = $row['49'];
			$index['prevencion'] = $row['50'];
			$index['redundancia'] = $row['51'];
			$index['enlaces'] = $row['52'];
			$index['resolucion'] = $row['53'];
			$index['lenguaje_clarol'] = $row['54'];
			$index['fuente'] = $row['55'];
			$index['contraste'] = $row['56'];
			$index['idioma'] = $row['57'];
			$index['uso'] = $row['58'];
			$index['multitareas'] = $row['59'];
			$index['actividad_mental'] = $row['60'];
			$index['dificultad_tarea'] = $row['61'];
			$index['actividad_fisica'] = $row['62'];
			$index['exigencia'] = $row['63'];
			$index['inseguro'] = $row['64'];
			$index['sumaTotal'] = $row['65'];
			array_push($result['relevancia'], $index);
		}
			
			$result["success"]="1";
			echo json_encode($result);
			mysqli_close($conexion);

 ?>