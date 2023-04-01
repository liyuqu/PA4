public abstract class GameOperation extends Main{
    protected int gameType;
    protected Map map;

    protected contentType loca=contentType.random;
    protected content hero;
    public GameOperation(int GameType) throws Exception {
        this.gameType = GameType;
        enterGame();
    }
    public void enterGame() throws Exception {
        initGame();
        StartGame();
    }
    public void initGame() throws Exception {
        this.map=new Map(8,8);
        SetMapContent();
    }

    public abstract void SetMapContent() throws Exception;

    public abstract void StartGame() throws Exception;

}
