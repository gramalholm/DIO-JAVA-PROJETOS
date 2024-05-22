public class Iphone {
    public static void main(String args[]){
        ReprodutorMusical reprodutorMusical = new ReprodutorMusical();
        System.out.println("Indo para o Reprodutor Musical ");
        reprodutorMusical.selecionarMusica("Talking to the moon");
        reprodutorMusical.tocar();
        reprodutorMusical.pausar();

        System.out.println(" ");

        AparelhoEletronico aparelhoEletronico = new AparelhoEletronico();
        System.out.println("Indo para o aparelho Eletronico ");
        aparelhoEletronico.ligar("22992541593");
        aparelhoEletronico.iniciarCorreioVoz();
        aparelhoEletronico.atender();

        System.out.println(" ");

        System.out.println("Indo para o navegador Internet");
        NavegadorInternet navegadorInternet = new NavegadorInternet();
        navegadorInternet.exibirPaginas("https://web.dio.me/track/santander-2024-backend-com-java");
        navegadorInternet.adicionarNovaAba();
        navegadorInternet.atualizarPagina();

    }
}
