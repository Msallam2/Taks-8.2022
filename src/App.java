import java.lang.ProcessBuilder.Redirect.Type;

import javax.print.DocFlavor.BYTE_ARRAY;

public class App {

    public static void main(String[] args) throws Exception {
        StepCounter s = new StepCounter("11.11.2011");
        
        s.incrementSteps(1111);

     //   System.out.println(s);

        s = new StepCounter("1.9.2017");

        s.incrementSteps(10000);

        System.out.println(s);

        
        ModuleScanner ms = new ModuleScanner();

      //  ms.animatedPronter("" + s, 10);

        Health.computeBMI(57, 1.8);

        LyriksWikia.returnURL("die fantastischen vier", "MFG");


        MultiplicationQuiz mq = new MultiplicationQuiz();
        mq.getExcercise();
    }

}