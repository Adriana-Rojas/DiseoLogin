<?php
include 'conexion.php';

$seguridad=$_POST['seguridad'];
$playstore=$_POST['playstore'];
$calculofrecuenciaerrores=$_POST['calculofrecuenciaerrores'];
$numeroserrores=$_POST['numeroserrores'];
$tiempotarea=$_POST['tiempotarea'];
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
$frecuenciaerrores="1"; ya no
$mensajes="7";
$prevencion="7";
$redundancia="7";
$enlaces="7";
*/
//
$calculoderelevancia="1";
//
// Create connection
$conn = new mysqli($hostname,$username,$password,$database);
// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}


$sql = "INSERT INTO permiso(seguridad, playstore) 
VALUES ('$seguridad', '$playstore')";
if(mysqli_query($conn, $sql)){
  echo "Registro insertado, el id insertado ha sido el " . mysqli_insert_id($conn);
  $idpermiso= mysqli_insert_id($conn);
}else{
  echo "No se inserto el registro correctamente.";
}
$sql3 = "INSERT INTO frecuenciaerrores(calculofrecuenciaerrores, numeroserrores, tiempotarea) 
VALUES ('$calculofrecuenciaerrores', '$numeroserrores', '$tiempotarea')";
if(mysqli_query($conn, $sql3)){
  echo "Registro insertado, el id insertado ha sido el " . mysqli_insert_id($conn);
  $idfrecuenciaerrores= mysqli_insert_id($conn);
}else{
  echo "No se inserto el registro correctamente.";
}
$sql2 = "INSERT INTO error(frecuenciaerrores, mensajes, prevencion, redundancia, enlaces) 
VALUES ('$idfrecuenciaerrores', '$mensajes', '$prevencion', '$redundancia', '$enlaces')";
if(mysqli_query($conn, $sql2)){
  echo "Registro insertado, el id insertado ha sido el " . mysqli_insert_id($conn);
  $iderror= mysqli_insert_id($conn);
}else{
  echo "No se inserto el registro correctamente.";
}
$sql4 = "INSERT INTO seguridad(permiso, error, calculoderelevancia) 
VALUES ('$idpermiso', '$iderror', '$calculoderelevancia')";
if(mysqli_query($conn, $sql4)){
  echo "Registro insertado, el id insertado ha sido el " . mysqli_insert_id($conn);
  $idseguridad= mysqli_insert_id($conn);
}else{
  echo "No se inserto el registro correctamente.";
}

$conn->close();
?>