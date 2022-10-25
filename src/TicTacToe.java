public class TicTacToe {
    public int[] field;
    public int mark;


    public TicTacToe(){
        field = new int[9];
        reset();
    }

    public void reset(){
        for (int i = 0; i< field.length; i++){
            field[i] = 0;
        }
        mark = 1;
    }

    public boolean setMark(int x, int y){
        if (x < 0 ^ x > 2 || y < 0 ^ y > 2){
            System.out.println("Falsches Feld");
            System.out.println(toString());
            return false;
        }
        int position = 3 * x + y;

        if (field[position] > 0){
            System.out.println("Falsches Feld");
            System.out.println(toString());
            return false;
        }

        field[position] = mark;

        mark = (mark % 2) + 1;

        System.out.println(toString());
        return true;
    }

    public String toString(){
        String temp = "";

        for (int i = 0; i < field.length; i++){
            switch (field[i]){
                case 0: temp = temp + " "; break;
                case 1: temp = temp + "X"; break;
                case 2: temp = temp + "O"; break;
                default: temp = temp + " ";
            }

            if ((i + 1) % 3 != 0){
                temp = temp + "|";
            }

            if ((i + 1) % 3 == 0 && i < 6){
                temp = temp + "\n";
                temp = temp + "-+-+-";
                temp = temp + "\n";
            }
        }

        checkWinner();
        return temp = temp + "\n";
    }

    public String getPlayer(){
        String player = "";
        if (mark == 1){
            player = "X";
        } else if (mark == 2){
            player = "O";
        }
        return player;
    }


    public void printWinner(){
        if (field[0] == 1){
            System.out.println("X hat gewonnen");
            reset();
        } else if (field[0] == 2){
            System.out.println("O hat gewonnen");
            reset();
        }
    }

    public void checkWinner(){
        if (field[0] != 0 && field[1] == field[0] && field[1] == field[2]){
            printWinner();
        }

        if (field[3] != 0 && field[4] == field[3] && field[4] == field[5]){
            printWinner();
        }

        if (field[6] != 0 && field[7] == field[6] && field[7] == field[8]){
            printWinner();
        }

        if (field[0] != 0 && field[3] == field[0] && field[6] == field[3]){
            printWinner();
        }

        if (field[1] != 0 && field[4] == field[1] && field[7] == field[4]){
            printWinner();
        }

        if (field[2] != 0 && field[5] == field[2] && field[8] == field[5]){
            printWinner();
        }

        if (field[0] != 0 && field[4] == field[0] && field[8] == field[4]){
            printWinner();
        }

        if (field[2] != 0 && field[4] == field[2] && field[6] == field[4]){
            printWinner();
        }

    }

}