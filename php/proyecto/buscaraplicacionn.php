<?php 

include 'conexion.php';

	$nombre=$_GET['nombre'];
	
	$consulta= "SELECT *from registrardatosaplicativo where nombre = '$nombre'";
	$resultado = $conexion -> query($consulta);
	
	while($fila = $resultado->fetch_array()){			
		$registrardatosaplicativo[] = array_map('utf8_encode',$fila);
	}		
	echo json_encode($registrardatosaplicativo);
	$resultado->close();

 ?>