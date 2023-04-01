public class Armory extends Equipment{
    private int damageReduction;
    public Armory(String name, int cost, int requiredLevel, int damageReduction) {
        super(name, cost, requiredLevel);
        this.damageReduction=damageReduction;
    }
    public int getDamageReduction(){
        return damageReduction;
    }
    public void setDamageReduction(int damageReduction){
        this.damageReduction=damageReduction;
    }

    public void ArmorInfo(){
        System.out.println(getName() + "   " + "Cost: " + getCost() + "   " + "Level Require: " + getRequiredLevel()
                +"   " + "Damage Reduction: " + getDamageReduction());
    }
}
