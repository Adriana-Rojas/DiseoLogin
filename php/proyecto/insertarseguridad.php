<?php
include 'conexion.php';

$seguridad=$_POST['seguridad'];
$playstore=$_POST['playstore'];
$calculofrecuenciaerrores=$_POST['calculofrecuenciaerrores'];
$numeroserrores=$_POST['numeroserrores'];
$tiempotarea=$_POST['tiempotarea'];
$frecuenciaerrores=$_POST['frecuenciaerrores'];
$mensajes=$_POST['mensajes'];
$prevencion=$_POST['prevencion'];
$redundancia=$_POST['redundancia'];
$enlaces=$_POST['enlaces'];
/*
$seguridad="7";
$playstore="7";
$calculofrecuenciaerrores="7";
$numeroserrores="7";
$tiempotarea="7";
$frecuenciaerrores="1";
$mensajes="7";
$prevencion="7";
$redundancia="7";
$enlaces="7";
*/
// Create connection
$conn = new mysqli($hostname,$username,$password,$database);
// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}


$sql = "INSERT INTO permiso(seguridad, playstore) 
VALUES ('$seguridad', '$playstore')";
if ($conn->query($sql) === TRUE) {
  echo "New record created successfully";
} else {
  echo "Error: " . $sql . "<br>" . $conn->error;
}
$sql3 = "INSERT INTO frecuenciaerrores(calculofrecuenciaerrores, numeroserrores, tiempotarea) 
VALUES ('$calculofrecuenciaerrores', '$numeroserrores', '$tiempotarea')";
if ($conn->query($sql3) === TRUE) {
  echo "New record created successfully";
} else {
  echo "Error: " . $sql3 . "<br>" . $conn->error;
}
$sql2 = "INSERT INTO error(frecuenciaerrores, mensajes, prevencion, redundancia, enlaces) 
VALUES ('$frecuenciaerrores', '$mensajes', '$prevencion', '$redundancia', '$enlaces')";
if ($conn->query($sql2) === TRUE) {
  echo "New record created successfully";
} else {
  echo "Error: " . $sql2 . "<br>" . $conn->error;
}


$conn->close();
?>