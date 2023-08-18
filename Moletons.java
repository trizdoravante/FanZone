package fan_zone.model;

import java.text.NumberFormat;
import java.util.Locale;

import fan_zone.carrinho.ItemCarrinho;

public class Moletons extends produto {
	private int tamanho, categoria;

	public Moletons(int codigo, float valor, int tipo, int estoque, int quantidadeCompra, int tamanho, int categoria) {
		super(codigo, valor, tipo, estoque, quantidadeCompra);
		this.tamanho = tamanho;
		this.categoria = categoria;
	}
//aqui vão ficar os moletons//

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	@Override
	public boolean adcCarrinho() {
		if(this.getQuantidadeCompra()<=this.getEstoque()) {
			System.out.println("O item foi adicionado ao carrinho!");
			return true;
			//add vetor do carrinho de compras assim que a classe for criada//
			
		}else {
			System.out.println("Quantidade selecionada é inferior ao estoque da loja!");
			return false;
		}
}
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Tamanho: "+this.tamanho);
		System.out.println("Categoria: "+this.categoria);
	}
	@Override
	public boolean quantidadeRemove(int quantidade) {
		if(quantidade>0 && quantidade<= this.getQuantidadeCompra()) {
			System.out.println("A quantidade desejada foi removida com sucesso!");
			return true;
			
		} else {
			System.out.println("Quantidade inserida inválida para remoção. Observe a quantidade no carrinho.");
			return false;
		}
	}
	public void exibirDetalhesMoletons() {
		String valorFormatado = NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(this.getValor());
		System.out.println("Detalhes do Moletom: ");
		System.out.println("Código: "+getCodigo());
		System.out.println("Valor: "+valorFormatado);
		System.out.println("Estoque: "+getEstoque());
		System.out.println("Tamanho: "+tamanho);
		System.out.println("Categoria: "+categoria);
	}
	@Override
	public void atualizarEstoque() {
	    ItemCarrinho[] itens = null;
		for (ItemCarrinho item : itens) {
	        produto produto = item.getProduto();
	        int quantidade = item.getQuantidade();
	        produto.setEstoque(produto.getEstoque() - quantidade);
	    }
	}
}
