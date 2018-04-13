<?php
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

$sql = mysql_query("SELECT Name FROM dogs");
//$result = $conn->query($sql);

$return_arr = array();

//if ($result->num_rows > 0) {
    // output data of each row
while($row = mysql_fetch_array($sql, MYSQLASSOC)) {
    $row_array['name'] = $row['Name'];
	
	array_push($return_arr, $row_array);
}

echo json_encode($return_arr);
//} else {
  //  echo "0 results";
//}


$conn->close();
?>