package src;

import java.util.Scanner;

public class Ejercicio1 {
    static Login user = new Login();
    public static void main(String[] args) {
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
        Integer flag;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Elija su acción");
            System.out.println("1. Ver balance");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Transferir");
            System.out.println("5. Salir");

            flag = sc.nextInt();
            switch (flag){
                case 1: user.readBalance();
                break;

                case 2: deposit();
                break;

                case 3: withdraw();
                break;

                case 4: transfer();
                break;
            }

        }while(flag < 5);
    }

    public static void deposit(){
        Double deposit;
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuanto desea depositar?");
        deposit = sc.nextDouble();
        user.depositBalance(deposit);
        user.readBalance();
    }

    public static void withdraw(){
        Double deposit;
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuanto desea retirar?");
        deposit = sc.nextDouble();
        user.withdrawBalance(deposit);
        user.readBalance();
    }

    public static void transfer(){
        String name;
        Double deposit;
        Scanner sc = new Scanner(System.in);
        System.out.println("¿A quien le va a transferir?");
        name = sc.nextLine();
        System.out.println("¿Cuanto desea transfeir?");
        deposit = sc.nextDouble();
        user.transferBalance(deposit, name);
        user.readBalance();
    }
}
