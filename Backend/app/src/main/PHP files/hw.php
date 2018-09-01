<?php

if($_SERVER['REQUEST_METHOD']=='POST'){

 include 'db_config.php';
 echo "dbConfig \n";
 
 $url = mysqli_connect($servername,$username,$password,$dbname);
 echo "connect \n";
 
 echo "username passed in " .$_SERVER['HTTP_USERNAME']. "!\n";
 echo "password passed in " . $_SERVER['HTTP_PASSWORD'] . "!\n";
 $name = $_SERVER['HTTP_USERNAME'];
 $pwd = $_SERVER['HTTP_PASSWORD'];
 
 
 echo "variables input \n";
 
 $Sql_Query = "select * from login where username = '$name' and password = '$pwd' ";
 
 $check = mysqli_fetch_array(mysqli_query($url,$Sql_Query));
 
 if(isset($check)){
 
 echo "Data Matched";
 }
 else{
 echo "Invalid Username or Password Please Try Again";
 }
 
 }else{
 echo "Check Again";
 }
mysqli_close($url);

?>