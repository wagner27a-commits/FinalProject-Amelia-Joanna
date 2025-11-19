public class Food {
    private String name;
    private int cost;
    private int numOwned;

    public Food(String name, int cost){
        this.name = name;
        this.cost = cost;
        this.numOwned = 0;
    }

    public String getName(){
        return name;
    }

    public int getCost(){
        return cost;
    }

    public int getQuant(){
        return numOwned;
    }

    public void increaseQuantity(){
        numOwned++;
    }

    @Override
    public String toString(){
        return name + ", " + cost +" Rainbows, "+numOwned+" owned";
    }

    @Override
    public boolean equals(Object o) {
        // compares to see if same object
        if (o == this)
        return true;
        // compares type
        if (!(o instanceof Food))
        return false;
        Food that = (Food) o;
        // performs actual comparison
        // compare this with that
        return this.name == that.name && this.cost == that.cost && this.numOwned == that.numOwned;
    }
}
