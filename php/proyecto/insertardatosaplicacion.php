<?php
include 'conexion.php';

$usuario=$_POST['usuario'];
$nombre=$_POST['nombre'];
$tipoaplicativo=$_POST['tipoaplicativo'];
$subirapk=$_POST['subirapk'];
$subirmanual=$_POST['subirmanual'];
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

$sql = "INSERT INTO registrardatosaplicativo (usuario,nombre, tipoaplicativo, subirapk, subirmanual)
VALUES ('$usuario','$nombre', '$tipoaplicativo', '$subirapk', '$subirmanual')";

if ($conn->query($sql) === TRUE) {
  echo "New record created successfully";
} else {
  echo "Error: " . $sql . "<br>" . $conn->error;
}

$conn->close();
?>