public class AdventureController {
    //Attributes
    private Map gameMap;
    private Player gamePlayer;

    //Constructor
    public AdventureController() {
        gameMap = new Map();
        gamePlayer = new Player(gameMap.getFirstRoom());
    }

    public Player getGamePlayer() {
        return gamePlayer;
    }

    public Map getGameMap() {
        return gameMap;
    }

    public String look() {
        return gamePlayer.look();
    }


}