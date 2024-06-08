import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso curso = new Curso();
        curso.setTitulo("Curso Java Básico");
        curso.setDescricao("Curso para ensinar o básico da linguagem Java");
        curso.setCargaHoraria(50);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria de código");
        mentoria.setDescricao("Ajuda para os necessitados");
        mentoria.setData(LocalDate.now());
        /*System.out.println(curso);
        System.out.println(mentoria);
         */
        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso);
        bootcamp.getConteudos().add(mentoria);
        System.out.println("------------------------------------------------------------------------------");
        Dev devGabriel = new Dev();
        devGabriel.setNome("Gabriel");
        devGabriel.inscreverBootcamp(bootcamp);
        System.out.println("Conteudos inscritos: " + devGabriel.getConteudosInscritos());
        devGabriel.progredir();
        System.out.println("Conteudos inscritos: " + devGabriel.getConteudosInscritos());
        System.out.println("Conteudos concluidos: " + devGabriel.getConteudosConcluidos());
        System.out.println("Xp: " + devGabriel.calcularXp());

        System.out.println("------------------------------------------------------------------------------");

        Dev devAlessandra = new Dev();
        devAlessandra.setNome("Alessandra");
        devAlessandra.inscreverBootcamp(bootcamp);
        System.out.println("Conteudos inscritos: " + devAlessandra.getConteudosInscritos());
        devAlessandra.progredir();
        System.out.println("Conteudos inscritos: " + devAlessandra.getConteudosInscritos());
        System.out.println("Conteudos concluidos: " + devAlessandra.getConteudosConcluidos());
        System.out.println("Xp: " + devGabriel.calcularXp());

        System.out.println("------------------------------------------------------------------------------");
    }
}
