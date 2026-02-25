import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class ProdutoPerecivel extends Produto {

    private double DESCONTO = 0.25;
    private int PRAZO_DESCONTO = 7;
    private LocalDate dataDeValidade;

    public ProdutoPerecivel(String desc, double precoCusto, double margemLucro, LocalDate dataDeValidade, double DESCONTO, int PRAZO_DESCONTO) {
        super(desc, precoCusto, margemLucro);

        if(dataDeValidade.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("O produto está vencido!");
        } else {
            this.dataDeValidade = dataDeValidade;
        }

    }

    public double valorVenda() {
        double desconto = 0d;
        int tempoDesconto = LocalDate.now().until(dataDeValidade).getDays();
        if(tempoDesconto<=PRAZO_DESCONTO){
            desconto = DESCONTO;
        }
        return(precoCusto * (1.0 + margemLucro))*(1-desconto);
    }

    @Override
    public String toString() {

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String dados = super.toString();
        dados += "\nValido até " + formato.format(dataDeValidade);
        return dados;

    }

}
