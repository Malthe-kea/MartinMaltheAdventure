import java.util.ArrayList;

public class Room {
    //attributes
    private String roomName;
    private String roomDescription;
    private Room north, east, west, south;
    private ArrayList<Item> itemList = new ArrayList<>();
    private ArrayList<Enemy> enemiesInRoom = new ArrayList<>();


    //Constructor
    public Room(String roomName, String roomDescription) {
        this.roomDescription = roomDescription;
        this.roomName = roomName;
    }
    //Methods

    public void addItemToCurrentRoom(Item item) {
        itemList.add(item);
    }
    public void addEnemyToCurrentRoom(Enemy enemy) {
        enemiesInRoom.add(enemy);
    }



    public Item lookForItemsInCurrentRoom(String shortName) {
        for (Item i : itemList) {
            if (i.getShortName().equals(shortName)) {
                return i;
            }
        }
        return null;
    }

    public void deleteItemFromCurrentRoom(String shortName) {
        Item item = lookForItemsInCurrentRoom(shortName);
        itemList.remove(item);
    }

    public Item searchForItemsInCurrentRoom(String shortName) {
        for (Item i : itemList) {
            if (i.getShortName().equals(shortName)) {
                return i;
            }
        }
        return null;
    }

    public void removeItem(Item item) {
        itemList.remove(item);
    }

    public ArrayList<Item> getItemsInCurrentRoom() {
        return itemList;
    }
    public ArrayList<Enemy> getEnemiesInRoom(){
        return enemiesInRoom;
    }


    // Getter & setter Methods
    public String getRoomName() {
        return roomName;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public Room getSouth() {
        return south;
    }

    public Room getEast() {
        return east;
    }

    public Room getNorth() {
        return north;
    }

    public Room getWest() {
        return west;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public void setSouth(Room south) {
        this.south = south;
    }
}