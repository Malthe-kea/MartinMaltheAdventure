public class Enemy extends Item {

    //Attributer
    private int healthPoints;
    private int attackPoints;


    public Enemy(String shortName, String longName, int healthPoints, int attackPoints, Weapon weapon) {
        super(shortName, longName);
        this.healthPoints = healthPoints;
        this.attackPoints = attackPoints;
    }

    public String getName() {
        return shortName;
    }

    public int getEnemyHealthPoints() {
        return healthPoints;
    }

    public int setEnemyHealthPoints(int enemyNewHealthPoints) {
        return healthPoints;
    }

    public int getEnemyAttackPoints () {
        return attackPoints;
    }
}
