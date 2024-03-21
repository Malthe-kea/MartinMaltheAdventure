public class MeleeWeapon extends Weapon {
    // MeleeWeapon kan normalt bruges et utal af gange.
    //ATTRIBUTES

    //KONSTRUKTØR
    public MeleeWeapon(String shortName, String longName, int damagePerStrike) {
        super(shortName, longName, damagePerStrike);
    }

    //GETTER METODE
    @Override
    int getDamagePerStrike() {
        return damagePerStrike;
    }

    @Override
    int getUsesLeft() {
        return 100000;
    }

    void useWeapon() {
    }
}