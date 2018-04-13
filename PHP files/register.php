<?php

 include 'db_config.php';
 $con = mysqli_connect($servername,$username,$password,$dbname);
  //$name = 'name';
  //$pwd = 'ds';
 if (isset($_POST['username'])) 
 { 
 // Instructions if $_POST['value'] exist 
  $name = $_POST['username'];
  echo 'in name is ' + $name;
 }
  
  if (isset($_POST['password'])) 
 {  
 // Instructions if $_POST['value'] exist 
  $pwd = $_POST['password'];
  echo 'password is' + $pwd;
 } 
 
 
 //$query=mysql_query("insert into login (name,password) values ('$name','$pwd')");
 //echo 'after assign sql insert';
 
 
 if(mysqli_query($con,"INSERT INTO login(username, password) VALUES ('$name', '$pwd')")){
 
 
 echo 'Data Inserted Successfully';
 
 }
 else{
 
 echo 'Try Again';
 
 }
 mysqli_close($con);
?>