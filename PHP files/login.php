<?php

 if($_SERVER['REQUEST_METHOD']=='POST'){

 include 'db_config.php';
 
 $con = mysqli_connect($servername,$username,$password,$dbname);
 
 $username = $_POST['user'];
 $password = $_POST['password'];
 
 $Sql_Query = "select * from AndroidLoginTable where username = '$username' and password = '$password' ";
 
 $check = mysqli_fetch_array(mysqli_query($con,$Sql_Query));
 
 if(isset($check)){
 
 echo "Data Matched";
 }
 else{
 echo "Invalid Username or Password Please Try Again";
 }
 
 }else{
 echo "Check Again";
 }
mysqli_close($con);