public class content {
    contentType cell; //market, enemy, or unknown
    int row;
    int col;
    public static final String ANSI_RED="\u001B[31m";

    public static final String ANSI_RESET = "\u001B[0m";

    public static final String ANSI_YELLOW = "\u001B[33m";

    public static final String ANSI_GREEN="\u001b[32m";

    public static final String ANSI_BLUE="\u001b[34m";

    boolean haveItem;

    private String icon;

    private contentType curtype;

    public content(int row, int col){
        this.row=row;
        this.col=col;
        this.haveItem=false;
        this.cell=contentType.random; //to easier to set content randomly
    }

    public void newGame() {
        this.haveItem = false;
        this.cell=contentType.random;
    }//here we start a new game//

    public void draw(){
        icon=this.cell.geticon();
        curtype=this.cell;
        if(curtype==contentType.market){
            System.out.print(ANSI_YELLOW+icon+ANSI_RESET);
        }else if (curtype==contentType.hero) {
            System.out.print(ANSI_GREEN+icon+ANSI_RESET);
        }else if (curtype==contentType.inaccessible) {
            System.out.print(ANSI_RED+icon+ANSI_RESET);
        }else{
            System.out.print(" ");
            }
        }

    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }


}
