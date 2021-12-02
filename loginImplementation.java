/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import junit.framework.*;

public class loginImplementation {
	
	public static String[] username = {"xxxxbbbba", "johnbennett", "softWareEng", "activeUser", "alrExists", "checkAgain"};;
	public static String[] password = {"validPass1", "correct34", "password3", "itIscorrect", "paswrd90", "againCrt"};
    /*
    valid:
        username exists in system database
        password matches existing username in system
    invalid:
        username does not exist in system
        password is incorrect for username

     */
    
	public static int checkUsername(String u) {
		int index = -1;
		int i = 0;
		for(String uid : username) {
			if(u.equalsIgnoreCase(uid)) {
				index = i;
			}
			i += 1;
		}
		return index;
	}
	
	public static String login(String u, String p) {
		if(u.equalsIgnoreCase(""))
			return "Enter the email attached to your account";
		
		int i = checkUsername(u);
		if(i == -1)
			return "Account does not exist";
		if(i > -1)
			if(!p.equals(password[i]))
				return "Failed to log into account";
		return "Successful login";
	}
    
}
