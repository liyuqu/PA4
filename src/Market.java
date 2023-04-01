import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Market {
    protected WeaponList weaponList;
    protected ArmoryList armoryList;
    protected SpellList spellList;
    protected PotionList potionList;

    public Market() throws Exception {
        weaponList=new WeaponList();
        armoryList=new ArmoryList();
        spellList=new SpellList();
        potionList=new PotionList();
    }
    public void display(ArrayList<Weapon> weapons,ArrayList<Spell> spells,ArrayList<Armory> armories,ArrayList<Potion> potions) {
        System.out.println("---------------------------------------------------------------  Market  ----------------------------------------------------------------");
        weaponList.display(weapons);
        spellList.display(spells);
        armoryList.display(armories);
        potionList.display(potions);
    }

}
