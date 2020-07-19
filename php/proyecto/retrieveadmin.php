<?php 

include 'conexion.php';
	
	$result = array();
	$result['administrador'] = array();
	$select= "SELECT *from administrador";
	$responce = mysqli_query($conexion,$select);
	
	while($row = mysqli_fetch_array($responce))
		{
			$index['id']      = $row['0'];
			$index['nombre']    = $row['1'];
			$index['telefono']   = $row['2'];
			$index['correo'] = $row['3'];
			$index['contraseña'] = $row['4'];
			
			array_push($result['administrador'], $index);
		}
			
			$result["success"]="1";
			echo json_encode($result);
			mysqli_close($conexion);

 ?>