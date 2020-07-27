<?php
include 'conexion.php';

$evaluador=$_POST['evaluador'];
$listaaplicaciones=$_POST['listaaplicaciones'];
$administrador=$_POST['administrador'];
/*
$nombre="adri";
$tipoaplicativo=3;
$subirapk=2;
$subirmanual=2;*/

// Create connection
$conn = new mysqli($hostname,$username,$password,$database);
// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}

$sql = "INSERT INTO asignarresportes (evaluador,listaaplicaciones, administrador)
VALUES ('$evaluador','$listaaplicaciones', '$administrador')";

if ($conn->query($sql) === TRUE) {
  echo "New record created successfully";
} else {
  echo "Error: " . $sql . "<br>" . $conn->error;
}

$conn->close();
?>