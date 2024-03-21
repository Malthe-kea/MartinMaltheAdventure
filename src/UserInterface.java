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
        System.out.println("*      THE GREAT ADVENTURE      *");
        System.out.println("*                               *");
        System.out.println("*********************************\n");
        userStartMenu();

        while (gameIsRunning) {
            //controller.getGamePlayer().playerDied();
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
                case "equip" -> {
                    controller.getGamePlayer().equipWeapon(commandParameter);
                }
                case "go north", "north", "n" -> {
                    if (controller.getGamePlayer().move("north")) {
                        System.out.println("You are moving north");
                    } else {
                        System.out.println("You can't go this way");
                    }
                }
                case "go south", "south", "s" -> {
                    if (controller.getGamePlayer().move("south")) {
                        System.out.println("You are moving south");
                    } else {
                        System.out.println("You can't go this way");
                    }
                }
                case "go east", "east", "e" -> {
                    if (controller.getGamePlayer().move("east")) {
                        System.out.println("You are moving east");
                    } else {
                        System.out.println("You can't go this way");
                    }
                }
                case "go west", "west", "w" -> {
                    if (controller.getGamePlayer().move("west")) {
                        System.out.println("You are moving west");
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
                    controller.getGamePlayer().setPlayerHealth(controller.getGamePlayer().getPlayerHealth() - 1);
                    System.out.println("INVALID COMMAND - NOW FEEL MY WRATH");
                    System.out.println("*a ghost gives you a 'trælår' and  you lose 1HP*");
                    System.out.println("You current HP is now " + controller.getGamePlayer().getPlayerHealth());
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
            System.out.println("Take | Drop | Go (n,s,e,w)| Inventory | Help | Exit");
            System.out.println("Any other commands will punish you");
            System.out.println();
            System.out.println("After adjusting your eyes you find the following items on the floor: ");
            System.out.println(controller.getGameMap().getFirstRoom().getItemsInCurrentRoom());
            System.out.println();
        System.out.println("In the distance you see your first encounter " + controller.getGameMap().getFirstRoom().getEnemiesInRoom()+ " as a voice whisperes ");
            System.out.println("your goal is to find the " + controller.getGameMap().getLastRoom().getEnemiesInRoom());
        }

    public void userHelp() {
        System.out.println("Write 'Look' to go look around you");
        System.out.println("Write 'Go' followed by a direction to move");
        System.out.println("Write 'Take' followed by the name of an item to put it in your inventory");
        System.out.println("Write 'Inventory' to look up your inventory");
        System.out.println("Write 'Eat' or 'drink' followed by the name of a food or drink in your inventory you'd like to consume");
        System.out.println("Write 'Health' to see your current health points");
    }

    //Split-method bruges til at dele kommandoen til switch-casen op i to dele -
    // - så spilleren f.eks. kan skrive "take example" for at tilgå "take" i switch og derefter videresende "example" til take-metoden i Player
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