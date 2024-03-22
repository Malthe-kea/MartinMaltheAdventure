import java.util.ArrayList;
import java.util.List;

public class Map {
    //Attributes
    private Room firstRoom;
    private Room lastRoom;
    private List<Item> items = new ArrayList<>();
    private List<Enemy> enemies = new ArrayList<>();

    //Constructor
    public Map() {
        createMap();
    }

    //Methods
    public void createMap() {
        Room room1 = new Room("The Moist Dungeon Floor", "As you begin your quest for the final boss, you feel the cold floor on your hands,\nand the voices echoes in the room as you try to stand up...\n");
        Room room2 = new Room("The Storage Room", "You have passed a great, wooden door with the label 'Storage Room' on the front. As you turn on the lights\nan angry man is looking at you, phrassing things about religions...\n");
        Room room3 = new Room("Entering the Matrix", "Aqua went back to the 80's, but you wil go back to 1999. On the floor, you see the colours Haiti.\nAs you come closer, you see two pills on a table - you have to pick, so choose wisely...\n");
        Room room4 = new Room("The Forgotten Entry Room","You have arrivede in the Forgotten Entry Room. As you have beaten your first enemy,\nyou've gained strength, courage and items. Be prepared for the next!\n");
        Room room5 = new Room("The Prison Cell", "The cell of horror, might and nothing but endless screaming, terror and pain. But luckily:\nEither you die here or will conquer the game... Welcome to hell!\n");
        Room room6 = new Room("Entering the Animatrix", "Matrix wasn't a stand-alone thing, and neither will it be here. In front of you stands a great guy.\nA muscular guy, black shades, tight suit and a long coat...\n");
        Room room7 = new Room("The Dining Room of Horror", "You arrive at The Dinning Room of Horror. A quick look around gives the ick, vomit in your mouth and a bad breath.\nEmpty meatsuits, heads and blood enough to take a swim in is covering the floor...\n");
        Room room8 = new Room("The Demonic Court", "The castle usede to be an old court building 200 something years ago. Demons have risen through the cracked floors,\nand demons have taken over the court, the chairs and rulling. Beware of the encounters in the room!\n");
        Room room9 = new Room("The Chapel", "Every large castle need a holy place. This one has the mightiest one with the greatest Messias known to mankind.\nAs you hear the organ plating, a shiny light brighten your eyes and you see a silhouette far away...\n");
        firstRoom = room1;
        lastRoom = room5;


        //ROOM 1
        room1.setEast(room2);
        room1.setSouth(room4);
        room1.addItemToCurrentRoom(new Food("wine", "100 year old bottle", -15));
        room1.addItemToCurrentRoom(new Food("oysters", "Handpicked in the supermarket", 30));
        room1.addItemToCurrentRoom(new Food("sparklingwater", "With lime and citrus", 20));
        room1.addItemToCurrentRoom(new MeleeWeapon("knife", "Crocodille Dundee would be jalous", 10));
        room1.addItemToCurrentRoom(new RangedWeapon("watergun", "the cheap on from BR", 2, 15));
        room1.addEnemyToCurrentRoom(new Enemy("Diablo", "Spawn of satan", 20, 10, new MeleeWeapon("Trefork", "Lucifers",10)));

        //ROOM 2
        room2.setWest(room1);
        room2.setEast(room3);
        room2.addItemToCurrentRoom(new Food("granolabar", "A month of the date", 5));
        room2.addItemToCurrentRoom(new Food("cheeseburger", "With a lot of pickles!", 20));
        room2.addItemToCurrentRoom(new RangedWeapon("dessertEagle", "A heavy boy", 25, 10));
        room2.addEnemyToCurrentRoom(new Enemy("rasmuspaludan", "With a coran and a lighter in the other hand", 50, 20, new MeleeWeapon("Lighter", "The cheap one", 5)));

        //ROOM 3
        room3.setWest(room2);
        room3.setSouth(room6);
        room3.addItemToCurrentRoom(new Food("blue-pill", "A blue pill", 0));
        room3.addItemToCurrentRoom(new Food("red-pill", "a red pill", 0));

        //ROOM 4
        room4.setNorth(room1);
        room4.setSouth(room7);
        room4.addItemToCurrentRoom(new Food("cocoadrink", "Supreme Chokomel drink", 15));
        room4.addItemToCurrentRoom(new Food("grapefruit", "Rotten", -10));
        room4.addItemToCurrentRoom(new MeleeWeapon("axe", "Yielded by a Look-A-Like Thor", 5));
        room4.addEnemyToCurrentRoom(new Enemy("mathteacher", "Standing with a shoehorn, a set of books preparing to yell at you", 50, 15, new RangedWeapon("Algebrabooks", "Hardbacks", 5, 10)));

        //ROOM 5
        room5.setSouth(room8);
        room5.addItemToCurrentRoom(new Food("juice", "Orange without plums", 15));
        room5.addEnemyToCurrentRoom(new Enemy("BigBoss", "El Chefe", 100, 30, new MeleeWeapon(finalItemForTheFinalBoss(), "Grail", 0)));
        //ROOM 6

        room6.setNorth(room3);
        room6.setSouth(room9);
        room6.addEnemyToCurrentRoom(new Enemy("Morpheus", "An entity dressed in a black leather coat", 10000, -5, new MeleeWeapon(" ", " ", 0)));


        //ROOM 7
        room7.setNorth(room4);
        room7.setEast(room8);
        room7.addItemToCurrentRoom(new Food("bugs", "Bugs, BBQ and Bourbon", 10));
        room7.addItemToCurrentRoom(new Food("coffee", "A hot cup of Merrild Coffee", -5));
        room7.addEnemyToCurrentRoom(new Enemy("derekshepard", "The doctor of Greys Anatomy - ish", 50, 15, new MeleeWeapon("breadknife", "A very sharp knife", 10)));


        //ROOM 8
        room8.setWest(room7);
        room8.setNorth(room5);
        room8.setEast(room9);
        room8.addItemToCurrentRoom(new Food("energydrink", "The cheap non-brand one", 5));
        room8.addItemToCurrentRoom(new Food("boooooowoahh", "A bootle of Water", 5));
        room8.addItemToCurrentRoom(new Enemy("devilmotherinlaw", "She's awaiting trial for cooking a bad stew", 40,10, new MeleeWeapon("A spandel", "The metal one", 10)));

        //ROOM 9
        room9.setWest(room8);
        room9.setNorth(room6);
        room9.addItemToCurrentRoom(new Food("altarbread", "No wine, so its a bit dry", 20));
        room9.addEnemyToCurrentRoom(new Enemy("Agent-Smith", "An ominous looking agent with nothing good in mind", 75, 10, new MeleeWeapon(" ", "", 0)));
    }

