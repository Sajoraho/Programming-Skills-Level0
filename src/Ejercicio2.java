package src;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args){
        int initialCurrency;
        int targetCurrency;
        String flag;
        Double amount;
        do{
            System.out.println("======== Currency Converter ========");
            System.out.println("1. CLP - Chilean Peso");
            System.out.println("2. ARS - Argentine Peso");
            System.out.println("3. USD - US Dollar");
            System.out.println("4. EUR - Euro");
            System.out.println("5. TRY - Turkish Lira");
            System.out.println("6. GBP - British Pound");
            System.out.println("7. Exit");

            Scanner sc = new Scanner(System.in);
            System.out.println("Elija su moneda actual");
            initialCurrency = sc.nextInt();

            if(initialCurrency >= 7){
                System.out.println("Que tenga un buen día");
                break;
            }

            System.out.println("Seleccione la cantidad");
            amount = sc.nextDouble();
            System.out.println("Elija la moneda a la que va a hacer la conversión");
            targetCurrency = sc.nextInt();
            if(targetCurrency < 1 || targetCurrency > 6 || targetCurrency == initialCurrency){
                System.out.println("Selección invalida, seleccione de nuevo");
                continue;
            }
            amount = currencyToUsd(initialCurrency, amount);
            amount = usdToCurrency(targetCurrency,amount);
            amount = amount + amount * 0.01;
            amount = Math.round(amount*100.0)/100.0;
            System.out.println("el dinero con la comision del 1% queda en "+amount+" "+simbolCurrency(targetCurrency));
            System.out.println("¿Desea retirarlo? (y/n)");
            flag = sc.next().toLowerCase();
            if(flag.equals("y")){
                break;
            } else {
                continue;
            }

        }while(true);
    }

    public static Double currencyToUsd(int currency, Double amount){
        return switch (currency) {
            case 1 -> amount / 887;     //CLP to USD
            case 2 -> amount / 1000;    //ARSB to USD
            case 3 -> amount;           //USD
            case 4 -> amount / 0.91;    //EUR to USD
            case 5 -> amount / 29.85;   //TRY to USD
            case 6 -> amount / 0.78;    //GBP to USD
            default -> 0.0;
        };
    }

    public static Double usdToCurrency(int currency, Double amount){
        return switch (currency) {
            case 1 -> amount * 887;    //CLP
            case 2 -> amount * 1000;   //ARSB
            case 3 -> amount;
            case 4 -> amount * 0.91;   //EUR
            case 5 -> amount * 29.85;  //TRY
            case 6 -> amount * 0.78;   // GBP
            default -> 0.0;
        };
    }

    public static String simbolCurrency(int currency){
        return switch (currency) {
            case 1 -> "CLP";
            case 2 -> "ARSB";
            case 3 -> "USD";
            case 4 -> "EUR";
            case 5 -> "TRY";
            case 6 -> "GBP";
            default -> "";
        };
    }
}
