import java.util.Random;

public class RandCPU extends Player {

    public RandCPU(String name, char symbol) {
        super(name, symbol);
    }

    @Override
    public int selection(Board gameboard) {
        boolean goodChoice = false;
        System.out.println(this.name + " is selecting: ");
        int pos = -1;
        while (!goodChoice) {
            pos = new Random().nextInt(gameboard.available.length);
            if (gameboard.available[pos] != -1) {
                goodChoice = true;
            }
        }
        return gameboard.available[pos];
    }
}
