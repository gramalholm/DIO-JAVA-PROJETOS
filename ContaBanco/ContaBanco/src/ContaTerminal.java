import java.util.Scanner;
import java.util.Locale;

public class ContaTerminal {
    String nome;
    String agencia;
    int numeroBanco;
    float saldoBanco;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        ContaTerminal cliente = new ContaTerminal();
        System.out.println("Digite seu nome ");
        cliente.nome = scanner.nextLine();
        System.out.println("Digite seu agencia ");
        cliente.agencia = scanner.nextLine();
        System.out.println("Digite o numero da conta: ");
        cliente.numeroBanco = scanner.nextInt();
        System.out.print("Saldo: ");
        cliente.saldoBanco = scanner.nextFloat();
        
        System.out.print("Olá " + cliente.nome + " ");
        System.out.print("obrigado por criar uma conta em nosso banco, sua agência é " + cliente.agencia + " ");
        System.out.print("conta " + cliente.numeroBanco + " ");
        System.out.print("e seu saldo " + "R$" + cliente.saldoBanco + " já está disponível para saque");
    }
}
