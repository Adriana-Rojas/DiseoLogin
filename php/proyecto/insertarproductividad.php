<?php
include 'conexion.php';

$productividad_inexperto=$_POST['productividad_inexperto'];
$calculorelevancia="1";

// Create connection
$conn = new mysqli($hostname,$username,$password,$database);
// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}


$sql = "INSERT INTO salidausuario(productividad_inexperto) 
VALUES ('$productividad_inexperto')";
if(mysqli_query($conn, $sql)){
  echo "Registro insertado, el id insertado ha sido el " . mysqli_insert_id($conn);
  $idsalidausuario= mysqli_insert_id($conn);
}else{
  echo "No se inserto el registro correctamente.";
}
$sql2 = "INSERT INTO productividad(salidausuario, calculorelevancia) 
VALUES ('$idsalidausuario', '$calculorelevancia')";
if(mysqli_query($conn, $sql2)){
  echo "Registro insertado, el id insertado ha sido el " . mysqli_insert_id($conn);
  $idproductividad= mysqli_insert_id($conn);
}else{
  echo "No se inserto el registro correctamente.";
}

$conn->close();
?>