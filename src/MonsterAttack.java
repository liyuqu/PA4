import java.util.ArrayList;
import java.util.Random;

public class MonsterAttack {
    private ArrayList<Hero> targets;

    private ArrayList<Monster> monsters;

    private int num;

    private Rule rule=new Rule();
    public MonsterAttack(ArrayList<Hero> heroes, ArrayList<Monster> monsters){
        this.targets=heroes;
        this.monsters=monsters;
    }
    public void Attack(){
        Random random=new Random();
        Hero target;
        System.out.println("############################ MONSTER ATTACK!!!!! ##############################");
        for (Monster monster:monsters){
            do {
                if (rule.isAllFaint(targets)){
                    return;
                }
            num = random.nextInt(targets.size());
            target = targets.get(num);
            if (target.getIsdefeat()!=defeat.faint){
                break;
            }
        }while(true);
            if (monster.getStatus()!=isDefeat.Faint){
                int damage=(int)(monster.getDamage()/3);
                damage-=target.defenseIncreaseInBattle;
                damage-=(int)(target.curArmory.getDamageReduction()/5);
                if (rule.isDodge(target)){
                    System.out.println("WOW! "+target.getName()+" dodged the attack from "+ monster.getName());
                }else{
                    target.setCurHP(target.curHP-damage);
                    System.out.println("Whoops! " +monster.getName()+ " attacked "+ target.getName()+" for "+
                            damage+ " damage!");
                }
            }
            target.CheckStatus();

        }

    }
}
