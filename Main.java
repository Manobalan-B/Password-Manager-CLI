import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String ch = "yes";
        System.out.println("\n            Welcome to our  Application");
        System.out.println("\n          We Provide Following Services...");
        do{
            int reDisplay = 0;
            System.out.println("\n1. Generate Password");
            System.out.println("2. Check Strength of your Password");
            System.out.println("3. Guidelines for a Strong Password");
            System.out.print("\nSelect One of the Above...(1-3) : ");
            try{
                int choice = Integer.parseInt(s.nextLine());
                switch (choice) {
                    case 1:
                        Generator g = new Generator();
                        g.getDetails(s);
                        g.generate();
                        break;
                    case 2:
                        System.out.print("\nEnter Your Password to be Checked : ");
                        Check ck = new Check(s.nextLine());
                        ck.findStrength();
                        break;
                    case 3:
                        Guidelines gl = new Guidelines();
                        gl.showGuidelines();
                        break;
                    default:
                        System.out.println("Please Enter an Valid Option...");
                        reDisplay = 1;
                        break;
                }
                if(reDisplay==1)
                continue;
                System.out.print("\nDo you Wish to Continue...(yes/no):");
                ch = s.nextLine();
            }
            catch(Exception e){
                System.out.println("Exception Arised!! "+e);
            }
        }
        while(ch.equalsIgnoreCase("yes"));
        System.out.println("\n                    Thank You For Using our Services...\n                            See You Later!!!");
        s.close();
    }
}