<?php
include 'conexion.php';

$nombre=$_POST['nombre'];
$telefono=$_POST['telefono'];
$correo=$_POST['correo'];
$contraseña=$_POST['contraseña'];
/*
$nombre="adri";
$telefono="Telefono";
$correo="correo";
$contraseña="contraseña";*/

// Create connection
$conn = new mysqli($hostname,$username,$password,$database);
// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}

$sql = "INSERT INTO administrador (nombre, telefono, correo, contraseña)
VALUES ('$nombre', '$telefono', '$correo', '$contraseña')";

if ($conn->query($sql) === TRUE) {
  echo "New record created successfully";
} else {
  echo "Error: " . $sql . "<br>" . $conn->error;
}

$conn->close();
?>