package avengers;

import java.util.Scanner;

public class CommandHandler {
    private TeamManager teamManager;
    private RetiredRegistry retiredRegistry;

    public CommandHandler(TeamManager teamManager, RetiredRegistry retiredRegistry) {
        this.teamManager = teamManager;
        this.retiredRegistry = retiredRegistry;
    }

    public void handle(String input) {
        String[] tokens = input.trim().split(" ");

        if (tokens.length == 0) return;

        switch (tokens[0].toUpperCase()) {
            case "ADD":
                if (tokens.length < 4) {
                    System.out.println("❌ Usage: ADD <Name> <Role> <PowerLevel>");
                    return;
                }
                try {
                    String name = tokens[1];
                    String role = tokens[2];
                    int power = Integer.parseInt(tokens[3]);
                    Avenger a = new Avenger(name, role, power);
                    if (teamManager.addAvenger(a))
                        System.out.println("✅ " + name + " added.");
                    else
                        System.out.println("⚠ " + name + " already exists.");
                } catch (NumberFormatException e) {
                    System.out.println("❌ PowerLevel must be a number.");
                }
                break;

            case "REMOVE":
                if (tokens.length < 2) {
                    System.out.println("❌ Usage: REMOVE <Name>");
                    return;
                }
                String nameToRemove = tokens[1];
                Avenger av = teamManager.findAvenger(nameToRemove);
                if (av != null) {
                    teamManager.removeAvenger(nameToRemove);
                    retiredRegistry.retire(av);
                    System.out.println("❌ " + nameToRemove + " retired.");
                } else {
                    System.out.println("⚠ Not found.");
                }
                break;

            case "SHOW":
                if (teamManager.isEmpty()) {
                    System.out.println("🚫 Team is empty.");
                } else {
                    System.out.println("🚀 Current Avengers:");
                    for (Avenger avenger : teamManager.getAllAvengers()) {
                        System.out.println("🟢 " + avenger);
                    }
                }
                break;

            case "RETIRED":
                retiredRegistry.displayRetired();
                break;

            case "FIND":
                if (tokens.length < 2) {
                    System.out.println("❌ Usage: FIND <Name>");
                    return;
                }
                Avenger found = teamManager.findAvenger(tokens[1]);
                if (found != null)
                    System.out.println("🔎 " + found);
                else
                    System.out.println("⚠ Not found.");
                break;

            default:
                System.out.println("❗ Unknown command.");
        }
     
    }
}