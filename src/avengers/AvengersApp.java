package avengers;

import java.util.Scanner;

public class AvengersApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TeamManager teamManager = new TeamManager();
        RetiredRegistry retiredRegistry = new RetiredRegistry();
        CommandHandler handler = new CommandHandler(teamManager, retiredRegistry);

        System.out.println("💥 Avengers Manager Console 💥");
        System.out.println("Commands: ADD, REMOVE, SHOW, RETIRED, FIND, EXIT");

        while (true) {
            System.out.print("⚡ Enter Command: ");
            String input = sc.nextLine().trim();
            if (input.equalsIgnoreCase("EXIT")) {
                System.out.println("🔒 Session Ended. Bye, Thor.");
                break;
            }
            handler.handle(input);
        }

        sc.close();
    }
}