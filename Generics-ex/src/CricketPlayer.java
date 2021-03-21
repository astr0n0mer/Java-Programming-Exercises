public class CricketPlayer extends Player {
    private int strikeRate;
    private int noOfCenturies;

    public CricketPlayer(String name) {
        super(name);
    }

    public void setStrikeRate(int strikeRate) {
        this.strikeRate = strikeRate;
    }

    public int getStrikeRate() {
        return strikeRate;
    }

    public void setNoOfCenturies(int noOfCenturies) {
        this.noOfCenturies = noOfCenturies;
    }

    public int getNoOfCenturies() {
        return noOfCenturies;
    }
}
