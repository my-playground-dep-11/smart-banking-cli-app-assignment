import java.util.Scanner;

public class App1{
    private final static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {

        final String CLEAR = "\033[H\033[2J";
        final String COLOR_BLUE_BOLD = "\033[34;1m";
        final String COLOR_RED_BOLD = "\033[31;1m";
        final String COLOR_GREEN_BOLD = "\033[32;1m";
        final String RESET = "\033[0m";

        final String DASHBOARD = "💰"+" Welcome to Smart Banking";
        final String OPEN_NEW_ACCOUNT = "💳"+" Open New Account";
        final String DEPOSIT_MONEY = "💵"+" Deposit Money";
        final String WITHDRAW_MONEY = "💶"+" Withdraw Money";
        final String TRANSFER_MONEY = "💸"+" Transfer Money";
        final String CHECK_ACCOUNT_BALANCE = "🤑"+" Check Account Balance";
        final String DROP_EXISTING_ACCOUNT = "❌"+" Drop Existing Account";
        final String EXIT = "👋"+" Exit";

        

        final String ERROR_MSG = String.format("\t%s%s%s\n", COLOR_RED_BOLD, "%s", RESET);
        final String SUCCESS_MSG = String.format("\t%s%s%s\n", COLOR_GREEN_BOLD, "%s", RESET);
    
        
        
        

        String screen = DASHBOARD;
        String[][] customerNames = new String[0][];

    
        do{
            final String APP_TITLE = String.format("%s%s%s",COLOR_BLUE_BOLD, screen, RESET);

            System.out.println(CLEAR);
            System.out.println("\t" + APP_TITLE + "\n");

            switch(screen){
                case DASHBOARD: 
                    System.out.println("\t[1]. Open New Account");
                    System.out.println("\t[2]. Deposit Money");
                    System.out.println("\t[3]. Withdraw Money");
                    System.out.println("\t[4]. Transfer Money");
                    System.out.println("\t[5]. Check Account Balance");
                    System.out.println("\t[6]. Drop Existing Account");
                    System.out.println("\t[7]. Exit\n");
                    System.out.print("\tEnter an option to continue: ");
                    int option = scanner.nextInt();
                    scanner.nextLine();

                    switch (option){
                        case 1: screen = OPEN_NEW_ACCOUNT; break;
                        case 2: screen = DEPOSIT_MONEY; break;
                        case 3: screen = WITHDRAW_MONEY; break;
                        case 4: screen = TRANSFER_MONEY; break;
                        case 5: screen = CHECK_ACCOUNT_BALANCE; break;
                        case 6: screen = DROP_EXISTING_ACCOUNT; break;
                        case 7: System.out.println(CLEAR); System.exit(0);
                        default: continue;
                    }
                    break;
                    case OPEN_NEW_ACCOUNT:
                    System.out.printf("\tNew Account ID: SDB-%05d \n", (customerNames.length + 1));
                    
                    boolean valid;
                    String name;
                    String id = "";
                    int deposit;
                    do{
                        valid = true;
                        System.out.print("\tEnter Customer Name: ");
                        name = scanner.nextLine().strip();
                        if (name.isBlank()){
                            System.out.printf(ERROR_MSG, "Name can't be Empty!");
                            valid = false;
                            continue;
                        }
                        for (int i = 0; i < name.length(); i++) {
                            if (!(Character.isLetter(name.charAt(i)) || 
                                Character.isSpaceChar(name.charAt(i))) ) {
                                System.out.printf(ERROR_MSG, "Invalid Name!");
                                valid = false;
                                break;
                            }
                        }
                    }while(!valid);
                    
                    String[][] newCustomer = new String[customerNames.length + 1][3];
                    for (int i = 0; i < customerNames.length; i++) {
                        newCustomer[i] = customerNames[i];
                    }
                    

                    
                    do{
                        valid = true;
                        System.out.print("\tInitial Deposit: ");
                        deposit = scanner.nextInt();
                        scanner.nextLine();
                        
                        if(!(deposit >= 5000)){
                            System.out.printf(ERROR_MSG, "Insufficient Amount!");
                            valid = false;
                            continue;
                    }

                    }while(!valid);

            
                    for (int i = 0; i < customerNames.length; i++) {
                        newCustomer[i] = customerNames[i];
                    }
                    
                    newCustomer[newCustomer.length - 1][0] = id;
                    newCustomer[newCustomer.length - 1][1] = name;
                    newCustomer[newCustomer.length - 1][2] = deposit + "";

                    customerNames = newCustomer;
                    

                    System.out.println();
                    System.out.printf(SUCCESS_MSG, String.format("SDB-%05d:%s has been saved successfully.", customerNames.length, name));
                    System.out.print("\tDo you want to continue adding (Y/n)? ");
                    if (scanner.nextLine().strip().toUpperCase().equals("Y")) continue;
                    screen = DASHBOARD;
                    break;

                    

                    

        }
        }while (true); 
    }
}