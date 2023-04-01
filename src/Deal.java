import java.util.ArrayList;
import java.util.Scanner;

public class Deal {
    private Weapon w;
    private Potion p;
    private Armory a;
    private Spell s;
    private String in;
    //has enough money?
    private boolean hasMoney(Hero h,int money){
        return h.getGold() >= money;
    }
    //satisfy level?
    private boolean satisfyLevel(Hero h , int level){
        return h.getLevel() >= level;
    }
    //buy
    public  <T extends Equipment> void Buy(Hero h, T item){
        if (hasMoney(h,item.getCost())&&satisfyLevel(h,item.getRequiredLevel())){
            h.setGold(h.getGold()-item.getCost());
            if(in.equals("w")){
                h.getInv().addWeapon((Weapon) item);
                System.out.println("You buy it successfully!!!");
            }else if(in.equals("p")){
                h.getInv().addPotion((Potion) item);
                System.out.println("You buy it successfully!!!");
            }else if(in.equals("a")){
                h.getInv().addArmory((Armory) item);
                System.out.println("You buy it successfully!!!");
            }else if(in.equals("s")){
                h.getInv().addSpell((Spell) item);
                System.out.println("You buy it successfully!!!");
            }
        }else{
            if(!hasMoney(h,item.getCost())){
                System.out.println("You don't have enough gold!");
            }else{
                System.out.println("Your level is too low!");
            }

        }
    }
    //sell
    public  <T extends Equipment> void Sell(Hero h, T item){
        if(in.equals("w")){
            h.getInv().removeWeapon((Weapon) item);
        }else if(in.equals("p")){
            h.getInv().removePotion((Potion) item);
        }else if(in.equals("a")){
            h.getInv().removeArmory((Armory) item);
        }else if(in.equals("s")){
            h.getInv().removeSpell((Spell) item);
        }
        h.setGold(h.getGold()+(int)(0.5*item.getCost()));
    }
    public void getInput(Hero hero,SubMarket subMarket){
        Scanner sc = new Scanner(System.in);
        subMarket.display();
        System.out.println("Do you want to buy/sell something?(y/n) "+hero.getName());
        System.out.printf("input:");

        if (sc.nextLine().equals("y")){
            while(true){
                System.out.println("Do you want to buy or sell?(b or s) "+hero.getName());
                System.out.printf("input:");
                String input=sc.nextLine();
                if(input.equals("b")){
                    boolean valid=false;
                    do {
                        System.out.println("Please select which type of item you want to buy?(enter " +
                                "w for weapon, a for armory, p for potion, s for spell) "+hero.getName());
                        System.out.printf("input:");
                        in=sc.nextLine();
                        switch (in) {
                            case "w" :
                                if(subMarket.getSubWeapons().size()==0){
                                    System.out.println("Sorry, no weapons available");
                                    sc.nextLine();
                                    valid=false;
                                    break;
                                }
                                valid=true;
                                int size= subMarket.SWSize;
                                w=getItem(subMarket.getSubWeapons(),size);
                                break;
                            case "a":
                                if(subMarket.getSubArmors().size()==0){
                                    System.out.println("Sorry, no armories available");
                                    sc.nextLine();
                                    valid=false;
                                    break;
                                }
                                valid=true;
                                size= subMarket.SASize;
                                a=getItem(subMarket.getSubArmors(),size);
                                break;
                            case "p":
                                if(subMarket.getSubPotions().size()==0){
                                    System.out.println("Sorry, no potions available");
                                    sc.nextLine();
                                    valid=false;
                                    break;
                                }
                                valid=true;
                                size= subMarket.SPSize;
                                p=getItem(subMarket.getSubPotions(),size);
                                break;
                            case "s":
                                if(subMarket.getSubSpells().size()==0){
                                    System.out.println("Sorry, no spells available");
                                    sc.nextLine();
                                    valid=false;
                                    break;
                                }
                                valid=true;
                                size= subMarket.SSSize;
                                s=getItem(subMarket.getSubSpells(),size);
                                break;

                            case "q":
                                valid=true;
                                break;
                            default:
                                valid=false;
                                System.out.println("Please enter a valid instruction!");
                                sc.nextLine();
                        }
                    }while(!valid);
                    if(in.equals("w")){
                        this.Buy(hero,w);
                    }else if (in.equals("a")){
                        this.Buy(hero,a);
                    } else if (in.equals("s")) {
                        this.Buy(hero,s);
                    }else if (in.equals("p")){
                        this.Buy(hero,p);
                    }

                }else if(input.equals("s")){
                    if(hero.getInv().isEmpty()){
                        System.out.println("You have nothing to sell! "+hero.getName());
                    }else {
                        hero.getInv().printall();
                        System.out.println("Please select which one you want to sell?(enter " +
                                "w for weapon, a for armory, p for potion, s for spell) "+hero.getName());
                        System.out.printf("input:");
                        boolean valid = false;

                        do {
                            System.out.printf("input:");
                            in = sc.nextLine();
                            switch (in) {
                                case "w":
                                    int size = hero.getInv().getWeapons().size();
                                    if (size != 0) {
                                        valid = true;
                                        w = getItem(hero.getInv().getWeapons(), size);
                                        break;
                                    } else {
                                        System.out.println("You have nothing about weapons!");
                                        sc.nextLine();
                                        valid = false;
                                        break;
                                    }
                                case "a":
                                    size = hero.getInv().getArmories().size();
                                    System.out.println(size);
                                    if (size != 0) {
                                        a = getItem(hero.getInv().getArmories(), size);
                                        valid = true;
                                        break;
                                    } else {
                                        System.out.println("You have nothing about armories!");
                                        sc.nextLine();
                                        valid = false;
                                        break;
                                    }
                                case "p":
                                    size = hero.getInv().getPotions().size();
                                    if (size != 0) {
                                        p = getItem(hero.getInv().getPotions(), size);
                                        valid = true;
                                        break;
                                    } else {
                                        System.out.println("You have nothing about potions!");
                                        sc.nextLine();
                                        valid = false;
                                        break;
                                    }
                                case "s":
                                    size = hero.getInv().getSpells().size();
                                    if (size != 0) {
                                        s = getItem(hero.getInv().getSpells(), size);
                                        valid = true;
                                        break;
                                    } else {
                                        System.out.println("You have nothing about spells!");
                                        sc.nextLine();
                                        valid = false;
                                        break;
                                    }
                                default:
                                    valid = false;
                                    System.out.println("Please enter a valid instruction!");
                                    sc.nextLine();
                            }
                        } while (!valid);
                        if (valid = true) {
                            if (in.equals("w")) {
                                this.Sell(hero, w);
                            } else if (in.equals("a")) {
                                this.Sell(hero, a);
                            } else if (in.equals("s")) {
                                this.Sell(hero, s);
                            } else if (in.equals("p")) {
                                this.Sell(hero, p);
                            }

                            System.out.println("You sell it successfully!!!");
                        }
                    }
                }
                System.out.println("Do you want to continue to buy or sell?(y/n) "+hero.getName());
                System.out.printf("input:");
                input=sc.nextLine();
                if(input.equals("n"))break;
            }
        }
    }
    public <T extends Equipment> T getItem(ArrayList<T> list, int num){
        Scanner scanner=new Scanner(System.in);
        boolean validInput = false;
        int input=0;
        while (!validInput) {
            try {
                System.out.println("OK, which item would you like? (enter 0-"+(num-1)+") for items");
                System.out.printf("input:");
                input = Integer.parseInt(scanner.nextLine());
                validInput = true;
                if (input>=num ||input<0) {
                    System.out.println("Invalid, you should enter through 0-"+(num-1));
                    scanner.nextLine();
                }else {
                    validInput=true;
                    break;
                }

            } catch (NumberFormatException e) {
                validInput=false;
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine();
            }
        }
        return list.get(input);
    }
}
