package fan_zone.carrinho;
import fan_zone.model.produto;

public class ItemCarrinho  {

	private produto produto;
	private int quantidade;
	
	public ItemCarrinho(produto produto, int quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
		
		
	}

	public produto getProduto() {
		return produto;
	}

	public void setProduto(produto produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public float calcularSubtotal () {
		return produto.getValor()*quantidade;
	}
	public void exibirDetalhesItem() {
		System.out.println("\nExibir detalhes do carrinho: ");
		System.out.println("Produto: "+produto.getTipo());
		System.out.println("Quantidade: "+quantidade);
		System.out.println("Subtotal: "+calcularSubtotal());
	}

}
