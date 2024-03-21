public class Map {
    //Attributes
    private Room firstRoom;

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


        //ROOM 1
        room1.setEast(room2);
        room1.setSouth(room4);
        room1.addItemToCurrentRoom(new Food("vin", "En 100 år gammel rosindrik", -15));
        room1.addItemToCurrentRoom(new MeleeWeapon("kniv", "Den vildeste kniv i byen", 100));
        room1.addItemToCurrentRoom(new RangedWeapon("vandpistol", "Den sløveste vandpistol øst for Randers", 1, 1));
        room1.addEnemyToCurrentRoom(new Enemy("Diablo", "Djævlen hamselv", 5,1000, new MeleeWeapon("Trefork", "Lucifers",10)));

        //ROOM 2
        room2.setWest(room1);
        room2.setEast(room3);
        room2.addItemToCurrentRoom(new Food("muslibar", "Muslibar med tranebær, citron og hasselnødder", 5));
        room2.addItemToCurrentRoom(new Food("bolle", "en bolle med ost og smør", 20));
        room2.addItemToCurrentRoom(new RangedWeapon("dessertEagle", "Den tungeste dreng i byen", 25, 10));

        //ROOM 3
        room3.setWest(room2);
        room3.setSouth(room6);
        room3.addItemToCurrentRoom(new Food("rugbrød", "Rugbrød med leverpostej, rødbedder og peber", 10));
        room3.addItemToCurrentRoom(new Food("agurk", "Den saftigste agurk i byen", 5));
        room3.addEnemyToCurrentRoom(new Enemy("karlof", "Den største bandit i byen", 60, 10,new MeleeWeapon("Tigersabel", "En skarp fætter", 10)));

        //ROOM 4
        room4.setNorth(room1);
        room4.setSouth(room7);
        room4.addItemToCurrentRoom(new Food("kakaodrik", "Supreme Chokomel drik", 15));
        room4.addItemToCurrentRoom(new Food("grapefrugt", "En råden grapefrugt", -10));
        room4.addItemToCurrentRoom(new MeleeWeapon("kølle", "Dolphs Kølle: DØDMEDKØLLE", 5));

        //ROOM 5
        room5.setSouth(room8);
        room4.addEnemyToCurrentRoom(new Enemy("Stor Fed Boss", "Last man standing", 100,10, new RangedWeapon("Magic Wand", "Tryllestøv bliver sendt mod dig", 25, 10)));

        //ROOM 6
        room6.setNorth(room3);
        room6.setSouth(room9);
        room6.addItemToCurrentRoom((new Food("fastelavnsbolle", "Den dyre fra Lagkagehuset", 20)));
        room6.addItemToCurrentRoom((new Food("kylling", "Rå kylling der har ligget lidt for længe", -15)));

        //ROOM 7
        room7.setNorth(room4);
        room7.setEast(room8);
        room7.addItemToCurrentRoom(new Food("insekter", "Et glas insekter spicet op med BBQ", 10));
        room7.addItemToCurrentRoom(new Food("kaffe", "En kop varm kaffe af mærket Merrild", 0));
        room7.addEnemyToCurrentRoom(new Enemy("Matematiklærer", "En matematiklærer fra folkeskolen", 50,10, new RangedWeapon("Matematikbøger", "10 års pensum af matematikbøger bliver kastet", 5, 10)));

        //ROOM 8
        room8.setWest(room7);
        room8.setNorth(room5);
        room8.setEast(room9);
        room8.addItemToCurrentRoom(new Food("energidrik", "Den helt billige sukkerfri fra Lidl", 5));
        room8.addItemToCurrentRoom(new Food("flaske vand", "En halvtom,lun flaske kildevand", 5));

        //ROOM 9
        room9.setWest(room8);
        room9.setNorth(room6);
        room9.addItemToCurrentRoom(new Food("majs", "En bøtte dåsemajs der udløb for 5 år siden", -10));
        room9.addItemToCurrentRoom(new Food("glögg", "En flaske alkoholfri Glögg fra Remam 1000", 3));
        room9.addEnemyToCurrentRoom(new Enemy("Ged", "En sur ged", 10, 10,new MeleeWeapon("Dåse", "En halvspist dåse", 2)));
    }

    public Room getFirstRoom() {
        return firstRoom;
    }

    public void setEnemyInRoom () {

    }
}