<?php
/* Displays user information and some useful messages */
session_start();
// Check if user is logged in using the session variable
if ( $_SESSION['logged_in'] != 1 ) {
  $_SESSION['message'] = "You must log in before viewing your profile page!";
  header("location: error.php");    
}
else {
    // Makes it easier to read
    $first_name = $_SESSION['first_name'];
    $last_name = $_SESSION['last_name'];
    $email = $_SESSION['email'];
    $active = $_SESSION['active'];
}
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
     <!--Boostrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css" integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy" crossorigin="anonymous">
    <title>Welcome <?= $first_name.' '.$last_name ?></title>
    <!-- CSS External link  -->
    <link rel="stylesheet" href="index.css">
    <!--Javascript External link -->
    <script src="index.js"></script>
    <!-- icon tab-->
    <link rel="icon" href="icon.jpeg">
   
</head>
<!--SET bk color to info and animated-->
<body id="main" class="progress-bar progress-bar-striped bg-info progress-bar-animated" role="progressbar" aria-valuenow="75"  aria-busy=""aria-valuemin="0" aria-valuemax="100" style="width: 100%"onload="onLoad()">
<!--Audio source with autoplay as soon as websites loads which will keep looping and its hidden from the user -->

          <p>
          <?php 
     
          // Display message about account verification link only once
          if ( isset($_SESSION['message']) )
          {
              echo $_SESSION['message'];
              
              // Don't annoy the user with more messages upon page refresh
              unset( $_SESSION['message'] );
          }
          
          ?>
          </p>
          
          <?php
          
          // Keep reminding the user this account is not active, until they activate
          if ( !$active ){
              echo
              '<div class="info">
              Account is unverified, please confirm your email by clicking
              on the email link!
              </div>';
          }
          
          ?>        
<!--Header tag-->
   <header class="mt-3">
        <!--Title -->
        <h1>SECURE YOUR DATA<img id="logo" src="logo.jpeg" alt="Logo" style="width:100px; height:100px; margin-top:-5px;padding: 30px"> </h1>
        
        <!--NavBar -->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="index.php">Home</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="logout.php">Logout <span class="sr-only"></span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Download Application</a>
                    </li>
                    <li class="nav-item dropdown">
                         <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                             About Us
                         </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                             <a class="dropdown-item" href="gallery.php">Gallery</a>
                             <a class="dropdown-item" href="about.php">Information</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="contact.php">Contact Us</a>
                        </div>
                  </li>
             </ul>
          </div>
    </nav>
 </header>
<?php include('form_process.php'); ?>
<link rel="stylesheet" href="form.css" type="text/css">
<div class="container">  
  <form id="contact" action="<?= htmlspecialchars($_SERVER["PHP_SELF"]) ?>" method="post">
    <h3>Contact</h3>
    <h4>Send Us Feedback, and get reply shortly!</h4>
    <fieldset>
      <input placeholder="Your Email Address..." type="text" name="email" value="<?= $email ?>" tabindex="2">
      <span class="error"><?= $email_error ?></span>
    </fieldset>
    <fieldset>
    <fieldset>
      <textarea placeholder="Enter Feedback Here..." value="<?= $message ?>" name="message" tabindex="5"></textarea>
    </fieldset>
    <fieldset>
      <button name="submit" type="submit" id="contact-submit" data-submit="...Sending" onclick="showLoader()">Submit</button>
    </fieldset>
    <div class="success"><?= $success ?></div>
    <div class="error"><?= $error ?></div>
    <div  id="loader" class="sk-circle" >
      <div class="sk-circle1 sk-child"></div>
      <div class="sk-circle2 sk-child"></div>
      <div class="sk-circle3 sk-child"></div>
      <div class="sk-circle4 sk-child"></div>
      <div class="sk-circle5 sk-child"></div>
      <div class="sk-circle6 sk-child"></div>
      <div class="sk-circle7 sk-child"></div>
      <div class="sk-circle8 sk-child"></div>
      <div class="sk-circle9 sk-child"></div>
      <div class="sk-circle10 sk-child"></div>
      <div class="sk-circle11 sk-child"></div>
      <div class="sk-circle12 sk-child"></div>
    </div>
  
  </form>
</div>
            <footer style=" position: fixed; width: 100%; left: 0; bottom: 0; text-align: center;">
                Made by Marley Ebejer
           </footer>
    <!--Boostrap JS-->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js" integrity="sha384-a5N7Y/aK3qNeh15eJKGWxsqtnX/wWdSZSKp+81YjTmS15nvnvxKHuzaWwXHDli+4" crossorigin="anonymous"></script>
</body>
</html>