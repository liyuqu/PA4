import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HeroAttack {
    boolean reChoose;
    private Sound sound=new Sound();

    private int attack = 0;

    Rule rule = new Rule();


    public void Attack(Hero hero, Monster monster) {
        reChoose = false;
        attack = 0;
        int damage = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Do you choose it wrongly? If so, you can press q to quit this func and " +
                "re-choose your action, and other input means continue this action.");
        System.out.printf("input: ");
        String cho = in.nextLine();
        if (cho.equalsIgnoreCase("q")) {
            reChoose = true;
            return;
        }
        if (hero.isDual()) {
            System.out.println("Which Weapon would you like to use?");
            System.out.println("a. " + hero.getCurWeapon1().getName());
            System.out.println("b. " + hero.getCurWeapon2().getName());
            do {
                System.out.printf("input: ");
                String input = in.nextLine();
                if (input.equalsIgnoreCase("a")) {
                    attack = (int) ((hero.getStrength() + hero.getCurWeapon1().getDamage()) * 0.3);
                    break;
                } else if (input.equalsIgnoreCase("b")) {
                    attack = (int) ((hero.getStrength() + hero.getCurWeapon2().getDamage()) * 0.3);
                    break;
                } else {
                    System.out.println("Error input, please choose a or b");
                }
            } while (true);
        } else {
            attack = (int) ((hero.getStrength() + hero.getCurWeapon1().getDamage()) * 0.3);
        }
        sound.heroAttack();
        boolean dodge = rule.isDodge(monster);
        if (dodge) {
            System.out.println("Whoops! The attack is dodged by " + monster.getName());
        } else {
            damage = attack - ((int) (monster.getDefense() * 0.02));
            monster.setCurHP(monster.getCurHP() - damage);
            System.out.println(hero.getName() + " attack " + monster.getName() + " for " + damage + " damage!");
            monster.checkStatus();
        }
    }

    public void castSpell(Hero hero, Monster monster) {
        reChoose = false;
        attack = 0;
        int damage = 0;
        Scanner in = new Scanner(System.in);
        Spell spell;
        System.out.println("Do you choose it wrongly? If so, you can press q to quit this func and " +
                "re-choose your action, and other input means continue this action.");
        System.out.printf("input: ");
        String cho = in.nextLine();
        if (cho.equalsIgnoreCase("q")) {
            reChoose = true;
            return;
        }
        hero.getInv().printSpell();//print all spells
        int number = hero.getInv().getSpells().size();
        do {
            System.out.println("Which spell do you wanna use? enter 0-" + (number - 1) + " to cast it");
            System.out.printf("input: ");
            try {
                int Num = in.nextInt();
                if (Num < 0 || Num >= number) {
                    System.out.println("Please enter a valid number!");
                    in.nextLine();
                } else {
                    spell = hero.getInv().getSpells().get(Num);
                    if (spell.getManaCost() > hero.getCurMP()) {
                        System.out.println("Sorry you don't have enough Mana to cast " + spell.getName());
                    } else {
                        break;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Sorry, please enter a valid NUMBER!");
                in.nextLine();
            }
        } while (true);
        sound.Magic();
        boolean dodge = rule.isDodge(monster);
        hero.setCurMP(hero.getCurMP() - spell.getManaCost());
        spell.AddUsed_number();
        if (spell.getUsed_number() == 10) {
            hero.getInv().getSpells().remove(spell);
        }
        if (dodge) {
            System.out.println("Whoops! The " + spell.getName() + " is dodged by " + monster.getName());
        } else {
            attack = spell.getDamage();
            if (spell.getType() == SpellType.Ice) {
                monster.setDamage((int) (monster.getDamage() * 0.9));
            } else if (spell.getType() == SpellType.Fire) {
                monster.setDefense((int) (monster.getDefense() * 0.9));
            } else if (spell.getType() == SpellType.Lightning) {
                monster.setDodge_chance((int) (monster.getDodge_chance() * 0.9));
            }//set the special influence of spell
            attack = (int) (attack * (0.7 + hero.getDexterity() * 0.0005));
            damage = attack - ((int) (monster.getDefense() * 0.02));
            monster.setCurHP(monster.getCurHP() - damage);
            System.out.println(hero.getName() + " use " + spell.getName() + " to attack " + monster.getName() + " for " + damage + " damage!");
            monster.checkStatus();

        }
    }

    public void UsePotion(Hero hero) {
        reChoose = false;
        Scanner in = new Scanner(System.in);
        System.out.println("Do you choose it wrongly? If so, you can press q to quit this func and " +
                "re-choose your action, and other input means continue this action.");
        System.out.printf("input: ");
        String cho = in.nextLine();
        if (cho.equalsIgnoreCase("q")) {
            reChoose = true;
            return;
        }
        Potion potion;
        hero.getInv().printPotion();//print all the potions
        int number = hero.getInv().getPotions().size();
        do {
            System.out.println("Which potion do you wanna use? enter 0-" + (number - 1) + " to use it");
            System.out.printf("input: ");
            try {
                int Num = in.nextInt();
                if (Num < 0 || Num >= number) {
                    System.out.println("Please enter a valid number!");
                    in.nextLine();
                } else {
                    potion = hero.getInv().getPotions().get(Num);
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Sorry, please enter a valid NUMBER!");
                in.nextLine();
            }
        } while (true);
        //then you use this potion!
        sound.potion();
        if (potion.getAttributeAffected().equals(PotionAffectType.Health.getTypeName())) {
            //health potion
            hero.setCurHP(hero.getCurHP() + potion.getAttributeIncrease());
        } else if (potion.getAttributeAffected().equals(PotionAffectType.Strength.getTypeName())) {
            hero.setStrengthIncreaseInBattle(potion.getAttributeIncrease());
        } else if (potion.getAttributeAffected().equals(PotionAffectType.Mana.getTypeName())) {
            hero.setCurMP(hero.getCurMP() + potion.getAttributeIncrease());
        } else if (potion.getAttributeAffected().equals(PotionAffectType.Agility.getTypeName())) {
            hero.setAgilityIncreaseInBattle(potion.getAttributeIncrease());
        } else if (potion.getAttributeAffected() .equals( PotionAffectType.Health_Mana_Strength_Agility.getTypeName())) {
            hero.setAgilityIncreaseInBattle(potion.getAttributeIncrease());
            hero.setStrengthIncreaseInBattle(potion.getAttributeIncrease());
            hero.setCurHP(hero.getCurHP() + potion.getAttributeIncrease());
            hero.setCurMP(hero.getCurMP() + potion.getAttributeIncrease());
        } else if (potion.getAttributeAffected() .equals( PotionAffectType.All.getTypeName())) {
            hero.setAgilityIncreaseInBattle(potion.getAttributeIncrease());
            hero.setStrengthIncreaseInBattle(potion.getAttributeIncrease());
            hero.setCurHP(hero.getCurHP() + potion.getAttributeIncrease());
            hero.setCurMP(hero.getCurMP() + potion.getAttributeIncrease());
            hero.setDexterityIncreaseInBattle(potion.getAttributeIncrease());
        }
        hero.getInv().getPotions().remove(potion);
    }
}
