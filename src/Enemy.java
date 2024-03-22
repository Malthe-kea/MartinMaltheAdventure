public class Enemy extends Item {

    //Attributer
    private int healthPoints;
    private int attackPoints;
    private Weapon weapon;

    public Enemy(String shortName, String longName, int healthPoints, int attackPoints, Weapon weapon) {
        super(shortName, longName);
        this.healthPoints = healthPoints;
        this.attackPoints = attackPoints;
        this.weapon = weapon;
    }

    public String getName() {
        return shortName;
    }

    public int getEnemyHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int newHealthPoints) {
        this.healthPoints = newHealthPoints;
    }

    public int getEnemyAttackPoints () {
        return attackPoints;
    }
    public Weapon getEnemyWeapon () {
        return weapon;
    }
}
