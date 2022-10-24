public class PrinterQueue {
    int maxStorage = 4;
    public String[] jobs;
    private int nextSlot;
    private int nextJob;
    private int amountJobs;

    public PrinterQueue(int max){
        jobs = new String[max];
        this.nextJob = 0;
        this.nextSlot = 0;
        this.amountJobs = 0;
        this.maxStorage = max;
    }

    public void addJob(String job) throws Exception {
        if (amountJobs >= maxStorage) {
            throw new Exception("Fehler: Maximalanzahl an Jobs erreicht");
        }
        jobs[nextSlot] = job;
        nextSlot = (nextSlot + 1) % maxStorage;
        amountJobs = amountJobs + 1;
    }

    public String nextJob() {
        String job = null;
        if (amountJobs > 0) {
            amountJobs = amountJobs - 1;
            job = jobs[nextJob];
            nextJob = (nextJob + 1) % maxStorage;
        }
        return job;
    }
}
