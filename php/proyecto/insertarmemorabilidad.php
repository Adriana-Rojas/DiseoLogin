<?php
include 'conexion.php';

$rapidez=$_POST['rapidez'];
$dificultad=$_POST['dificultad'];
$aprendizaje=$_POST['aprendizaje'];
$facilidad=$_POST['facilidad'];

// Create connection
$conn = new mysqli($hostname,$username,$password,$database);
// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}


$sql = "INSERT INTO comprensibilidad(rapidez, dificultad, aprendizaje, facilidad) 
VALUES ('$rapidez', '$dificultad', '$aprendizaje', '$facilidad')";
if ($conn->query($sql) === TRUE) {
  echo "New record created successfully";
} else {
  echo "Error: " . $sql . "<br>" . $conn->error;
}

$conn->close();
?>