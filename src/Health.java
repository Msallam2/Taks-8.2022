public class Health {

   public static String[] categories = {
        "untergewichtig",
        "normalgewichtig",
        "übergewichtig",
        "fettleibig"
    };

    public static double computeBMI(int m, double i2){
        double weight = m/(i2 * i2);
        sortToCategory(weight);
        return weight;
    }

    public static void sortToCategory(double w){
        String category = categories[0];

        if (w < 18.5){
            category = categories[0];
        }

        if (w >= 18.5 && w <= 25){
            category = categories[1];
        }

        if (w >= 25 && w <= 30){
            category = categories[2];
        }

        if (w > 30){
            category = categories[3];
        }

        System.out.println("Mit einem BMI von " + w + " sind sie " + category);

    }

}