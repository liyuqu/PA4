import java.util.List;
import java.util.ArrayList;
public class Inventory{
    protected ArrayList<Weapon> weapons;
    protected ArrayList<Armory> armories;
    protected ArrayList<Potion> potions;
    protected ArrayList<Spell> spells;
    protected WeaponList weaponList=new WeaponList();
    protected ArmoryList armoryList=new ArmoryList();
    protected SpellList spellList=new SpellList();
    protected PotionList potionList=new PotionList();

    public Inventory(ArrayList<Weapon> weapons, ArrayList<Armory> armories, ArrayList<Potion>potions, ArrayList<Spell> spells) throws Exception {
            this.weapons=weapons;
            this.armories=armories;
            this.potions=potions;
            this.spells=spells;
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(ArrayList<Weapon> weapons) {
        this.weapons = weapons;
    }

    public ArrayList<Armory> getArmories() {
        return armories;
    }

    public void setArmories(ArrayList<Armory> armories) {
        this.armories = armories;
    }

    public ArrayList<Potion> getPotions() {
        return potions;
    }

    public void setPotions(ArrayList<Potion> potions) {
        this.potions = potions;
    }

    public ArrayList<Spell> getSpells() {
        return spells;
    }

    public void setSpells(ArrayList<Spell> spells) {
        this.spells = spells;
    }

    public void printWeapon(){
        weaponList.display(this.getWeapons());
    }
    public void printArmory(){
        armoryList.display(this.getArmories());
    }
    public void printPotion(){
        potionList.display(this.getPotions());
    }
    public void printSpell(){
        spellList.display(this.getSpells());
    }
    public void addWeapon(Weapon weapon){
        this.weapons.add(weapon);
    }
    public void removeWeapon(Weapon weapon){
        this.weapons.remove(weapon);
    }
    public void addArmory(Armory armory){
        this.armories.add(armory);
    }
    public void removeArmory(Armory armory){
        this.armories.remove(armory);
    }
    public void addSpell(Spell spell){
        this.spells.add(spell);
    }
    public void removeSpell(Spell spell){
        this.spells.remove(spell);
    }
    public void addPotion(Potion potion){
        this.potions.add(potion);
    }
    public void removePotion(Potion potion){
        this.potions.remove(potion);
    }

    public boolean isEmpty() {
        if(!weapons.isEmpty()||!potions.isEmpty()||!armories.isEmpty()||!spells.isEmpty()){
            return false;
        }else{
            return true;
        }
    }
    public void printall(){
        System.out.println("------------------------------------------------------------  Inventory  -----------------------------------------------------------");
        weaponList.display(weapons);
        spellList.display(spells);
        armoryList.display(armories);
        potionList.display(potions);

    }

}
