public class Accessory {
    private String name;
    private String path;
    private int cost;
    private Boolean owned;

    public Accessory(String name, String path, int cost){
        this.name = name;
        this.path = path;
        this.cost = cost;
        this.owned = false;
    }

    public String getName(){
        return name;
    }

    public String getPath(){
        return path;
    }

    public int getCost(){
        return cost;
    }

    public Boolean isOwned(){
        return owned;
    }

    public void own(){
        owned = true;
    }

    @Override
    public String toString(){
        String ownedText;
        if(owned){
            ownedText = "owned";
        }
        else{
            ownedText = "not owned";
        }
        return name + ": " + cost + " rainbows, " +ownedText;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
        return true;
        if (!(o instanceof Accessory))
        return false;
        Accessory that = (Accessory) o;
        return this.name == that.name && this.cost == that.cost && this.path == that.path && this.owned == that.owned;
    }
}
