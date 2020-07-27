<?php
include 'conexion.php';

$multitareas=$_POST['multitareas'];
$actividad_mental=$_POST['actividad_mental'];
$dificultad_tarea=$_POST['dificultad_tarea'];
$actividad_fisica=$_POST['actividad_fisica'];
$exigencia=$_POST['exigencia'];
$inseguro=$_POST['inseguro'];
// Create connection
$conn = new mysqli($hostname,$username,$password,$database);
// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}


$sql = "INSERT INTO usosimultaneo(multitareas, actividad_mental, dificultad_tarea, actividad_fisica, exigencia, inseguro) 
VALUES ('$multitareas', '$actividad_mental', '$dificultad_tarea', '$actividad_fisica', '$exigencia', '$inseguro')";
if ($conn->query($sql) === TRUE) {
  echo "New record created successfully";
} else {
  echo "Error: " . $sql . "<br>" . $conn->error;
}


$conn->close();
?>