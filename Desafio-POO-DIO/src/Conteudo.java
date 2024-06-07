import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public abstract class Conteudo {
    public static final double XP_PADRAO = 10d;
    private String titulo;
    private String descricao;

    public abstract double calcularXp();
}
