<?php

include 'conexion.php';
    
     $id = $_POST["id"];
     $nombre = $_POST["nombre"];
     $telefono = $_POST["telefono"];
     $correo = $_POST["correo"];
     $contraseña = $_POST["contraseña"];
/*
     $id = "15";
     $nombre ="modifi";
     $telefono = "telemodo";
     $correo = "correomodif";
     $contraseña = "contramodi";*/
     
     $sql = "UPDATE usuario SET  nombre = '$nombre', telefono = '$telefono', correo = '$correo', contraseña = '$contraseña' WHERE id = '$id' ";
     
     $result = mysqli_query($conexion,$sql);
     
     if($result){
         echo "usuario Updated";
        
     }
     else{
         echo "Failed";
     }
     mysqli_close($conexion);
     
        
?>