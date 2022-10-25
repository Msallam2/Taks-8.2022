public class Temperature {
    private int[] temperaturen;
    public static int jahr;

    public Temperature(int jahr) {
        temperaturen = new int[12];
        for (int i = 0; i < temperaturen.length; i++) {
            temperaturen[i] = -1000;
        }
    }

    public void addTemperature(int monat, int wert) {
        if (monat > 0 && monat < 13) {
            temperaturen[monat - 1] = wert;
        }
    }

    public void plotGraph() {
        if (isComplete()) {
            int maximalTemperatur = getMaxTemperatur();
            int minimalTemperatur = getMinTemperatur();
            for (int i = maximalTemperatur; i >= minimalTemperatur; i = i - 1) {
                for (int j = 0; j < temperaturen.length; j++) {
                    if (temperaturen[j] >= i) {
                        System.out.print(" #");
                    } else {
                        System.out.print("  ");
                    }
                }
                System.out.println();
            }
        }
    }

    private boolean isComplete() {
        for (int i = 0; i < temperaturen.length; i++) {
            if (temperaturen[i] == -1000) {
                return false;
            }
        }
        return true;
    }

    private int getMaxTemperatur() {
        int maximum = -1000;
        for (int i = 0; i < temperaturen.length; i++) {
            if (temperaturen[i] > maximum) {
                maximum = temperaturen[i];
            }
        }
        return maximum;
    }

    private int getMinTemperatur() {
        int minimum = 1000;
        for (int i = 0; i < temperaturen.length; i++) {
            if (temperaturen[i] < minimum) {
                minimum = temperaturen[i];
            }
        }
        return minimum;
    }
}