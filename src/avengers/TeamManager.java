package avengers;

import java.util.HashSet;

public class TeamManager {

    private HashSet<Avenger> team;

    public TeamManager() {
        this.team = new HashSet<>();
    }

    public boolean addAvenger(Avenger avenger) {
        return team.add(avenger);
    }

    public boolean removeAvenger(String name) {
        return team.remove(new Avenger(name, "", 0));
    }

    public Avenger findAvenger(String name) {
        for (Avenger a : team) {
            if (a.getName().equalsIgnoreCase(name)) {
                return a;
            }
        }
        return null;
    }

    public HashSet<Avenger> getAllAvengers() {
        return team;
    }

    public boolean isEmpty() {
        return team.isEmpty();
    }
}