<?php

include 'conexion.php';
    
     $id = $_POST["id"];
     //$id = "15";
     
     $sql = "DELETE FROM evaluador WHERE id='$id'";
     
     $result = mysqli_query($conexion,$sql);
     
     if($result){
         echo "Data Deleted";
        
     }
     else{
         echo "Failed";
     }
     mysqli_close($conexion);
     


?>