public class MeleeWeapon extends Weapon {
    // MeleeWeapon kan normalt bruges et utal af gange.
    //ATTRIBUTES
    private int damageDoneToOpponentPerStrike;

    //KONSTRUKTØR
    public MeleeWeapon(String shortName, String longName, int damageDoneToOpponentPerStrike) {
        super(shortName, longName, damageDoneToOpponentPerStrike);
    }

    //GETTER METODE
    public int getDamageDoneToOpponentPerStrike(){
        return damageDoneToOpponentPerStrike;}


    @Override
    public boolean canUse() {
        return true;
    }

    @Override
    int getAmmoLeft() {
        return 0;
    }

    public void useWeapon () {
        getDamageDoneToOpponentPerStrike();
    }
}