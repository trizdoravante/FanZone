package fan_zone.model;

import java.text.NumberFormat;
import java.util.Locale;

import fan_zone.carrinho.ItemCarrinho;

public abstract class produto {
private int codigo;//qual é o código do produto?//
private float valor; //preço do produto em questão//
private int tipo; //o tipo do produto (se é camisa, caneca, etc. é int pq vamos usar switch case//
private int estoque;//usaremos essa variável para fazer o boolean de disponibilidade da pela//
private int quantidadeCompra; //quanto daquele item o usuário vai comprar//


public produto(int codigo, float valor, int tipo, int estoque, int quantidadeCompra) {
	this.codigo = codigo;
	this.valor = valor;
	this.tipo = tipo;
	this.estoque = estoque;
}
public int getCodigo() {
	return codigo;
}
public void setCodigo(int codigo) {
	this.codigo = codigo;
}
public float getValor() {
	return valor;
}
public void setValor(float valor) {
	this.valor = valor;
}
public int getTipo() {
	return tipo;
}
public void setTipo(int tipo) {
	this.tipo = tipo;
}
public int getEstoque() {
	return estoque;
}
public void setEstoque(int estoque) {
	this.estoque = estoque;
}

public int getQuantidadeCompra() {
	return quantidadeCompra;
}
public void setQuantidadeCompra(int quantidadeCompra) {
	this.quantidadeCompra = quantidadeCompra;
}

public boolean disponibilidade(int quantidade) {
	if(quantidade<=this.getEstoque()) {
			return true;
		} else {
		System.out.println("\nParece que não temos a quantidade que você deseja no nosso estoque :(");
return false;

}
}
public void Adicionar(int codigo, int quantidade) {
	if(this.getCodigo()==codigo) {
		if(disponibilidade(quantidade)) {
			System.out.println("O produto foi adicionado ao carrinho "+this.getCodigo()+" x"+quantidade);
			
		}
		
	}else {
		System.out.println("O produto não foi encontrado.");
	}
	
	}
public boolean quantidadeRemove(int quantidade) {
	if(disponibilidade(quantidade)) {
		
		if(quantidade>0 && quantidade<= this.getQuantidadeCompra()) {
		System.out.println("A quantidade desejada foi removida com sucesso!");
		return true;
		
	} else {
		System.out.println("Quantidade inserida inválida para remoção. Observe a quantidade no carrinho.");
		return false;
	}
	}else {
		return false;
	}
}


public boolean adcCarrinho(int quantidade) {
	if(this.disponibilidade(quantidade)&& quantidade<=this.getEstoque()) {
		System.out.println("O item foi adicionado ao carrinho!");
		return true;
		
	}else {
		System.out.println("Quantidade selecionada é inferior ao estoque da loja!");
		return false;
	}
}

public void visualizar() {
	String tipo ="";
	 String valorFormatado = NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(this.valor);
	switch(this.tipo) {
	case 1:
		tipo = "BLUSAS";
		break;
	case 2:
		tipo = "MOLETONS";
		break;
	case 3:
		tipo = "CANECAS E ACESSÓRIOS DE COZINHA";
		break;
	case 4:
		tipo = "BANHO E CAMA";
		break;
	case 5:
		tipo = "DECORAÇÃO";
		break;
	case 6:
		tipo = "ACESSÓRIOS";
		break;
	}
	System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
	System.out.println("                                                                             ");
    System.out.println("||||||||||||||||||||||||||||||||DADOS DO CARRINHO||||||||||||||||||||||||||||");
    System.out.println("||||||||||||||||||||||||CÓDIGO DO PRODUTO: "+this.codigo+" ||||||||||||||||||");
    System.out.println("||||||||||||||||||||||||VALOR: "+valorFormatado+" |||||||||||||||||||||||||||||||");
    System.out.println("||||||||||||||||||||||||TIPO DO PRODUTO: "+this.tipo+"|||||||||||||||||||||||");
    System.out.println("||||||||||||||||||||||||ESTOQUE DO PRODUTO: "+this.estoque+" ||||||||||||||||");
    System.out.println("||||||||||||||||||||||||QUANTIDADE SELECIONADA PARA COMPRA: "+this.quantidadeCompra+"||||||||||||||");
    System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
	System.out.println("                                                                             ");
	System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
}
public boolean adcCarrinho() {
	
	return false;
}
public void atualizarEstoque() {
    ItemCarrinho[] itens = null;
	for (ItemCarrinho item : itens) {
        produto produto = item.getProduto();
        int quantidade = item.getQuantidade();
        produto.setEstoque(produto.getEstoque() - quantidade);
    }
}

}
