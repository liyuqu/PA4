import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

enum defeat{faint, alive}

public class Hero extends Status {
    protected int exp;
    protected int maxHP;
    protected int curHP;
    protected int maxMP;
    protected int curMP;
    protected int Dexterity;
    protected int gold;
    protected int Strength;
    protected int Agility;
    protected HeroType heroType;
    protected Inventory Inv;
    protected Weapon curWeapon1;
    protected Weapon curWeapon2;
    protected Armory curArmory;
    protected int StrengthIncreaseInBattle;
    protected int DexterityIncreaseInBattle;
    protected int AgilityIncreaseInBattle;
    protected boolean dual = false;
    protected boolean inbattle = false;
    protected defeat isdefeat;
    protected Weapon hand = new Weapon("hand", 0, 0, 0, 0);

    protected int defenseIncreaseInBattle=0;
    public Hero(String name, int maxMp, int Strength, int Agility, int Dexterity, int gold, int level, HeroType heroType,
                int curHP, int exp, int curMP, Inventory Inv, Weapon curWeapon1, Armory curArmory, int StrengthIncreaseInBattle,
                int DexterityIncreaseInBattle, int AgilityIncreaseInBattle) {
        super(name, level, curHP);
        this.Dexterity = Dexterity;
        this.curMP = curMP;
        this.maxMP = maxMp;
        this.gold = gold;
        this.heroType = heroType;
        this.Inv = Inv;
        this.curWeapon1 = curWeapon1;
        this.curArmory = curArmory;
        this.StrengthIncreaseInBattle = StrengthIncreaseInBattle;
        this.AgilityIncreaseInBattle = AgilityIncreaseInBattle;
        this.DexterityIncreaseInBattle = DexterityIncreaseInBattle;
        this.isdefeat = defeat.alive;
        this.Strength = Strength;
        this.Agility = Agility;
        this.exp = exp;
        this.defenseIncreaseInBattle=0;
        this.curHP=curHP;
        this.maxHP=level*100;

    }


    public Hero(String name, int maxMp, int Strength, int Agility, int Dexterity, int gold, int level, HeroType heroType,
             int curHP, int exp, int curMP, Inventory Inv, Weapon curWeapon1, Weapon curWeapon2, Armory curArmory, int StrengthIncreaseInBattle,
                int DexterityIncreaseInBattle, int AgilityIncreaseInBattle) {
        super(name, level, curHP);
        this.Dexterity = Dexterity;
        this.curMP = curMP;
        this.maxMP = maxMp;
        this.gold = gold;
        this.heroType = heroType;
        this.Inv = Inv;
        this.dual = true;
        this.curWeapon1 = curWeapon1;
        this.curWeapon2 = curWeapon2;
        this.curArmory = curArmory;
        this.StrengthIncreaseInBattle = StrengthIncreaseInBattle;
        this.AgilityIncreaseInBattle = AgilityIncreaseInBattle;
        this.DexterityIncreaseInBattle = DexterityIncreaseInBattle;
        this.isdefeat = defeat.alive;
        this.Strength = Strength;
        this.Agility = Agility;
        this.exp = exp;
        this.defenseIncreaseInBattle=0;
        this.curHP=curHP;
        this.maxHP=level*100;
    }

    public defeat isDefeat() {
        return isdefeat;
    }

    public void setDefeat(defeat isdefeat) {
        this.isdefeat = isdefeat;
    }

    public int getStrengthIncreaseInBattle() {
        return StrengthIncreaseInBattle;
    }

    public void setStrengthIncreaseInBattle(int StrengthIncreaseInBattle) {
        this.StrengthIncreaseInBattle = StrengthIncreaseInBattle;
    }

    public int getAgilityIncreaseInBattle() {
        return AgilityIncreaseInBattle;
    }

    public void setAgilityIncreaseInBattle(int AgilityIncreaseInBattle) {
        this.AgilityIncreaseInBattle = AgilityIncreaseInBattle;
    }

    public int getDexterityIncreaseInBattle() {
        return DexterityIncreaseInBattle;
    }

