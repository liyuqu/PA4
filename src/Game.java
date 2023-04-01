import java.util.Scanner;

public class Game {
    public void startGame() throws Exception {
        boolean loop;
        System.out.println("Welcome to Game World!");
        System.out.println("Here is the list of games you can play, press the" +
                "number to play it!");
        do {
            loop = true;
            System.out.println("1. Legends_Monsters_Heroes");
            System.out.println("0. Quit the Game");
            Scanner scanner = new Scanner(System.in);
            System.out.printf("input: ");
            String gameNum = scanner.nextLine();
            switch (gameNum) {
                case "1":
                    new LMHGameOperation(GameType.LMH.getGameType());
                case "0":
                    loop = false;
                    System.out.println("Good Bye!");
                    return;
                default:
                    System.out.println("Wrong Input! Please select again !");
            }
        } while (loop);
    }
}

