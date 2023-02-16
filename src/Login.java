public class Login {
    private String login;

    public Login(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public boolean check_log(String login){
        if(login.toLowerCase().equals(login)){
            return false;
        }
        if(!login.contains("0") && !login.contains("1")&&!login.contains("2")&& !login.contains("3")&& !login.contains("4")&& !login.contains("5")&& !login.contains("6")&& !login.contains("7")&& !login.contains("8")&& !login.contains("9")){
            return false;
        }
        if(login.length()<6){
            return false;
        }
        return true;
    }
}
