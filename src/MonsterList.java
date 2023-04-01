import java.util.ArrayList;

public class MonsterList {
    Monster a_monster;
    private ArrayList<Monster> allMonsters= new ArrayList<Monster>();
    public MonsterList() throws Exception {
        ReadTxt r =new ReadTxt();
        initDragons(r.readTxt("./src/Legends_Monsters_and_Heroes/Dragons.txt"));
        initExoskeletons(r.readTxt("./src/Legends_Monsters_and_Heroes/Exoskeletons.txt"));
        initSpirits(r.readTxt("./src/Legends_Monsters_and_Heroes/Spirits.txt"));
    }
    private void initDragons(ArrayList<String[]> d){
        for (int i = 1; i < d.size(); i++) {
            a_monster=new Monster(d.get(i)[0],
                    Integer.parseInt(d.get(i)[1]),
                    100*Integer.parseInt(d.get(i)[1]),
                    Integer.parseInt(d.get(i)[2]),
                    Integer.parseInt(d.get(i)[3]),
                    Integer.parseInt(d.get(i)[4]),
                    MonsterType.Dragons
                    );
            this.allMonsters.add(a_monster);
        }
    }

    private void initExoskeletons(ArrayList<String[]> e){
        for (int i = 1; i < e.size(); i++) {
            a_monster=new Monster(e.get(i)[0],
                    Integer.parseInt(e.get(i)[1]),
                    100*Integer.parseInt(e.get(i)[1]),
                    Integer.parseInt(e.get(i)[2]),
                    Integer.parseInt(e.get(i)[3]),
                    Integer.parseInt(e.get(i)[4]),
                    MonsterType.Exoskeletons
            );
            this.allMonsters.add(a_monster);
        }
    }
    private void initSpirits(ArrayList<String[]> s){
        for (int i = 1; i < s.size(); i++) {
            a_monster=new Monster(s.get(i)[0],
                    Integer.parseInt(s.get(i)[1]),
                    100*Integer.parseInt(s.get(i)[1]),
                    Integer.parseInt(s.get(i)[2]),
                    Integer.parseInt(s.get(i)[3]),
                    Integer.parseInt(s.get(i)[4]),
                    MonsterType.Spirits
            );
            this.allMonsters.add(a_monster);
        }
    }
    public ArrayList<Monster> getAllMonsters() {
        return allMonsters;
    }

    public void display(ArrayList<Monster> monsters){
        System.out.println("------------------------------------------------------------------------  Monster  ------------------------------------------------------------------------");
        System.out.println("Number              Name                  Damage               Defense             DodgeChance             Type                Level              HP");
        for (int i = 0; i < monsters.size(); i++) {
            System.out.printf("%d\t\t",i);
            System.out.printf("%20s",monsters.get(i).getName());
            System.out.printf("%20s",monsters.get(i).getDamage());
            System.out.printf("%20s",monsters.get(i).getDefense());
            System.out.printf("%20s",monsters.get(i).getDodge_chance());
            System.out.printf("%20s",monsters.get(i).getType().getTypeName());
            System.out.printf("%20s",monsters.get(i).getLevel());
            System.out.printf("%20s",monsters.get(i).getCurHP());
            System.out.println();
        }
    }

}
