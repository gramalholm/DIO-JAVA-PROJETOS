import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        int numero1, numero2;
        System.out.println("Digite o primeiro parametro: ");
        numero1 = terminal.nextInt();
        System.out.println("Digite o segundo parametro: ");
        numero2 = terminal.nextInt();
        try {

            comparaParametros(numero1,numero2);
        } catch (ParametrosInvalidosException e){
            System.out.println("Parametro1 maior que Parametro2 ");
            throw new RuntimeException(e);
        }
    }
    static void comparaParametros(int num1, int num2) throws ParametrosInvalidosException{
        int subtracao;
        if(num1 > num2){
            throw new ParametrosInvalidosException();
        }
        subtracao = num2 - num1;
        for(int i = 1; i<= subtracao; i++){
            System.out.println("imprimindo o numero: " + i);
        }
    }
}

