import java.util.ArrayList;

public class Rule {
    //set rules like defeat
    Sound sound=new Sound();
    public boolean isAllFaint(ArrayList<Hero> heroes) {
        for (Hero hero : heroes) {
            if (hero.getIsdefeat() == defeat.alive) {
                return false;
            }

        }
        System.out.println("All heroes are defeated, Game Over!");
        return true;
    }


    public boolean isWin(ArrayList<Monster> monsters) {
        for (Monster monster : monsters) {
            if (monster.getStatus() == isDefeat.Alive) {
                return false;
            }

        }
        return true;
    }
    public void enterBattle(ArrayList<Hero> heroes){
        for (Hero hero:heroes){
            hero.setInbattle(true);
        }
    }
    public void leaveBattle(ArrayList<Hero> heroes){
        for (Hero hero:heroes){
            hero.setInbattle(false);
        }
    }

    public void updateAfterRound(ArrayList<Hero> heroes, ArrayList<Monster> monsters) {
        // after each round, check for heroes and monsters, set their SurvivalStatus
        // recover HP and MP for alive heroes
        for (int i = 0; i < heroes.size(); i++) {
            if (heroes.get(i).getCurHP() <= 0) {
                heroes.get(i).setIsdefeat(defeat.faint);
            }
            if (monsters.get(i).getCurHP() <= 0) {
                monsters.get(i).setStatus(isDefeat.Faint);
            }
            if (heroes.get(i).getIsdefeat() == defeat.alive) {
                heroes.get(i).setCurHP((int) (heroes.get(i).getCurHP() * 1.1));
                heroes.get(i).setCurMP((int) (heroes.get(i).getCurMP() * 1.1));
            }
        }
    }
    public boolean isAlive(Hero hero){
        return hero.getIsdefeat() == defeat.alive;
    }
    public boolean isDodge(Hero hero){
        double r= Math.random();
        if (r<(hero.getAgility()+hero.getAgilityIncreaseInBattle())*0.0002){
            return true;
        }
        return false;
    }
    public boolean isDodge(Monster monster){
        double r=Math.random();
        if(r<monster.getDodge_chance()*0.001){
            return true;
        }
        return false;
    }
    public void battleSettle(ArrayList<Hero> heroes,ArrayList<Monster> monsters) {
        int level = 0;
        for (int i = 0; i < monsters.size(); i++) {
            level += monsters.get(i).getLevel();
        }
        leaveBattle(heroes);
        sound.Win();
        System.out.println("Congrats! You won the battle!");
        for (Hero hero : heroes) {
            if (hero.isDefeat() == defeat.alive) {
                hero.addExp(level*4);
                hero.addGold(level * 100);
                System.out.println(hero.getName()+ " get "+ level*4+ " exp and "+ level*100+ " gold!");
                hero.LevelUp();
            } else {//the hero has fainted, he cannot get exp/gold, but he can revive
                hero.setCurHP(hero.getMaxHP()/2);
                hero.setCurMP(hero.getMaxMP()/2);
            }
            hero.setIsdefeat(defeat.alive);
            hero.setDefenseIncreaseInBattle(0);
            hero.setStrengthIncreaseInBattle(0);
            hero.setDexterityIncreaseInBattle(0);
            hero.setAgilityIncreaseInBattle(0);//reset the influence of potion to 0
        }
    }

}

