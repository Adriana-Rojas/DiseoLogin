<?php 

include 'conexion.php';
	$id = $_POST["id"];
	$idaplicativo = $_POST["idaplicativo"];
/*	$id ="1";
	$idaplicativo="819";*/
	$result = array();
	$result['usabilidad'] = array();
	$select= "SELECT * FROM usabilidad u, registrardatosaplicativo r,eficiencia e,eficacia ef,memorabilidad m ,productividad p,satisfaccion s,seguridad se ,universabilidad uni , cargacognitiva ca WHERE u.aplicativo = r.id AND r.usuario = '$id' AND u.aplicativo = '$idaplicativo' AND e.id =u.eficiencia AND ef.id=u.eficacia and m.id=u.memorabilidad AND p.id=u.productividad AND s.id=u.satisfaccion AND se.id=u.seguridad AND uni.id=u.universabilidad AND ca.id=u.cargacognitiva ";
	$responce = mysqli_query($conexion,$select);
	$cantidad=0;
	$suma=0;
	$calcularusabilidad=0;
	$eficiencia=0;
	$eficacia=0;
	$memorabilidad=0;
	$productividad=0;
	$satisfaccion=0;
	$seguridad=0;
	$universabilidad=0;
	$cargacognitiva=0;
	$diez=10;
	
	while($row = mysqli_fetch_array($responce))
		{
			$cantidad=$cantidad+1;
			$index['id'] = $row['0'];
			$index['aplicativo']= $row['1'];
			$index['nombre']= $row['13'];
			$index['calcularusabilidad']= $row['2'];
			$calcularusabilidad = $calcularusabilidad+$row['2'];
			$index['eficiencia']= $row['21'];
			$eficiencia=$eficiencia+ $row['21'];
			$index['eficacia']= $row['25'];
			$eficacia=$eficacia+ $row['25'];
			$index['memorabilidad'] = $row['31'];
			$memorabilidad=$memorabilidad+ $row['31'];
			$index['productividad']= $row['34'];
			$productividad=$productividad+ $row['34'];
			$index['satisfaccion'] = $row['37'];
			$satisfaccion=$satisfaccion+ $row['37'];
			$index['seguridad'] = $row['41'];
			$seguridad=$seguridad+ $row['41'];
			$index['universabilidad']= $row['45'];
			$universabilidad=$universabilidad+ $row['45'];
			$index['cargacognitiva']= $row['48'];
			$cargacognitiva=$cargacognitiva+ $row['48'];

			array_push($result['usabilidad'], $index);
		}			
			
			/*echo " Sumacantidad= " .$cantidad;
			echo " Sumacalcularusabilidad= " .$calcularusabilidad/$cantidad;
			echo " Sumaeficiencia= " .($eficiencia)/$cantidad;
			echo " Sumaeficacia= " .($eficacia)/$cantidad;
			echo " Sumamemorabilidad= " .($memorabilidad)/$cantidad;
			echo " Sumaproductividad= " .($productividad)/$cantidad;
			echo " Sumasatisfaccion= " .($satisfaccion)/$cantidad;
			echo " Sumaseguridad= " .($seguridad)/$cantidad;
			echo " Sumauniversabilidad= " .($universabilidad)/$cantidad;
			echo " Sumacargacognitiva= " .($cargacognitiva)/$cantidad;*/
			$result["success"]="1";
			echo json_encode($result);
			mysqli_close($conexion);

 ?>