import lombok.*;
@Setter @Getter @NoArgsConstructor
public abstract class Conta implements InterfaceConta{
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    protected int agencia;
    protected int conta;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente){
        this.agencia = Conta.AGENCIA_PADRAO;
        this.conta = SEQUENCIAL++;
        this.cliente = cliente;
    }

    public void sacar(Double valor){
        saldo -= valor;
    }

    public void depositar(Double valor){
        saldo += valor;
    }

    public void transferir(Conta contaDestino, Double valor){
        contaDestino.depositar(valor);
        this.sacar(valor);
    }

    protected void imprimirInformacoes() {
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Conta: %d", this.conta));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

    public String toString(){
        return " Clinte: " + cliente.getNome() + "," +
                "Agencia: " + agencia + "," +
                "Conta: " + conta + "," +
                "Saldo: " + saldo;
    }
}
