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
            String weight = sc.nextLine();
            System.out.println("Körpergröße (cm)");
            double height = Double.parseDouble(sc.nextLine());
            Health h = new Health();
            h.computeBMI(Integer.parseInt(weight),height);

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

    public void password(Password password, boolean v){
        try {
            Password p = password;
            if (v == false){
                System.out.println("Password eingeben");
                String given = sc.nextLine();
                char[] g = new char[given.toString().length()];
                for (int i = 0; i < given.toString().length(); i++){
                    g[i] = given.charAt(i);
                }
                System.out.println("PASS 1/1");
                p = new Password(g);
            }

            System.out.println("[1] Password ändern");
            System.out.println("[2] Password löschen");

            switch (sc.nextLine()){
                case "1" : {
                    System.out.println("Neues Password eingeben: (a - z) + (A - Z) + (1 - 9) + (! - *)");
                    String np = sc.nextLine();
                    System.out.println("Altes Password eingeben:");
                    String op = sc.nextLine();
                    p.changePassword(op.toCharArray(),np.toCharArray());
                    break;
                }
                case "2" : p.deletePassword(); break;
                default: password(p, true);
            }


        } catch (Exception e){
            System.out.println(e);
            System.out.println("Ein Fehler ist aufgetreten");
            printMenu();
        }
    }

    public void multiplicationQuiz(){
        try {

            System.out.println("Maximum eingeben");
            long maximum = sc.nextLong();
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
                case "3" : System.out.println(Arrays.asList(pq.jobs)); printerQueue(pq,true);;
                default: printMenu();
            }

        } catch (Exception e){
            System.out.println("Ein Fehler ist aufgetreten");
            printMenu();
        }
    }


    public void _TicTacToe(TicTacToe game){
        try {
            TicTacToe ttt = game;

            System.out.println("Spieler: " + ttt.getPlayer());

                System.out.println("x Feld eingeben (0 - 2)");
                String x = sc.nextLine();

                int x1 = Integer.parseInt(x);


                System.out.println("y Feld eingeben (0 - 2)");
                String y = sc.nextLine();

                int y1 = Integer.parseInt(y);

                if (x1 < 0 ^ x1 > 2 || y1 < 0 ^ y1 > 2){
                    throw new Exception();
                }

                ttt.setMark(Integer.parseInt(x), Integer.parseInt(y));
                _TicTacToe(ttt);

                ttt.checkWinner();


        } catch (Exception e){
            System.out.println("Ein Fehler ist aufgetreten");
            printMenu();
        }
    }

    public void clipBoard(Clipboard clipboard,  boolean v){
        try {

            Clipboard c = clipboard;
            if (!v){
                System.out.println("Anzahl des Arrays eingeben");
                String l = sc.nextLine();
                c = new Clipboard(Integer.parseInt(l));
            }

            System.out.println("[1] Copy");
            System.out.println("[2] Paste");
            System.out.println("[3] Print");

            switch (sc.nextLine()){
                case "1" : System.out.println("Message:"); c.copy(sc.nextLine()); clipBoard(c, true); break;
                case "2" : System.out.println(c.paste()); clipBoard(c, true); break;
                case "3" : c.print(); clipBoard(c, true); break;
                default: printMenu();
            }

        } catch (Exception e){
            System.out.println("Ein Fehler ist aufgetreten");
            printMenu();
        }
    }

    public void temperature(Temperature temperature,  boolean v){
        try {
            Temperature t = temperature;

            if (!v){
                System.out.println("Jahr eingeben");
                String year = sc.nextLine();
                t = new Temperature(Integer.parseInt(year));
            }

            System.out.println("[1] Add to Month");
            System.out.println("[2] Add to all Months");
            System.out.println("[3] Print");

            switch (sc.nextLine()){
                case "1" : {
                    int m;
                    int w;
                    System.out.println("Monat eingeben:");
                    m = Integer.parseInt(sc.nextLine());
                    System.out.println("Wert: eingeben");
                    w = Integer.parseInt(sc.nextLine());
                    t.addTemperature(m, w);
                    temperature(t, true);
                    break;
                }
                case "2" : {
                    int w1;
                    System.out.println("Wert: eingeben");
                    w1 = Integer.parseInt(sc.nextLine());
                    for (int i = 1; i < 13; i++){
                        t.addTemperature(i, w1);
                    }

                    temperature(t, true);
                    break;
                }
                case "3" : t.plotGraph(); temperature(t, true); break;
                default: printMenu();
            }
        } catch (Exception e){
            System.out.println("Ein Fehler ist aufgetreten");
            printMenu();
        }
    }


    public void ambientLight(AmbientLight ambientLight,  boolean v){
        try {
            AmbientLight a = ambientLight;

            if (!v){
                System.out.println("Hue eingeben (0 - 360)");
                String hue = sc.nextLine();
                System.out.println("Saturation eingeben (0 - 100)");
                String saturation = sc.nextLine();
                System.out.println("Helligkeit eingeben (0 - 100)");
                String helligkeit = sc.nextLine();
                a = new AmbientLight(Integer.parseInt(hue), Integer.parseInt(saturation), Integer.parseInt(helligkeit));
            }

            System.out.println("Hue: " + a.hue + " Saturation: " + a.saturation + " Helligkeit: " + a.brightness);
            System.out.println("[1] Increase saturation");
            System.out.println("[2] Increase brightness");
            System.out.println("[3] Decrease saturation");
            System.out.println("[4] Decrease brightness");
            System.out.println("[5] Random Color");
            System.out.println("[6] Print Color");

            switch (sc.nextLine()){
                case "1" : {
                    int s;
                    System.out.println("Wie oft?");
                    s = Integer.parseInt(sc.nextLine());

                    for (int i = 0; i < s; i++){
                        a.increaseSaturation();
                    }
                    ambientLight(a, true);
                    break;
                }
                case "2" : {
                    int b;
                    System.out.println("Wie oft?");
                    b = Integer.parseInt(sc.nextLine());

                    for (int i = 0; i < b; i++){
                        a.increaseBrightness();
                    }
                    ambientLight(a, true);
                    break;
                }

                case "3" : {
                    int ds;
                    System.out.println("Wie oft?");
                    ds = Integer.parseInt(sc.nextLine());

                    for (int i = 0; i < ds; i++){
                        a.decreaseSaturation();
                    }
                    ambientLight(a, true);
                    break;
                }
                case "4" : {
                    int db;
                    System.out.println("Wie oft?");
                    db = Integer.parseInt(sc.nextLine());

                    for (int i = 0; i < db; i++){
                        a.decreaseBrightness();
                    }
                    ambientLight(a, true);
                    break;
                }

                case "5" : System.out.println(Arrays.toString(a.getRandomColor())); ambientLight(a, true); break;
                case "6" : System.out.println(Arrays.toString(a.getNextColor())); ambientLight(a, true); break;
                default: printMenu();
            }
        } catch (Exception e){
            System.out.println("Ein Fehler ist aufgetreten");
            printMenu();
        }
    }

    public void stiftcipher(){
        try {
            System.out.println("Key eingeben");
            String k = sc.nextLine();
            StiftCipher stiftCipher = new StiftCipher(Integer.parseInt(k));
            System.out.println("Wort eingeben");
            String w = sc.nextLine();
            System.out.println("[1] verschlüsseln");
            System.out.println("[2] entschlüsseln");
            switch (sc.nextLine()){
                case "1" : stiftCipher.encipher(w); break;
                case "2" : stiftCipher.decipher(w); break;
                default: printMenu();
            }

        } catch (Exception e){
            System.out.println("Ein Fehler ist aufgetreten");
            printMenu();
        }
    }

    public void mastermind(){
        try {
            System.out.println("Zufällige Farben generiert");
            System.out.println("Farbe 1 eingeben: 0: Rot, 1: Grün, 2: Blau, 3: Weiß, 4: Orange, 5: Grau");
            String f1 = sc.nextLine();
            System.out.println("Farbe 2 eingeben: 0: Rot, 1: Grün, 2: Blau, 3: Weiß, 4: Orange, 5: Grau");
            String f2 = sc.nextLine();
            System.out.println("Farbe 3 eingeben: 0: Rot, 1: Grün, 2: Blau, 3: Weiß, 4: Orange, 5: Grau");
            String f3 = sc.nextLine();
            System.out.println("Farbe 4 eingeben: 0: Rot, 1: Grün, 2: Blau, 3: Weiß, 4: Orange, 5: Grau");
            String f4 = sc.nextLine();

            int[] generated = new int[4];
            for (int i = 0; i < 4; i++){
                int index = (int) (Math.random() * 6);
                generated[i] = index;
             }


            Mastermind mastermind = new Mastermind(generated[0], generated[1], generated[2], generated[3]);
            System.out.println("Generierte Farben: " + Arrays.toString(mastermind.code));
            System.out.println("Geschätzte Farben: " + "[" + mastermind.colors[Integer.parseInt(f1)] + ", " + mastermind.colors[Integer.parseInt(f2)] + ", " + mastermind.colors[Integer.parseInt(f3)] + ", " + mastermind.colors[Integer.parseInt(f4)] + "]");

            System.out.println("Correct colors: " + mastermind.guess(Integer.parseInt(f1),Integer.parseInt(f2),Integer.parseInt(f3),Integer.parseInt(f4))[0]);
            System.out.println("Correct colors and positions: " + mastermind.guess(Integer.parseInt(f1),Integer.parseInt(f2),Integer.parseInt(f3),Integer.parseInt(f4))[1]);

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
        System.out.println("[5] Password");
        System.out.println("[6] Multiplication Quiz");
        System.out.println("[7] TV Remote");
        System.out.println("[8] StopWatch");
        System.out.println("[9] PrinterQueue");
        System.out.println("[10] Tic Tac Toe");
        System.out.println("[11] Clipboard");
        System.out.println("[12] Temperatur");
        System.out.println("[13] Ambient Light");
        System.out.println("[14] StiftCipher");
        System.out.println("[15] Mastermind");

        String command = sc.nextLine();

        switch (command){
            case "1" : stepCounter(); break;
            case "2" : moduleScanner(); break;
            case "3" : health(); break;
            case "4" : lyricsWikia(); break;
            case "5" : password(null, false); break;
            case "6" : multiplicationQuiz(); break;
            case "7" : tv_remote(null, false); break;
            case "8" : stopWatch(false); break;
            case "9" : printerQueue(null, false); break;
            case "10" : _TicTacToe(new TicTacToe()); break;
            case "11" : clipBoard(null, false); break;
            case "12" : temperature(null, false); break;
            case "13" : ambientLight(null, false); break;
            case "14" : stiftcipher(); break;
            case "15" : mastermind(); break;

            default: printMenu();
        }
    }
}
