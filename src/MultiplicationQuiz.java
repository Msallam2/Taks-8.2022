
public class MultiplicationQuiz {
    int a , b = 0;
    long max = 20;
    int delay = 3000;

    public MultiplicationQuiz(long maximum, int zeit){
        max = maximum;
        delay = zeit;
    }
    void getExercise() throws Exception{
        a = (int) Math.round(Math.random() * max);
        b = (int) Math.round(Math.random() * max);

        ModuleScanner ms = new ModuleScanner();

        ms.animatedPrinter(a + " x " + b + " = ", 40);

        Thread.sleep(delay);
      
        ms.animatedPrinter("" + getResult(), 40);


      //  System.out.print(getResult());
    }

    int getResult(){
        return a * b;
    }
}
