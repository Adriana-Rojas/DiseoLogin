<?php 

include 'conexion.php';

	$nombre=$_GET['nombre'];
	
	$consulta= "SELECT *from evaluador where nombre = '$nombre'";
	$resultado = $conexion -> query($consulta);
	
	while($fila = $resultado->fetch_array()){			
		$evaluador[] = array_map('utf8_encode',$fila);
	}		
	echo json_encode($evaluador);
	$resultado->close();

 ?>