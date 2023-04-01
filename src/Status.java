public class Status extends Entity{
    private int level;
    private int curHP;
    private int MaxHp;
    private int expToUpgrade;

    public Status(String name, int level, int curHP) {
        super(name);
        this.level=level;
        this.curHP=curHP;
        MaxHp=level*100;
        expToUpgrade=level*10;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCurHP() {
        return curHP;
    }

    public void setCurHP(int curHP) {
        this.curHP = curHP;
    }

    public int getMaxHp() {
        return MaxHp;
    }

    public void setMaxHp(int maxHp) {
        MaxHp = maxHp;
    }
    public void setExpToUpgrade(int expToUpgrade) {
        this.expToUpgrade = expToUpgrade;
    }

    public int getExpToUpgrade() {
        return expToUpgrade;
    }
}
