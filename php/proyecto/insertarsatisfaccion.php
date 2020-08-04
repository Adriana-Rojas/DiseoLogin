<?php
include 'conexion.php';

$estetica_general=$_POST['estetica_general'];
$comodidad_visual=$_POST['comodidad_visual'];
$informacion=$_POST['informacion'];
$iconos=$_POST['iconos'];
$eleccion=$_POST['eleccion'];
$busqueda=$_POST['busqueda'];
$videos=$_POST['videos'];
$recomendacion=$_POST['recomendacion'];
$calculo_satisfaccion=$_POST['calculo_satisfaccion'];
$organizacion=$_POST['organizacion'];
$interfaz=$_POST['interfaz'];
$gusto=$_POST['gusto'];
$herramientas=$_POST['herramientas'];
$satisfaccion=$_POST['satisfaccion'];
$lenguaje=$_POST['lenguaje'];
$sobrecarga=$_POST['sobrecarga'];
$interfaz_limpia=$_POST['interfaz_limpia'];
$espacio=$_POST['espacio'];
$longitud=$_POST['longitud'];
$texto=$_POST['texto'];
//
$calculoderelevancia=$_POST['calculoderelevancia'];
//
// Create connection
$conn = new mysqli($hostname,$username,$password,$database);
// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}


$sql = "INSERT INTO estetica(estetica_general, comodidad_visual, informacion, iconos, eleccion, busqueda, videos, recomendacion, calculo_satisfaccion, organizacion, interfaz, gusto, herramientas, satisfaccion, lenguaje, sobrecarga, interfaz_limpia, espacio, longitud, texto) 
VALUES ('$estetica_general', '$comodidad_visual', '$informacion', '$iconos', '$eleccion', '$busqueda', '$videos', '$recomendacion', '$calculo_satisfaccion', '$organizacion', '$interfaz', '$gusto', '$herramientas', '$satisfaccion', '$lenguaje', '$sobrecarga', '$interfaz_limpia', '$espacio', '$longitud', '$texto')";
if(mysqli_query($conn, $sql)){
  echo "Registro insertado, el id insertado ha sido el " . mysqli_insert_id($conn);
  $idestetica= mysqli_insert_id($conn);
}else{
  echo "No se inserto el registro correctamente.";
}
$sql2 = "INSERT INTO satisfaccion(estetica, calculoderelevancia) 
VALUES ('$idestetica', '$calculoderelevancia')";
if(mysqli_query($conn, $sql2)){
  echo "Registro insertado, el id insertado ha sido el " . mysqli_insert_id($conn);
  $idsatisfaccion= mysqli_insert_id($conn);
}else{
  echo "No se inserto el registro correctamente.";
}

$conn->close();
?>