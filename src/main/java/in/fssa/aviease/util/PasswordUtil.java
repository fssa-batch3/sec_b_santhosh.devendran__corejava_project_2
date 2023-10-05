package in.fssa.aviease.util;

public class PasswordUtil {

	
	/**
	 * Finds the smallest digit not contained in the given mobile number.
	 *
	 * @param mobile The mobile number to analyze.
	 * @param first  The first digit of the mobile number.
	 * @return The smallest digit not contained in the mobile number, or the value of 'first' if all digits are present.
	 */
	 public static int findSmallNotContains(long mobile,int first){
	        
	        int[] num={0,1,2,3,4,5,6,7,8,9};
	    
	    while(mobile>0L){
	        int temp=(int) (mobile%10);
	        if(num[temp]!=0){
	            num[temp]=0;
	        }
	        mobile=mobile/10;
	    }
	    
	    int small=10;
	    
	  for(int i=0;i<num.length;i++){
	      
	      if(num[i]<small && num[i]!= 0){
	            small=num[i];
	      }
	  }
	  
	  
	  return small == 10 ? first : small;
	  
	  
	    }
	    
	 /**
	  * Encrypts a password using the provided key.
	  *
	  * @param password The password to encrypt.
	  * @param key      The encryption key.
	  * @return The encrypted password.
	  */
	    public static String encryptData(String password,int key){
	        String encrypted="";
	        
	        key=password.length()+key;
	        
	        for(int i=0;i<password.length();i++){
	            char temp = password.charAt(i);
	            temp += (i % 2 == 0) ? key : -key;
	           encrypted=encrypted+temp;
	        }
	        return encrypted;
	    }
	    
	    /**
	     * Decrypts an encrypted password using the provided key.
	     *
	     * @param password The encrypted password to decrypt.
	     * @param key      The decryption key.
	     * @return The decrypted password.
	     */
	     public static String decryptData(String password,int key){
	         String de="";
	         
	         key=password.length()+key;
	        
	        for(int i=0;i<password.length();i++){
	            char temp = password.charAt(i);
	            temp += (i % 2 == 0) ? -key : key;
	            de=de+temp;
	        }
	        return de;
	       
	    }
	     
	     /**
	      * Encrypts a password based on the mobile number and a calculated key.
	      *
	      * @param mobile   The mobile number.
	      * @param password The password to encrypt.
	      * @return The encrypted password.
	      */
	     public static String passwordEncrypt(long mobile,String password) {
	    	  int first = (int) (mobile / 1000000000); 
	    	    int small=findSmallNotContains(mobile,first);
	    	    
	    	    int key=first%small == 0 || first%small > 4 ?(first/small) : (first%small);
	    	    
	    	    return encryptData(password,key);
	     }
	     
	     /**
	      * Decrypts an encrypted password based on the mobile number and a calculated key.
	      *
	      * @param mobile   The mobile number.
	      * @param password The encrypted password to decrypt.
	      * @return The decrypted password.
	      */
	     public static String passwordDecrypt(long mobile,String password) {
	   	  int first = (int) (mobile / 1000000000); 
	   	    int small=findSmallNotContains(mobile,first);
	   	    
	   	    int key=first%small == 0 || first%small > 4 ?(first/small) : (first%small);
	   	    
	   	    return decryptData(password,key);
	    }
	     
	     
}
