<?php
include 'conexion.php';

$tiempoinicio=$_POST['tiempoinicio'];
$tiemporespuesta=$_POST['tiemporespuesta'];
$numerodeevaluaciones=$_POST['numerodeevaluaciones'];
$calculartiemporespuesta=$_POST['calculartiemporespuesta'];
$consumoram=$_POST['consumoram'];
$consumomedram=$_POST['consumomedram'];
$consumomaxram=$_POST['consumomaxram'];
$calculoram=$_POST['calculoram'];
$consumocpu=$_POST['consumocpu'];
$consumomedcpu=$_POST['consumomedcpu'];
$consumomaxcpu=$_POST['consumomaxcpu'];
$calculocpu=$_POST['calculocpu'];
$iniciobateria=$_POST['iniciobateria'];
$finalbateria=$_POST['finalbateria'];
$calculobateria=$_POST['calculobateria'];
$esfuerzo=$_POST['esfuerzo'];
$efectividadrelativatarea=$_POST['efectividadrelativatarea'];
$costototal=$_POST['costototal'];
$calculocostoeconomico=$_POST['calculocostoeconomico'];
/*
$tiempoinicio="2";
$tiemporespuesta="2";
$numerodeevaluaciones="2";
$calculartiemporespuesta="2";
$consumoram="2";
$consumomedram="3";
$consumomaxram="2";
$calculoram="2";
$consumocpu="2";
$consumomedcpu="2";
$consumomaxcpu="2";
$calculocpu="2";
$canticonsumida="2";
$consumomedbateria="2";
$calculobateria="2";
$esfuerzo="2";
$completartarea="2";
$calculoesfuerzo="2";
//$efectividadrelativatarea="2";
$costototal="2";
$calculoderelevancia="2";*/
//
$calculoderelevancia=$_POST['calculoderelevancia'];
//

// Create connection
$conn = new mysqli($hostname,$username,$password,$database);
// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}


$sql = "INSERT INTO tiemporespuesta( tiempoinicio, tiemporespuesta, numerodeevaluaciones, calculartiemporespuesta) 
VALUES ('$tiempoinicio', '$tiemporespuesta', '$numerodeevaluaciones', '$calculartiemporespuesta')";

if(mysqli_query($conn, $sql)){
  echo "Registro insertado, el id insertado ha sido el " . mysqli_insert_id($conn);
  $idtiemporespuesta= mysqli_insert_id($conn);
}else{
  echo "No se inserto el registro correctamente.";
}

$sql2 = "INSERT INTO ram(consumoram, consumomedram, consumomaxram, calculoram) 
VALUES ( '$consumoram', '$consumomedram', '$consumomaxram', '$calculoram')";
if(mysqli_query($conn, $sql2)){
  echo "Registro insertado, el id insertado ha sido el " . mysqli_insert_id($conn);
  $idram= mysqli_insert_id($conn);
}else{
  echo "No se inserto el registro correctamente.";
}
$sql3 = "INSERT INTO cpu(consumocpu, consumomedcpu, consumomaxcpu, calculocpu) 
VALUES ('$consumocpu', '$consumomedcpu', '$consumomaxcpu', '$calculocpu')";
if(mysqli_query($conn, $sql3)){
  echo "Registro insertado, el id insertado ha sido el " . mysqli_insert_id($conn);
  $idcpu= mysqli_insert_id($conn);
}else{
  echo "No se inserto el registro correctamente.";
}
$sql4 = "INSERT INTO bateria(iniciobateria, finalbateria, calculobateria) 
VALUES ( '$iniciobateria', '$finalbateria', '$calculobateria')";
if(mysqli_query($conn, $sql4)){
  echo "Registro insertado, el id insertado ha sido el " . mysqli_insert_id($conn);
  $idbateria= mysqli_insert_id($conn);
}else{
  echo "No se inserto el registro correctamente.";
}

$sql5 = "INSERT INTO esfuerzo(esfuerzo) 
VALUES ( '$esfuerzo')";
if(mysqli_query($conn, $sql5)){
  echo "Registro insertado, el id insertado ha sido el " . mysqli_insert_id($conn);
  $idesfuerzo= mysqli_insert_id($conn);
}else{
  echo "No se inserto el registro correctamente.";
}
$sql6 = "INSERT INTO costoeconomico(costototal) 
VALUES ( '$costototal')";
if(mysqli_query($conn, $sql6)){
  echo "Registro insertado, el id insertado ha sido el " . mysqli_insert_id($conn);
  $idcostoeconomico= mysqli_insert_id($conn);
}else{
  echo "No se inserto el registro correctamente.";
}

$sql7 = "INSERT INTO recursos(tiemporespuesta, ram, cpu, bateria)
VALUES ('$idtiemporespuesta', '$idram', '$idcpu', '$idbateria')";
if(mysqli_query($conn, $sql7)){
  echo "Registro insertado, el id insertado ha sido el " . mysqli_insert_id($conn);
  $idrecursos= mysqli_insert_id($conn);
}else{
  echo "No se inserto el registro correctamente.";
}

$sql8= "INSERT INTO eficiencia(recursos, esfuerzo, costoeconomico, calculoderelevancia) 
VALUES ('$idrecursos', '$idesfuerzo', '$idcostoeconomico', '$calculoderelevancia')";
if(mysqli_query($conn, $sql8)){
  echo "Registro insertado, el id insertado ha sido el " . mysqli_insert_id($conn);
  $ideficiencia= mysqli_insert_id($conn);
}else{
  echo "No se inserto el registro correctamente.";
}

$conn->close();
?>