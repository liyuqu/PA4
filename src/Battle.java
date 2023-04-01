import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Battle {
    public Rule rule=new Rule(); //import the rule into this class
    private ArrayList<Monster> monsters; // for the random pick of monsters
    private ArrayList<Integer> Nums; //for the int for the monsters
    private Hero hero1;
    private Hero hero2;
    private Hero hero3;

    private Sound sound=new Sound();

    private ArrayList<Hero> newHero=new ArrayList<Hero>();

    private ArrayList<Monster>newMonster=new ArrayList<Monster>();
    ArrayList<Monster> nMonster;


    public boolean Encounter(){
        double r=Math.random();
        if(r>0.5){
            System.out.println("#####################################");
            System.out.println("####### Wild Monsters Appear! #######");
            System.out.println("#####################################");
            sound.Battle();
            return true;
        }
        return false;
    }
    public void fight(ArrayList<Hero> heroes) throws Exception {
        for(Hero hero:heroes){
            hero.setInbattle(true);
        }
        newMonster=new ArrayList<Monster>();
        monsters=new ArrayList<Monster>();
        newHero=new ArrayList<Hero>();
        MonsterList monsterList = new MonsterList();
        int monsterSize = heroes.size();
        Random random = new Random();
        Nums = new ArrayList<Integer>();
        if (monsterSize>0){
            Hero hero=heroes.get(0);
            hero1=duplicateHero(hero);
            newHero.add(hero1);
            if(monsterSize>1){
                hero=heroes.get(1);
                hero2=duplicateHero(hero);
                newHero.add(hero2);
                if (monsterSize>2) {
                    hero = heroes.get(2);
                    hero3=duplicateHero(hero);
                    newHero.add(hero3);
                    }
                }
            }//duplicate heroes attribute for possible defeat and replay
        int level = Integer.MIN_VALUE;
        for (Hero hero : heroes) {
            if (level < hero.getLevel()) {
                level = hero.getLevel();
            }
        }//here we get the max level of heroes.
        for (int i = 0; i < monsterSize ; i++) {
            do {
                int monster = random.nextInt(monsterList.getAllMonsters().size());
                if (!Nums.contains(monster)&&monsterList.getAllMonsters().get(monster).getLevel()<=level) {
                    Nums.add(monster);
                    monsters.add(monsterList.getAllMonsters().get(monster));
                    break;
                }
            } while (true);
        }

        for (Monster amonster : monsters) {
            Monster mm=duplicateMonster(amonster);
            newMonster.add(mm);
        }
        monsterList.display(newMonster);
        beforeBattle(heroes);
        while (true) {
            heroTurn(heroes, monsters);
            if (rule.isWin(monsters)) {
                break;
            }
            monsterTurn(heroes, monsters);
            if (rule.isAllFaint(heroes)) {
                System.out.println("Do you wanna play again? (press P to play again for this battle, c for cheat " +
                        "which means full health and mana to go back to the battle)");
                Scanner scanner=new Scanner(System.in);
                System.out.printf("input: ");
                String input=scanner.nextLine();
                if(input.equalsIgnoreCase("p")){
                    replay(newHero,newMonster);
                }else if (input.equalsIgnoreCase("c")) {
                    for (Hero hero : newHero) {
                        hero.setCurHP(hero.getMaxHP());
                        hero.setCurMP(hero.getMaxMP());
                    }
                    replay(newHero,newMonster);
                }else{
                    System.exit(0);
                }
                break;
            }
        }
        rule.battleSettle(heroes,monsters);
    }

    public Hero duplicateHero(Hero hero) {
        Hero aHero;
        if (hero.isDual()) {
            aHero = new Hero(hero.getName(), hero.getMaxMP(), hero.getStrength(), hero.getAgility(), hero.getDexterity(),
                    hero.getGold(), hero.getLevel(), hero.getHeroType(), hero.getCurHP(), hero.getExp(), hero.getCurMP(),
                    hero.getInv(), hero.getCurWeapon1(), hero.getCurWeapon2(), hero.getCurArmory(), hero.getStrengthIncreaseInBattle(),
                    hero.getDexterityIncreaseInBattle(), hero.getAgilityIncreaseInBattle());
        } else {
            aHero = new Hero(hero.getName(), hero.getMaxMP(), hero.getStrength(), hero.getAgility(), hero.getDexterity(),
                    hero.getGold(), hero.getLevel(), hero.getHeroType(), hero.getCurHP(), hero.getExp(), hero.getCurMP(),
                    hero.getInv(), hero.getCurWeapon1(), hero.getCurArmory(), hero.getStrengthIncreaseInBattle(),
                    hero.getDexterityIncreaseInBattle(), hero.getAgilityIncreaseInBattle());
        }
        return aHero;
    }

    public Monster duplicateMonster(Monster monster){
        Monster aMonster;
        aMonster=new Monster(monster.getName(),monster.getLevel(),monster.getCurHP(),monster.getDamage(),
                monster.getDefense(),monster.getDodge_chance(),monster.getType());
        return aMonster;
    }

    public void replay(ArrayList<Hero> heroes,ArrayList<Monster>monsters) {
        int size=heroes.size();
        ArrayList<Hero> nHero=new ArrayList<Hero>();
        Hero ahero=duplicateHero(heroes.get(0));
        nHero.add(ahero);
        if (size>1){
            ahero=duplicateHero(heroes.get(1));
            nHero.add(ahero);
            if(size>2){
                ahero=duplicateHero(heroes.get(2));
                nHero.add(ahero);
            }
        }
        ArrayList<Monster> nMonster=new ArrayList<Monster>();

        Monster aMonster=duplicateMonster(monsters.get(0));
        nMonster.add(aMonster);
        if (size>1){
            aMonster=duplicateMonster(monsters.get(1));
            nMonster.add(aMonster);
            if(size>2){
                aMonster=duplicateMonster(monsters.get(2));
                nMonster.add(aMonster);
            }
        }


        System.out.println("You have restarted your last fight! Please be careful this time");
        beforeBattle(heroes);
        while (true) {
            heroTurn(heroes, monsters);
            if (rule.isWin(monsters)) {
                break;
            }
            rule.updateAfterRound(heroes,monsters);
            monsterTurn(heroes, monsters);
            if (rule.isAllFaint(heroes)) {
                System.out.println("Do you wanna play again? (press P to play again for this battle)");
                Scanner scanner=new Scanner(System.in);
                System.out.printf("input:");
                String input=scanner.nextLine();
                if(input.equalsIgnoreCase("p")){
                    //replay this battle, still duplicate it
                    replay(nHero,nMonster);
                }else{
                    System.exit(0);
                }
                break;
            }
        }
        rule.battleSettle(heroes,monsters);
    }

    public void beforeBattle(ArrayList<Hero> heroes) {
        System.out.println("Do you wanna equip anything?(Armory or Weapon) Y for yes " +
                "and other for no, after this we will start our battle");
        System.out.printf("input:");
        Scanner in = new Scanner(System.in);
        do {
            String input = in.nextLine();
            if (input.equalsIgnoreCase("Y")) {
                for (Hero hero : heroes) {
                    hero.equip(); //here we can equip things that we want
                }
                System.out.println("Do you wanna equip anything else?(y for yes)");
                System.out.printf("input:");
            }else {
                break;
            }
        }while (true);
    }

    public void heroTurn(ArrayList<Hero> heroes, ArrayList<Monster> monsters) {
        HeroAttack heroAttack = new HeroAttack();
        Scanner in=new Scanner(System.in);
        for (Hero hero : heroes) {
            do {
                if (rule.isWin(monsters)){
                    return;
                }
                if(hero.getIsdefeat()!=defeat.alive){
                    System.out.println(hero.getName()+" has fainted!");
                    break;
                }
                System.out.println("Choose which action do you want to!");
                System.out.println("a. Attack (use your weapon)");
                System.out.println("b. Cast a Spell");
                System.out.println("c. use potions in your inventory");
                System.out.println("i. see your hero info");
                System.out.printf("input: ");
                String input=in.nextLine();
                    switch (input){
                        case "i":
                            hero.printHero();
                            heroAttack.reChoose=true;
                            break;
                        case "a":
                            System.out.println("which monster you would like to attack");
                            System.out.println("------------------------------------------------------------------------  Monster  ------------------------------------------------------------------------");
                            System.out.println("Number          Name                  Damage               Defense             DodgeChance             Type                Level                HP");
                            System.out.printf("a");
                            monsters.get(0).display();
                            if(monsters.size()>1){
                                System.out.printf("b");
                                monsters.get(1).display();
                                if(monsters.size()>2){
                                    System.out.printf("c");
                                    monsters.get(2).display();
                            }
                        }
                            do {
                                System.out.printf("input: ");
                                String m = in.nextLine();
                                if(m.equalsIgnoreCase("a")) {
                                    if (monsters.get(0).getStatus() != isDefeat.Alive) {
                                        System.out.println("Sorry, this monster is fainted");
                                        in.nextLine();
                                    } else {
                                        heroAttack.Attack(hero, monsters.get(0));
                                        break;
                                    }
                                }else if (m.equalsIgnoreCase("b")) {
                                        if (heroes.size()<2) {
                                            System.out.println("Sorry, wrong number");
                                            in.nextLine();
                                        }else if (monsters.get(1).getStatus()!=isDefeat.Alive) {
                                            System.out.println("Sorry, this monster is fainted");
                                            in.nextLine();
                                        }
                                        heroAttack.Attack(hero, monsters.get(1));
                                        break;
                                    } else if (m.equalsIgnoreCase("c")) {
                                    if (heroes.size() < 3) {
                                        System.out.println("Sorry, wrong number");
                                        in.nextLine();
                                    } else if (monsters.get(2).getStatus() != isDefeat.Alive) {
                                        System.out.println("Sorry, this monster is fainted");
                                        in.nextLine();
                                    }
                                    heroAttack.Attack(hero, monsters.get(2));
                                    break;
                                }else {
                                    System.out.println("Sorry you enter the wrong number, please enter again");
                                    in.nextLine();
                                }
                                }while (true);
                            break;
                        case "b":
                            if (hero.getInv().getSpells().size()==0) {
                                System.out.println("Sorry you have no spells");
                                heroAttack.reChoose=true;
                                break;
                            }else {
                                int least = 10000;
                                for (Spell spell : hero.getInv().getSpells()) {
                                    if (least > spell.getManaCost()) {
                                        least = spell.getManaCost();
                                    }
                                }
                                if (!(least > hero.getCurMP())) {
                                    System.out.println("which monster you would like to attack");
                                    System.out.println("------------------------------------------------------------------------  Monster  ------------------------------------------------------------------------");
                                    System.out.println("Number              Name                  Damage               Defense             DodgeChance             Type                Level              HP");
                                    System.out.printf("a");
                                    monsters.get(0).display();
                                    if(monsters.size()>1){
                                        System.out.printf("b");
                                        monsters.get(1).display();
                                    } else if(monsters.size()>2){
                                        System.out.printf("c");
                                        monsters.get(2).display();
                                    }
                                    do{
                                        System.out.printf("input: ");
                                        String m = in.nextLine();
                                            if(m.equalsIgnoreCase("a")) {
                                                if (monsters.get(0).getStatus() != isDefeat.Alive) {
                                                    System.out.println("Sorry, this monster is fainted");
                                                    in.nextLine();
                                                } else {
                                                    heroAttack.castSpell(hero, monsters.get(0));
                                                    break;
                                                }
                                            }else if (m.equalsIgnoreCase("b")) {
                                                if (heroes.size()<2) {
                                                    System.out.println("Sorry, wrong number");
                                                    in.nextLine();
                                                }else if (monsters.get(1).getStatus()!=isDefeat.Alive) {
                                                    System.out.println("Sorry, this monster is fainted");
                                                    in.nextLine();
                                                }
                                                heroAttack.castSpell(hero, monsters.get(1));
                                                break;
                                            } else if (m.equalsIgnoreCase("c")) {
                                                if (heroes.size() < 3) {
                                                    System.out.println("Sorry, wrong number");
                                                    in.nextLine();
                                                } else if (monsters.get(2).getStatus() != isDefeat.Alive) {
                                                    System.out.println("Sorry, this monster is fainted");
                                                    in.nextLine();
                                                }
                                                heroAttack.castSpell(hero, monsters.get(2));
                                                break;
                                            }else {
                                                System.out.println("Sorry you enter the wrong number, please enter again");
                                                in.nextLine();
                                            }
                                        }while (true);
                                } else {
                                    System.out.println("Sorry you have no mana to cast any spell");
                                    heroAttack.reChoose=true;
                                    in.nextLine();
                                    break;
                                }

                            }
                            break;
                        case "c":
                            if (hero.getInv().getPotions().size()==0) {
                                System.out.println("Sorry you have no potions");
                                heroAttack.reChoose = true;
                                in.nextLine();
                                break;
                            }else{
                                heroAttack.UsePotion(hero);
                    }
                            break;
                        default:
                            System.out.println("Wrong input, please input again");
                            heroAttack.reChoose=true;
                            in.nextLine();

                }
                    if (heroAttack.reChoose==false){
                        break;
                    }
            }while(true);
        }
    }
    public void monsterTurn(ArrayList<Hero>heroes, ArrayList<Monster> monsters){
        MonsterAttack monsterAttack=new MonsterAttack(heroes,monsters);
        monsterAttack.Attack();
        sound.monster();
    }
}


