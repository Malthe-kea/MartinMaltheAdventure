public class Enemy extends Item {

    //Attributer
    private int healthPoints;
    private String name;

    public Enemy(String shortName, String longName, int healthPoints, Weapon weapon) {
        super(shortName, longName);
        this.healthPoints = healthPoints;
    }
public String getName () {
        return shortName;
}

    public int getEnemyHealthPoints() {
        return healthPoints;
    }

    public int setEnemyHealthPoints(int enemyNewHealthPoints) {
        return healthPoints;
    }
}
