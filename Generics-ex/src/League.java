import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team> {
    private String name;
    ArrayList<T> teams = new ArrayList<>();

    public League(String name) {
        this.name = name;
    }

    public void addTeam(T newTeam) {
        if (getIndexOf(newTeam) >= 0) {
            System.out.println("Team " + newTeam.getName() + " is already registered in " + this.name);
        } else {
            teams.add(newTeam);
            System.out.println("Team " + newTeam.getName() + " added successfully in " + this.name);
        }
    }

    private int getIndexOf(T newTeam) {
        for (int i = 0; i < teams.size(); i++) {
            if (teams.get(i).getName().equals(newTeam.getName()))
                return i;
        }
        return -1;
    }

    public void getPointsTable() {
        Collections.sort(teams);
        System.out.println("-----POINTS TABLE-----");
        for (T team : teams) {
            System.out.println(team.getName() + ": " + team.getScore());
        }
    }

    public String getName() {
        return name;
    }
}

