import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class SubMarket extends Market{
    protected content id;
    protected static HashMap<content, SubMarket> subMarketMap = new HashMap<content, SubMarket>();

    protected ArrayList<Weapon> subWeapons= new ArrayList<Weapon>();
    protected ArrayList<Spell> subSpells= new ArrayList<Spell>();
    protected ArrayList<Armory> subArmors= new ArrayList<Armory>();
    protected ArrayList<Potion> subPotions= new ArrayList<Potion>();
    protected int wSize=weaponList.getAllWeapons().size();
    protected int aSize=armoryList.getAllArmory().size();
    protected int sSize=spellList.getAllSpells().size();
    protected int pSize=potionList.getAllpotion().size();
    protected int SWSize;
    protected int SASize;
    protected int SSSize;
    protected int SPSize;
    protected ArrayList<Integer> wNum=new ArrayList<Integer>();
    protected ArrayList<Integer> aNum=new ArrayList<Integer>();
    protected ArrayList<Integer> sNum=new ArrayList<Integer>();
    protected ArrayList<Integer> pNum=new ArrayList<Integer>();


    public SubMarket() throws Exception{
        Random rand=new Random();
        SWSize=rand.nextInt(wSize-1);//weapon
        for (int i=0 ;i<SWSize;i++){
            boolean repeat=true;
            while(repeat) {
                int size = rand.nextInt(wSize);
                if (wNum.contains(size)){
                    repeat=true;
                }else{
                    subWeapons.add(weaponList.getAllWeapons().get(size));
                    wNum.add(size);
                    break;
                }
            }
        }
        SASize=rand.nextInt(aSize-1);//armory
        for (int i=0 ;i<SASize;i++){
            boolean repeat=true;
            while(repeat) {
                int size = rand.nextInt(aSize);
                if (aNum.contains(size)){
                    repeat=true;
                }else{
                    subArmors.add(armoryList.getAllArmory().get(size));
                    aNum.add(size);
                    break;
                }
            }
        }
        SSSize=rand.nextInt(sSize-1);//spell
        for (int i=0 ;i<SSSize;i++){
            boolean repeat=true;
            while(repeat) {
                int size = rand.nextInt(sSize);
                if (sNum.contains(size)){
                    repeat=true;
                }else{
                    subSpells.add(spellList.getAllSpells().get(size));
                    sNum.add(size);
                    break;
                }
            }
        }
        SPSize=rand.nextInt(pSize-1);
        for (int i=0 ;i<SPSize;i++){
            boolean repeat=true;
            while(repeat) {
                int size = rand.nextInt(pSize);
                if (pNum.contains(size)){
                    repeat=true;
                }else{
                    subPotions.add(potionList.getAllpotion().get(size));
                    pNum.add(size);
                    break;
                }
            }
        }



    }

    public ArrayList<Armory> getSubArmors() {
        return subArmors;
    }

    public ArrayList<Potion> getSubPotions() {
        return subPotions;
    }

    public ArrayList<Spell> getSubSpells() {
        return subSpells;
    }

    public ArrayList<Weapon> getSubWeapons() {
        return subWeapons;
    }
    public void display(){
        System.out.println("---------------------------------------------------------------  Market  ----------------------------------------------------------------");
        weaponList.display(subWeapons);
        spellList.display(subSpells);
        armoryList.display(subArmors);
        potionList.display(subPotions);
    }
    public void setId(content id){
        this.id=id;
    }

    public static void addSubMarket(SubMarket subMarket) {
        subMarketMap.put(subMarket.getId(), subMarket);
    }

    private content getId() {
        return id;
    }

    public static SubMarket getSubMarketById(content id) {
        return subMarketMap.get(id);
    }
}
