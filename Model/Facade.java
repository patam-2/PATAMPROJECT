package test.Model;

public class Facade
{
    Tile.Bag bag;
    Board board;
    DictionaryManager dictionaryManager;

    public Facade()
    {
        bag= Tile.Bag.getBag();
        board=Board.getBoard();
        dictionaryManager=DictionaryManager.get();
    }
}
