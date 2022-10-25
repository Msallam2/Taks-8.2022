import java.util.Arrays;

public class Clipboard {
    public String[] clipboard;
    public int index = -1;

    public Clipboard(int i){
        clipboard = new String[i];
    }

    public void copy(String s){
        if (index < clipboard.length - 1){
            index++;
            clipboard[index] = s;
        } else{
            clipboard[0] = null;

            for (int i = 1; i < clipboard.length; i++){
                clipboard[i - 1] = clipboard[i];
            }

            clipboard[index] = s;
        }

    }

    public String paste(){
        String s = clipboard[index];
        //clipboard[index] = null;

        if (index > 0){
            index--;
        } else {
            index = 0;
        }
        return s;
    }

    public void print(){
        System.out.println(Arrays.asList(clipboard));
    }

}
