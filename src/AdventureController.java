public class AdventureController {
    //Attributes
    private Map gameMap;
    private Player gamePlayer;

    //Constructor
    public AdventureController() {
        gameMap = new Map();
        gamePlayer = new Player(gameMap.getFirstRoom());
    }

    //Getters bliver lavet her
    public Player getGamePlayer() {
        return gamePlayer;
    }

    public Map getGameMap() {
        return gameMap;
    }

    //Setters bliver lavet her:
    public void setGameMap(Map gameMap) {
        this.gameMap = gameMap;
    }

    public void setGamePlayer(Player gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    public void showPlayerInventory() {
        gamePlayer.getInventory();
    }

    public String look() {
        return gamePlayer.look();
    }

    //Weapon methods for use in subclasses
    public void attack() {
        getGamePlayer().getCurrentWeapon().getDamageDoneToOpponentPerStrike();
        if (getGamePlayer().getCurrentWeapon() instanceof RangedWeapon) {
            ((RangedWeapon) getGamePlayer().getCurrentWeapon()).setRemainingUses(getGamePlayer().getCurrentWeapon().getAmmo() - 1);
        } else {
            System.out.println("You dont have a weapon");
        }
    }
}