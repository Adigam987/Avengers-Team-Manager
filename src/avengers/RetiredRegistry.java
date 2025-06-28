package avengers;

import java.util.ArrayList;

public class RetiredRegistry {
    private ArrayList<Avenger> retired;

    public RetiredRegistry() {
        this.retired = new ArrayList<>();
    }

    public void retire(Avenger avenger) {
        retired.add(avenger);
    }

    public ArrayList<Avenger> getRetired() {
        return retired;
    }

    public void displayRetired() {
        if (retired.isEmpty()) {
            System.out.println("No retired Avengers.");
        } else {
            System.out.println("🏁 Retired Avengers:");
            for (Avenger a : retired) {
                System.out.println("⚫ " + a);
            }
        }
    }
}