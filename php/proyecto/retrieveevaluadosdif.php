<?php 

include 'conexion.php';
	$id = $_POST["id"];
	//$id ="44";
	$result = array();
	$result['usabilidad'] = array();
	$select= "SELECT DISTINCT aplicativo,nombre from usabilidad u,registrardatosaplicativo r WHERE u.aplicativo = r.id AND r.usuario = '$id'";
	$responce = mysqli_query($conexion,$select);
	
	
	while($row = mysqli_fetch_array($responce))
		{
			
			$index['id']= $row['0'];
			$index['nombre']= $row['1'];				

			array_push($result['usabilidad'], $index);
		}			
	
			$result["success"]="1";
			echo json_encode($result);
			mysqli_close($conexion);

 ?>