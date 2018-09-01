
<?php
$servername = "127.0.0.1";
$username = "root";
$password = "";
$dbname = "androidconnection";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Cliona Connection failed: " . $conn->connect_error);
} 

$sql = "Select * FROM animals";


if ($conn->query($sql) == TRUE) 
{
    echo " successfully!!";
	$result = $conn->query($sql);
	while($row = $result->fetch_assoc()) 
	{
        echo "Name: " . $row["Name"]. " - Description: " . $row["Description"] . "\r\n";
    }
} 
else 
{
    echo "Cliona Error: " . $sql . "<br>" . $conn->error;
}

$conn->close();
?>