// class for all of the food in the app

public class Food {
    private String name;
    private int cost;
    private int numOwned;
    private int happiness;

    public Food(String name, int cost, int happiness){
        this.name = name;
        this.cost = cost;
        this.numOwned = 0;
        this.happiness = happiness;;
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

    public int getHappiness(){
        return happiness;
    }

    public void increaseQuantity(){
        numOwned++;
    }

    public void decreaseQuantity(){
        numOwned--;
    }

    @Override
    public String toString(){
        return name + ", " + cost +" Rainbows, "+numOwned+" owned, +"+happiness+" happiness";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
        return true;
        if (!(o instanceof Food))
        return false;
        Food that = (Food) o;
        return this.name == that.name && this.cost == that.cost && this.numOwned == that.numOwned && this.happiness == that.happiness;
    }
}
