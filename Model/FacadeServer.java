package Model;

public class FacadeServer {

    public DictionaryManager dictionaryManager;
    public MyServer myServer;

    public FacadeServer(int port) {
        this.dictionaryManager = DictionaryManager.get();
        this.myServer = new MyServer(port, new BookScrabbleHandler());
        this.myServer.start();
    }

    public void close() {
        this.myServer.close();
    }
}
