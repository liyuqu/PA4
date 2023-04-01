import java.util.ArrayList;
import java.util.Random;

enum isDefeat{
    Faint,Alive
}
public class Monster extends Status{
    private int damage;
    private int defense;
    private int dodge_chance;
    MonsterType type;
    private isDefeat status;
    private int curHP;
    private int level;

    public Monster(String name, int level,int curHP, int damage,int defense,int dodge_chance, MonsterType type) {
        super(name, level, curHP);
        this.damage=damage;
        this.defense=defense;
        this.dodge_chance=dodge_chance;
        this.type=type;
        this.status=isDefeat.Alive;
        this.level=level;
        this.curHP=curHP;
    }

        @Override
    public void setCurHP(int curHp){
        this.curHP=curHp;
    }

    @Override
    public int getCurHP() {
        return curHP;
    }

    public int getDamage() {
        return damage;
    }

    public void setType(MonsterType type) {
        this.type = type;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDefense() {
        return defense;
    }

    public int getDodge_chance() {
        return dodge_chance;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setStatus(isDefeat status) {
        this.status = status;
    }

    public void setDodge_chance(int dodge_chance) {
        this.dodge_chance = dodge_chance;
    }

    public MonsterType getType() {
        return type;
    }

    @Override
    public int getLevel() {
        return level;
    }

    public isDefeat getStatus() {
        return status;
    }
    public void checkStatus(){
        if (!(this.getCurHP()>0)){
            this.setStatus(isDefeat.Faint);
            System.out.println("And "+this.getName()+ " get fainted!");
            this.setCurHP(0);
        }
    }
    public void display(){
            System.out.printf("%20s",this.getName());
            System.out.printf("%20s",this.getDamage());
            System.out.printf("%20s",this.getDefense());
            System.out.printf("%20s",this.getDodge_chance());
            System.out.printf("%30s",this.getType().getTypeName());
            System.out.printf("%20s",this.getLevel());
            System.out.printf("%20s",this.getCurHP());
            System.out.println();
        }
    }


