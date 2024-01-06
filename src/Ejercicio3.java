package src;

import java.util.Scanner;

public class Ejercicio3 {
    static UniversityClass user = new UniversityClass();
    public static void main(String[] args){
        String username;
        String password;
        Integer attempt;
        Boolean login;

        System.out.println("Bienvenido al sistema bancario");
        do {
            System.out.println("Por favor introduzca su usuario: ");
            Scanner sc = new Scanner(System.in);
            username = sc.nextLine();
            System.out.println("Ahora introduzca su contraseña: ");
            password = sc.nextLine();
            user.login(username, password);
            attempt = user.getAttempt();
            login = user.getLogin();

        } while ((attempt > 0));

        if (login.equals(true)){
            menu();
        }
    }

    public static void menu(){

    }
}
