import java.util.Scanner;

public class UserInterface {
    //Attributes
    boolean gameIsRunning = true;
    Scanner scanner;
    AdventureController controller;
    String command;
    String commandParameter;

    //Constructor
    public UserInterface() {
        scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        controller = new AdventureController();
    }

    // Methods
    public void playGame() {
        System.out.println("*********************************");
        System.out.println("*                               *");
        System.out.println("*      ADVENTURE WITH A TWIST   *");
        System.out.println("*                               *");
        System.out.println("*********************************\n");
        userStartMenu();

        while (gameIsRunning) {
            command = "";
            commandParameter = "";
            command = processUserInput(scanner.next().toLowerCase());


            switch (command) {

                case "take", "t" -> {
                    String itemToTake = commandParameter;
                    controller.getGamePlayer().takeItemAndAddToInventory(itemToTake);
                }
                case "drop", "d" -> {
                    String itemToDrop = commandParameter;
                    controller.getGamePlayer().dropItemInCurrentRoom(itemToDrop);
                }
                case "eat", "drink" -> {
                    controller.getGamePlayer().eatFoodOrItem(commandParameter);
                }
                case "attack", "a" -> {
                    String enemyToAttack = commandParameter;
                    controller.getGamePlayer().attack(enemyToAttack);

                }
                case "equip", "eq" -> {
                    controller.getGamePlayer().equipWeapon(commandParameter);
                }
                case "go north", "north", "n" -> {
                    if (controller.getGamePlayer().move("north")) {
                        System.out.println("You are moving north");
                        System.out.println(controller.getGamePlayer().getCurrentRoom().getRoomDescription());
                        System.out.println("You found the following items lying around:");
                        System.out.println(controller.getGamePlayer().getCurrentRoom().getItemsInCurrentRoom());
                        System.out.println("In front of you stands and enemy: ");
                        System.out.println(controller.getGamePlayer().getCurrentRoom().getEnemiesInRoom());
                    } else {
                        System.out.println("You can't go this way");
                    }
                }
                case "go south", "south", "s" -> {
                    if (controller.getGamePlayer().move("south")) {
                        System.out.println("You are moving south");
                        System.out.println(controller.getGamePlayer().getCurrentRoom().getRoomDescription());
                        System.out.println("You found the following items lying around:");
                        System.out.println(controller.getGamePlayer().getCurrentRoom().getItemsInCurrentRoom());
                        System.out.println("In front of you stands and enemy: ");
                        System.out.println(controller.getGamePlayer().getCurrentRoom().getEnemiesInRoom());
                    } else {
                        System.out.println("You can't go this way");
                    }
                }
                case "go east", "east", "e" -> {
                    if (controller.getGamePlayer().move("east")) {
                        System.out.println("You are moving east");
                        System.out.println(controller.getGamePlayer().getCurrentRoom().getRoomDescription());
                        System.out.println("You found the following items lying around :");
                        System.out.println(controller.getGamePlayer().getCurrentRoom().getItemsInCurrentRoom());
                        System.out.println("In front of you stands and enemy: ");
                        System.out.println(controller.getGamePlayer().getCurrentRoom().getEnemiesInRoom());
                    } else {
                        System.out.println("You can't go this way");
                    }
                }
                case "go west", "west", "w" -> {
                    if (controller.getGamePlayer().move("west")) {
                        System.out.println("You are moving west");
                        System.out.println(controller.getGamePlayer().getCurrentRoom().getRoomDescription());
                        System.out.println("You found the following items lying around:");
                        System.out.println(controller.getGamePlayer().getCurrentRoom().getItemsInCurrentRoom());
                        System.out.println("In front of you stands and enemy: ");
                        System.out.println(controller.getGamePlayer().getCurrentRoom().getEnemiesInRoom());
                    } else {
                        System.out.println("You can't go this way");
                    }
                }
                case "exit" -> {
                    System.exit(0);
                }
                case "help", "h" -> {
                    userHelp();
                }
                case "look", "l" -> {
                    System.out.println(controller.look());
                }
                case "health", "hp" -> {
                    System.out.println("You currently have " + controller.getGamePlayer().getPlayerHealth() + " HP");
                    System.out.println("To increase your HP, try to eat or drink something");
                }
                case "inventory", "inv", "i" -> {
                    if (controller.getGamePlayer().getInventory().isEmpty()) {
                        System.out.println("Your inventory is empty");
                    } else {
                        System.out.println(controller.getGamePlayer().getInventory());
                        System.out.println(controller.getGamePlayer().getCurrentWeapon());
                    }
                }

                default -> {
                    controller.getGamePlayer().setPlayerHealth(-1);
                    System.out.println("INVALID COMMAND - NOW FEEL MY WRATH!");
                    System.out.println("*A ghost gives you a 'trælår' and  you lose 1HP*");
                    System.out.println("Your current HP is now " + controller.getGamePlayer().getPlayerHealth());
                }
            }
        }
    }


    public void userStartMenu() {
        System.out.println("You find yourself on a moist dungeon floor in what seems to be an old castle");
        System.out.println("'Where am I?' you whisper, as the sound of your voice echoes through the room.");
        System.out.println("Next to you lies a chalkboard with a message written on it :");
        System.out.println();
        System.out.println("'Your voice is for no use in this world.");
        System.out.println("From now on, you are only allowed to write the following commands on me");
        System.out.println("Take | Drop | Look | Eat |Go (N,S,E,W)| Inventory | Help | Attack | Exit");
        System.out.println("Any other commands will punish you");
        System.out.println();
        System.out.println("After adjusting your eyes, you find the following items on the floor: ");
        System.out.println(controller.getGameMap().getFirstRoom().getItemsInCurrentRoom());
        System.out.println();
        System.out.println("As you move around in the rooms, you will find things to eat, items to take and weapons to equip.");
        System.out.println("But beware: Not all edible stuff is good for your health, an not all weapons are good!");
        System.out.println();
        System.out.println("First, when you cant go any further with dry feet, you shall seek a great bird and cross the black salt'");
        System.out.println();
        System.out.println("In the distance you see your first encounter " + controller.getGameMap().getFirstRoom().getEnemiesInRoom() + " as a voice whisperes: ");
        System.out.println("'Your goal is to find the final boss called " + controller.getGameMap().getLastRoom().getEnemiesInRoom() + " and loot their treasure - let the games begin'");
    }

    public void userHelp() {
        System.out.println("Write 'Look' to go look around you");
        System.out.println("Write 'Go' followed by a direction to move");
        System.out.println("Write 'Take' followed by the name of an item to put it in your inventory");
        System.out.println("Write 'Inventory' to look up your inventory");
        System.out.println("Write 'Eat' or 'drink' followed by the name of a food or drink in your inventory you'd like to consume");
        System.out.println("Write 'Attack' and then the monster you wish to attack, if you wanna attack that monster");
        System.out.println("Write 'Health' to see your current health points");
        System.out.println("Write 'Exit' to exit the game");
    }

    public String processUserInput(String command) {
        String[] userInputArray = command.split(" ");
        this.command = userInputArray[0];
        if (this.command.equals("eat") || this.command.equals("drink") || this.command.equals("drop") || this.command.equals("take") || this.command.equals("equip") || this.command.equals("attack")) {
            commandParameter = userInputArray[1];
            return userInputArray[0];
        }
        return command;
    }
}