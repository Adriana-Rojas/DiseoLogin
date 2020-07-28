<?php
include 'conexion.php';

$tareascompletadas=$_POST['tareascompletadas'];
$totaltareas=$_POST['totaltareas'];
$calculoterminaciontarea=$_POST['calculoterminaciontarea'];

$calculoefectividad=$_POST['calculoefectividad'];
$numerofaltas=$_POST['numerofaltas'];

$calculotiempo=$_POST['calculotiempo'];

$calculoextensibilidad=$_POST['calculoextensibilidad'];

$calculoreusabilidad=$_POST['calculoreusabilidad'];

$calculoescalabilidad=$_POST['calculoescalabilidad'];

//
$calcularcumplimientotarea="1";
$calculoderelevancia="1";
//


// Create connection
$conn = new mysqli($hostname,$username,$password,$database);
// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}


$sql = "INSERT INTO terminaciontarea(tareascompletadas, totaltareas, calculoterminaciontarea) 
VALUES ('$tareascompletadas', '$totaltareas', '$calculoterminaciontarea')";
if(mysqli_query($conn, $sql)){
  echo "Registro insertado, el id insertado ha sido el " . mysqli_insert_id($conn);
  $idterminaciontarea= mysqli_insert_id($conn);
}else{
  echo "No se inserto el registro correctamente.";
}
$sql2 = "INSERT INTO efectividadtarea(calculoefectividad, numerofaltas) 
VALUES ('$calculoefectividad', '$numerofaltas')";
if(mysqli_query($conn, $sql2)){
  echo "Registro insertado, el id insertado ha sido el " . mysqli_insert_id($conn);
  $idefectividadtarea= mysqli_insert_id($conn);
}else{
  echo "No se inserto el registro correctamente.";
}
$sql3 = "INSERT INTO tiempotarea(calculotiempo) 
VALUES ('$calculotiempo')";
if(mysqli_query($conn, $sql3)){
  echo "Registro insertado, el id insertado ha sido el " . mysqli_insert_id($conn);
  $idtiempotarea= mysqli_insert_id($conn);
}else{
  echo "No se inserto el registro correctamente.";
}
$sql4 = "INSERT INTO extensibilidad(calculoextensibilidad) 
VALUES ('$calculoextensibilidad')";
if(mysqli_query($conn, $sql4)){
  echo "Registro insertado, el id insertado ha sido el " . mysqli_insert_id($conn);
  $idextensibilidad= mysqli_insert_id($conn);
}else{
  echo "No se inserto el registro correctamente.";
}
$sql5 = "INSERT INTO reusabilidad(calculoreusabilidad) 
VALUES ('$calculoreusabilidad')";
if(mysqli_query($conn, $sql5)){
  echo "Registro insertado, el id insertado ha sido el " . mysqli_insert_id($conn);
  $idreusabilidad= mysqli_insert_id($conn);
}else{
  echo "No se inserto el registro correctamente.";
}
$sql6 = "INSERT INTO escalabilidad(calculoescalabilidad) 
VALUES ('$calculoescalabilidad')";
if(mysqli_query($conn, $sql6)){
  echo "Registro insertado, el id insertado ha sido el " . mysqli_insert_id($conn);
  $idescalabilidad= mysqli_insert_id($conn);
}else{
  echo "No se inserto el registro correctamente.";
}

$sql7 = "INSERT INTO cumplimientotarea(efectividadtarea, tiempocompletar, calcularcumplimientotarea) 
VALUES ('$idefectividadtarea', '$idtiempotarea', '$calcularcumplimientotarea')";
if(mysqli_query($conn, $sql7)){
  echo "Registro insertado, el id insertado ha sido el " . mysqli_insert_id($conn);
  $idcumplimientotarea= mysqli_insert_id($conn);
}else{
  echo "No se inserto el registro correctamente.";
}

$sql8 = "INSERT INTO eficacia(terminaciontareas, cumpliminentotarea, calculoderelevancia, extensibilidad, reusabilidad, escalabilidad)
VALUES ('$idterminaciontarea', '$idcumplimientotarea', '$calculoderelevancia', '$idextensibilidad', '$idreusabilidad', '$idescalabilidad')";
if(mysqli_query($conn, $sql8)){
  echo "Registro insertado, el id insertado ha sido el " . mysqli_insert_id($conn);
  $ideficacia= mysqli_insert_id($conn);
}else{
  echo "No se inserto el registro correctamente.";
}
$conn->close();
?>