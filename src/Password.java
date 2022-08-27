public class Password {
    private char[] password;

    Password(char[] pass){
        this.password = new char[pass.length];

        for (int i = 0; i<= password.length; i++){
            this.password[i] = pass[i];
        }

    }


    public boolean isStrong(char[] password){
        if (password.length < 10){
            return false;
        }
        return true;
    }

}
