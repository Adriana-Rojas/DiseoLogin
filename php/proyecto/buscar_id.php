<?php 

$con=mysqli_connect("localhost","root","","proyecto");
// Check connection
$nombre="perez";
if (!$con) {
  die("Connection failed: " . mysqli_connect_error());
}

$sql = "SELECT id, nombre, correo FROM usuario where nombre=? ";
$sentencia->bind_param('ss',$nombre);
$sentencia->execute();
$result = mysqli_query($con, $sql);

if (mysqli_num_rows($result) > 0) {
  // output data of each row
  while($row = mysqli_fetch_assoc($result)) {
    echo "id: " . $row["id"]. " - Name: " . $row["nombre"]. " " . $row["correo"]. "<br>";
  }
} else {
  echo "0 results";
}

mysqli_close($con);
?>