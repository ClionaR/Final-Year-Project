<?php

if($_SERVER['REQUEST_METHOD']=='POST'){

 include 'db_config.php';
 echo "dbConfig \n";
 
 $url = mysqli_connect($servername,$username,$password,$dbname);
 echo "connect \n";
 
 echo "in" .$_POST["username"]. "!";
 echo "passed in" . $_POST["password"] . "!";
 if (isset($_POST['value'])) 
 { 
 // Instructions if $_POST['value'] exist 
  $name = $_POST['username'];
  echo "username is: " + $name;
 } 
  if (isset($_POST['value'])) 
 {  
 // Instructions if $_POST['value'] exist 
  $pwd = $_POST['password'];
  echo "password is: " + $pwd;
 } 
 
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