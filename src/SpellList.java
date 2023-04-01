import java.util.ArrayList;

public class SpellList {
    Spell a_spell;
    private ArrayList<Spell> allSpells= new ArrayList<Spell>();

    // read .txt to init the Spells list
    public SpellList() throws Exception {
        ReadTxt r =new ReadTxt();
        initFireSpells(r.readTxt("./src/Legends_Monsters_and_Heroes/FireSpells.txt"));
        initLightningSpells(r.readTxt("./src/Legends_Monsters_and_Heroes/LightningSpells.txt"));
        initIceSpells(r.readTxt("./src/Legends_Monsters_and_Heroes/IceSpells.txt"));
    }

    private void initLightningSpells(ArrayList<String[]> w){
        for (int i = 1; i < w.size(); i++) {
            a_spell=new Spell(w.get(i)[0],
                    Integer.parseInt(w.get(i)[1]),
                    Integer.parseInt(w.get(i)[2]),
                    Integer.parseInt(w.get(i)[3]),
                    Integer.parseInt(w.get(i)[4]),
                    SpellType.Lightning

            );
            this.allSpells.add(a_spell);
        }
    }

    private void initIceSpells(ArrayList<String[]> p){
        for (int i = 1; i < p.size(); i++) {
            a_spell = new Spell(p.get(i)[0],
                    Integer.parseInt(p.get(i)[1]),
                    Integer.parseInt(p.get(i)[2]),
                    Integer.parseInt(p.get(i)[3]),
                    Integer.parseInt(p.get(i)[4]),
                    SpellType.Ice

            );
            this.allSpells.add(a_spell);
        }

    }

    private void initFireSpells(ArrayList<String[]> s){
        for (int i = 1; i < s.size(); i++) {
            a_spell=new Spell(s.get(i)[0],
                    Integer.parseInt(s.get(i)[1]),
                    Integer.parseInt(s.get(i)[2]),
                    Integer.parseInt(s.get(i)[3]),
                    Integer.parseInt(s.get(i)[4]),
                    SpellType.Fire
            );
            this.allSpells.add(a_spell);

        }
    }

    public ArrayList<Spell> getAllSpells() {
        return allSpells;
    }

    public void display(ArrayList<Spell> spells){
        System.out.println("-----------------------------------------------------------------  SPELLS  ------------------------------------------------------------------------");
        System.out.println("Number              Name                   Cost                 required level             Damage             ManaCost               Type           Used Time");
        for (int i = 0; i < spells.size(); i++) {
            System.out.printf("%d\t\t",i);
            System.out.printf("%20s",spells.get(i).getName());
            System.out.printf("%20s",spells.get(i).getCost());
            System.out.printf("%20s",spells.get(i).getRequiredLevel());
            System.out.printf("%25s",spells.get(i).getDamage());
            System.out.printf("%20s",spells.get(i).getManaCost());
            System.out.printf("%20s",spells.get(i).getType().getTypeName());
            System.out.printf("%20s",spells.get(i).getUsed_number()+"/10");
            System.out.println();
        }
    }

    }
