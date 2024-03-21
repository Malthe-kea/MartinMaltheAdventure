public class RangedWeapon extends Weapon {

    //ATTRIBUTES
    protected int ammo;
    private int damageDoneToOpponenetPerStrike;


    //KONSTRUKTØR
    public RangedWeapon(String shortname, String longName,int damageDoneToOpponentPerStrike, int ammo) {
        super(shortname, longName, damageDoneToOpponentPerStrike);
        this.ammo = ammo;
    }


    @Override
    public int getAmmoLeft() {
        return ammo--;
    }

    @Override
    public void useWeapon() {
        getDamagePerStrike();
    }

   int getDamagePerStrike() {
        return damageDoneToOpponenetPerStrike;
    }


}