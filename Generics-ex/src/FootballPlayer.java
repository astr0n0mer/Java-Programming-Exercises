public class FootballPlayer extends Player {
    private int noOfGoals;

    public FootballPlayer(String name) {
        super(name);
    }

    public void setNoOfGoals(int noOfGoals) {
        this.noOfGoals = noOfGoals;
    }

    public int getNoOfGoals() {
        return noOfGoals;
    }
}
