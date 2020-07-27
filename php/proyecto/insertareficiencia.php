<?php
include 'conexion.php';

$tiempoinicio=$_POST['tiempoinicio'];
$tiemporespuesta=$_POST['tiemporespuesta'];
$numerodeevaluaciones=$_POST['numerodeevaluaciones'];
$calculartiemporespuesta=$_POST['calculartiemporespuesta'];
$consumoram=$_POST['consumoram'];
$consumomedram=$_POST['consumomedram'];
$consumomaxram=$_POST['consumomaxram'];
$calculoram=$_POST['calculoram'];
$consumocpu=$_POST['consumocpu'];
$consumomedcpu=$_POST['consumomedcpu'];
$consumomaxcpu=$_POST['consumomaxcpu'];
$calculocpu=$_POST['calculocpu'];
$canticonsumida=$_POST['canticonsumida'];
$consumomedbateria=$_POST['consumomedbateria'];
$calculobateria=$_POST['calculobateria'];
$esfuerzo=$_POST['esfuerzo'];
$completartarea=$_POST['completartarea'];
$calculoesfuerzo=$_POST['calculoesfuerzo'];
$efectividadrelativatarea=$_POST['efectividadrelativatarea'];
$costototal=$_POST['costototal'];

// Create connection
$conn = new mysqli($hostname,$username,$password,$database);
// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}


$sql = "INSERT INTO tiemporespuesta( tiempoinicio, tiemporespuesta, numerodeevaluaciones, calculartiemporespuesta) 
VALUES ('$tiempoinicio', '$tiemporespuesta', '$numerodeevaluaciones', '$calculartiemporespuesta')";
if ($conn->query($sql) === TRUE) {
  echo "New record created successfully";
} else {
  echo "Error: " . $sql . "<br>" . $conn->error;
}
$sql2 = "INSERT INTO ram(consumoram, consumomedram, consumomaxram, calculoram) 
VALUES ( '$consumoram', '$consumomedram', '$consumomaxram', '$calculoram')";
if ($conn->query($sql2) === TRUE) {
  echo "New record created successfully";
} else {
  echo "Error: " . $sql2 . "<br>" . $conn->error;
}
$sql3 = "INSERT INTO cpu(consumocpu, consumomedcpu, consumomaxcpu, calculocpu) 
VALUES ('$consumocpu', '$consumomedcpu', '$consumomaxcpu', '$calculocpu')";
if ($conn->query($sql3) === TRUE) {
  echo "New record created successfully";
} else {
  echo "Error: " . $sql3 . "<br>" . $conn->error;
}
$sql4 = "INSERT INTO bateria(canticonsumida, consumomedbateria, calculobateria) 
VALUES ( '$canticonsumida', '$consumomedbateria', '$calculobateria')";
if ($conn->query($sql4) === TRUE) {
  echo "New record created successfully";
} else {
  echo "Error: " . $sql4 . "<br>" . $conn->error;
}
$sql5 = "INSERT INTO esfuerzo(esfuerzo, completartarea, calculoesfuerzo) 
VALUES ( '$esfuerzo', '$completartarea', '$calculoesfuerzo')";
if ($conn->query($sql5) === TRUE) {
  echo "New record created successfully";
} else {
  echo "Error: " . $sql5 . "<br>" . $conn->error;
}
$sql6 = "INSERT INTO costoeconomico( efectividadrelativatarea, costototal) 
VALUES ('$efectividadrelativatarea', '$costototal')";

if ($conn->query($sql6) === TRUE) {
  echo "New record created successfully";
} else {
  echo "Error: " . $sq6l . "<br>" . $conn->error;
}

$conn->close();
?>