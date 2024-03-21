public class RangedWeapon extends Weapon {

    //ATTRIBUTES
    protected int ammo;



    //KONSTRUKTØR
    public RangedWeapon(String shortname, String longName,int damagePerStrike, int ammo) {
        super(shortname, longName, damagePerStrike);
        this.ammo = ammo;
    }



    public int getUsesLeft() {
        return ammo--;
    }

    @Override
    public void useWeapon() {
        getDamagePerStrike();
    }

   int getDamagePerStrike() {
        return damagePerStrike;
    }


}