public class StopWatch {
    long startTime;
    long stopTime;
    boolean running = false;

    public StopWatch(long startTime, long stopTime){
        this.startTime = startTime;
        this.stopTime = stopTime;
        running = false;
    }
    public void start(){
        running = true;
        startTime = System.currentTimeMillis();
    }

    public void stop(){
        running = false;
        stopTime = System.currentTimeMillis();
        System.out.println("Zeit: " + (stopTime - startTime) + "ms | " + "Sekunden: " + (stopTime - startTime)/1000);
    }

    public String elapsedTime(){
        long time;
        if (running){
            time = System.currentTimeMillis() - stopTime;

        } else{
            time = stopTime - startTime;
        }

        long seconds = time / 1000;
        long hundreds = time % 1000;

        return "" + seconds + "." + hundreds;
    }

}
