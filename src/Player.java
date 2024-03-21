import java.util.ArrayList;

public class Player {

    //Attributes
    private Room currentRoom;
    private ArrayList<Item> inventory;
    private int playerHealth = 0;
    private Weapon currentWeapon;
    private Weapon weapon;
    private AdventureController controller;
    private ArrayList enemyInRoom;
    private Enemy enemy;


    //CONSTRUCTOR
    public Player(Room currentRoom) {
        this.currentRoom = currentRoom;
        this.inventory = new ArrayList<>();
        setPlayerHealth(100);
    }


    public void playerDied() {
        if (playerHealth <= 0) {
            System.out.println("You died - GAME OVER!");
            System.exit(0);
        }
    }

    public int getPlayerHealth() {
        return playerHealth;
    }

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    public void setPlayerHealth(int changeInHealth) {
        playerHealth += changeInHealth;
        if (playerHealth <= 0) { // health range er sat fra 0-100
            playerDied();
        } else if (playerHealth > 100) {
            playerHealth = 100;
        }
    }

    public void eatFoodOrItem(String shortName) {
        Item item = findItemFromInventoryOrCurrentRoom(shortName);
        if (item == null) {
            System.out.println("you found nothing to eat");
        } else if (item instanceof Food food) {
            removeItem(item);
            setPlayerHealth(food.getHealthPoints());
            if (playerHealth == 100) {
                System.out.println("You consumed " + item);
                System.out.println("You're at full HP");
            } else {
                System.out.println("You consumed" + item + " and gained " + food.getHealthPoints() + " HP");
            }
        } else System.out.println(item + " is not edible");
    }


    public void equipWeapon(String shortName) {
        Item equippedWeapon = findItemFromInventory(shortName);
        if (equippedWeapon == null) {
            System.out.println("no weapon found with the name :" + equippedWeapon);
        } else if (equippedWeapon instanceof Weapon) {
            currentWeapon = (Weapon) equippedWeapon;
            getCurrentRoom().removeItem(equippedWeapon);
            inventory.remove(equippedWeapon);
            System.out.println("You have equipped " + equippedWeapon);
        } else {
            System.out.println("you cant equip " + " as a weapon");
        }
    }

    public void attack(String enemyShortName) {
        String enemyToAttack = enemyShortName;

        ArrayList<Enemy> enemyInRoom  = currentRoom.getEnemiesInRoom();
        if ( enemyInRoom.isEmpty()) {
            System.out.println("no enemies in this room to fight");
        } else {
            for (Enemy e : enemyInRoom) {
                if (enemy.getName().equalsIgnoreCase(enemy.shortName)) {
                    Weapon equippedWeapon = controller.getGamePlayer().getEquippedWeapon();
                    if (equippedWeapon == null) {
                        System.out.println("You don't have a weapon equipped. You can chose from the following items " + getInventory());
                    } else if (equippedWeapon instanceof MeleeWeapon) {
                        equippedWeapon.useWeapon();
                        System.out.println("You attacked with " + equippedWeapon.getShortName() + ".");
                    } else if (equippedWeapon.getAmmoLeft() == 0) {
                        System.out.println("You are out of ammo");
                    } else if (equippedWeapon instanceof RangedWeapon) {
                        equippedWeapon.useWeapon();
                        System.out.println("You attacked with " + equippedWeapon.getShortName() + ".");
                        System.out.println("You have " + equippedWeapon.getAmmoLeft() + " ammo left");
                    }
                }
            }
        }
    }

    public void takeItemAndAddToInventory(String itemName) {
        Item item = currentRoom.searchForItemsInCurrentRoom(itemName);
        if (item != null) {
            currentRoom.removeItem(item);
            addItemToInventory(item);
            System.out.println("you took the: " + item.getShortName() + ".");
        } else {
            System.out.println("no item with the name : " + itemName + " exists.");
        }
    }

    public Item findItemFromInventoryOrCurrentRoom(String shortName) {
        for (Item i : inventory) {
            if (i.getShortName().equals(shortName)) {
                return i;
            }
        }
        for (Item i : currentRoom.getItemsInCurrentRoom()) {
            if (i.getShortName().equals(shortName)) {
                return i;
            }
        }
        return null;
    }

    public Item findItemFromInventory(String shortName) {
        for (Item i : inventory) {
            if (i.getShortName().equals(shortName)) {
                return i;
            }
        }
        return null;
    }

    //removes item from inventory
    public void dropItemInCurrentRoom(String shortName) {
        System.out.println("Write the name of the item you want to drop");
        Item item = findItemFromInventoryOrCurrentRoom(shortName);
        if (item != null) {
            removeItem(item);
            currentRoom.addItemToCurrentRoom(item);
            System.out.println("the item " + item + " has been removed");
        } else {
            System.out.println("no item in inventory with the name :" + shortName + ".");
        }

    }

    public void addItemToInventory(Item item) {
        inventory.add(item);
    }

    public void removeItem(Item item) {
        inventory.remove(item);
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void setCurrentWeapon(Weapon currentWeapon) {
        this.currentWeapon = currentWeapon;
    }

    public Weapon getEquippedWeapon() {
        return currentWeapon;
    }

    public String look() {
        StringBuilder roomInfo = new StringBuilder();
        roomInfo.append("You are in: ").append(currentRoom.getRoomName());
        roomInfo.append("\n").append(currentRoom.getRoomDescription());
        roomInfo.append("\n");
        roomInfo.append("You find the following items in the room: ");
        roomInfo.append("\n").append(currentRoom.getItemsInCurrentRoom());
        return roomInfo.toString();
    }

    //Overført fra "Adventure del 2 review" PDF slide 15
    public boolean move(String direction) {
        Room desiredRoom = switch (direction) {
            case "north" -> currentRoom.getNorth();
            case "south" -> currentRoom.getSouth();
            case "east" -> currentRoom.getEast();
            case "west" -> currentRoom.getWest();
            default -> null;
        };

        if (desiredRoom != null) {
            currentRoom = desiredRoom;
            return true;
        } else {
            return false;
        }
    }
}