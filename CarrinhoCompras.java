package fan_zone.carrinho;
import fan_zone.model.Acessorios;
import fan_zone.model.BanhoECama;
import fan_zone.model.Blusas;
import fan_zone.model.CanecasAccCoz;
import fan_zone.model.Decoracao;
import fan_zone.model.Moletons;
import fan_zone.model.Usuario;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import fan_zone.model.produto;


public class CarrinhoCompras {
	Scanner leia = new Scanner(System.in);
	String resposta;
	private Usuario usuario;
	private List<ItemCarrinho>itens;
	private List<Acessorios>listaAcessorios;
	private List<BanhoECama>listaBanhoECama;
	private List<Blusas>listaBlusas;
	private List<CanecasAccCoz>listaCanecasAccCoz;
	private List<Decoracao>listaDecoracao;
	private List<Moletons>listaMoletons;
	private CarrinhoCompras carrinhoCompras;
	
	public CarrinhoCompras(Usuario usuario) {
		this.usuario = usuario;
		this.itens = new ArrayList<>();
		this.listaAcessorios = new ArrayList<>();
		this.listaBanhoECama = new ArrayList<>();
		this.listaBlusas = new ArrayList<>();
		this.listaCanecasAccCoz = new ArrayList<>();
		this.listaDecoracao = new ArrayList<>();
		this.listaMoletons = new ArrayList<>();
		
		
	}
	public CarrinhoCompras() {
		
	}
	public void adicionarItem(produto produtoItem, int quantidade) {
	    for (ItemCarrinho item : itens) {
	        if (item.getProduto().equals(produtoItem)) {
	            item.setQuantidade(item.getQuantidade() + quantidade);
	            return;
	        }
	    }

	    ItemCarrinho novoItem = new ItemCarrinho(produtoItem, quantidade);
	    itens.add(novoItem);
	}
	public void removerItem(ItemCarrinho item) {
		itens.remove(item);
	}
	public float CalcularTotal () {
		float total = 0;
		for (ItemCarrinho item : itens) {
			total+= item.calcularSubtotal();
			
		}
		return total;
	}
		
		public void atualizarEstoque() {
	        for (ItemCarrinho item : itens) {
	            produto produto = item.getProduto();
	            int quantidade = item.getQuantidade();
	            produto.setEstoque(produto.getEstoque() - quantidade);
	        }
	}
	public void finalizarPedido() {
		float valorTotal = CalcularTotal();
		System.out.println("\nValor total da compra: "+formatarValorMoeda(valorTotal));
		Scanner leia = new Scanner (System.in);
		System.out.println("Deseja confirmar o pagamento? (S/N)");
		resposta = leia.next();
		if(resposta.equalsIgnoreCase("S")){
			System.out.println("\nProcessando pagamento...");
			boolean pagamentoConfirmado = true;
			if(pagamentoConfirmado) {
			atualizarEstoque();	
			itens.clear();
			System.out.println("\nSeu pedido foi finalizado com sucesso!");
			System.out.println("\nღ(¯`◕‿◕´¯) ♫ ♪ ♫ OBRIGADA POR COMPRAR CONOSCO! ♫ ♪ ♫ )¯´◕‿◕`¯(ღ");
			}
			
		}else {
			System.out.println("Pedido não finalizado. Itens permanecem no carrinho.");
		}
		
	}
	private String formatarValorMoeda(float valorTotal) {
		 String valorFormatado = NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(valorTotal);
		return null;
	}
	public void exibirCarrinho() {
		System.out.println("O carrinho de compras de: "+usuario.getNomeDeLogin());
		if(itens.isEmpty()) {
			System.out.println("O carrinho está vazio!");
		}else {
			System.out.println("\nItens no carrinho: ");
			for(ItemCarrinho item: itens) {
				produto produtoItem = item.getProduto();
				System.out.println("Produto: "+produtoItem.getCodigo()+"- Quantidade"+item.getQuantidade());
				item.exibirDetalhesItem();
			}
			System.out.println("Total: "+carrinhoCompras.CalcularTotal());
		}
	}
	
	 private void adicionarItemAoCarrinho() {
	        System.out.println("Digite o código do produto que deseja adicionar: ");
	        int codProduto = leia.nextInt();
	        int quantidadeProduto = leia.nextInt();
	        produto produtoSelecionado = obterProdutoPorCodigo(codProduto);

	        if (produtoSelecionado != null) {
	            adicionarItem(produtoSelecionado, quantidadeProduto);
	            produtoSelecionado.setEstoque(produtoSelecionado.getEstoque() - quantidadeProduto);
	            System.out.println("Produto adicionado ao carrinho!");
	        } else {
	            System.out.println("Código de produto inválido.");
	        }
	    }
	private produto obterProdutoPorCodigo(int codProduto) {
		for(Acessorios acessorios : listaAcessorios) {
			if(acessorios.getCodigo()==codProduto) {
				return acessorios;
			}
		}
		
		for(BanhoECama banhoECama: listaBanhoECama) {
			if(banhoECama.getCodigo()==codProduto) {
				return banhoECama;
			}
		}
		for(Moletons moletons: listaMoletons) {
			if(moletons.getCodigo()==codProduto) {
				return moletons;
			}
		}
		for(Blusas blusas: listaBlusas) {
			if(blusas.getCodigo()==codProduto) {
				return blusas;
			}
		}
		for(CanecasAccCoz canecasAccCoz: listaCanecasAccCoz) {
			if(canecasAccCoz.getCodigo()==codProduto) {
				return canecasAccCoz;
			}
		}
		for(Decoracao decoracao: listaDecoracao) {
			if(decoracao.getCodigo()==codProduto) {
				return decoracao;
			}
		}
		return null;
			}
	public boolean removerItemPorCodigo(int codigoProduto) {
		for(ItemCarrinho item : itens) {
			if(item.getProduto().getCodigo()==codigoProduto) {
				int quantidadeRemover = item.getQuantidade();
				produto produto = item.getProduto();
				produto.setEstoque(produto.getEstoque() + quantidadeRemover);
				itens.remove(item);
				return true;
			}
		}
		return false;
	}
	private ItemCarrinho[] getCarrinho() {
		// TODO Auto-generated method stub
		return null;
	}
	public void adicionarItem(Acessorios produtoSelecionado, int quantidade) {
		listaAcessorios.add(produtoSelecionado);
		adicionarItem(produtoSelecionado, quantidade);
		
	}
	public void adicionarItem(Decoracao produtSelecionado, int quantida) {
		listaDecoracao.add(produtSelecionado);
		adicionarItem(produtSelecionado, quantida);
	}
	public void adicionarItem(BanhoECama produtoSelecio, int quantidad) {
		listaBanhoECama.add(produtoSelecio);
		adicionarItem(produtoSelecio, quantidad);
		
	}
	public void adicionarItem(CanecasAccCoz productSelect, int quant) {
		listaCanecasAccCoz.add(productSelect);
		adicionarItem(productSelect, quant);
		
	}
	public void adicionarItem(Moletons prodSelec, int quantidade) {
	listaMoletons.add(prodSelec);
	adicionarItem(prodSelec, quantidade);
		
	}
	public void adicionarItem(Blusas prodSele, int quantidade) {
		listaBlusas.add(prodSele);
		adicionarItem(prodSele, quantidade);
	}

		
	}


