public interface InterfaceConta {
    void sacar(Double valor);

    void depositar(Double valor);

    void transferir(Conta destino, Double valor);

    void imprimirExtrato();
}