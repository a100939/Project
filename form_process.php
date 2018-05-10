<?php 
require 'db.php';
use PHPMailer\PHPMailer\PHPMailer;
use PHPMailer\PHPMailer\Exception;
require 'vendor/autoload.php';


//Define variables
    $email_error = "";
    $email = $message = $error = $success = "";

//form is submitted with POST method


if ( $_SERVER['REQUEST_METHOD'] == 'POST' ) 
{   
    $email = $mysqli->escape_string($_POST['email']);
    $result = $mysqli->query("SELECT * FROM users WHERE email='$email'");

    
    if (empty($_POST["email"])) {
         $email_error = "Email is required"; 
         
    }
    else{
        if ( $result->num_rows == 0 ) // User doesn't exist
        { 
            $email_error = "User with that email doesn't exist!";
          
        }
        else { // User exists (num_rows != 0)
        
        $user = $result->fetch_assoc(); // $user becomes array with user data
        $email = $user['email'];
        $hash = $user['hash'];
        $first_name = $user['name'];
        $active = $user['active'];
        
        if($active ==  false)
        {
            $email_error = "You need to active account first!!";
        }
            else{ 
                
                if (empty($_POST["message"])) {
                    $error ="Message Needs to be filled!!";
                    $message = "";
                } 
                
                else{
                    
                

                
                $mail = new PHPMailer(true);   
        
                $mail->isSMTP();                                      // Set mailer to use SMTP
                $mail->Host = 'smtp.gmail.com';  // Specify main and backup SMTP servers
                $mail->SMTPAuth = true;                               // Enable SMTP authentication
                $mail->Username = 'securefiles2017.2018@gmail.com';                 // SMTP username
                $mail->Password = 'sf2017/2018';                           // SMTP password
                $mail->SMTPSecure = 'tls';                            // Enable TLS encryption, `ssl` also accepted
                $mail->Port = 587;                                    // TCP port to connect to
                
                //Recipients
                $mail->setFrom($email, $first_name);
                $mail->addAddress('securefiles2017.2018@gmail.com');     // Add a recipient
                $mail->isHTML(true);                                  // Set email format to HTML
                $mail->Subject ='Feedback from '.$first_name.' with email: '.$email;
                $mail->Body = test_input($_POST["message"]);
                $mail->send();
                $success = "Message has been sent, thank you for contacting us!";
            }    
             if ($email_error == ''){
                 $message_body = '';
                 unset($_POST['submit']);
                 foreach ($_POST as $key => $value){
                     $message_body .=  "$key: $value\n";
  
  
 
                 }
             }
            }
        }
    }
}



      
  
  function test_input($data) {
  $data = trim($data);
  $data = stripslashes($data);
  $data = htmlspecialchars($data);
  return $data;
}



?>





  




