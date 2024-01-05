package src;

public class Login {
    private String username = "123";
    private String password = "123";
    private Boolean login = false;
    private Integer attempt = 3;
    private Double balance = 2000.0;

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

    public void readBalance(){
        System.out.println("Su saldo es: "+this.balance);
        System.out.println("\n");
    }

    public void depositBalance(Double deposit){
        this.balance = balance + deposit;
        System.out.println("Deposito exitoso");
    }

    public void withdrawBalance(Double deposit){
        if(deposit > this.balance){
            System.out.println("No se puede realizar el retiro, seleccione otro monto");
        } else{
            this.balance = balance - deposit;
            System.out.println("Retiro exitoso");
        }
    }

    public void transferBalance(Double deposit, String name){
        if(deposit > this.balance){
            System.out.println("No se puede realizar la transferencia, seleccione otro monto");
        } else{
            this.balance = balance - deposit;
            System.out.println("Tranferencia exitosa a "+name);
        }
    }

}
