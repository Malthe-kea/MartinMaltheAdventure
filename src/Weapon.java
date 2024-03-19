public abstract class Weapon extends Item {
    //Attributes
    private int damageDoneToOpponentPerStrike;
    private int ammo;

    //Constructor
    public Weapon(String shortName, String longName, int damageDoneToOpponentPerStrike) {
        super(shortName, longName); //calls item constructor
        this.damageDoneToOpponentPerStrike = damageDoneToOpponentPerStrike;
    }

    //Getter
    public int getDamageDoneToOpponentPerStrike() {
        return damageDoneToOpponentPerStrike;
    }

    public int getAmmo() {
        return ammo;
    }

    //public abstract int remainingUses(); //overridden in RangedWeapon class to keep count of remaining uses of the ranged weapon

    public abstract boolean canUse() ; //overridden in RangedWeapon class to decide if the ranged weapon is usable
}