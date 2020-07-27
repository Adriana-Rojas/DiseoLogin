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


// Create connection
$conn = new mysqli($hostname,$username,$password,$database);
// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}


$sql = "INSERT INTO terminaciontarea(tareascompletadas, totaltareas, calculoterminaciontarea) 
VALUES ('$tareascompletadas', '$totaltareas', '$calculoterminaciontarea')";
if ($conn->query($sql) === TRUE) {
  echo "New record created successfully";
} else {
  echo "Error: " . $sql . "<br>" . $conn->error;
}
$sql2 = "INSERT INTO efectividadtarea(calculoefectividad, numerofaltas) 
VALUES ('$calculoefectividad', '$numerofaltas')";
if ($conn->query($sql2) === TRUE) {
  echo "New record created successfully";
} else {
  echo "Error: " . $sql2 . "<br>" . $conn->error;
}
$sql3 = "INSERT INTO tiempotarea(calculotiempo) 
VALUES ('$calculotiempo')";
if ($conn->query($sql3) === TRUE) {
  echo "New record created successfully";
} else {
  echo "Error: " . $sql3 . "<br>" . $conn->error;
}
$sql4 = "INSERT INTO extensibilidad(calculoextensibilidad) 
VALUES ('$calculoextensibilidad')";
if ($conn->query($sql4) === TRUE) {
  echo "New record created successfully";
} else {
  echo "Error: " . $sql4 . "<br>" . $conn->error;
}
$sql5 = "INSERT INTO reusabilidad(calculoreusabilidad) 
VALUES ('$calculoreusabilidad')";
if ($conn->query($sql5) === TRUE) {
  echo "New record created successfully";
} else {
  echo "Error: " . $sql5 . "<br>" . $conn->error;
}
$sql6 = "INSERT INTO escalabilidad(calculoescalabilidad) 
VALUES ('$calculoescalabilidad')";

if ($conn->query($sql6) === TRUE) {
  echo "New record created successfully";
} else {
  echo "Error: " . $sq6l . "<br>" . $conn->error;
}

$conn->close();
?>