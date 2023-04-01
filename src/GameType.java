public enum GameType {
    LMH(1,"Legends_Monsters_Heroes");

    private String GameName;

    private int gameType;

    GameType(int gameType,String GameName){
        this.GameName=GameName;
        this.gameType=gameType;
    }

    public int getGameType() {
        return gameType;
    }
}





