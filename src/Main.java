import java.util.Scanner;

public class Main {
    static String userName, password;
    static String TEST_USER_NAME = "patika", TEST_PASSWORD= "java123";
    static Scanner input = new Scanner(System.in);

    static void setInputPassword(){
        System.out.print("Type a new password: ");
        password = input.nextLine();
    }

    public static void main(String[] args) {
        System.out.print("Type the user name: ");
        userName = input.nextLine();

        System.out.print("Type the password : ");
        password = input.nextLine();

        if(userName.equals(TEST_USER_NAME) && password.equals(TEST_PASSWORD)) {
            System.out.println("Successfully login");
        } else {
            if(!userName.equals(TEST_USER_NAME)) {
                System.out.println("Wrong user name!");
            } else {
                System.out.println("Wrong password!!");
                System.out.print("Would you like to reset the password?\n(1-Yes/ 2-No ) type the option number: ");
                int select = input.nextInt();
                // @see to prevent that problem: https://stackoverflow.com/questions/13102045/scanner-is-skipping-nextline-after-using-next-or-nextfoo
                input.nextLine();

                if(select == 1){
                    String wrongPassword = password;

                    System.out.println("Please make sure you don't type the old password or the one you've just typed: ");
                    setInputPassword();

                    while(password.equals(wrongPassword) || password.equals(TEST_PASSWORD)){
                        System.out.println("Could not create password, please enter another password!");
                        setInputPassword();
                    };

                    TEST_PASSWORD = password;
                    System.out.println("The password is changed!");
                }
            }
        }
    }
}
