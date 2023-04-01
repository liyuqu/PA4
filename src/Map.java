public class Map {
    private int rownum;//the size will enter

    private int colnum;

    public static final String ANSI_RED="\u001B[31m";

    public static final String ANSI_RESET = "\u001B[0m";

    public static final String ANSI_YELLOW = "\u001B[33m";

    public static final String ANSI_GREEN="\u001b[32m";

    public static final String ANSI_BLUE="\u001b[34m";

    public content[][] realboard;//we set every cell a single one to easily reset them or change them

    public Map(int rownum, int colnum) {
        this.rownum = rownum;
        this.colnum = colnum;
        initGame();
    }

    public void initGame() {
        realboard = new content[rownum][colnum];//set a new char matrix
        for (int row = 0; row < rownum; row++) {
            for (int col = 0; col < colnum; col++) {
                realboard[row][col] = new content(row, col);//relate to public pawn--the cell inside it should
                //be not occupied, which means every cell's boolean set to false
            }
        }
    }

    public void newGame() {
        for (int row = 0; row < rownum; row++) {
            for (int col = 0; col < colnum; col++) {
                realboard[row][col].newGame(); //reset the cell(see function in pawn)
            }
        }
    }
    // then we need to print the board out//
    public void draw() {
        for (int i = 0; i < rownum; i++) {
            if (i <= rownum - 1) {
                int bbs = colnum;
                while (bbs > 1) {
                    System.out.print("+-+-");
                    bbs -= 1;
                }
                if (bbs == 1) {
                    System.out.println("+-+-+");
                }
            }
            for (int j = 0; j < colnum; j++) {
                if (j==0){
                    System.out.print("|");
                }
                System.out.print(" ");
                realboard[i][j].draw();
                System.out.print(" ");
                if (j < colnum - 1) {
                    System.out.print("|");
                } else if (j == colnum - 1) {
                    System.out.println("|");
                }
            }
            if(i==rownum-1){
                int bbss = colnum;
                while (bbss > 1) {
                    System.out.print("+-+-");
                    bbss -= 1;
                }
                if (bbss == 1) {
                    System.out.println("+-+-+");
                }
            }

        }
        System.out.println();
        System.out.println("Legend: \n" +
                "empty slot means you may randomly encounter a battle\n" +
                ANSI_YELLOW+"$"+ANSI_RESET+" means a market, it is safe and you can enter m/M to view market's items\n" +
                ANSI_RED+"X"+ANSI_RESET+" means the inaccessible area, you cannot walk through it");
        System.out.println();

    }
}
