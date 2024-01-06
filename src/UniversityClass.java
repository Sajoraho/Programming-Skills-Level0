package src;

public class UniversityClass {
    private String username = "123";
    private String password = "123";
    private Boolean login = false;
    private Integer attempt = 3;
    private String[] avaliablePrograms = {"Computer Science", "Medicine", "Marketing", "Arts"};
    private String firstName;
    private String lastName;
    private String[] chosenProgram = new String[4];
    private String[] cities = {"London", "Manchester", "Liverpool"};

    public Boolean getLogin() {
        return login;
    }

    public Integer getAttempt() {
        return attempt;
    }

    public void login(String username, String password){
        if (this.username.equals(username) && this.password.equals(password) ) {
            this.attempt = 0;
            System.out.println("Bienvenido, "+username);
            this.login = true;
        }
        else {
            this.attempt--;
            if(this.attempt > 0){
                System.out.println("Le quedan "+this.attempt+" intentos, por favor intente de nuevo");
            }
            else {
                System.out.println("Login bloqueado, por favor contacte a su banco");
            }

        }
    }
}

