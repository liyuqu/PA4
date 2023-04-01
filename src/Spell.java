public class Spell extends Equipment{
    private int damage;
    private int manaCost;
    private SpellType type;
    private int used_number=0;
    private int max_use=10;
    public Spell(String name, int cost, int requiredLevel, int damage, int manaCost, SpellType type) {
        super(name, cost, requiredLevel);
        this.damage=damage;
        this.manaCost=manaCost;
        this.type=type;
    }
    public void setDamage(int damage){
        this.damage=damage;
    }
    public void setManaCost(int manaCost){
        this.manaCost=manaCost;
    }

    public void setType(SpellType type) {
        this.type = type;
    }

    public int getDamage() {
        return damage;
    }

    public int getManaCost() {
        return manaCost;
    }

    public int getUsed_number() {
        return used_number;
    }

    public void AddUsed_number() {
        this.used_number +=1;
    }

    public SpellType getType(){
        return type;
    }
    public void SpellInfo(){
        System.out.println(getName() + "   " + "Cost: " + getCost() + "   " + "Level Require: " + getRequiredLevel()
                +"   " + "Damage: " + getDamage() + "   " + "Spell Type: " + getType() + "   " + "Mana Cost: " + getCost() + " Used Time: " + used_number
        + "/" + max_use);
    }
}
