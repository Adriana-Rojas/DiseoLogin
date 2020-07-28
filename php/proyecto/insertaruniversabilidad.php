<?php
include 'conexion.php';

$resolucion=$_POST['resolucion'];
$lenguaje=$_POST['lenguaje'];
$fuente=$_POST['fuente'];
$contraste=$_POST['contraste'];
$idioma=$_POST['idioma'];
$uso=$_POST['uso'];
//
$calculocarga="1";
//
// Create connection
$conn = new mysqli($hostname,$username,$password,$database);
// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}


$sql = "INSERT INTO accesibilidad(resolucion, lenguaje, fuente, contraste,idioma) 
VALUES ('$resolucion', '$lenguaje', '$fuente', '$contraste','$idioma')";
if(mysqli_query($conn, $sql)){
  echo "Registro insertado, el id insertado ha sido el " . mysqli_insert_id($conn);
  $idaccesibilidad= mysqli_insert_id($conn);
}else{
  echo "No se inserto el registro correctamente.";
}
$sql3 = "INSERT INTO fidelidad(uso) 
VALUES ('$uso')";
if(mysqli_query($conn, $sql3)){
  echo "Registro insertado, el id insertado ha sido el " . mysqli_insert_id($conn);
  $idfidelidad= mysqli_insert_id($conn);
}else{
  echo "No se inserto el registro correctamente.";
}
$sql4 = "INSERT INTO universabilidad(accesibilidad, fidelidad, calculocarga)
 VALUES ('$idaccesibilidad', '$idfidelidad', '$calculocarga')";
if(mysqli_query($conn, $sql4)){
  echo "Registro insertado, el id insertado ha sido el " . mysqli_insert_id($conn);
  $iduniversabilidad= mysqli_insert_id($conn);
}else{
  echo "No se inserto el registro correctamente.";
}
$conn->close();
?>