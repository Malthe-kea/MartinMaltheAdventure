public abstract class Weapon extends Item {
    //Attributes
    private int damagePerStrike;


    //Constructor
    public Weapon(String shortName, String longName, int damagePerStrike) {
        super(shortName, longName); //calls item constructor
        this.damagePerStrike = damagePerStrike;
    }



    abstract void useWeapon();
    abstract int getAmmoLeft();

    abstract int getDamagePerStrike();
}