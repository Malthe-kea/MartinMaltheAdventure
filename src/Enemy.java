public class Enemy extends Item {

    //Attributer
    private int healthPoints;

    public Enemy(String shortName, String longName, int healthPoints, Weapon weapon) {
        super(shortName, longName);
        this.healthPoints = healthPoints;
    }

}
