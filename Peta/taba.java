import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class taba {
  private static boolean notDone = true;


  public void isDone(boolean notDone){
    this.notDone = notDone;
  }
  public boolean getValue(){
    return notDone;
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
          break;
      }

    
  }


 }   
}



class dat {
int count = 0;
taba taba = new taba();
Scanner s = new Scanner(System.in);
String role = "";
String folderPath = "Downloads\\Peta\\Database\\" + role;


//Doctors
     String fileName = "Oraya";  
      String doctorsPath = folderPath + "\\" + fileName + ".txt";
      File dFile = new File(doctorsPath);
     // Patient
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
      
        System.out.println("--------------------------------------");
        System.out.println("Search for a doctor\nEnter doctor's last name: ");
        String lName = s.nextLine();
        dSetFileName(lName);

        if(dFile.exists()){
          count = 0;
            readFile(dFile);
            System.out.println("Are you now done looking for doctors? ");
            String ans = s.nextLine();
            switch (ans.toLowerCase()) {
                case "yes":
                taba.isDone(false);
            
                    
                    break;
                case "no":
                taba.isDone(true);
                break;
            
                default:
                System.out.println("Not a valid option.\nEnding process now.");
                taba.isDone(false);
                    break;
            }

        }
        else{
          System.out.println("There's no Doctor named " + lName + " here");
          System.out.println("Please try again");

          count++;
          System.out.println(taba.getValue());
          System.out.println(count);

        }
       if(count >=3 ){
        System.out.println("Do you still want to continue? ");
        String ans = s.nextLine();
       
        if(ans.equalsIgnoreCase("yes")){
          count = 0;

        }else{
          System.out.println("ending process now.");
          taba.isDone(false);
        }
      }
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
        System.out.println("--------------------------------------");
        System.out.println("Search for patient\nEnter Patient's last name and First Name:");
        System.out.println("(Click Enter before entering First Name)");
        String last = s.nextLine();
        String first = s.nextLine();
        System.out.println("Enter Patient's ID number: \nex.000001");
        patientNum = s.nextLine();
       
        System.out.println("Enter doctor's diagnosis: ");
        diagnosis = s.nextLine();

        fileName = last + ","+first;
        pSetFileName(fileName);
        readFile(pFile);
        if(pFile.exists()){
          System.out.println("tae ko mabaho");
          taba.isDone(false);
        }else{
          taba.isDone(false);
        }

        
      
      }

      
  
     
  }