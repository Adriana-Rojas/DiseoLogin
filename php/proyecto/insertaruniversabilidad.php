<?php
include 'conexion.php';

$resolucion=$_POST['resolucion'];
$lenguaje=$_POST['lenguaje'];
$fuente=$_POST['fuente'];
$contraste=$_POST['contraste'];
$idioma=$_POST['idioma'];
$uso=$_POST['uso'];
// Create connection
$conn = new mysqli($hostname,$username,$password,$database);
// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}


$sql = "INSERT INTO accesibilidad(resolucion, lenguaje, fuente, contraste,idioma) 
VALUES ('$resolucion', '$lenguaje', '$fuente', '$contraste','$idioma')";
if ($conn->query($sql) === TRUE) {
  echo "New record created successfully";
} else {
  echo "Error: " . $sql . "<br>" . $conn->error;
}
$sql3 = "INSERT INTO fidelidad(uso) 
VALUES ('$uso')";
if ($conn->query($sql3) === TRUE) {
  echo "New record created successfully";
} else {
  echo "Error: " . $sql3 . "<br>" . $conn->error;
}

$conn->close();
?>