import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateAccountFinalImplementation {

    public static final int MIN_LENGTH_LOGIN_ID = 8;
    public static final int MAX_LENGTH_LOGIN_ID = 20;

    public static final int MIN_LENGTH_PWD = 8;
    public static final int MAX_LENGTH_PWD = 12;
    
    public static final int LENGTH_PHONE = 10;
   

    public static String[] existingAccs = {"xxxxbbbba", "johnbennett", "softWareEng", "activeUser", "alrExists", "checkAgain"}; //existing accounts
    public static String[] validAreaCode={"214", "469", "972", "936", "281"}; //small sample of valid phone area codes
    public static char[] invalidCharacters = {' ', ',', '/', '\\'}; //possible invalid chars

    public static boolean checkIDLength(String usrID) //used to check for ID length reqs
    {
        if(MIN_LENGTH_LOGIN_ID <= usrID.length()  &&  usrID.length() <= MAX_LENGTH_LOGIN_ID){
            return true;
        }else{
            return false;
        }
    }
    public static boolean checkAccExist(String usrID)//used to check if an account exists tied to the username
    {
        for(String id : existingAccs) {
            if(usrID.equals(id)){
                return true;
            }
        }
        return false;
    }
    public static boolean checkPhoneValid(String phoneNum) //used to check if phone number length is valid and has valid area code
    {
        String areaCode = phoneNum.substring(0, 3); //getting the area code
        if(phoneNum.length() == LENGTH_PHONE) //checking length
        {
            for (String code : validAreaCode) //loop through valid codes and check if it exists in array 
            {
                
                if(areaCode.equals(code))
                {
                    return true;
                }
            }
            return false;
        }else{
            return false;
        }
    }
    public static boolean checkValidEmail(String usrEmail) //uses regex pattern to verify email address
    {
        if (usrEmail==null) //check for null to avoid errors
        {
            return false;
        }
        String regexPattern="^[a-zA-Z0-9_+&*-]+(?:\\."+ "[a-zA-Z0-9_+&*-]+)*@" +"(?:[a-zA-Z0-9-]+\\.)+[a-z" +"A-Z]{2,7}$"; //regex pattern to match
        Pattern check = Pattern.compile(regexPattern);
        return check.matcher(usrEmail).matches(); //checking if email string matches regex pattern for email validity
    }   
    public static boolean checkIDForInvalid(String usrID) //checking user ID for invalid chars-true if one is found
    {
        
        for(char c : invalidCharacters){
            if(usrID.indexOf(c) >= 0){
                return true;
            }
        }
        //since none were found return false
        return false;
    }
    
    public static boolean checkPassForInvalid(String usrPwd) //checking password for invalid chars
    {
        for(char c : invalidCharacters){
            if(usrPwd.indexOf(c) >= 0){
                return true;
            }
        }
        //since none were found return false
        return false;
    }
    
    
    
    public static boolean checkPwdLength(String usrPwd) //make sure the length of the password is valid in range
    {
        if(MIN_LENGTH_PWD <= usrPwd.length()  &&  usrPwd.length() <= MAX_LENGTH_PWD){
            return true;
        }else{
            return false;
        }
    }
    public static boolean checkPwdReqs(String usrPwd) //check if password has all necessary reqs
    {
        //must have one letter number and special character
        boolean letter = false;
        boolean number = false;
        boolean specialChar = false;
        if (checkPassForInvalid(usrPwd))
        {
            return false;
        }
        for (char c : usrPwd.toCharArray()) 
        {
            if (Character.isLetter(c)) 
            {
                letter = true;
            } 
            else if (Character.isDigit(c)) 
            {
                number = true;
            } 
            else 
            {
                specialChar = true;
            }
        }
        //return if all reqs are met
        return( letter && number && specialChar );
    }
    public static boolean validPass(String usrPwd) //check if password is valid by combining functions
    {
        return (checkPwdReqs(usrPwd) && checkPwdLength(usrPwd));
    }

    public static boolean checkRetype(String usrPass, String retypePass)//making sure retyped password is valid
    {
        if( usrPass.equals(retypePass) )
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static String create(String usrID, String usrPass, String retypePass, String phoneNum, String emailAd) //main method to create a new account, outputs errors or registration succesful
    {
        if( !checkIDLength( usrID ) ) {
            return "Login ID does not meet requirments";
        }
        if( checkAccExist( usrID ) ) {
            return "There is already an account associated with this username";
        }
        if( checkIDForInvalid( usrID ) ){
            return "Username has an invalid character";
        }
        if( !validPass( usrPass ) ){

            return "Password does not meet requirements";
        }
        if( !checkRetype( usrPass, retypePass ) ){
            return "Retyped password does not match the password";
        }
        if (!checkPhoneValid(phoneNum))
        {
            return "Invalid Phone Number";
        }
        if (!checkValidEmail(emailAd))
        {
            return "Invalid Email Address";
        }
        //all reqs have been met, account is created and succesful
        return "Account creation is Successful";
    }
}
