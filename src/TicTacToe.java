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

}