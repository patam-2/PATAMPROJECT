package View;

import Model.Host;
import Model.Tile;
import Model.Word;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.util.HashMap;


public class BoardController {

    @FXML
    private Button letter1button;

    @FXML
    private Button letter2button;

    @FXML
    private Button letter3button;

    @FXML
    private Button letter4button;

    @FXML
    private Button letter5button;

    @FXML
    private Button letter6button;

    @FXML
    private Button letter7button;

    @FXML
    public BoardDisplayer boardDisplayer = new BoardDisplayer();

    @FXML
    private Button challengeButton;

    @FXML
    private Button queryButton;

    @FXML
    private Button clearButton;

    @FXML
    private ToggleButton isVertical;

    @FXML
    private TextField score;

    private int numOfIsVerticalIsPressed = 1;

    @FXML
    private TextField myWord;

    public HashMap<Character, String> lettersMap = new HashMap<>();
    public boolean flag = false;
    private String abc = "ABCDEFGHIJKNMLOPQRSTUVWXYZ";
    public boolean wordFlag = false;
    public int firstRow;
    public int firstCol;

    String[][] boardData = new String[][]{
                                            {"3W", "0", "0", "2L", "0", "0", "0", "3W", "0", "0", "0", "2L", "0", "0", "3W"},
                                            {"0", "2W", "0", "0", "0", "3L", "0", "0", "0", "3L", "0", "0", "0", "2W", "0"},
                                            {"0", "0", "2W", "0", "0", "0", "2L", "0", "2L", "0", "0", "0", "2W", "0", "0"},
                                            {"2L", "0", "0", "2W", "0", "0", "0", "2L", "0", "0", "0", "2W", "0", "0", "2L"},
                                            {"0", "0", "0", "0", "2W", "0", "0", "0", "0", "0", "2W", "0", "0", "0", "0"},
                                            {"0", "3L", "0", "0", "0", "3L", "0", "0", "0", "3L", "0", "0", "0", "3L", "0"},
                                            {"0", "0", "2L", "0", "0", "0", "2L", "0", "2L", "0", "0", "0", "2L", "0", "0"},
                                            {"3W", "0", "0", "2L", "0", "0", "0", "2WS", "0", "0", "0", "2L", "0", "0", "3W"},
                                            {"0", "0", "2L", "0", "0", "0", "2L", "0", "2L", "0", "0", "0", "2L", "0", "0"},
                                            {"0", "3L", "0", "0", "0", "3L", "0", "0", "0", "3L", "0", "0", "0", "3L", "0"},
                                            {"0", "0", "0", "0", "2W", "0", "0", "0", "0", "0", "2W", "0", "0", "0", "0"},
                                            {"2L", "0", "0", "2W", "0", "0", "0", "2L", "0", "0", "0", "2W", "0", "0", "2L"},
                                            {"0", "0", "2W", "0", "0", "0", "2L", "0", "2L", "0", "0", "0", "2W", "0", "0"},
                                            {"0", "2W", "0", "0", "0", "3L", "0", "0", "0", "3L", "0", "0", "0", "2W", "0"},
                                            {"3W", "0", "0", "2L", "0", "0", "0", "3W", "0", "0", "0", "2L", "0", "0", "3W"},};


    String[][] cloneBoard = new String[][]{
                                            {"3W", "0", "0", "2L", "0", "0", "0", "3W", "0", "0", "0", "2L", "0", "0", "3W"},
                                            {"0", "2W", "0", "0", "0", "3L", "0", "0", "0", "3L", "0", "0", "0", "2W", "0"},
                                            {"0", "0", "2W", "0", "0", "0", "2L", "0", "2L", "0", "0", "0", "2W", "0", "0"},
                                            {"2L", "0", "0", "2W", "0", "0", "0", "2L", "0", "0", "0", "2W", "0", "0", "2L"},
                                            {"0", "0", "0", "0", "2W", "0", "0", "0", "0", "0", "2W", "0", "0", "0", "0"},
                                            {"0", "3L", "0", "0", "0", "3L", "0", "0", "0", "3L", "0", "0", "0", "3L", "0"},
                                            {"0", "0", "2L", "0", "0", "0", "2L", "0", "2L", "0", "0", "0", "2L", "0", "0"},
                                            {"3W", "0", "0", "2L", "0", "0", "0", "2WS", "0", "0", "0", "2L", "0", "0", "3W"},
                                            {"0", "0", "2L", "0", "0", "0", "2L", "0", "2L", "0", "0", "0", "2L", "0", "0"},
                                            {"0", "3L", "0", "0", "0", "3L", "0", "0", "0", "3L", "0", "0", "0", "3L", "0"},
                                            {"0", "0", "0", "0", "2W", "0", "0", "0", "0", "0", "2W", "0", "0", "0", "0"},
                                            {"2L", "0", "0", "2W", "0", "0", "0", "2L", "0", "0", "0", "2W", "0", "0", "2L"},
                                            {"0", "0", "2W", "0", "0", "0", "2L", "0", "2L", "0", "0", "0", "2W", "0", "0"},
                                            {"0", "2W", "0", "0", "0", "3L", "0", "0", "0", "3L", "0", "0", "0", "2W", "0"},
                                            {"3W", "0", "0", "2L", "0", "0", "0", "3W", "0", "0", "0", "2L", "0", "0", "3W"},};


