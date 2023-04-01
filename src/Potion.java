public class Potion extends Equipment{
    private String AttributeAffected;
    private int AttributeIncrease;
    public Potion(String name, int cost, int requiredLevel,String AttributeAffected,int AttributeIncrease) {
        super(name, cost, requiredLevel);
        this.AttributeAffected=AttributeAffected;
        this.AttributeIncrease=AttributeIncrease;
    }
    public String getAttributeAffected(){
        return AttributeAffected;
    }
    public void setAttributeAffected(String AttributeAffected){
        this.AttributeAffected=AttributeAffected;
    }
    public int getAttributeIncrease(){
        return AttributeIncrease;
    }
    public void setAttributeIncrease(int AttributeIncrease){
        this.AttributeIncrease=AttributeIncrease;
    }
    public void PotionInfo(){
        System.out.println(getName() + "   " + "Cost: " + getCost() + "   " + "Level Require: " + getRequiredLevel()
                +"   " + "Attribute Affect: " + getAttributeAffected() + "   " + "Attribute Increase: " + getAttributeIncrease());
    }
}
