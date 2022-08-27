
public class StepCounter {
    
    int steps;
    String datum;

    StepCounter(String datum){
        this.datum = datum;
        this.steps = 0;
    }

    void incrementSteps(int x){
        steps+= x;
    }

    public String toString(){
        String s = "Am " + datum + " bin ich " + steps + " schritte gegangen";
        return s;
    }

}
