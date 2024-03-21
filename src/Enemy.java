public class Enemy extends Item {

    //Attributer
    private int healthPoints;
    private String name;

// Indhent et meleeWeapon fra klassen

    public Enemy(String shortName, String longName, int healthPoints, Weapon weapon) {
        super(shortName, longName);
        this.healthPoints = healthPoints;
    }
public String getName () {
        return shortName;
}
}
