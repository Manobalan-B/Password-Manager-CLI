import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Generator {
    
    public static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
	public static final String NUMBERS = "1234567890";
	public static final String SYMBOLS = "!@#$%^&*()-_=+\\/~?";
    StringBuilder password = new StringBuilder();
    public String extractString="";

    public boolean canHaveLower = false;
    public boolean canHaveUpper = false;
    public boolean canHaveNumber = false;
    public boolean canHaveSpecial = false;
    public int len;

    public void getDetails(Scanner s){

        System.out.println("\nAnswer For the Below Questions to Generate Random Password of Your Desire!!! (yes/no)");

        System.out.print("\nDo You Need Uppercase Letters in your Password? : ");
        if(s.nextLine().equalsIgnoreCase("yes")) canHaveUpper = true;
        System.out.print("\nDo You Need Lowercase Letters in your Password? : ");
        if(s.nextLine().equalsIgnoreCase("yes")) canHaveLower = true;
        System.out.print("\nDo You Need Numbers in your Password? : ");
        if(s.nextLine().equalsIgnoreCase("yes")) canHaveNumber = true;
        System.out.print("\nDo You Need Special Characters in your Password? : ");
        if(s.nextLine().equalsIgnoreCase("yes")) canHaveSpecial = true;

        System.out.print("\nEnter the Length for Your Password : ");
        len = Integer.parseInt(s.nextLine());

    }

    public void generate(){
        for(int i=0;i<len;i++)
        password.append("x");

        if(canHaveLower)
        extractString+=LOWERCASE_LETTERS;
        if(canHaveUpper)
        extractString+=UPPERCASE_LETTERS;
        if(canHaveNumber)
        extractString+=NUMBERS;
        if(canHaveSpecial)
        extractString+=SYMBOLS;

        List<Integer> checkIndex = new ArrayList<Integer>();
        for(int i=0;i<len;i++)
        checkIndex.add(i);

        while(!checkIndex.isEmpty()){
            int rand_Index = (int)((Math.random()*100000)%len);
            int rand_Value;
            if(checkIndex.contains(rand_Index)){
                if(canHaveLower){
                    rand_Value = (int)((Math.random()*1000000)%LOWERCASE_LETTERS.length());
                    password.setCharAt(rand_Index, LOWERCASE_LETTERS.charAt(rand_Value));
                    canHaveLower = false;  
                }
                else if(canHaveUpper){
                    rand_Value = (int)((Math.random()*1000000)%UPPERCASE_LETTERS.length());
                    password.setCharAt(rand_Index, UPPERCASE_LETTERS.charAt(rand_Value));
                    canHaveUpper = false;
                }
                else if(canHaveNumber){
                    rand_Value = (int)((Math.random()*1000000)%NUMBERS.length());
                    password.setCharAt(rand_Index, NUMBERS.charAt(rand_Value));
                    canHaveNumber = false;
                }
                else if(canHaveSpecial){
                    rand_Value = (int)((Math.random()*1000000)%SYMBOLS.length());
                    password.setCharAt(rand_Index, SYMBOLS.charAt(rand_Value));
                    canHaveSpecial = false;
                }
                else{
                    rand_Value = (int)((Math.random()*1000000)%extractString.length());
                    password.setCharAt(rand_Index, extractString.charAt(rand_Value));
                }
                
                checkIndex.remove(Integer.valueOf(rand_Index));
            }
        }

        System.out.print("\nYour Generated Password is : "+password+"\n");
    }
}