public class Food extends Item { // den klasse er en subklasse af Item.mItem contructor er derfor kaldt ind med dens egenskaber.

    //Attributer
    private int healthPoints;

    //contructor
    public Food(String shortName, String longName, int healthPoints) {
        super(shortName, longName); // kalder item konstruktor ind
        this.healthPoints = healthPoints;
    }

    //getter metod
    public int getHealthPoints() {
        return healthPoints;
    }
}