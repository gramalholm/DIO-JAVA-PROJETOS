import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor
public class Mentoria extends Conteudo {
    private LocalDate data;


    @Override
    public String toString() {
        return "Mentoria{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", data=" + getData() +
                '}';
    }

    @Override
    public double calcularXp() {
        return XP_PADRAO+20;
    }
}
