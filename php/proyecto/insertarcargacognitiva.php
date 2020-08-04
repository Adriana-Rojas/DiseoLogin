<?php
include 'conexion.php';

$multitareas=$_POST['multitareas'];
$actividad_mental=$_POST['actividad_mental'];
$dificultad_tarea=$_POST['dificultad_tarea'];
$actividad_fisica=$_POST['actividad_fisica'];
$exigencia=$_POST['exigencia'];
$inseguro=$_POST['inseguro'];
//
$calculoderelevancia=$_POST['calculoderelevancia'];
//
// Create connection
$conn = new mysqli($hostname,$username,$password,$database);
// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}


$sql = "INSERT INTO usosimultaneo(multitareas, actividad_mental, dificultad_tarea, actividad_fisica, exigencia, inseguro) 
VALUES ('$multitareas', '$actividad_mental', '$dificultad_tarea', '$actividad_fisica', '$exigencia', '$inseguro')";
if(mysqli_query($conn, $sql)){
  echo "Registro insertado, el id insertado ha sido el " . mysqli_insert_id($conn);
  $idusosimultaneo= mysqli_insert_id($conn);
}else{
  echo "No se inserto el registro correctamente.";
}
$sql2 = "INSERT INTO cargacognitiva(usosimultaneo, calculoderelevancia)
 VALUES ('$idusosimultaneo', '$calculoderelevancia')";
if(mysqli_query($conn, $sql2)){
  echo "Registro insertado, el id insertado ha sido el " . mysqli_insert_id($conn);
  $idcargacognitiva= mysqli_insert_id($conn);
}else{
  echo "No se inserto el registro correctamente.";
}


$conn->close();
?>