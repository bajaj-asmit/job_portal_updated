<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

   <style>
   
   body{
   background-image:url(chgpass.jpg);
   color:white;
   }
   .box{
   position:absolute;
   width:700px;
   height:200px;
   left:500px;
   top:250px;
   border:2px solid black;
   background-color:white;
   }
   
   .box form .row{
   margin: 5px;
   position:relative;
   top:25px;
   left:140px;
   }
   
   #btn{
   
   }
   </style>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>admin change password</title>
  </head>
  <body>

   <div class="box">

     <form action="changeAdminPass" method="post">
     
     <div class="row">
     <div class="col-sm-3">
     Enter old password:
     </div>
     <div class="col-sm-3">
     <input type="password" class="form-control" name="oldpass">
     </div>
     </div>
     
     <div class="row">
     <div class="col-sm-3">
      Enter new password:
     </div>
     <div class="col-sm-3">
     <input type="password" class="form-control" name="newpass">
     </div>
     </div>
     <div class="row">
     <div class="col-sm-2">
     <input type="submit" id="btn" class="btn btn-primary" >
     </div>
     </div>
      
     </form>
</div>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    
  </body>
</html>