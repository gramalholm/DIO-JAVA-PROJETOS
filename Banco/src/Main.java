import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        while(opcao != 3){
            System.out.println("=== Bem vindo ao seu banco digital ===");
            System.out.println("O que deseja? \n1.Logar numa conta já existente \n2.Criar uma conta nova\n3.Sair");
            opcao = scanner.nextInt();
            Conta contaBanco = banco.menu(opcao);
            if(opcao == 1){
                int opcaoBanco = 0;
                while(opcaoBanco != 5){
                    System.out.println("Oque deseja fazer hoje?");
                    System.out.println("1.Sacar dinheiro\n2.Depositar dinheir\n3.Transferir para outra conta\n4.Imprimir extrato\n5.Sair");
                    opcaoBanco = scanner.nextInt();
                    banco.operacoes(opcaoBanco, contaBanco);
                }

            }
        }
        banco.listarContas();
    }
}
