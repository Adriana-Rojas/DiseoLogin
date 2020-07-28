<?php
include 'conexion.php';

$rapidez=$_POST['rapidez'];
$dificultad=$_POST['dificultad'];
$aprendizaje=$_POST['aprendizaje'];
$facilidad=$_POST['facilidad'];
//
$calculorelevancia="1";
//

// Create connection
$conn = new mysqli($hostname,$username,$password,$database);
// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}

$sql = "INSERT INTO comprensibilidad(rapidez, dificultad, aprendizaje, facilidad) 
VALUES ('$rapidez', '$dificultad', '$aprendizaje', '$facilidad')";
if(mysqli_query($conn, $sql)){
  echo "Registro insertado, el id insertado ha sido el " . mysqli_insert_id($conn);
  $idcomprensibilidad= mysqli_insert_id($conn);
}else{
  echo "No se inserto el registro correctamente.";
}
$sql2 = "INSERT INTO memorabilidad(comprensibilidad,calculorelevancia) 
VALUES ('$idcomprensibilidad','$calculorelevancia')";
if(mysqli_query($conn, $sql2)){
  echo "Registro insertado, el id insertado ha sido el " . mysqli_insert_id($conn);
  $idmemorabilidad= mysqli_insert_id($conn);
}else{
  echo "No se inserto el registro correctamente.";
}
$conn->close();
?>