    public Room getFirstRoom() {
        return firstRoom;
    }

    public Room getLastRoom () {
        return lastRoom;
    }


    public String finalItemForTheFinalBoss() {
        return "The Divine Holy Grail stands as the quintessence of celestial splendor, an ethereal vessel imbued with the luminescence of the heavens. " + " \n" +
                "It is a paragon of sanctity, a chalice of unparalleled reverence that radiates with a divine aura, shimmering with the purest of lights. " +
                "\nThis sacrosanct relic, cloaked in the mystique of ancient lore, is the epitome of spiritual magnificence and miraculous wonder.\n" +
                "Crafted from the essence of holiness, the Grail is a beacon of hope, a symbol of the ultimate quest for enlightenment and redemption. " +
                "\nIts mere presence is said to be a benediction, bestowing blessings and grace upon those who gaze upon its hallowed form. " +
                "\nThe Grail is not merely an artifact; it is a consecrated icon, a testament to the boundless glory and majesty of the divine.\n"+
                "Adorned with the most resplendent jewels, each facet and gem reflecting the infinite spectrum of creation, the Holy Grail is a masterpiece of celestial artistry. " +
                "\nIt is a vessel of prophecy and virtue, a cornucopia of sacred power that transcends the temporal realm, bridging the mortal world with the divine firmament.\n" +
                "In the annals of legend, the Divine Holy Grail is venerated as the apotheosis of purity and the embodiment of the divine will. " +
                "\nIt is an object of veneration, an eternal symbol of the quest for the divine, a pursuit as timeless as the stars that wheel overhead in the firmament of eternity.";

    }


}