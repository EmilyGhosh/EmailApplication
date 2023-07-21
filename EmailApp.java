package emailapp;
import java.util.*;
public class EmailApp {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity=50;
    private int defaultPasswordLength=10;
    private String alternateEmail;
    private String companySuffix=".aeycompany.com";

    //Constructor to receive the 1st & last name
    public EmailApp(String firstName , String lastName ){
        this.firstName=firstName;
        this.lastName =lastName;
        System.out.println("Email created - "+ this.firstName+this.lastName);

        //call a method asking for dept - return the dept
        this.department=setDepartment();
        System.out.println("Department "+ this.department);

        //call a method that returns a password
        this.password=randomPassword(defaultPasswordLength);
        System.out.println("Your Password is "+ this.password);

        //combine element
        email=firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department+companySuffix;
        System.out.println(email);
    }
    //Ask for the dept
    private String setDepartment(){
        System.out.print("Department Codes \n1for Sales \n2 for Development\n3 for Accounting\n0 for None\nEnter the Department Code- ");
        Scanner sc = new Scanner (System.in);
        int code=sc.nextInt();
        if(code==0){return "Sales";}
        else if(code==1){return "Development";}
        else if(code==2){return "Accounting";}
        else{return "";}

    }
    //Generate a random password
    private String randomPassword(int length){
        String passwordSet="ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
        char [] password=new char[length];
        for(int i=0;i<length;i++){
            int rand=(int)(Math.random()* passwordSet.length());
            password[i]=passwordSet.charAt(rand);
            //System.out.println(rand);
            //System.out.println(passwordSet.charAt(rand));

        }
        return new String(password);
    }
    //Set mailbox Capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity=capacity;
    }
    //Set the alternate email
    public void setAlternateEmail(String alternate){
        this.alternateEmail=alternate;
    }
    //Change the password
    public void changePassword(String password){
        this.password=password;
    }
    public int getMailboxCapacity(){return mailboxCapacity;}
    public String getAlternateEmail(){return alternateEmail;}
    public String getPassword(){return password;}
    public String showinfo(){
        return "Display Name- " + firstName +" "+ lastName+
                "\nCompany Email- "+ email+
                "\nMailBox Capacity- "+ mailboxCapacity+"mb";
    }
}
