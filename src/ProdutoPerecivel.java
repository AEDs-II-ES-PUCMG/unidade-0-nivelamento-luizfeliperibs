import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class ProdutoPerecivel extends Produto {

    private double DESCONTO = 0.25;
    private int PRAZO_DESCONTO = 7;
    private LocalDate dataDeValidade;

    public ProdutoPerecivel(String desc, double precoCusto, double margemLucro, LocalDate dataDeValidade) {
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
    public String gerarDadosTexto(){
        String precoFormatado = String.format("%.2f", precoCusto).replace(",",".");
        String margemFormatada = String.format("%.2f", margemLucro).replace(",",".");
        return String.format("1;%s;%s;%s", descricao, precoFormatado, margemFormatada);
    }

    /**
    * Gera uma linha de texto a partir dos dados do produto
    * @return Uma string no formato "tipo; descrição;preçoDeCusto;margemDeLucro;[dataDeValidade]"
    */

    @Override
    public String toString() {

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String dados = super.toString();
        dados += "\nValido até " + formato.format(dataDeValidade);
        return dados;

    }

}