    public void setDexterityIncreaseInBattle(int DexterityIncreaseInBattle) {
        this.DexterityIncreaseInBattle = DexterityIncreaseInBattle;
    }

    public Weapon getCurWeapon1() {
        return curWeapon1;
    }

    public void setCurWeapon1(Weapon curWeapon1) {
        this.curWeapon1 = curWeapon1;
    }

    public Weapon getCurWeapon2() {
        return curWeapon2;
    }

    public void setCurWeapon2(Weapon curWeapon2) {
        this.curWeapon2 = curWeapon2;
    }

    public boolean isDual() {
        return dual;
    }

    public void setDual(boolean dual) {
        this.dual = dual;
    }

    public void setCurArmory(Armory curArmory) {
        this.curArmory = curArmory;
    }

    public Armory getCurArmory() {
        return curArmory;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getCurMP() {
        return curMP;
    }

    public void setCurMP(int curMP) {
        this.curMP = curMP;
    }

    public int getExp() {
        return exp;
    }
    public void addExp(int add){
        this.exp=add+exp;
    }
    public void addGold(int add){
        this.gold=gold+add;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setMaxMP(int maxMP) {
        this.maxMP = maxMP;
    }

    public int getMaxMP() {
        return maxMP;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setInv(Inventory inv) {
        Inv = inv;
    }

    public Inventory getInv() {
        return Inv;
    }

    public void setHeroType(HeroType heroType) {
        this.heroType = heroType;
    }

    public HeroType getHeroType() {
        return heroType;
    }

    public void setDexterity(int dexterity) {
        Dexterity = dexterity;
    }

    public int getDexterity() {
        return Dexterity;
    }

    public void printInventory() {
        List<Weapon> weapons = this.Inv.getWeapons();
        List<Armory> armories = this.Inv.getArmories();
        List<Potion> potions = this.Inv.getPotions();
        List<Spell> spells = this.Inv.getSpells();
        System.out.println("Inventory of " + this.getName() + " : ");
        if (weapons.size() == 0) {
            System.out.println(this.getName() + " doesn't have any weapons");
        } else {
            this.Inv.printWeapon();
        }
        if (armories.size() == 0) {
            System.out.println(this.getName() + " doesn't have any armories");
        } else {
            this.Inv.printArmory();
        }
        if (potions.size() == 0) {
            System.out.println(this.getName() + " doesn't have any potions");
        } else {
            this.Inv.printPotion();
        }
        if (spells.size() == 0) {
            System.out.println(this.getName() + " doesn't have any spells");
        } else {
            this.Inv.printSpell();
        }
    }

    public void printHero() {
        System.out.println(this.getName() + ": ");
        System.out.println("HeroType: " + this.getHeroType() + ", level: " + this.getLevel() + ", " +
                "exp: " + this.getExp() + "/" + this.getExpToUpgrade() + ", HP: " + this.getCurHP() + "/" + this.getMaxHP()
                + ", MP: " + this.getCurMP() + "/" + this.getMaxMP() + ", Strength:" + this.getStrength() + ", Dexterity: " +
                this.getDexterity() + ", Agility: " + this.getAgility() + ", gold:" + this.getGold());
        if (dual) {
            System.out.println("For equipment: equipped weapon: " + this.getCurWeapon1().getName() + ", "
                    + this.getCurWeapon2().getName() + ", equipped armory: " + this.getCurArmory().getName());
        } else {
            System.out.println("For equipment: equipped weapon: " + this.getCurWeapon1().getName() +
                    ", equipped armory: " + this.getCurArmory().getName());
        }
        printInventory();
        if (inbattle == true) {
            System.out.println("Strength increase in the battle: " + this.getStrengthIncreaseInBattle() +
                    ", Agility increase in the battle: " + this.getAgilityIncreaseInBattle() +
                    ", Dexterity increase in the battle: " + this.getDexterityIncreaseInBattle()+", " +
                    "Defense increase in the battle: " +this.getDefenseIncreaseInBattle());
        }
    }

    @Override
    public void setCurHP(int curHP) {
        this.curHP = curHP;
    }

    @Override
    public int getCurHP() {
        return curHP;
    }

    public void setStrength(int strength) {
        Strength = strength;
    }

    public void setAgility(int agility) {
        Agility = agility;
    }

    public int getAgility() {
        return Agility;
    }

    public int getStrength() {
        return Strength;
    }

    public Weapon searchWeaponByName(String name) {
        for (Weapon weapon : Inv.getWeapons()) {
            if (weapon.getName().equals(name)) {
                return weapon;
            }
        }
        return null;
    }

    public void setInbattle(boolean inbattle) {
        this.inbattle = inbattle;
    }

    public boolean isInbattle() {
        return inbattle;
    }

    public void setDefenseIncreaseInBattle(int defenseIncreaseInBattle) {
        this.defenseIncreaseInBattle = defenseIncreaseInBattle;
    }

    public int getDefenseIncreaseInBattle() {
        return defenseIncreaseInBattle;
    }

    public void LevelUp() {
        while (this.exp >= this.getExpToUpgrade()) {
            this.exp -= this.getExpToUpgrade();
            this.setLevel(this.getLevel() + 1);
            this.setExpToUpgrade(this.getLevel() * 10);
            this.setMaxHP(this.getLevel() * 100);
            this.setCurHP(this.getMaxHP());//when they level up, they should restore the
            this.setMaxMP((int) (this.getMaxMP() * 1.1));
            this.setCurMP(this.getMaxMP());
            if (this.getHeroType() == HeroType.Warrior) {
                this.setAgility((int) (this.getAgility() * 1.1));
                this.setDexterity((int) (this.getDexterity() * 1.05));
                this.setStrength((int) (this.getStrength() * 1.1));
            }
            if (this.getHeroType() == HeroType.Sorcerer) {
                this.setAgility((int) (this.getAgility() * 1.1));
                this.setDexterity((int) (this.getDexterity() * 1.1));
                this.setStrength((int) (this.getStrength() * 1.05));
            }
            if (this.getHeroType() == HeroType.Paladin) {
                this.setAgility((int) (this.getAgility() * 1.05));
                this.setDexterity((int) (this.getDexterity() * 1.1));
                this.setStrength((int) (this.getStrength() * 1.1));
            }
            System.out.println("Congrats! "+ this.getName()+ " level up! He is level "+ this.getLevel()+" now!");

        }
    }

    public void equip() {
        if (this.Inv.weapons.isEmpty() && this.Inv.armories.isEmpty()) {
            System.out.println("Sorry you have no equipment to be equipped");
        } else {
            System.out.println("You can equip your weapons/armors, " + this.getName());
            System.out.println("You have: ");
            this.Inv.printWeapon();
            this.Inv.printArmory();
            boolean good=false;
            Scanner sc = new Scanner(System.in);
            do {
                System.out.println("Which do you want to equip? Weapon(W) or Armor(A)? Enter the letter to choose (or you can enter q to quit this menu)");
                System.out.printf("input:");
                String in = sc.nextLine();
                if (in.equalsIgnoreCase("A")) {
                    good=true;
                    if (this.Inv.armories.isEmpty()) {
                        System.out.println("Sorry you have no armories to equip");
                    } else {
                        System.out.println("Enter 0 to " + (this.Inv.armories.size() - 1) + " to select your item to equip");
                        boolean valid = false;
                        do {
                            try {
                                int number = sc.nextInt();
                                if (number < 0 || number > this.Inv.armories.size() - 1) {
                                    System.out.println("Sorry you enter a invalid number, please try again");
                                    valid = false;
                                    sc.nextLine();
                                } else {
                                    valid = true;
                                    this.setCurArmory(this.Inv.armories.get(number));
                                    break;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input. Please enter a number.");
                                valid = false;
                                sc.nextLine();
                            }
                        } while (!valid);
                    }
                } else if (in.equalsIgnoreCase("W")) {
                    good=true;
                    if (this.Inv.weapons.isEmpty()) {
                        System.out.println("Sorry you have no weapons to equip");
                    } else if (this.Inv.weapons.size()==1&&this.curWeapon1==this.Inv.weapons.get(0)){
                        System.out.println("Sorry you have no weapons to equip");
                    } else if(this.Inv.weapons.size()==2&&this.curWeapon1==this.Inv.weapons.get(0)&&
                    this.curWeapon2==this.Inv.weapons.get(1)){
                        System.out.println("Sorry you have no weapons to equip");
                    }else if(this.Inv.weapons.size()==2&&this.curWeapon1==this.Inv.weapons.get(1)&&
                            this.curWeapon2==this.Inv.weapons.get(0)) {
                        System.out.println("Sorry you have no weapons to equip");
                    }else {
                        boolean valid = false;
                        System.out.println("Enter 0 to " + (this.Inv.weapons.size() - 1) + " to select your item to equip");
                        do {
                            valid = false;
                            try {
                                System.out.printf("input:");
                                int number = sc.nextInt();
                                if (number < 0 || number > this.Inv.weapons.size() - 1) {
                                    System.out.println("Sorry you enter a invalid number, please try again");
                                    valid = false;
                                    sc.nextLine();
                                } else {
                                    valid = true;
                                    if (this.dual) {
                                        if (this.Inv.weapons.get(number).getRequiredHand() == 2) {
                                            this.setDual(false);
                                            this.setCurWeapon1(this.Inv.weapons.get(number));
                                            this.setCurWeapon2(hand);
                                        } else {
                                            System.out.println("you have two weapons right now, which do you want to drop?");
                                            System.out.println("0. ");
                                            this.curWeapon1.WeaponInfo();
                                            System.out.println("1. ");
                                            this.curWeapon2.WeaponInfo();
                                            boolean validInput = false;
                                            int num;
                                            do {
                                                try {
                                                    System.out.println("Enter a number(0,1): ");
                                                    System.out.printf("input:");
                                                    num = sc.nextInt();
                                                    if (num<0 ||num>1) {
                                                        System.out.println("Wrong number, please enter again!");
                                                        validInput = false;
                                                        sc.nextLine();
                                                    }else {
                                                        validInput = true;
                                                        break;
                                                    }
                                                } catch (InputMismatchException e) {
                                                    System.out.println("Invalid input. Please enter a number.");
                                                    sc.nextLine(); // consume the invalid input
                                                }
                                            } while (!validInput);
                                        }
                                    } else {
                                        if (this.Inv.weapons.get(number).getRequiredHand() == 2) {
                                            this.setDual(false);
                                            this.setCurWeapon1(this.Inv.weapons.get(number));
                                        } else {
                                            if (this.getCurWeapon1().getRequiredHand() == 2) {
                                                this.setDual(false);
                                                this.setCurWeapon1(this.Inv.weapons.get(number));
                                            } else if (this.getCurWeapon1().getRequiredHand() == 0) {
                                                this.setDual(false);
                                                this.setCurWeapon1(this.Inv.weapons.get(number));
                                            } else {
                                                this.setDual(true);
                                                //we can get dual!
                                                System.out.println("You are dual-wielding!");
                                                this.setCurWeapon2(this.Inv.weapons.get(number));
                                            }
                                        }
                                    }
                                }
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input. Please enter a number.");
                                valid = false;
                                sc.nextLine();
                            }
                        } while (!valid);
                    }
                }else if(in.equalsIgnoreCase("q")) {
                    good = true;
                    break;
                }else{
                    good=false;
                    System.out.println("Sorry, wrong input, please enter again. (a/w)");
                    sc.nextLine();
                }

            }while (!good);
        }
    }

    public defeat getIsdefeat() {
        return this.isdefeat;
    }
    public void setIsdefeat(defeat isdefeat){
        this.isdefeat=isdefeat;
    }
    public void CheckStatus(){
        if(this.curHP<=0){
            this.isdefeat=defeat.faint;
            this.curHP=0;
        }
    }
}