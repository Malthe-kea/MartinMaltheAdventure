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
        System.out.println("You are now ready to explore the wilderness!\n");
        System.out.println("Please choose your next action:");
        System.out.println("Write 'Go north' to go north");
        System.out.println("Write 'Go west' to go west");
        System.out.println("Write 'Go south' to go south");
        System.out.println("Write 'Go east' to go east");
        System.out.println("Write 'Look' to go look around you");
        System.out.println("Write 'Help' to ask for help");
        System.out.println("Write 'Attack' and which monster you wanna attack, to attack a monster");
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