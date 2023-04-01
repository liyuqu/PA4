public class Equipment extends Entity {
    private int cost;

    private int requiredLevel;

    public Equipment(String name, int cost, int requiredLevel) {
        super(name);
        this.cost=cost;
        this.requiredLevel=requiredLevel;
    }
    public int getCost(){
        return cost;
    }
    public int getRequiredLevel(){
        return requiredLevel;
    }

    public void setCost(int cost){
        this.cost=cost;
    }
    public void setRequiredLevel(int requiredLevel){
        this.requiredLevel=requiredLevel;
    }
}
