
public class MultiplicationQuiz {
    int a , b = 0;
    int max = 20;

    void getExcercise() throws Exception{
        a = (int) Math.round(Math.random() * max);
        b = (int) Math.round(Math.random() * max);
     //   System.out.print(a + " x " + b + " = ");
       
        ModuleScanner ms = new ModuleScanner();

        ms.animatedPronter(a + " x " + b + " = ", 40);

        Thread.sleep(3000);
      
        ms.animatedPronter("" + getResult(), 40);


      //  System.out.print(getResult());
    }

    int getResult(){
        return a * b;
    }
}
