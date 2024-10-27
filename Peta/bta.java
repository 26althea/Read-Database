import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class bta {
 static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
      dat dat = new dat();
      int count = 0;
     boolean notDone = true;
      while (notDone) {
        System.out.println("--------------------------------------");
        System.out.println("Search for a doctor\nEnter doctor's last name: ");
        String lName = s.nextLine();
        dat.setFileName(lName);
 
       if(dat.file.exists()){
        
        count = 0;
         
         dat.readFile();
        System.out.println("Are you now done searching for Doctors? yes|no");
       String ans = s.nextLine();

       if (ans.equalsIgnoreCase("no")) {
        notDone = true;
       }else if(ans.equalsIgnoreCase("yes")){
        notDone = false;
       }else{
        System.out.println("Not a valid option.\nEnding process now.");
        notDone = false;
       }
 
       }else{
         System.out.println("There's no Doctor named " + lName + " here");
         System.out.println("Please try again");
         
         count++;

       }
       if(count == 3){
        System.out.println("Do you still want to keep going? ");
        String ans = s.nextLine();

        if (ans.equalsIgnoreCase("yes")) {
          count = 0;
          
        }else if (ans.equalsIgnoreCase("no")){
          notDone = false;
          System.out.println("Process ends now.");
        }

       }

       
      }  
         
     
     
    }
}



class dat {


  String folderPath = "Downloads\\new\\Database\\Doctors";
   String fileName = "";  
    String filePath = folderPath + "\\" + fileName + ".txt";
    File file = new File(filePath);
   
    public void setFileName(String newfileName){
        this.fileName = newfileName;
        this.filePath = folderPath + "\\" + fileName + ".txt";
        this.file = new File(filePath);
    }
    public void readFile(){

      try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      
        String inFo;
        System.out.println("--------------------------------------");
        while ((inFo = br.readLine()) != null){
        
        System.out.println(inFo);
        }
         

       

      } catch (IOException e) {
          System.out.println("An error occurred while reading the file.");
          e.printStackTrace();
      }
    
    
    }

   
}