import java.util.ArrayList;

public class WeaponList {
    Weapon new_weapon;
    private ArrayList<Weapon> allWeapons;
    public WeaponList() throws Exception {
        ReadTxt r = new ReadTxt();
        initialWeapons(r.readTxt("./src/Legends_Monsters_and_Heroes/Weaponry.txt"));
    }

    public void initialWeapons(ArrayList<String[]> w) {
        allWeapons=new ArrayList<Weapon>();
        for (int i = 1; i < w.size(); i++) {
            new_weapon = new Weapon(w.get(i)[0],
                    Integer.parseInt(w.get(i)[1]),
                    Integer.parseInt(w.get(i)[2]),
                    Integer.parseInt(w.get(i)[3]),
                    Integer.parseInt(w.get(i)[4])
            );
            allWeapons.add(new_weapon);
        }
    }

    public void display(ArrayList<Weapon> weapons){
        System.out.println("---------------------------------------------------------------  Weapons  ----------------------------------------------------------------");
        System.out.println("Number              Name                     Cost                 Require_Level                  Damage               Require Hand ");
        for (int i = 0; i < weapons.size(); i++) {
            System.out.printf("%d\t\t",i);
            System.out.printf("%20s",weapons.get(i).getName());
            System.out.printf("%20s",weapons.get(i).getCost());
            System.out.printf("%20s",weapons.get(i).getRequiredLevel());
            System.out.printf("%35s",weapons.get(i).getDamage());
            System.out.printf("%20s",weapons.get(i).getRequiredHand());
            System.out.println();
        }
    }

    public ArrayList<Weapon> getAllWeapons() {
        return allWeapons;
    }

}
