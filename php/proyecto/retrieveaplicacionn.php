<?php 
$con=mysqli_connect("localhost","root","","proyecto");
	
	$sql="SELECT * FROM registrardatosaplicativo";
	$datos=Array();
	$resul=mysqli_query($con,$sql);
	while ($row=mysqli_fetch_object($resul)) {
		$datos[]=$row;
	}
	echo json_encode($datos);
	mysqli_close($con);
 ?>