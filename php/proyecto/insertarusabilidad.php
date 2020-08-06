<?php
include 'conexion.php';

//$aplicativo="819";
$aplicativo=$_POST['aplicativo'];
$eficiencia=$_POST['eficiencia'];
$eficacia=$_POST['eficacia'];
$memorabilidad=$_POST['memorabilidad'];
$productividad=$_POST['productividad'];
$satisfaccion=$_POST['satisfaccion'];
$seguridad=$_POST['seguridad'];
$universabilidad=$_POST['universabilidad'];
$cargacognitiva=$_POST['cargacognitiva'];
$calcularusabilidad=$_POST['calcularusabilidad'];
/*
$aplicativo="819";
$eficiencia="2";
$eficacia="2";
$memorabilidad="2";
$productividad="2";
$satisfaccion="2";
$seguridad=$idseguridad;
$universabilidad="2";
$cargacognitiva="2";
$calcularusabilidad="2";
*/

// Create connection
$conn = new mysqli($hostname,$username,$password,$database);
// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}


$sql = "INSERT INTO usabilidad(aplicativo, calcularusabilidad, eficiencia, eficacia, memorabilidad, productividad, satisfaccion, seguridad, universabilidad, cargacognitiva) 
VALUES ('$aplicativo', '$calcularusabilidad', '$eficiencia', '$eficacia', '$memorabilidad', '$productividad', '$satisfaccion', '$seguridad', '$universabilidad', '$cargacognitiva')";

if ($conn->query($sql) === TRUE) {
  echo "New record created successfully";
} else {
  echo "Error: " . $sql . "<br>" . $conn->error;
}

$conn->close();
?>