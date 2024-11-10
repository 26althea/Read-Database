import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedWriter;

public class taba {
  private static  boolean notDone = true;
  

  public void isDone(boolean notDone){
    this.notDone = notDone;
  }

 public static void main(String[] args) {
  Scanner s = new Scanner(System.in);
  dat dat = new dat();


    while (notDone) {
      System.out.println("-------------------------------");
      System.out.println("Enter the role you want to search for: *D - Doctor | P - Patient");
      String role = s.nextLine();
      switch (role.toLowerCase()) {
        case "d":
        dat.role = "Doctors";
        dat.searhDoctor();
     
          
          break;
      case "p":
      dat.role = "Patients";
      dat.searchPatient();

      break;
        default:
        System.out.println("Please enter a valid option");
          break;
      }

    
  }
s.close();

 }   
}



class dat {
int count = 0;
taba taba = new taba();
Scanner s = new Scanner(System.in);
String role = "";
String patientNum = new String();
String folderPath = "Downloads\\Peta\\Database\\" + role;
String fileName = new String();  
String path = new String();
File file = new File("wabalabadubdub");

 
      public void setFileName(String newFileName){
        this.fileName = newFileName;
        this.folderPath = "Downloads\\Peta\\Database\\" + role;
        this.path = folderPath+"\\"+fileName;
        this.file = new File(path);
      }

      public void deleteFile() {
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("File " + fileName + " deleted successfully.");
            } else {
                System.out.println("Failed to delete file " + fileName + ".");
            }
        } else {
            System.out.println("File does not exist.");
        }
    }
  
      public void searhDoctor(){
        taba.isDone(true);
        boolean ambaho = true;
        while(ambaho){
      
        System.out.println("--------------------------------------");
        System.out.println("Search for a doctor\nEnter doctor's last name: ");
        String lName = s.nextLine();
        lName +=".txt";
        setFileName(lName);

        if(file.exists()){
          count = 0;
            readFile(file);
            System.out.println("\nAre you done looking for doctors? ");
            String ans = s.nextLine();
            switch (ans.toLowerCase()) {
                case "yes":
                System.out.println("Do you want to go back to main menu?");
                String a = s.nextLine();
                if(a.equalsIgnoreCase("yes")){
                  ambaho = false;
            
                }else{
                  ambaho = false;
                  taba.isDone(false);
                  System.out.println("Ending Process.");

                }
              
                    
                    break;
                case "no":

               
                break;
            
                default:
               
                    break;
            }

        }
        else{
          System.out.println("There's no Doctor named " + lName + " here");
          System.out.println("Please try again");

          count++;
        
        }
       if(count >=3 ){
        System.out.println("Do you still want to continue? ");
        String ans = s.nextLine();
       
        if(ans.equalsIgnoreCase("yes")){
          count = 0;

        }else{
          System.out.println("ending process now.");
          taba.isDone(false);
          ambaho = false;
          
          
          
        }
      }}
      }


      public void readFile(File path){
  
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
        
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


      public void searchPatient(){
      
        boolean mabango = true;
        while(mabango){
        System.out.println("--------------------------------------");
        System.out.println("Search for patient\nEnter Patient's last name and First Name(All of the patient's first name):");
        System.out.println("(Click Enter before entering First Name)");
        String last = s.nextLine().trim();
        String first = s.nextLine().trim()  ;
        fileName = last.toUpperCase() + ","+first.toUpperCase();
        setFileName(fileName);
        
       
        File path = new File(folderPath);
        String []listOfN = path.list();
       boolean itExists = false;
        for(String names: listOfN){
          if(names.startsWith(fileName)){
            System.out.println(names);
            itExists = true;
         
          }
        }
        if (itExists == false) {
          System.out.println("The patient does not exists.");
          mabango = false;
          break;
        }


        System.out.println("Enter Patient's ID number: \nex.000001");
        patientNum = s.nextLine();

        for(String names: listOfN){
      
          if(names.startsWith(fileName + "-" + patientNum)){
            setFileName(names);

          break;
          }
        }
          
       

        if(file.exists()){
          readFile(file);

          System.out.println("\n Edit| Delete | Back");
          String choices = s.nextLine();
          switch (choices.toLowerCase()) {
            case "edit":
              
              break;
          case "delete":
              System.out.println("Are you sure you want to delete this file? yes|no");
              String confirmDelete = s.nextLine();
              if (confirmDelete.equalsIgnoreCase("yes")) {
                 deleteFile();
          }

          break;
          case "back":
          

          System.out.println("Enter yes if you're done searching for a patient No if not: ");
          choices = s.nextLine();
          if (choices.equalsIgnoreCase("yes")) {
            mabango = false;
            
          }else if(choices.equalsIgnoreCase("no")){
            System.out.println("Proceeding to main search.");
            
          }
          
          break;
            default:
              System.out.println("Invalid option.");
              break;
          }
        }else{
          System.out.println(file);
          System.out.println("You're looking for something that doesn't exists");
        }

        
      
      }
    }
      
  
     
  }
