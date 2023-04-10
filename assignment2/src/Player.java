import java.util.Scanner;
public class Player {
    public String name;
    public char symbol;

    public Player(String name, char symbol){
        this.name = name;
        this.symbol = symbol;
    }

    public int selection(Board gameboard){
        boolean goodChoice = false;
        Scanner typed = new Scanner(System.in);
        int pos = -1;
        while(!goodChoice) {
            System.out.println("Where do you want to go?: ");
            String userP = typed.nextLine();
            try {
                pos = Integer.parseInt(userP);
            } catch (Exception notInt){
                pos = -1;
            }
            if(pos <= 0 || pos > gameboard.available.length){
                System.out.println("Selection must be an available number on the board!");
            }
            else if(gameboard.available[pos - 1] != -1){
                goodChoice = true;
            } else{
                System.out.println("That position is not available!");
            }
        }

        return pos - 1;
    }
}
