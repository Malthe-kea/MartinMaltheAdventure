public class Item {
    String shortName;
    private String longName;


    public Item(String shortName, String longName) {
        this.longName = longName;
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }

    public String getLongName() {
        return longName;
    }

    @Override
    public String toString() {
        return getShortName();
    }
}