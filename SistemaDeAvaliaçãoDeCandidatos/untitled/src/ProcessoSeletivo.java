import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
public class ProcessoSeletivo {

    public static void main(String[] args){
        analizarCandidato(1900.00);
        String[] selecionadosEntrevista = selecaoCandidatoEntrevista();
        selecaoCandidatoVaga(selecionadosEntrevista);
        for(String selecionado: selecionadosEntrevista){
            entrandoEmContato(selecionado);
        }
    }

    public static void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do{
            atendeu = atender();
            continuarTentando = !atendeu;
            if(continuarTentando){
                tentativasRealizadas ++;
            }
            else{
                System.out.println("CONTATO REALIZADO COM SUCESSO");
            }
        }while(continuarTentando && tentativasRealizadas < 3);
        if(atendeu){
            System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativasRealizadas + " TENTATIVA");
        }
        else{
            System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato +  ",NÚMERO MAXIMO TENTATIVAS " + tentativasRealizadas + "REALIZADO");
        }

    }

    static boolean atender(){
        return new Random().nextInt(3) == 1;
    }

    static void selecaoCandidatoVaga(String[] candidatosSelecionados){
        String[] selecionados = candidatosSelecionados.clone();
        for(String candidato : selecionados){
            if(candidato == null) {
                break;
            }
            System.out.println("O(A) candidato(a) " + candidato + " foi selecionado para a vaga");
        }
    }

    static String[] selecaoCandidatoEntrevista(){
        String[] candidatos = {"Felipe","Marcia", "Juliana", "Alessandra", "Gabriel", "Lana", "Michelle"};
        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.00;
        int contador = 0;
        int i = 0;
        String [] selecionados = new String[5];

        while(candidatosSelecionados < 5 && candidatoAtual < candidatos.length){
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();
            if(salarioPretendido <= salarioBase){
                selecionados[i] = candidatos[contador];
                System.out.println("O(A) candidato(a) " + candidato + " foi selecionado para a entrevista");
                i++;
            }
            candidatoAtual ++;
            contador ++;
        }
        return selecionados;
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analizarCandidato(double salario){
        double salarioBase = 2000.00;
        if(salario < salarioBase){
            System.out.println("LIGAR PARA O CANDIDATO");
        }
        else if(salario == salarioBase){
            System.out.println("LIGAR PARA O CANDIDATO, COM CONTRA PROPOSTA");
        }
        else{
            System.out.println("AGUARDANDO RESULTADO DOS DEMAIS CANDIDATOS.");
        }
    }
}