    @FXML
    private void handleQueryButtonPressed(MouseEvent  event) {
        queryButton.setStyle("-fx-background-color: #E6B0AA;");
    }


    @FXML
    private void handleChallengeButtonPressed(MouseEvent  event) {
        challengeButton.setStyle("-fx-background-color: #E6B0AA;");
    }

    @FXML
    private void handleQueryButtonReleased(MouseEvent event) {
        queryButton.setStyle("-fx-background-color: #F2D7D5;");
    }

    @FXML
    private void handleChallengeButtonReleased(MouseEvent event) {
        challengeButton.setStyle("-fx-background-color: #F2D7D5;");
    }

    @FXML
    private void handleClearButtonPressed(MouseEvent  event) {
        clearButton.setStyle("-fx-background-color: #E6B0AA;");
    }

    @FXML
    private void handleClearButtonReleased(MouseEvent event) {
        clearButton.setStyle("-fx-background-color: #F2D7D5;");
    }

    @FXML
    private void handleIsVerticalButtonPressed(MouseEvent  event) {
        numOfIsVerticalIsPressed++;

        if (numOfIsVerticalIsPressed %2 == 0)
            isVertical.setStyle("-fx-background-color: #E6B0AA;");
        else
            isVertical.setStyle("-fx-background-color: #F2D7D5;");

    }

    private void loadLetters() {
        for (char letter = 'A'; letter <= 'Z'; letter++) {
            String path = "C:/Users/ariel/OneDrive/Desktop/RunningTask_1/BookScabbleFacade/src/View/resources/"+String.valueOf(letter)+".jpg";
            this.lettersMap.put(letter, path);
        }
    }

    private void setLetters() {
        letter1button.setText(String.valueOf(HostController.viewModel.gameManager.host.playerTilesMap.get(1).get(0).letter));
        letter2button.setText(String.valueOf(HostController.viewModel.gameManager.host.playerTilesMap.get(1).get(1).letter));
        letter3button.setText(String.valueOf(HostController.viewModel.gameManager.host.playerTilesMap.get(1).get(2).letter));
        letter4button.setText(String.valueOf(HostController.viewModel.gameManager.host.playerTilesMap.get(1).get(3).letter));
        letter5button.setText(String.valueOf(HostController.viewModel.gameManager.host.playerTilesMap.get(1).get(4).letter));
        letter6button.setText(String.valueOf(HostController.viewModel.gameManager.host.playerTilesMap.get(1).get(5).letter));
        letter7button.setText(String.valueOf(HostController.viewModel.gameManager.host.playerTilesMap.get(1).get(6).letter));
    }


