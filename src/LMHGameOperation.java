import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class LMHGameOperation extends GameOperation {
    protected HeroList herolist;
    protected ArrayList<Hero> heroes;
    protected Market market;
    protected SubMarket subMarket;
    protected Deal deal;
    protected SubMarket thisMarket;


    public LMHGameOperation(int GameType) throws Exception {
        super(GameType);
    }

    @Override
    public void SetMapContent() throws Exception {
        content[][] board = this.map.realboard;
        Random random = new Random();
        int i = 13;//20% of inaccessible area
        int j = 19; // 30% of market area
        while (i >= 1) {
            int a = random.nextInt(8);
            int b = random.nextInt(8);
            if (board[a][b].haveItem == false & a + b != 0) {
                board[a][b].cell = contentType.inaccessible;
                board[a][b].haveItem = true;
                i -= 1;
            }
        }
        while (j >= 1) {
            int a = random.nextInt(8);
            int b = random.nextInt(8);
            if (board[a][b].haveItem == false & a + b != 0) {
                board[a][b].cell = contentType.market;
                board[a][b].haveItem = true;
                subMarket=new SubMarket();
                subMarket.setId(board[a][b]);
                subMarket.addSubMarket(subMarket);
                j -= 1;
            }
        }
        hero=board[0][0];
        board[0][0].cell = contentType.hero;
    }

    public void Move_Hero() throws Exception {
        content[][] board = this.map.realboard;
        Scanner in = new Scanner(System.in);
        boolean quit = false;
        boolean valid = false;
        Battle battle=new Battle();
        do {
            do {
                System.out.println("You can use the following operation guidelines to play the game.");
                System.out.println("• W/w: move up\n" +
                        "• A/a: move left\n" +
                        "• S/s: move down\n" +
                        "• D/d: move right\n" +
                        "• Q/q: quit game\n" +
                        "• I/i: show information\n" +
                        "• M/m: enter market");
                System.out.printf("input:");
                String input = in.nextLine();
                if (input.equalsIgnoreCase("A")){
                    if (hero.getCol()==0){
                        valid=false;
                        System.out.println("Cannot move outside of the map! Please reenter!");
                    }else {
                        if (board[hero.getRow()][hero.getCol() - 1].cell==contentType.inaccessible){
                            System.out.println("Sorry, this is a inaccessible area!");
                            in.nextLine();
                            break;
                        }
                        hero.cell = loca;
                        hero = board[hero.getRow()][hero.getCol() - 1];
                        loca = hero.cell;
                        hero.cell = contentType.hero;
                        valid = true;
                        break;
                    }

                }
                else if (input.equalsIgnoreCase("S")){
                    if (hero.getRow()==7){
                        valid=false;
                        System.out.println("Cannot move outside of the map! Please reenter!");
                    }else {
                        if (board[hero.getRow() + 1][hero.getCol()].cell==contentType.inaccessible){
                            System.out.println("Sorry, this is a inaccessible area!");
                            in.nextLine();
                            break;
                        }
                        hero.cell = loca;
                        System.out.println(loca.geticon());
                        hero = board[hero.getRow() + 1][hero.getCol()];
                        loca = hero.cell;
                        hero.cell = contentType.hero;
                        valid = true;
                        break;
                    }
                }
                else if (input.equalsIgnoreCase("D")) {
                    if (hero.getCol() == 7) {
                        valid = false;
                        System.out.println("Cannot move outside of the map! Please reenter!");
                    } else {
                        if (board[hero.getRow()][hero.getCol()+1].cell==contentType.inaccessible){
                            System.out.println("Sorry, this is a inaccessible area!");
                            in.nextLine();
                            break;
                        }
                        hero.cell = loca;
                        hero = board[hero.getRow()][hero.getCol() + 1];
                        loca = hero.cell;
                        hero.cell = contentType.hero;
                        valid = true;
                        break;

                    }
                }
                else if (input.equalsIgnoreCase("W")) {
                    if (hero.getRow() == 0) {
                        valid = false;
                        System.out.println("Cannot move outside of the map! Please reenter!");
                    } else {
                        if (board[hero.getRow() - 1][hero.getCol()].cell==contentType.inaccessible){
                            System.out.println("Sorry, this is a inaccessible area!");
                            in.nextLine();
                            break;
                        }
                        hero.cell = loca;
                        hero = board[hero.getRow() - 1][hero.getCol()];
                        loca = hero.cell;
                        hero.cell = contentType.hero;
                        valid = true;
                        break;

                    }
                }
                else if (input.equalsIgnoreCase("Q")) {
                    quit = true;
                    valid = true;
                    break;
                }
                else if (input.equalsIgnoreCase("M")) {
                    if (loca == contentType.market) {
                        ViewMarket();
                        break;
                    } else {
                        System.out.println("Sorry, but you are not on a market");
                        valid = false;
                    }
                }
                else if (input.equalsIgnoreCase("I")){
                    ShowInfo();
                    break;
                }else {
                    valid = false; //the situation that input isn't in the manual
                    System.out.println("Sorry, your enter doesn't fit our operations");
                }
            }while (!valid);
            if (!quit) {
                map.draw();
            }
            if (loca==contentType.random){
                if(battle.Encounter()){
                    battle.fight(heroes);
                    map.draw();
                }
            }
        } while (!quit);
    }
    public void ShowInfo(){
        for (Hero hero:heroes){
            hero.printHero();
        }
        System.out.println("If you want to equip something, press e; if not, press anything else");
        Scanner sc=new Scanner(System.in);
        System.out.printf("input:");
        String in=sc.nextLine();
        if (in.equalsIgnoreCase("e")){
            for (Hero hero:heroes){
                hero.equip();
            }
        }



    }
    public void ViewMarket() throws Exception {
        thisMarket=subMarket.getSubMarketById(this.map.realboard[hero.getRow()][hero.getCol()]);
        deal=new Deal();
        for (int i=0;i<heroes.size();i++){
            Hero hero=heroes.get(i);
            deal.getInput(hero,thisMarket);
        }




    }
    @Override
    public void StartGame() throws Exception {
        content[][] board = this.map.realboard;
        System.out.println("Welcome to Legends_Monster_Heroes!");
        herolist=new HeroList();
        herolist.getInput();
        heroes=herolist.getHeroParty();
        map.draw();
        market=new Market();
        Move_Hero();
    }
}
