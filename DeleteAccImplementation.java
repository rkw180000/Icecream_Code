import java.util.Scanner;


    class usrAccount //class used for user accounts with necessary variables
    {
        String phoneNum;
        String usrId;
        String password;
        String email;
        String paymentInfo;
        boolean active;
        public usrAccount(String usrIdentification) //first constructor with just id
        {
            phoneNum="";
            usrId=usrIdentification;
            password="";
            email="";
            active=false;
           
            
                   
        }
        public usrAccount(String usrIden, String phone, String pwd, String eml)//second constructor with all creation variables
        {
            phoneNum=phone;
            usrId=usrIden;
            password=pwd;
            email=eml;
            active=false;
            
        }
            
    }
        
        
    public class DeleteAccImplementation {


    public static usrAccount [] existingAccs = new usrAccount[3]; //creating database of existing accounts
   
    
    public static void main(String[] args) //creating and testing with main method
    {
        
        existingAccs[0]=new usrAccount("grefw", "2149550644", "password", "validemail@yahoo.com");
        existingAccs[1]=new usrAccount("greddddw", "2149550644", "password", "validemail@yahoo.com");
        existingAccs[2]=new usrAccount("greejncewknfcyes", "2149550644", "password", "validemail@yahoo.com");
        
    }
    
    public static boolean checkAccExist(String usrID)//used to check if an account exists tied to the username
    {
        for(int i=0; i<existingAccs.length; i++) //loop through and find if account exists
        {
            if(usrID.equals(existingAccs[i].usrId) ){
                return true;
            }
        }
        return false;
    }
    
   
     public static String delete(String usrID, String response) //main method to delete an existing account
    {
        // Scanner newScan= new Scanner(System.in); //creating scanner and string to confirm deletion
        // String response;
         
         existingAccs[0]=new usrAccount("grefw", "2149550644", "password", "validemail@yahoo.com");
         existingAccs[1]=new usrAccount("greddddw", "2149550644", "password", "validemail@yahoo.com");
         existingAccs[2]=new usrAccount("greejncewknfcyes", "2149550644", "password", "validemail@yahoo.com");
        
         
         if( checkAccExist( usrID ) == true )  //check if account exists for deletion
         {
            //System.out.println("Account was found, are you sure you wish to delete your account?");
            //response=newScan.nextLine();
            if (response.equalsIgnoreCase("yes") == true) //if deletion confirmed then find account in array and remove elements
            {
                for(int i=0; i< existingAccs.length; i++) {
                    
                    
                    if(usrID.equals(existingAccs[i].usrId)) //if account is found with searched id
                    {
                        if (existingAccs[i].active) //if account is currently active(being used) block deletion
                        {
                            return ("Account is active somewhere and therefore cannot be deleted");
                        }
                        existingAccs[i].usrId=""; //otherwise nullify all info for given account and give confirmation
                        existingAccs[i].email="";
                        existingAccs[i].password="";
                        existingAccs[i].paymentInfo="";
                        existingAccs[i].phoneNum="";
                        
                        return ("Account found and deleted.");
                    }

                    
                }
            }
            else
            {
            	return("Account was not deleted");
            }
                
         }
         else //if account cannot be found let user known deletion failed
         {
             return ("Account cannot be found and cannot be deleted, exiting");
         }
         return ("Unknown failure, returning to menu"); //random error catcher
         
        
     }
    }
    
   
    
    
    
    
    

    
    

   

