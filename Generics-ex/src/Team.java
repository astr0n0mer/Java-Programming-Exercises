import java.util.ArrayList;

public class Team<T extends Player> implements Comparable<Team<T>> {
    private String name;
    private int matchesWon = 0;
    private int matchesLost = 0;
    private int matchesTied = 0;
    private ArrayList<T> players = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public void addPlayer(T newPlayer) {
        if (getIndexOf(newPlayer) >= 0) {
            System.out.println(newPlayer.getName() + " is already in " + this.name);
        } else {
            players.add(newPlayer);
            System.out.println(newPlayer.getName() + " added successfully to " + this.name);
        }
    }

    private int getIndexOf(T newPlayer) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getName().equals(newPlayer.getName()))
                return i;
        }
        return -1;
    }

    public void updateScorecard(Team<T> opponentTeam, int ourScore, int opponentScore) {
        if (ourScore - opponentScore > 0) {
            this.matchesWon++;
        } else if (ourScore - opponentScore < 0) {
            this.matchesLost++;
        } else {
            this.matchesTied++;
        }
        // Updating opponent team's scorecard below
        if (opponentTeam != null) {
            opponentTeam.updateScorecard(null, opponentScore, ourScore);
        }
    }

    @Override
    public int compareTo(Team<T> opponentTeam) {
        // We need to multiply the return value of Integer.compare() by (-1) since it is designed for
        // ascending order sorting, but we want to display the team with the highest score at the top
        // so (-1) is there for descending sorting
        return (-1) * Integer.compare(this.getScore(), opponentTeam.getScore());
    }

    public int getScore() {
        return matchesWon * 3 + matchesTied * 2 - matchesLost;
    }

    public String getName() {
        return name;
    }

    public int getMatchesWon() {
        return matchesWon;
    }

    public int getMatchesLost() {
        return matchesLost;
    }

    public int getMatchesTied() {
        return matchesTied;
    }
}
