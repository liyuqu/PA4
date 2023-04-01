public class Weapon extends Equipment {
    private int damage;
    private int requiredHand;
    public Weapon(String name, int cost, int requiredLevel, int damage,int requiredHand) {
        super(name, cost, requiredLevel);
        this.damage=damage;
        this.requiredHand=requiredHand;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setRequiredHand(int requiredHand) {
        this.requiredHand = requiredHand;
    }

    public int getRequiredHand() {
        return requiredHand;
    }
    public void WeaponInfo(){
        System.out.println(getName() + "   " + "Cost: " + getCost() + "   " + "Level Require: " + getRequiredLevel()
                +"   " + "Damage: " + getDamage() + "   " + "Hand Require: " + getRequiredHand());
    }
}
