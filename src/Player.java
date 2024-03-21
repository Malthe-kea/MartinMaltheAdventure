import java.util.ArrayList;

public class Player {

    //Attributes
    private Room currentRoom;
    private ArrayList<Item> inventory;
    private int playerHealth = 0;
    private Weapon currentWeapon;
    private ArrayList enemyInRoom;
    private Enemy enemyToAttack;


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
        enemyInRoom = currentRoom.getEnemiesInRoom();
        this.enemyToAttack = (Enemy) enemyInRoom.get(0);

        if (enemyInRoom.isEmpty()) {
            System.out.println("no enemies in this room to fight");
        } else if (this.enemyToAttack.getName().equalsIgnoreCase(this.enemyToAttack.shortName)) {
            Weapon equippedWeapon = getEquippedWeapon();
            if (equippedWeapon == null) {
                System.out.println("You don't have a weapon equipped. You can chose from the following items " + getInventory());
            } else if (equippedWeapon instanceof MeleeWeapon) {
                equippedWeapon.useWeapon();
                meleeWeaponAttackSequence();
            } else if (equippedWeapon.getUsesLeft() == 0) {
                System.out.println("You are out of ammo");
            } else if (equippedWeapon instanceof RangedWeapon) {
                equippedWeapon.useWeapon();
                rangedWeaponAttackSeqeuence();
            }
        }
    }

    public void meleeWeaponAttackSequence() {
        Weapon equippedWeapon = getEquippedWeapon();
        int enemyNewHealthValue = (enemyToAttack.getEnemyHealthPoints() - equippedWeapon.getDamagePerStrike());
        System.out.println("You attacked with " + equippedWeapon.getShortName() + ".");
        enemyToAttack.setHealthPoints(enemyNewHealthValue);
        if (enemyNewHealthValue <= 0) {
            enemyDied();
            System.out.println("you have defeated " + enemyToAttack);
        } else {
            System.out.println("The enemy now has " + enemyNewHealthValue + " HP left.");
            playerHealth = enemyAttackPlayer();
            if (playerHealth <= 0) {
                playerDied();
            }
        }
    }
    public void rangedWeaponAttackSeqeuence() {
        Weapon equippedWeapon = getEquippedWeapon();
        int enemyNewHealthValue = (enemyToAttack.getEnemyHealthPoints() - equippedWeapon.getDamagePerStrike());
        System.out.println("You attacked with " + equippedWeapon.getShortName() + ".");
        enemyToAttack.setHealthPoints(enemyNewHealthValue);
        if (enemyNewHealthValue <= 0) {
            enemyDied();
            System.out.println("you have defeated " + enemyToAttack);
        } else {
            System.out.println("The enemy now has " + enemyNewHealthValue + " HP left.");
            System.out.println("You have " + equippedWeapon.getUsesLeft() + " ammo left");
            playerHealth = enemyAttackPlayer();
            if (playerHealth <= 0) {
                playerDied();
            }
        }
    }
    public int enemyAttackPlayer() {
        enemyInRoom = currentRoom.getEnemiesInRoom();
        enemyToAttack = (Enemy) enemyInRoom.get(0);
        if (enemyToAttack.getEnemyHealthPoints() <= 0) {
            enemyDied();
        } else {
            int playerNewHealth = (playerHealth - ((Enemy) enemyInRoom.get(0)).getEnemyAttackPoints());
            System.out.println(enemyToAttack + " attacked you with " + enemyToAttack.getEnemyAttackPoints());
            System.out.println("Your current HP is now " + playerNewHealth);
            return playerNewHealth;
        }
        return playerHealth;
    }

    public void enemyDied() {
        enemyInRoom = currentRoom.getEnemiesInRoom();
        Enemy enemy = (Enemy) enemyInRoom.get(0);
        currentRoom.addItemToCurrentRoom(enemy.getEnemyWeapon());
        currentRoom.deleteEnemyFromCurrentRoom(enemy);

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


    public Weapon getEquippedWeapon() {
        return currentWeapon;
    }

    public String getEnemiesInCurrentRoom() {
        enemyInRoom = currentRoom.getEnemiesInRoom();
        String enemyMessage;
        if (enemyInRoom.isEmpty()) {
            enemyMessage = "no enemies in this room to fight";
        } else {
            enemyMessage = "In the roome you encounter " + enemyInRoom + ".";
        }
        return enemyMessage;
    }

    public String look() {
        StringBuilder roomInfo = new StringBuilder();
        roomInfo.append("You are in: ").append(currentRoom.getRoomName());
        roomInfo.append("\n").append(currentRoom.getRoomDescription());
        roomInfo.append("\n");
        roomInfo.append("You find the following items in the room: ");
        roomInfo.append("\n").append(currentRoom.getItemsInCurrentRoom());
        roomInfo.append("\n").append(getEnemiesInCurrentRoom());
        return roomInfo.toString();
    }

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