    @FXML
    public void initialize()
    {
        setLetters();
        loadLetters();
        boardDisplayer.setBoardMat(boardData);
        
        boardDisplayer.addEventFilter(MouseEvent.MOUSE_CLICKED, (e)->boardDisplayer.requestFocus());
        boardDisplayer.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {

                int row = boardDisplayer.getRow();
                int col = boardDisplayer.getCol();

                if (keyEvent.getCode() == KeyCode.UP && !flag)
                    boardDisplayer.setRow(row - 1);

                if (keyEvent.getCode() == KeyCode.LEFT && !flag)
                    boardDisplayer.setCol(col - 1);

                if (keyEvent.getCode() == KeyCode.RIGHT && !flag)
                    boardDisplayer.setCol(col + 1);

                if (keyEvent.getCode() == KeyCode.DOWN && !flag)
                    boardDisplayer.setRow(row + 1);

                keyEvent.consume();
            }
        });

        Platform.runLater(() -> {  // Set the focus on the boardDisplayer automatically
            boardDisplayer.requestFocus();
        });

        letter1button.setOnAction(event -> {

            int row = boardDisplayer.getRow();
            int col = boardDisplayer.getCol();
            if (wordFlag == false){
                wordFlag = true;
                firstRow = row;
                firstCol = col;
            }

            if (abc.contains(boardDisplayer.boardMat[row][col]))
                return;
            char letter = letter1button.getText().charAt(0);
            boardDisplayer.changePhoto(letter);
            boardDisplayer.requestFocus();
            letter1button.setDisable(true);
            setWord(letter);
            isVertical.setDisable(true);
            flag = true;
            setDisplay();
        });

        letter2button.setOnAction(event -> {
            int row = boardDisplayer.getRow();
            int col = boardDisplayer.getCol();

            if (wordFlag == false){
                wordFlag = true;
                firstRow = row;
                firstCol = col;
            }

            if (abc.contains(boardDisplayer.boardMat[row][col]))
                return;
            char letter = letter2button.getText().charAt(0);
            boardDisplayer.changePhoto(letter);
            boardDisplayer.requestFocus();
            letter2button.setDisable(true);
            setWord(letter);
            isVertical.setDisable(true);
            flag = true;
            setDisplay();
        });

        letter3button.setOnAction(event -> {
            int row = boardDisplayer.getRow();
            int col = boardDisplayer.getCol();

            if (wordFlag == false){
                wordFlag = true;
                firstRow = row;
                firstCol = col;
            }

            if (abc.contains(boardDisplayer.boardMat[row][col]))
                return;
            char letter = letter3button.getText().charAt(0);
            boardDisplayer.changePhoto(letter);
            boardDisplayer.requestFocus();
            letter3button.setDisable(true);
            setWord(letter);
            isVertical.setDisable(true);
            flag = true;
            setDisplay();
        });

        letter4button.setOnAction(event -> {
            int row = boardDisplayer.getRow();
            int col = boardDisplayer.getCol();

            if (wordFlag == false){
                wordFlag = true;
                firstRow = row;
                firstCol = col;
            }

            if (abc.contains(boardDisplayer.boardMat[row][col]))
                return;
            char letter = letter4button.getText().charAt(0);
            boardDisplayer.changePhoto(letter);
            boardDisplayer.requestFocus();
            letter4button.setDisable(true);
            setWord(letter);
            isVertical.setDisable(true);
            flag = true;
            setDisplay();
        });

        letter5button.setOnAction(event -> {
            int row = boardDisplayer.getRow();
            int col = boardDisplayer.getCol();

            if (wordFlag == false){
                wordFlag = true;
                firstRow = row;
                firstCol = col;
            }

            if (abc.contains(boardDisplayer.boardMat[row][col]))
                return;
            char letter = letter5button.getText().charAt(0);
            boardDisplayer.changePhoto(letter);
            boardDisplayer.requestFocus();
            letter5button.setDisable(true);
            setWord(letter);
            isVertical.setDisable(true);
            flag = true;
            setDisplay();
        });

        letter6button.setOnAction(event -> {
            int row = boardDisplayer.getRow();
            int col = boardDisplayer.getCol();

            if (wordFlag == false){
                wordFlag = true;
                firstRow = row;
                firstCol = col;
            }

            if (abc.contains(boardDisplayer.boardMat[row][col]))
                return;
            char letter = letter6button.getText().charAt(0);
            boardDisplayer.changePhoto(letter);
            boardDisplayer.requestFocus();
            letter6button.setDisable(true);
            setWord(letter);
            isVertical.setDisable(true);
            flag = true;
            setDisplay();
        });

        letter7button.setOnAction(event -> {
            int row = boardDisplayer.getRow();
            int col = boardDisplayer.getCol();

            if (wordFlag == false){
                wordFlag = true;
                firstRow = row;
                firstCol = col;
            }

            if (abc.contains(boardDisplayer.boardMat[row][col]))
                return;
            char letter = letter7button.getText().charAt(0);
            boardDisplayer.changePhoto(letter);
            boardDisplayer.requestFocus();
            letter7button.setDisable(true);
            setWord(letter);
            isVertical.setDisable(true);
            flag = true;
            setDisplay();
        });

        isVertical.setOnAction(event ->{

            if (isVertical.isDisabled())
                isVertical.setStyle("-fx-background-color: #E6B0AA;");
            boardDisplayer.requestFocus();
        });

        clearButton.setOnAction(event->{

            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 15; j++){
                    boardData[i][j] = cloneBoard[i][j];
                }
            }
            myWord.setText("");
            letter1button.setDisable(false);
            letter2button.setDisable(false);
            letter3button.setDisable(false);
            letter4button.setDisable(false);
            letter5button.setDisable(false);
            letter6button.setDisable(false);
            letter7button.setDisable(false);
            queryButton.setDisable(false);
            challengeButton.setDisable(false);
            numOfIsVerticalIsPressed = 1;
            isVertical.setStyle("-fx-background-color: #F2D7D5;");
            isVertical.setDisable(false);
            flag = false;
            wordFlag = false;
            boardDisplayer.requestFocus();
            boardDisplayer.redraw();
        });

        queryButton.setOnAction(event ->{

            Tile[] tiles = new Tile[myWord.getText().length()];
            for (int i = 0; i < myWord.getText().length(); i++) {
              for (int j = 0; j < Host.host.playerTilesMap.get(1).size(); j++)
              {
                  if (Host.host.playerTilesMap.get(1).get(j).letter == myWord.getText().charAt(i))
                      tiles[i] = Host.host.playerTilesMap.get(1).get(j);
              }
            }

            boolean isVer = isVertical.isSelected();
            Word word = new Word(tiles, firstRow, firstCol, isVer);
            int result = HostController.viewModel.gameManager.host.placeWord(word);
            if (result != 0) {
                score.setText(String.valueOf(Integer.parseInt(score.getText()) + result));
                for (int i = 0; i < 15; i++) {
                    for (int j = 0; j < 15; j++){
                        cloneBoard[i][j] = boardData[i][j];
                    }
                }
            }
            queryButton.setDisable(true);
            challengeButton.setDisable(true);
            letter1button.setDisable(true);
            letter2button.setDisable(true);
            letter3button.setDisable(true);
            letter4button.setDisable(true);
            letter5button.setDisable(true);
            letter6button.setDisable(true);
            letter7button.setDisable(true);
            setLetters();
        });

        challengeButton.setOnAction(event ->{

            boolean isValid = HostController.viewModel.gameManager.host.challenge(myWord.getText());

            if (isValid)
            {
                Tile[] tiles = new Tile[myWord.getText().length()];
                for (int i = 0; i < myWord.getText().length(); i++) {
                    for (int j = 0; j < Host.host.playerTilesMap.get(1).size(); j++)
                    {
                        if (Host.host.playerTilesMap.get(1).get(j).letter == myWord.getText().charAt(i))
                            tiles[i] = Host.host.playerTilesMap.get(1).get(j);
                    }
                }

                boolean isVer = isVertical.isSelected();
                Word word = new Word(tiles, firstRow, firstCol, isVer);
                int result = HostController.viewModel.gameManager.host.placeWord(word);
                if (result != 0) {
                    score.setText(String.valueOf(Integer.parseInt(score.getText()) + result));
                    for (int i = 0; i < 15; i++) {
                        for (int j = 0; j < 15; j++){
                            cloneBoard[i][j] = boardData[i][j];
                        }
                    }
                }
            }
            else {
                // MOVES TURN
            }
            queryButton.setDisable(true);
            challengeButton.setDisable(true);
            letter1button.setDisable(true);
            letter2button.setDisable(true);
            letter3button.setDisable(true);
            letter4button.setDisable(true);
            letter5button.setDisable(true);
            letter6button.setDisable(true);
            letter7button.setDisable(true);
            setLetters();
        });
    }

    private void setWord(char letter){

        int row = boardDisplayer.getRow();
        int col = boardDisplayer.getCol();
        int i = row;
        int start = row;
        int j = col;

        boardDisplayer.boardMat[row][col] = String.valueOf(letter);
        String word = "";

        if (isVertical.isSelected()) {

            while ((i >= 0 && i < 15) && abc.contains(boardDisplayer.boardMat[i][j])) {
                i--;
            }
            if ((i != 0 && i < 14) || (i == 0 && !abc.contains(boardDisplayer.boardMat[i][j])))
                i++;
            start = i;
            while ((start >= 0 && start < 15) && abc.contains(boardDisplayer.boardMat[start][j])) {
                word += boardDisplayer.boardMat[start][j];
                start++;
            }
            myWord.setText(word);
        }

        if (!isVertical.isSelected()) {

            while ((j >= 0 && j < 15) && abc.contains(boardDisplayer.boardMat[i][j])) {
                j--;
            }

            if ((j != 0 && j < 14) || (j == 0 && !abc.contains(boardDisplayer.boardMat[i][j])))
                j++;

            start = j;

            while ((start >= 0 && start < 15) && abc.contains(boardDisplayer.boardMat[i][start])) {
                word += boardDisplayer.boardMat[i][start];
                start++;
            }
            myWord.setText(word);
        }
    }

    private void setDisplay() {

        String abc = "ABCDEFGHIJKNMLOPQRSTUVWXYZ";
        int row = boardDisplayer.getRow();
        int col = boardDisplayer.getCol();

        if (isVertical.isSelected()) {
            while ((row >= 0 && row < 15) && abc.contains(boardDisplayer.boardMat[row][col])) {
                row++;
            }
            boardDisplayer.setRow(row);
        }

        else {
            while ((col >= 0 && col < 15) && abc.contains(boardDisplayer.boardMat[row][col])) {
                col++;
            }
            boardDisplayer.setCol(col);
        }
    }
}
