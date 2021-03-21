public class Main {
    public static void main(String[] args) {
        League<Team<CricketPlayer>> iPL = new League<>("Indian Premier League");

        Team<CricketPlayer> mumbaiIndians = new Team<>("Mumbai Indians");
        mumbaiIndians.addPlayer(new CricketPlayer("Lasith Malinga"));
        mumbaiIndians.addPlayer(new CricketPlayer("Sanju Samson"));
        System.out.println();

        Team<CricketPlayer> deccanChargers = new Team<>("Deccan Chargers");
        deccanChargers.addPlayer(new CricketPlayer("M.H. Dhoni"));
        // Adding the same player again
        deccanChargers.addPlayer(new CricketPlayer("M.H. Dhoni"));
        deccanChargers.addPlayer(new CricketPlayer("Suresh Raina"));
        System.out.println();

        Team<CricketPlayer> bengalTigers = new Team<>("Bengal Tigers");
        bengalTigers.addPlayer(new CricketPlayer("Virat Kohli"));
        bengalTigers.addPlayer(new CricketPlayer("Yuzvendra Chahal"));
        System.out.println();

        iPL.addTeam(mumbaiIndians);
        // Adding the same team again
        iPL.addTeam(mumbaiIndians);
        iPL.addTeam(deccanChargers);
        iPL.addTeam(bengalTigers);
        System.out.println();

        mumbaiIndians.updateScorecard(deccanChargers, 3, 1);
        mumbaiIndians.updateScorecard(bengalTigers, 3, 2);
        deccanChargers.updateScorecard(bengalTigers, 1, 3);
        deccanChargers.updateScorecard(mumbaiIndians, 1, 1);

        iPL.getPointsTable();
        System.out.println("------------------------------------------------------------------------");
        League<Team<FootballPlayer>> uEFA = new League<>("UEFA");

        Team<FootballPlayer> barcelona = new Team<>("FC Barcelona");
        barcelona.addPlayer(new FootballPlayer("Lionel Messi"));
        barcelona.addPlayer(new FootballPlayer("Rooney"));
        System.out.println();

        Team<FootballPlayer> realMadrid = new Team<>("Real Madrid");
        realMadrid.addPlayer(new FootballPlayer("Cristiano Ronaldo"));
        realMadrid.addPlayer(new FootballPlayer("Pepe"));
        System.out.println();

        uEFA.addTeam(barcelona);
        uEFA.addTeam(realMadrid);

        barcelona.updateScorecard(realMadrid, 3, 2);
        realMadrid.updateScorecard(barcelona, 1, 2);

        uEFA.getPointsTable();
    }
}
