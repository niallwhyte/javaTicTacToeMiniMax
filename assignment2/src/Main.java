import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        Scanner typed = new Scanner(System.in);
        System.out.println("Welcome to tic-tac-toe\n");
        System.out.println("Enter your name: \n");
        String userName = typed.nextLine();
        char symbol;
        int whoMakesFirstMove = 0;
        do{
            System.out.println("Choose your symbol (X or O): \n");
            symbol = Character.toLowerCase(typed.next().charAt(0));

            if (symbol != 'x' && symbol != 'o'){
                System.out.println("You must input either X or O.\n");
            }
            typed.nextLine();
        } while (symbol != 'x' && symbol != 'o');

        while (whoMakesFirstMove != 1 && whoMakesFirstMove != 2) {
            System.out.print("Choose who will go first, Player 1 or Player 2: \n");
            try {
                whoMakesFirstMove = Integer.parseInt(typed.next());
                typed.nextLine();
            } catch (NumberFormatException e) {
                System.out.println("Error! Input must be an integer.");
                typed.nextLine();
            }
        }

        boolean activeGame = true;
        while(activeGame) {
            System.out.println("Please select an option from the menu\n1.Two Player\n2.Random Computer\n3.Smart CPU\n4.Exit");
            int userChoice = Integer.parseInt(typed.nextLine());
            Board game = null;
            if (userChoice == 1) {
                game = new Board(new Player(userName, 'X'), new Player("Player Two", 'O'));
            } else if (userChoice == 2) {
                if (symbol == 'x'){
                    game = new Board(new Player(userName, 'X'), new RandCPU("CPU", 'O'));
                } else {
                    game = new Board(new Player(userName, 'O'), new RandCPU("CPU", 'X'));
                }
            } else if (userChoice == 3) {
                if (symbol == 'x'){
                    game = new Board(new Player(userName, 'X'), new MinMaxCPU("DeepBlue", 'O'));
                } else {
                    game = new Board(new Player(userName, 'O'), new MinMaxCPU("DeepBlue", 'X'));
                }

            } else if (userChoice == 4){
                System.out.println("Goodbye!");
                exit(0);
            }
            System.out.println(game.showBoard());

            if (whoMakesFirstMove == 1){
                game.playerTurn(game.player1);
            } else {
                game.playerTurn(game.player2);
            }
            System.out.println("The game is completed!");
        }
    }
}