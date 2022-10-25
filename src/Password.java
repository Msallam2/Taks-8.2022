import java.util.Arrays;

public class Password {
    private char[] password;

    Password(char[] pass){
        System.out.println("PASS 2/2");
        this.password = new char[pass.length];
        System.out.println("PASS 3/3");
        for (int i = 0; i <= pass.length - 1; i++){
            this.password[i] = pass[i];
        }

    }

    public boolean isStrong(char[] password){
        boolean lower = false;
        boolean upper = false;
        boolean figure = false;
        boolean special = false;

        for (int i = 0; i < password.length; i++) {
            if (password[i] >= 'a' && password[i] <= 'z') {
                lower = true;
            }
            if (password[i] >= 'A' && password[i] <= 'Z') {
                upper = true;
            }
            if (password[i] >= '0' && password[i] <= '9') {
                figure = true;
            }
            if (password[i] >= '!' && password[i] <= '*') {
                special = true;
            }
        }
        if (password.length < 8) {
            return false;
        }
        if (lower == true && upper == true && figure == true && special == true) {
            return true;
        } else {
            return false;
        }
    }

    public boolean changePassword(char[] given, char[] newPassword){
        if (Arrays.equals(newPassword, password)){
            System.out.println("Das Selbe Password wurde eingegeben");
            return false;
        }

        if (!Arrays.equals(given, password)){
            System.out.println("Das alte Password stimmt nicht");
            return false;
        }

        if (!isStrong(newPassword)){
            System.out.println("Das neue Password ist nicht stark");
            return false;
        }

        System.out.println(Arrays.toString(given) + " -> " + Arrays.toString(newPassword));
        password = newPassword;
        return true;
    }

    public void deletePassword(){
        password = null;
    }
}