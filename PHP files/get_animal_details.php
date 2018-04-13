<?php
require 'db_config.php'; // connects to DB

$query = "SELECT Name FROM dogs"; 
/*WHERE Age= "Puppy" AND WHERE Size = "Small" AND WHERE Suitability = "Children Under Ten" AND (WHERE LivingSitu = "House With Garden" || LivingSitu = "House Without Garden")" ;
*/
if(mysqli_query($conn, $query))
{
    echo'Success';
} else {
    echo'not executed';
}
?>