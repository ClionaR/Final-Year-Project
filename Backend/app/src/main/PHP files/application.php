<?php

if($_SERVER['REQUEST_METHOD']=='POST'){

 include 'db_config.php';
 echo "dbConfig \n";
 
 $url = mysqli_connect($servername,$username,$password,$dbname);
 echo "connect \n";
 
 echo "name passed in " .$_SERVER['HTTP_NAME']. "!\n";
 echo "address passed in " . $_SERVER['HTTP_ADDRESS'] . "!\n";
 echo "email passed in " . $_SERVER['HTTP_EMAIL'] . "!\n";
 echo "animalType passed in " . $_SERVER['HTTP_ANIMALTYPE'] . "!\n";
 echo "animalName passed in " . $_SERVER['HTTP_ANIMALNAME'] . "!\n";
 echo "otherPeople passed in " . $_SERVER['HTTP_OTHERPEOPLE'] . "!\n";
 echo "otherPets passed in " . $_SERVER['HTTP_OTHERPETS'] . "!\n";
 $name = $_SERVER['HTTP_NAME'];
 $addr = $_SERVER['HTTP_ADDRESS'];
 $ema = $_SERVER['HTTP_EMAIL'];
 $anity = $_SERVER['HTTP_ANIMALTYPE'];
 $anina = $_SERVER['HTTP_ANIMALNAME'];
 $othppl = $_SERVER['HTTP_OTHERPEOPLE'];
 $othpet = $_SERVER['HTTP_OTHERPETS'];
 
 
 echo "variables input \n";
 
 $Sql_Query = "insert into applicants(name, phone, address,email,animalType, animalName, otherPeople, otherPets) values('$name', null, '$addr', '$ema', '$anity', '$anina', '$othppl', '$othpet')";
 
 
 if(isset($check)){
 
 echo "Data Inserted";
 }
 else{
 echo "Insert Failed";
 }
 
 }else{
 echo "Check Again";
 }
mysqli_close($url);

?>