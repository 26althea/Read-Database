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
String folderPath = "Downloads\\Peta\\Database\\" + role;


//Doctors file connected variables
     String fileName = "Oraya";  
      String doctorsPath = folderPath + "\\" + fileName + ".txt";
      File dFile = new File(doctorsPath);
     // Patient file connected variables
      String patientNum = "0";
      String diagnosis;
      String patientPath = folderPath+"\\"+fileName+"-"+patientNum+"-"+diagnosis+ ".txt";
      File pFile = new File(patientPath);

      public void dSetFileName(String newfileName){
          this.fileName = newfileName;
          this.folderPath = "Downloads\\Peta\\Database\\" + role;
          this.doctorsPath = folderPath + "\\" + fileName + ".txt";
          this.dFile = new File(doctorsPath); 
      }
      public void pSetFileName(String newFileName){
        this.fileName = newFileName;
        this.folderPath = "Downloads\\Peta\\Database\\" + role;
        this.patientPath = folderPath+"\\"+fileName+"-"+patientNum+"-"+diagnosis+ ".txt";
        this.pFile = new File(patientPath);
      }

      public void searhDoctor(){
        taba.isDone(true);
        boolean ambaho = true;
        while(ambaho){
      
        System.out.println("--------------------------------------");
        System.out.println("Search for a doctor\nEnter doctor's last name: ");
        String lName = s.nextLine();
        dSetFileName(lName);

        if(dFile.exists()){
          count = 0;
            readFile(dFile);
            System.out.println("Are you done looking for doctors? ");
            String ans = s.nextLine();
            switch (ans.toLowerCase()) {
                case "yes":
                System.out.println("Do you want to go back to mainscreen?");
                String a = s.nextLine();
                if(a.equalsIgnoreCase("yes")){
                  ambaho = false;
            
                }else{
                  taba.isDone(false);
                }
              
                    
                    break;
                case "no":
                taba.isDone(true);
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
        System.out.println("Search for patient\nEnter Patient's last name and First Name:");
        System.out.println("(Click Enter before entering First Name)");
        String last = s.nextLine().trim();
        String first = s.nextLine().trim()  ;
        fileName = last.toUpperCase() + ","+first.toUpperCase();
        pSetFileName(fileName);
        
       
        File path = new File(folderPath);
        String []listOfN = path.list();
       
        for(String names: listOfN){
          if(names.startsWith(fileName)){
            System.out.println(names);
         
          }
        }

        System.out.println("Enter Patient's ID number: \nex.000001");
        patientNum = s.nextLine();


       
        System.out.println("Enter doctor's diagnosis: ");
        diagnosis = s.nextLine();
        diagnosis.toUpperCase();
      
         
        pSetFileName(fileName);

        if(pFile.exists()){
          readFile(pFile);

          taba.isDone(false);

        }else{
          System.out.println(pFile);
          System.out.println("You're looking for something that doesn't exists");
        }

        
      
      }
    }
      
  
     
  }
