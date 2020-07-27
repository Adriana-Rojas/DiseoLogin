<?php
include 'conexion.php';

$productividad_inexperto=$_POST['productividad_inexperto'];

// Create connection
$conn = new mysqli($hostname,$username,$password,$database);
// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}


$sql = "INSERT INTO salidausuario(productividad_inexperto) 
VALUES ('$productividad_inexperto')";
if ($conn->query($sql) === TRUE) {
  echo "New record created successfully";
} else {
  echo "Error: " . $sql . "<br>" . $conn->error;
}

$conn->close();
?>