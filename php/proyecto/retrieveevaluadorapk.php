<?php 

include 'conexion.php';
	$id = $_POST["id"];
	//$id ="2";
	$result = array();
	$result['evaluador'] = array();
	$select= "SELECT * FROM registrardatosaplicativo r, asignarresportes a WHERE r.id = a.listaaplicaciones AND a.evaluador = '$id' ";
	$responce = mysqli_query($conexion,$select);
	
	while($row = mysqli_fetch_array($responce))
		{
			$index['id']      = $row['0'];
			$index['usuario']    = $row['1'];
			$index['nombre']   = $row['2'];
			$index['tipoaplicativo'] = $row['3'];
			$index['subirapk'] = $row['4'];
			$index['subirmanual']      = $row['5'];
			$index['evaluador']   = $row['6'];
			$index['listaaplicaciones'] = $row['7'];
			$index['administrador'] = $row['8'];
			
			array_push($result['evaluador'], $index);
		}
			
			$result["success"]="1";
			echo json_encode($result);
			mysqli_close($conexion);

 ?>