public class Check {

    public static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
	public static final String NUMBERS = "1234567890";
	public static final String SYMBOLS = "!@#$%^&*()-_=+\\/~?";
    public String password;

    public Check(String password){
        this.password = password;
        
    }

    public void findStrength(){

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasSpecial = false;
        boolean hasDigit = false;
        int score = 0 ;

        for(int i=0;i<password.length();i++){
            if(UPPERCASE_LETTERS.indexOf(password.charAt(i))!=-1){
                hasUpper = true;
            }
            else if(LOWERCASE_LETTERS.indexOf(password.charAt(i))!=-1){
                hasLower = true;
            }
            else if(NUMBERS.indexOf(password.charAt(i))!=-1){
                hasDigit = true;
            }
            else{
                hasSpecial = true;    
            }
        }

        if(hasUpper) ++score;
        if(hasLower) ++score;
        if(hasDigit) ++score;
        if(hasSpecial) ++score;
        if(password.length()>=8) ++score;
        if(password.length()>=16) ++score;

        System.out.println("\nYOUR PASSWORD SCORE IS : "+score);
        if(score==6)
        System.out.println("Excellent!! Your Password is very Strong.Make Sure Your Password doesnot contains Dictionary Words.");
        else if(score>=4)
        System.out.println("Good!! Your Password is Strong. But you can still Strengthen it");
        else if(score>2)
        System.out.println("Your Password Seems to be Medium. Try to make More Secure");
        else
        System.out.println("Your Password is too weak. Please Follow Our Guidelines to Make your Password Strengthen and Secure Your Data");
    }
}