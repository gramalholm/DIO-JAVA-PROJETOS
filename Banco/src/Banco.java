import Exceptions.CpfInvalidoException;
import Exceptions.SenhaMenorQue8Exception;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Banco {
    private Map<String,Conta> contasBanco;

    public Banco() {
        this.contasBanco = new HashMap<>();
    }

    public Conta menu(int opcao){
        Scanner scanner = new Scanner(System.in);
        switch (opcao){
            case 1:
                return logarConta();
            case 2:
                return adicionarConta();
        }
        return null;
    }

    private Conta logarConta(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cpf: ");
        String cpfCliente = scanner.next();
        System.out.println("Senha: ");
        String senhaCliente = scanner.next();

        try{
            verificaSenha(senhaCliente);
        }catch (SenhaMenorQue8Exception e){
            System.out.println("Sua senha deve ter no minimo 8 caracteres!");
        }

        Conta contaBanco = verificarExistenciaCliente(cpfCliente, senhaCliente);
        if(contaBanco != null){
            System.out.println("Bem vindo " + contaBanco.cliente.getNome() + "!");
            return contaBanco;
        }
        else{
            System.out.println("Conta Inexistente");
            return null;
        }
    }

    private Conta adicionarConta(){
        Scanner scanner = new Scanner(System.in);
        Cliente clienteNovo = new Cliente();
        System.out.println("=== Criação de conta ===");
        System.out.println("Digite seu nome: ");
        clienteNovo.setNome(scanner.next());

        System.out.println("Digite seu cpf: ");
        clienteNovo.setCpf(scanner.next());
        if(contasBanco.containsKey(clienteNovo.getCpf())){
            System.out.println("Cpf já cadastrado");
        }
        else {
            try {
                verificaCpf(clienteNovo.getCpf());
            } catch (CpfInvalidoException e) {
                System.out.println("Cpf inválido");
            }

            System.out.println("Digite sua senha: ");
            clienteNovo.setSenha(scanner.next());
            try {
                verificaSenha(clienteNovo.getSenha());
            } catch (SenhaMenorQue8Exception e) {
                throw new RuntimeException("Senha deve ter no mínimo 8 caracteres");
            }

            System.out.println("Deseja Criar:\n1.Conta Corrente\n2.Conta Poupança");
            int opcaoConta = scanner.nextInt();
            if(opcaoConta == 1){
                ContaCorrente novaContaBanco = new ContaCorrente(clienteNovo);
                contasBanco.put(novaContaBanco.cliente.getCpf(), novaContaBanco);
                System.out.println("Conta Criada!");
                return novaContaBanco;
            }
            else{
                ContaPoupanca novaContaBanco = new ContaPoupanca(clienteNovo);
                contasBanco.put(novaContaBanco.cliente.getCpf(), novaContaBanco);
                System.out.println("Conta Criada!");
                return novaContaBanco;
            }
        }
        return null;
    }

    private void verificaCpf(String cpf) throws CpfInvalidoException {
        if(cpf.length() < 11){
            throw new CpfInvalidoException();
        }
    }

    private void verificaSenha(String senha) throws SenhaMenorQue8Exception {
        if(senha.length() < 8){
            throw new SenhaMenorQue8Exception();
        }
    }

    private Conta verificarExistenciaCliente(String cpf, String senha){
        for(Conta conta: contasBanco.values()){
            if(conta.cliente.getCpf().equals(cpf) && conta.cliente.getSenha().equals(senha)){
                return conta;
            }
        }
        return null;
    }

    private boolean verificaExistenciaConta(int numeroConta){
        for(Conta conta: contasBanco.values()){
            if(conta.getConta() == numeroConta){
                return true;
            }
        }
        return false;
    }

    private Conta acharContaBaseadaNumero(int numeroConta){
        for(Conta conta: contasBanco.values()){
            if(conta.getConta() == numeroConta){
                return conta;
            }
        }
        return null;
    }

    public void operacoes(int opcaoBanco, Conta contaBanco){
        Scanner scanner = new Scanner(System.in);
            switch (opcaoBanco){
                case 1:
                    System.out.println("Digite o valor que deseja sacar: ");
                    double saque = scanner.nextDouble();
                    contaBanco.sacar(saque);
                    break;
                case 2:
                    System.out.println("Digite o valor que deseja depositar: ");
                    double deposito = scanner.nextDouble();
                    contaBanco.depositar(deposito);
                    break;
                case 3:
                    System.out.println("Digite o valor que deseja transferir: ");
                    double transferencia = scanner.nextDouble();
                    System.out.println("Digite o numero da conta que deseja transferir: ");
                    int contaTransferencia = scanner.nextInt();
                    boolean verificacao = verificaExistenciaConta(contaTransferencia);
                    if(verificacao) {
                        contaBanco.transferir(acharContaBaseadaNumero(contaTransferencia), transferencia);
                    }
                    else{
                        System.out.println("A conta digitada não existe");
                    }
                    break;
                case 4:
                    contaBanco.imprimirExtrato();
        }
    }

    public void listarContas(){
        System.out.println(contasBanco);
    }
}
