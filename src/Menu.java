import java.util.Arrays;
import java.util.Scanner;

public class Menu {

    Scanner sc = new Scanner(System.in);

    public void stepCounter(){

        try {
            System.out.println("Datum eingeben");
            String datum = sc.nextLine();
            StepCounter s = new StepCounter(datum);

            System.out.println("Wie viele Schritte sind sie gelaufen");
            int schritte = sc.nextInt();
            s.incrementSteps(schritte);
            System.out.println(s.toString());

        } catch (Exception e){
            System.out.println("Ein Fehler ist aufgetreten");
            printMenu();
        }

    }

    public void moduleScanner(){
        try {
            System.out.println("Message eingeben");
            String message = sc.nextLine();
            System.out.println("Delay eingeben (ms)");
            int delay = sc.nextInt();
            ModuleScanner m = new ModuleScanner();
            m.animatedPrinter(message,delay);

        } catch (Exception e){
            System.out.println("Ein Fehler ist aufgetreten");
            printMenu();
        }
    }

    public void health(){
        try {
            System.out.println("Körpergewicht eingeben (KG) ");
            int weight = sc.nextInt();
            System.out.println("Körpergröße (cm)");
            int height = sc.nextInt();
            Health h = new Health();
            h.computeBMI(weight,height/100);

        } catch (Exception e){
            System.out.println("Ein Fehler ist aufgetreten");
            printMenu();
        }
    }

    public void lyricsWikia(){
        try {
            System.out.println("Name des Authors eingeben");
            String name = sc.nextLine();
            System.out.println("Title eingeben");
            String title = sc.nextLine();
            LyriksWikia lw = new LyriksWikia();
            lw.returnURL(name,title);

        } catch (Exception e){
            System.out.println("Ein Fehler ist aufgetreten");
            printMenu();
        }
    }

    public void multiplicationQuiz(){
        try {

            System.out.println("Maximum eingeben");
            int maximum = sc.nextInt();
            System.out.println("Zeit für die Aufgabe eingeben (ms)");
            int zeit = sc.nextInt();
            MultiplicationQuiz ms = new MultiplicationQuiz(maximum, zeit);
            ms.getExercise();

        } catch (Exception e){
            System.out.println("Ein Fehler ist aufgetreten");
            printMenu();
        }
    }

    public void tv_remote_next(TV_Remote t){
        t.nextChannel();
        t.acquireData();
        tv_remote(t, true);
    }

    public void tv_remote_name(TV_Remote t){
        System.out.println("Name eingeben");
        String nn = sc.nextLine();
        t.nameChannel(nn);
        tv_remote(t, true);
    }

    public void tv_remote(TV_Remote t, boolean v){
        try {
            TV_Remote tr = t;
            if (v == false){
                System.out.println("Anzahl Kanäle eingeben");
                String amount = sc.nextLine();
                tr = new TV_Remote(Integer.parseInt(amount));
            }

            System.out.println("[1] Nächster Kanal");
            System.out.println("[2] Kanal umbenennen");

            switch (sc.nextLine()){
                case "1" : tv_remote_next(tr); break;
                case "2" : tv_remote_name(tr); break;
                default: tv_remote(t, true);
            }


        } catch (Exception e){
            System.out.println("Ein Fehler ist aufgetreten");
            printMenu();
        }
    }


    public void stopWatch_print(StopWatch sw) throws Exception{
        System.out.println("Stoppuhr eingestellt..");
        System.out.println("[1] Stop");
        System.out.println("[2] elapsedTime");

        switch (sc.nextLine()){
            case "1" : sw.stop(); break;
            case "2" : System.out.println(sw.elapsedTime()); stopWatch_print(sw); break;
            default: stopWatch_print(sw);

        }
    }
    public void stopWatch(boolean v){
        try {

            StopWatch sw = null;
            if (v == false){
                sw = new StopWatch(0, 0);
            }

            System.out.println("[1] Start");

            switch (sc.nextLine()){
                case "1" : sw.start(); stopWatch_print(sw); break;
                default: stopWatch(true);
            }

        } catch (Exception e){
            System.out.println("Ein Fehler ist aufgetreten");
            printMenu();
        }
    }

    public void printerQueue(PrinterQueue printer,  boolean v){
        try {
            PrinterQueue pq = printer;

            if (!v){
                System.out.println("Maximale Aufträge eingeben");
                String maximum = sc.nextLine();
                pq = new PrinterQueue(Integer.parseInt(maximum));
            }

            System.out.println("[1] Add Job");
            System.out.println("[2] Next Job");
            System.out.println("[3] Print Jobs");

            switch (sc.nextLine()){
                case "1" : System.out.println("Name des Jobs eingeben"); pq.addJob(sc.nextLine()); printerQueue(pq,true); break;
                case "2" : System.out.println(pq.nextJob()); printerQueue(pq,true); break;
                case "3" : System.out.println(Arrays.asList(pq.jobs));
                default: printMenu();
            }

        } catch (Exception e){
            System.out.println("Ein Fehler ist aufgetreten");
            printMenu();
        }
    }

    public void printMenu(){
        System.out.println("[1] Stepcounter");
        System.out.println("[2] ModuleScanner");
        System.out.println("[3] BMI Rechner");
        System.out.println("[4] Lyrics Wikia");
        System.out.println("[5] Multiplication Quiz");
        System.out.println("[6] TV Remote");
        System.out.println("[7] StopWatch");
        System.out.println("[8] PrinterQueue");

        String command = sc.nextLine();
        switch (command){
            case "1" : stepCounter(); break;
            case "2" : moduleScanner(); break;
            case "3" : health(); break;
            case "4" : lyricsWikia(); break;
            case "5" : multiplicationQuiz(); break;
            case "6" : tv_remote(null, false); break;
            case "7" : stopWatch(false); break;
            case "8" : printerQueue(null, false); break;
        }
    }
}
