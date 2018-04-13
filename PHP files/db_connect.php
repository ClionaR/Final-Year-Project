
/<?php
$servername = "127.0.0.1";
$username = "root";
$password = "";
$dbname = "androidconnection";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 

$sql = "Select * FROM animals";

if ($conn->query($sql) === TRUE) {
    echo " successfully";
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}

$conn->close();
?>