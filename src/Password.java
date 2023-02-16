public class Password {
    private String password;

    public Password(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean check_pass(String password){
        if(password.toLowerCase().equals(password)){
            return false;
        }
        if(!password.contains("0") && !password.contains("1")&&!password.contains("2")&& !password.contains("3")&& !password.contains("4")&& !password.contains("5")&& !password.contains("6")&& !password.contains("7")&& !password.contains("8")&& !password.contains("9")){
            return false;
        }
        if(password.length()<6){
            return false;
        }
        return true;
    }
}
