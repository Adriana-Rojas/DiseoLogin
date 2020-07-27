<?php 

include 'conexion.php';

	$tipoaplicativo=$_GET['tipoaplicativo'];
	
	$consulta= "SELECT *from tipodeaplicacion where tipoaplicativo = '$tipoaplicativo'";
	$resultado = $conexion -> query($consulta);
	
	while($fila = $resultado->fetch_array()){			
		$tipodeaplicacion[] = array_map('utf8_encode',$fila);
	}		
	echo json_encode($tipodeaplicacion);
	$resultado->close();

 ?>