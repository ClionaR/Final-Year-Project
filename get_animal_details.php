<?php
require 'db_connect.php'; // connects to DB

$query = "SELECT * FROM animals";

if(mysqli_query($conn, $query))
{
    echo'Success';
} else {
    echo'not executed';
}
?>