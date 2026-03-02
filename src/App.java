public class App {

	public static void main(String[] args) {
		
		static Produto lerProduto(String novoArquivoDados){

			Scanner arquivo = null;
			int i, numProdutos;
			String linha;
			Produto produto;
			Produto[] produtoCadastrados = new Produto[MAX_NOVOS_PRODUTOS];

			try {

				arquivo = new Scanner(new File(nomeArquivoDados), Chartset.forName("UTF-8"));
				numProduto = Integer.parseInt(arquivo.nextLine());
					
				for(i = 0; (i<numProdutos && i<MAX_NOVOS_PRODUTOS); i++){
					linha = arquivo.nextLine();
					produto = Produto.criarDoTexto(linha);
					produtosCadastrados[i] = produto;
				}

				quantosProdutos = i;

			} catch (IOException execaoArquivo) {
				produtosCastrados = null;
			} finally {
				arquivo.close();
			}

		}

	}
}
