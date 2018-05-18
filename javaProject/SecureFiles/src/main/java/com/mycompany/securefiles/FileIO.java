package com.mycompany.securefiles;

/**
 *
 * @author Marley
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.*;
public class FileIO {
    public static void main(String[]args){
        
        //Create a new Path Object
        
         System.out.println("The home folder is: "+System.getProperty("user.dir"));
         System.out.println("The home folder is: "+System.getProperty("user.home"));
         Path pictureDirectory = Paths.get(System.getProperty("user.home"),"Pictures");
         System.out.println("Your pictuers folder os at: " +pictureDirectory );
         Path myPath =Paths.get("/some/path");
         
         //Delete a file
         try
         {
             Path deleteFilePath = Paths.get(System.getProperty("user.home"),"Documents","README.txt");
             Files.delete(deleteFilePath);
             System.out.println("Deleted.");
                     }
         catch(Exception e)
         {
             e.printStackTrace();
         }
        //Rename a file
        try
        {
            File oldFile = new File(System.getProperty("user.home")+"/Documents/license.txt");
            File newFile = new File(System.getProperty("user.home")+"/Documents/test.txt");
            oldFile.renameTo(newFile);
            System.out.println("Name Changed");
            File moveFile = new File(System.getProperty("user.home")+"test.txt");
            newFile.renameTo(moveFile);
            System.out.println("File Moved");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        //Copy File
        try{
             Path fileToCopy = Paths.get(System.getProperty("user.home")+ "/Pictures/logo.jpeg");
            Path copiedFile = Paths.get(System.getProperty("user.home")+ "/Pictures/copylogo.jpeg");
            
            Files.copy(fileToCopy,copiedFile, REPLACE_EXISTING);
        }
        catch(Exception e){
            e.printStackTrace();
        }   
        /*try
        {
            File fileToCopy = new File(System.getProperty("user.home")+ "/Pictures/logo.jpeg");
            File copiedFile = new File(System.getProperty("user.home")+ "/Pictures/copylogo.jpeg");
            
            //Create a new file
            copiedFile.createNewFile();
            
            //Create our streams
            FileInputStream fis = new FileInputStream(fileToCopy);
             FileOutputStream fos = new FileOutputStream(copiedFile);
             
             //Write from old file to new file
             int aByte;
             while((aByte = fis.read())!= -1)
             {
                 fos.write(aByte);
             }
             fis.close();
             fos.close();
             
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        */
        
       //List files in a directory
       try{
           File documentsFolder = new File(System.getProperty("user.home")+"/Documents");
           File[] filesInFolder = documentsFolder.listFiles();
           
           for (int i = 0; i < filesInFolder.length; i++) {
               System.out.println(filesInFolder[i]);
               
           }
       }
       catch(Exception e){
           e.printStackTrace();
       }
    }
    
}
