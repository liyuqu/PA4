import java.util.ArrayList;

public class PotionList {
    Potion new_potion;
    public ArrayList<Potion> allpotion;
    public PotionList() throws Exception {
        ReadTxt r =new ReadTxt();
        initalPotion(r.readTxt("./src/Legends_Monsters_and_Heroes/Potions.txt"));
    }
    public void initalPotion(ArrayList<String[]> p){
        allpotion=new ArrayList<Potion>();
        for (int i = 1; i < p.size(); i++) {
        new_potion=new Potion(p.get(i)[0],
                Integer.parseInt(p.get(i)[1]),
                Integer.parseInt(p.get(i)[2]),
                p.get(i)[4],
                Integer.parseInt(p.get(i)[3])
                );
        allpotion.add(new_potion);
    }
}

    public ArrayList<Potion> getAllpotion() {
        return allpotion;
    }

    public void display(ArrayList<Potion> potions){
        System.out.println("---------------------------------------------------------------  Potions  ----------------------------------------------------------------");
        System.out.println("Number              Name                     Cost               Require_Level              Increase               Affected Attribute");
        for (int i = 0; i < potions.size(); i++) {
            System.out.printf("%d\t\t",i);
            System.out.printf("%20s",potions.get(i).getName());
            System.out.printf("%20s",potions.get(i).getCost());
            System.out.printf("%20s",potions.get(i).getRequiredLevel());
            System.out.printf("%30s",potions.get(i).getAttributeIncrease());
            System.out.printf("%30s",potions.get(i).getAttributeAffected());
            System.out.println();
        }
    }
}
