import br.com.casadocodigo.loja.dao.ProdutoDAO;
import br.com.casadocodigo.loja.models.Relatorio;

public class TesteRelatorio {

	public static void main(String[] args) {
		Relatorio relatorio = new Relatorio();
		ProdutoDAO produto = new ProdutoDAO();

		System.out.println(relatorio);

	}

}
