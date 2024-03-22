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
        Room room1 = new Room("The Dragon Chamber", "Glowing lava streams illuminate the eggs beneath the sky of scales and flames, while dragons rest in slumber.");
        Room room2 = new Room("The Elf King's Salon)", "Crystal-like flowers bloom above swaying treetops, while elves dance among shimmering dust particles.");
        Room room3 = new Room("Scyscraber of Magic", "The clouds envelop floating books, while starry sky archives and sky-blue shelves stretch towards the infinity of knowledge.");
        Room room4 = new Room("Troldmandens Laboratorium", "Boblende kedler og glimtende eliksirer omgiver en hvirvlende portal, hvor magiens pulserende hjerte skaber et kalejdoskopisk skuespil.");
        Room room5 = new Room("The Prison Cell", "The cell of horror, might and nothing but endless screaming, terror and pain. Welcome to hell!");
        Room room6 = new Room("Skovens Hjerte", "Solens stråler filtrerer gennem løvtagets grene og kaster gyldne strejf over mosdækkede stier og levende træers hvisken.");
        Room room7 = new Room("Home of Hobbit", "Cozy houses hide among colorful flower meadows and fragrant kitchen gardens, where light dances on crooked stone terraces.");
        Room room8 = new Room("Demonic Court", "Lava rivers surround a ruined court, where demonic beings hold court and pronounce fateful judgments under a flaming sky.");
        Room room9 = new Room("Englernes Have", "En skyfri himmel bader engle i gyldent lys, mens blomsterbede stråler i alskens farver og en bæk risler mellem ædle sten.");
        firstRoom = room1;
        lastRoom = room5;


        //ROOM 1
        room1.setEast(room2);
        room1.setSouth(room4);
        room1.addItemToCurrentRoom(new Food("qine", "100 year old bottle", -15));
        room1.addItemToCurrentRoom(new Food("oysters", "Handpicked in the supermarket", 30));
        room1.addItemToCurrentRoom(new Food("sparklingwater", "With lime and citrus", 20));
        room1.addItemToCurrentRoom(new MeleeWeapon("knife", "Crocodille Dundee would be jalous", 10));
        room1.addItemToCurrentRoom(new RangedWeapon("watergun", "the cheap on from BR", 2, 15));
        room1.addEnemyToCurrentRoom(new Enemy("Diablo", "The devil himself", 20, 10, new MeleeWeapon("Trefork", "Lucifers",10)));

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

        //ROOM 5
        room5.setSouth(room8);
        room5.addItemToCurrentRoom(new Food("juice", "Orange without plums", 15));
        room5.addEnemyToCurrentRoom(new Enemy("BigBoss", "El Chefe", 100, 25, new MeleeWeapon(finalItemForTheFinalBoss(), "Grail", 0)));
        //ROOM 6

        room6.setNorth(room3);
        room6.setSouth(room9);
        room6.addEnemyToCurrentRoom(new Enemy("Morpheus", "An entity dressed in a black leather coat", 10000, -5, new MeleeWeapon(" ", " ", 0)));


        //ROOM 7
        room7.setNorth(room4);
        room7.setEast(room8);
        room7.addItemToCurrentRoom(new Food("bugs", "Bugs, BBQ and Bourbon", 10));
        room7.addItemToCurrentRoom(new Food("coffee", "A hot cup of Merrild Coffee", -5));
        room7.addEnemyToCurrentRoom(new Enemy("mathteacher", "The old one from your elemantary schooll", 50, 15, new RangedWeapon("Algebrabooks", "Hardbacks", 5, 10)));

        //ROOM 8
        room8.setWest(room7);
        room8.setNorth(room5);
        room8.setEast(room9);
        room8.addItemToCurrentRoom(new Food("energydrink", "The cheap non-brand one", 5));
        room8.addItemToCurrentRoom(new Food("boooooowoahh", "A bootle of Water", 5));
        room8.addItemToCurrentRoom(new Enemy("motherinlaw", "She's on a visit...", 40,10, new MeleeWeapon("A spandel", "The metal one", 10)));

        //ROOM 9
        room9.setWest(room8);
        room9.setNorth(room6);
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