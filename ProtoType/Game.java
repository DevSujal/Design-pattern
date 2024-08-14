
public interface Game {

    public Game getClone();

    public String toString();

}

class Chess implements Game {
    private String name, theme;
    private int noOfBoxes;

    Chess(String name, String theme, int noOfBoxes) {
        this.name = name;
        this.theme = theme;
        this.noOfBoxes = noOfBoxes;
    }

    @Override
    public Game getClone() {
        return new Chess(name, theme, noOfBoxes);
    }

    @Override
    public String toString() {
        return "\nName of the game : " + name + "\nTheme of the game : " + theme + "\nNo of boxes in the Chess Game : " + noOfBoxes;
    }
}

class TicTacToe implements Game {
    private String name;
    private int noOfBoxes;

    TicTacToe(String name, int noOfBoxes) {
        this.name = name;
        this.noOfBoxes = noOfBoxes;
    }

    @Override
    public Game getClone() {
        return new TicTacToe(name, noOfBoxes);
    }

    @Override
    public String toString() {
        return "\nName of the game : " + name + "\nNo of boxes in the Tic Tac Toe Game : " + noOfBoxes;

    }
}

 class Test {

    public static void main(String[] args) {
        Game chess1 = new Chess("chess", "black and white", 64);
        Chess chess2 = (Chess)chess1.getClone();

        Game tictactoe1 = new TicTacToe("Tic Tac Toe", 9);
        Game tictactoe2 = tictactoe1.getClone();

        System.out.println(chess1);
        System.out.println(chess2);
        System.out.println(tictactoe1);
        System.out.println(tictactoe2);
    }
    
}