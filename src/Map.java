public class Map {
    //Attributes
    private Room firstRoom;
    private Room lastRoom;

    //Constructor
    public Map() {
        createMap();
    }

    //Methods
    public void createMap() {
        Room room1 = new Room("Dragekammeret", "Lysende lavastrømme gløder om æggene under himlen af skæl og flamme, mens drager hviler i dvale.");
        Room room2 = new Room("Alvekongens Salon", "Krystallignende blomster blomstrer over svajende trætoppe, mens elvere danser mellem lysende støvpartikler.");
        Room room3 = new Room("Skytårnets Bibliotek", " Skyerne omslutter svævende bøger, mens stjernehimmel-arkiver og himmelblå reoler strækker sig mod uendeligheden af viden.");
        Room room4 = new Room("Troldmandens Laboratorium", "Boblende kedler og glimtende eliksirer omgiver en hvirvlende portal, hvor magiens pulserende hjerte skaber et kalejdoskopisk skuespil.");
        Room room5 = new Room("Undervands Paladset", "Perlemorskoraller danner en labyrint omkring svævende slotte, hvor havets folk samles mellem tangskove og skinnende krystalgrotter");
        Room room6 = new Room("Skovens Hjerte", "Solens stråler filtrerer gennem løvtagets grene og kaster gyldne strejf over mosdækkede stier og levende træers hvisken.");
        Room room7 = new Room("Hobbithjemmet", "Hyggelige huse gemmer sig blandt farverige blomsterenge og duftende køkkenhaver, hvor lyset danser på skæve stenterrasser.");
        Room room8 = new Room("Dæmonisk Domstol", "Lavafloder omgiver en ruineret domstol, hvor dæmoniske væsner holder hof og udfælder skæbnesvangre domme under en flammende himmel.");
        Room room9 = new Room("Englernes Have", "En skyfri himmel bader engle i gyldent lys, mens blomsterbede stråler i alskens farver og en bæk risler mellem ædle sten.");
        firstRoom = room1;
        lastRoom = room5;


        //ROOM 1
        room1.setEast(room2);
        room1.setSouth(room4);
        room1.addItemToCurrentRoom(new Food("vin", "En 100 år gammel rosindrik", -15));
        room1.addItemToCurrentRoom(new Food("østers", "Håndplukket i østersøen", 30));
        room1.addItemToCurrentRoom(new Food("egekilde", "Danskvand med citrus", 20));
        room1.addItemToCurrentRoom(new MeleeWeapon("kniv", "Den vildeste kniv i byen", 10));
        room1.addItemToCurrentRoom(new RangedWeapon("vandpistol", "Den sløveste vandpistol øst for Randers", 2, 15));
        room1.addEnemyToCurrentRoom(new Enemy("Diablo", "Djævlen hamselv", 20, 10, new MeleeWeapon("Trefork", "Lucifers",10)));

        //ROOM 2
        room2.setWest(room1);
        room2.setEast(room3);
        room2.addItemToCurrentRoom(new Food("muslibar", "Muslibar med tranebær, citron og hasselnødder", 5));
        room2.addItemToCurrentRoom(new Food("bolle", "en bolle med ost og smør", 20));
        room2.addItemToCurrentRoom(new RangedWeapon("dessertEagle", "Den tungeste dreng i byen", 25, 10));
        room2.addEnemyToCurrentRoom(new Enemy("rasmuspaludan", "Med en koran og lighter i hånden", 50, 20, new MeleeWeapon("Lighter", "Den billige fra kiosken", 5)));

        //ROOM 3
        room3.setWest(room2);
        room3.setSouth(room6);
        room3.addItemToCurrentRoom(new Food("blue-pill", "A blue pill", 0));
        room3.addItemToCurrentRoom(new Food("red-pill", "a red pill", 0));

        //ROOM 4
        room4.setNorth(room1);
        room4.setSouth(room7);
        room4.addItemToCurrentRoom(new Food("kakaodrik", "Supreme Chokomel drik", 15));
        room4.addItemToCurrentRoom(new Food("grapefrugt", "En råden grapefrugt", -10));
        room4.addItemToCurrentRoom(new MeleeWeapon("kølle", "Dolphs Kølle", 5));

        //ROOM 5
        room5.setSouth(room8);
        room5.addItemToCurrentRoom(new Food("brikjuice", "Appelsinjuive", 15));
        room5.addEnemyToCurrentRoom(new Enemy("BigBoss", "Last man standing", 100, 25, new MeleeWeapon(finalItemForTheFinalBoss(), "Grail", 0)));
        //ROOM 6
        room6.setNorth(room3);
        room6.setSouth(room9);
        room6.addEnemyToCurrentRoom(new Enemy("Morpheus", "En skikkelse klædt i lang lædderjakke", 10000, -5, new MeleeWeapon(" ", " ", 0)));


        //ROOM 7
        room7.setNorth(room4);
        room7.setEast(room8);
        room7.addItemToCurrentRoom(new Food("insekter", "Et glas insekter spicet op med BBQ", 10));
        room7.addItemToCurrentRoom(new Food("kaffe", "En kop varm kaffe af mærket Merrild", 0));
        room7.addEnemyToCurrentRoom(new Enemy("Matematiklærer", "En matematiklærer fra folkeskolen", 50, 15, new RangedWeapon("Matematikbøger", "10 års pensum af matematikbøger bliver kastet", 5, 10)));

        //ROOM 8
        room8.setWest(room7);
        room8.setNorth(room5);
        room8.setEast(room9);
        room8.addItemToCurrentRoom(new Food("energidrik", "Den helt billige sukkerfri fra Lidl", 5));
        room8.addItemToCurrentRoom(new Food("flaske vand", "En halvtom,lun flaske kildevand", 5));
        room8.addItemToCurrentRoom(new Enemy("Svigermor", "Hun er på besøg", 40,10, new MeleeWeapon("Emma Gad bog", "Hardback", 10)));

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