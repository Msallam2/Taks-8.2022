public class StiftCipher {

    public int keyCode;
    final String ALPHA = "abcdefghijklmnopqrstuvwxyz";

    public StiftCipher(int key){
        keyCode = key;
    }

    public void encipher(String s){
        String coded = "";

        for (int i = 0; i < s.length(); i++){
            char current = s.charAt(i);
            for (int x = 0; x < ALPHA.length(); x++){
                if (current == ALPHA.charAt(x)){
                    int max = x + keyCode;
                    if (max >= 26){
                        max = (max + 26) % 26;
                    }
                    coded = coded + ALPHA.charAt(max);
                }

            }


        }

        System.out.println(s + " -> " + coded);
    }

    public void decipher(String s){
        String coded = "";

        for (int i = 0; i < s.length(); i++){
            char current = s.charAt(i);
            for (int x = 0; x < ALPHA.length(); x++){
                if (current == ALPHA.charAt(x)){
                    int max = x - keyCode;
                    if (max < 26){
                        max = (max + 26) % 26;
                    }
                    coded = coded + ALPHA.charAt(max);
                }

            }


        }

        System.out.println(s + " -> " + coded);
    }


}