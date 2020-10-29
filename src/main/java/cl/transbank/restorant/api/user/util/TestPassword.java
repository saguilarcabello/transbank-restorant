package cl.transbank.restorant.api.user.util;

public class TestPassword {

	public static void main(String[] args) {
		String myPassword = "EqdmPh53c9x";
        
        String salt = PasswordUtil.getSalt(30);
        String mySecurePassword = PasswordUtil.generateSecurePassword(myPassword, salt);
         
        System.out.println("password = " + mySecurePassword);
        System.out.println("Salt value = " + salt);
	}

}
