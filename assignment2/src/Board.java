public class Board {
    public int[] boardState;
    public Player player1;
    public Player player2;
    public int[] available;

    Board(Player player1, Player player2){
        boardState = new int[9];
        this.player1 = player1;
        this.player2 = player2;
        for (int spot: boardState
        ) {
            spot = 0;
        }
        this.available = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
    }

    public void playerTurn(Player activePlayer){
        Player inactivePlayer;
        int playerNum;
        if(activePlayer == player1){
            inactivePlayer = player2;
            playerNum = 1;
        } else{ inactivePlayer = player1; playerNum = 2;}
        System.out.println(String.format("It is %s's turn: ", activePlayer.name));

        int selected = activePlayer.selection(this);
        available[selected] = -1;
        boardState[selected] = playerNum;

        System.out.println(showBoard());
        int winner = checkWin();
        if(winner == 1){
            System.out.println("Congratulations " + player1.name);
            return;
        } else if (winner == 2) {
            System.out.println("Congratulations " + player2.name);
            return;
        } else if (winner == -1) {
            System.out.println("No more moves left. This is a draw");
            return;
        } else{
        playerTurn(inactivePlayer);
        }
    }

    public char[] symbolsBoard(){
        char[] symbols = new char[9];
        for(int i = 0; i < boardState.length; i++){
            if(boardState[i] == 0){
                symbols[i] = (char)(i+1+'0');
            } else if (boardState[i] == 1) {
                symbols[i] = player1.symbol;
            } else if (boardState[i] == 2){
                symbols[i] = player2.symbol;
            }
        }
        return symbols;
    }

    public int checkWin(){
        int winCon = 0;
        if(boardState[0] == boardState[1] && boardState[0] == boardState[2] && boardState[0] != 0){
            winCon = 1;
        }
        else if(boardState[3] == boardState[4] && boardState[3] == boardState[5] && boardState[3] != 0){
            winCon = 2;
        }
        else if(boardState[6] == boardState[7] && boardState[6] == boardState[8] && boardState[6] != 0){
            winCon = 3;
        }
        else if(boardState[0] == boardState[3] && boardState[0] == boardState[6] && boardState[0] != 0){
            winCon = 1;
        }
        else if(boardState[1] == boardState[4] && boardState[1] == boardState[7] && boardState[1] != 0){
            winCon = 2;
        }
        else if(boardState[2] == boardState[5] && boardState[2] == boardState[8] && boardState[2] != 0){
            winCon = 3;
        }
        else if(boardState[0] == boardState[4] && boardState[0] == boardState[8] && boardState[0] != 0){
            winCon =2;
        }
        else if(boardState[6] == boardState[4] && boardState[6] == boardState[2] && boardState[6] != 0){
            winCon = 2;
        }

        switch (winCon){
            case 1:
                return boardState[0];
            case 2:
                return boardState[4];
            case 3:
                return boardState[8];
            default:
                for(int i = 0; i < boardState.length; i++){
                    if(boardState[i] == 0){
                        return 0;
                    }
                }
                return -1;
        }
    }

    public String showBoard(){
        char[] visualBoard = symbolsBoard();
        return String.format("%c | %c | %c\n--+---+--\n%c | %c | %c\n--+---+--\n%c | %c | %c",visualBoard[0],visualBoard[1],visualBoard[2],visualBoard[3],visualBoard[4],visualBoard[5],visualBoard[6],visualBoard[7],visualBoard[8]);
    }
}
