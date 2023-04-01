import java.util.ArrayList;

public class ArmoryList {
    Armory new_armory;
    private ArrayList<Armory> allArmory;

    public ArmoryList() throws Exception {
        ReadTxt r = new ReadTxt();
        initalArmory(r.readTxt("./src/Legends_Monsters_and_Heroes/Armory.txt"));
    }

    public void initalArmory(ArrayList<String[]> a) {
        allArmory=new ArrayList<Armory>();
        for (int i = 1; i < a.size(); i++) {
            new_armory = new Armory(a.get(i)[0],
                    Integer.parseInt(a.get(i)[1]),
                    Integer.parseInt(a.get(i)[2]),
                    Integer.parseInt(a.get(i)[3])
            );
            allArmory.add(new_armory);
        }
    }
    public void display(ArrayList<Armory> armories){
        System.out.println("---------------------------------------------------------------  Armory  ----------------------------------------------------------------");
        System.out.println("Number              Name                     Cost                 Require_Level                  Damage Reduction ");
        for (int i = 0; i < armories.size(); i++) {
            System.out.printf("%d\t\t",i);
            System.out.printf("%20s",armories.get(i).getName());
            System.out.printf("%20s",armories.get(i).getCost());
            System.out.printf("%20s",armories.get(i).getRequiredLevel());
            System.out.printf("%40s",armories.get(i).getDamageReduction());
            System.out.println();
        }
    }

    public ArrayList<Armory> getAllArmory() {
        return allArmory;
    }
}
