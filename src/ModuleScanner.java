import java.util.Scanner;



public class ModuleScanner {
    Scanner scanner = new Scanner(System.in);
    
    void animatedPrinter(String s, int time) throws Exception {
        for (int i = 0; i< s.length(); i++){
            System.out.print(s.charAt(i));
            Thread.sleep(time);
        } 
    }

}
