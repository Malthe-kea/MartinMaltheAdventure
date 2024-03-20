public class RangedWeapon extends Weapon {

    //ATTRIBUTES
    protected int ammo;


    //KONSTRUKTØR
    public RangedWeapon(String shortname, String longName,int damageDoneToOpponentPerStrike, int ammo) {
        super(shortname, longName, damageDoneToOpponentPerStrike);
        this.ammo = ammo;
    }



    @Override
    public int getAmmoLeft() {
        return ammo--;
    }

    //Metode der siger at hvis der er flere "skud" end 0 i et våben kan vi bruge det
    @Override
    public boolean canUse() {
        if (getAmmoLeft() > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void useWeapon() {
        getDamagePerStrike();
    }
}