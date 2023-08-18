package fan_zone;
import fan_zone.util.Cores;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import fan_zone.model.produto;
import fan_zone.model.Acessorios;
import fan_zone.model.BanhoECama;
import fan_zone.model.Blusas;
import fan_zone.model.CanecasAccCoz;
import fan_zone.model.Decoracao;
import fan_zone.model.Moletons;
import fan_zone.model.Usuario;
import fan_zone.carrinho.CarrinhoCompras;
import fan_zone.carrinho.ItemCarrinho;
public class Menu {
	private CarrinhoCompras carrinhoCompras;
	private Usuario usuario;
	public Menu(Usuario usuario, List<Blusas> blusasEmEstoque, List<Moletons> moletonsEmEstoque, List<CanecasAccCoz> canecasEmEstoque, List<BanhoECama> banhoEmEstoque, List<Decoracao> decoracaoEmEstoque, List<Acessorios> acessoriosEmEstoque) {
	this.usuario = usuario;
	carrinhoCompras = new CarrinhoCompras(usuario);
	
	}

	public static void main(String[] args) {
		
		Scanner leia = new Scanner(System.in);
		  System.out.println("Insira o nome do LogIn:");
	        String nomeDeLogin = leia.next();
	        Usuario usuario = new Usuario(nomeDeLogin);
	        
	        List<Blusas> BlusasEmEstoque = new ArrayList<>();
	        List<Moletons> MoletonsEmEstoque = new ArrayList<>();
	        List<CanecasAccCoz> CanecasEmEstoque = new ArrayList<>();
	        List<BanhoECama> BanhoEmEstoque = new ArrayList<>();
	        List<Decoracao> DecoracaoEmEstoque = new ArrayList<>();
	        List<Acessorios> AcessoriosEmEstoque = new ArrayList<>();

	        Menu menu = new Menu(usuario, BlusasEmEstoque, MoletonsEmEstoque, CanecasEmEstoque, BanhoEmEstoque, DecoracaoEmEstoque, AcessoriosEmEstoque);
	        menu.mostrarMenu(leia);
	        leia.close();
	    }

	    public void mostrarMenu(Scanner leia) {
	    	int opcaoSelecionada;
	    	int codProduto;
	    	int quantidadeProduto;
	    	produto produtoSelecionado = null;
		
		while(true) {
			System.out.println(Cores.TEXT_BLACK_BOLD+Cores.ANSI_WHITE_BACKGROUND+"|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
			System.out.println("        ▄████  ██      ▄    ▄▄▄▄▄▄   ████▄    ▄   ▄███▄                          ");
			System.out.println("        █▀   ▀ █ █      █  ▀   ▄▄▀   █   █     █  █▀   ▀                         ");
			System.out.println("        █▀▀    █▄▄█ ██   █  ▄▀▀   ▄▀ █   █ ██   █ ██▄▄                           ");
			System.out.println("        █      █  █ █ █  █  ▀▀▀▀▀▀   ▀████ █ █  █ █▄  ▄▀                         ");
			System.out.println("         █        █ █  █ █                 █  █ █ ▀███▀                          ");
			System.out.println("          ▀      █  █   ██                 █   ██                                ");
			System.out.println("                ▀                                                                ");
			System.out.println("                                                                                 ");
			System.out.println("                                       TEMOS FRETE GRÁTIS PARA TODO O BRASIL!    ");
			System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
			System.out.println("                                                                                 ");
			System.out.println("   1.  LOGIN                                                                     ");
			System.out.println("   2.  👚 BLUSAS  👚                                                              ");
			System.out.println("   3.  🧥 MOLETONS 🧥                                                              ");
			System.out.println("   4.  ☕ CANECAS E ACESSÓRIOS DE COZINHA ☕                                      ");
			System.out.println("   5.  🛏️ BANHO E CAMA 🛏️                                                         ");
			System.out.println("   6.  🖼️ DECORAÇÃO 🖼️                                                            ");
			System.out.println("   7.  💍 ACESSÓRIOS 💍                                                            ");
			System.out.println("   8.  🛒 MEU CARRINHO DE COMPRAS 🛒                                              ");
			System.out.println("   9.  FINALIZAR PEDIDO                                                           ");
			System.out.println("   10. SAIR                                                                       ");
			System.out.println("                                                                                  ");
			System.out.println("                                                                                  ");
			System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||"+Cores.TEXT_RESET);
			System.out.println("Digite sua opção: ");
			opcaoSelecionada = leia.nextInt();
			if(opcaoSelecionada==10) {
				System.out.println(Cores.TEXT_RED_BOLD+"               OBRIGADA POR COMPRAR CONOSCO, VOLTE SEMPRE!            ");
				System.out.println(Cores.TEXT_RED_BOLD+"▁ ▂ ▄ ▅ ▆ ▇ █ FANZONE, O MUNDO DOS FÃS EM UM SÓ LUGAR! █ ▇ ▆ ▅ ▄ ▂ ▁");
				leia.close();
				System.exit(0);
			}
			switch(opcaoSelecionada) {
			case 1:
				System.out.println(Cores.TEXT_BLACK_BOLD_BRIGHT+"LOGIN\n\n");
				String nomeDeLogin = "";
				System.out.println("Insira o nome do LogIn:");
				nomeDeLogin = leia.next();
				Usuario usuario1 = new Usuario(nomeDeLogin);
				CarrinhoCompras carrinhoCompra = new CarrinhoCompras(usuario1);
				break;
			case 2:
				System.out.println(Cores.TEXT_BLACK_BOLD_BRIGHT+"BLUSAS\n\n");
				System.out.println("\nInsira o tamanho desejado:");
				System.out.println("1. Pequeno.");
				System.out.println("2. Médio.");
				System.out.println("3. Grande.");
				System.out.println("4. Extra Grande.");
				int tamanhoSelect = leia.nextInt();
				
				System.out.println("\nInsira categoria desejada: ");
				System.out.println("1. Animes.");
				System.out.println("2. Games.");
				System.out.println("3.Filmes/Séries.");
				int categoriaSelect = leia.nextInt();
				List<Blusas> blusasDisponiveis = new ArrayList<>();
				List<Blusas> BlusasEmEstoque = new ArrayList<>();
				BlusasEmEstoque.add(new Blusas(131, 49.90f, 10,0,0, tamanhoSelect, categoriaSelect));
				BlusasEmEstoque.add(new Blusas (132,49.90f, 6, 0, 0, tamanhoSelect, categoriaSelect));
				BlusasEmEstoque.add(new Blusas(133, 49.90f, 9, 0,0, tamanhoSelect, categoriaSelect));				
				BlusasEmEstoque.add(new Blusas(134, 49.90f, 8,0,0, tamanhoSelect, categoriaSelect));
				BlusasEmEstoque.add(new Blusas(135, 49.90f, 7,0,0, tamanhoSelect, categoriaSelect));				
				
				
				blusasDisponiveis.add(null);
				blusasDisponiveis.add (null);
				blusasDisponiveis.add(null);
				blusasDisponiveis.add(null);
				blusasDisponiveis.add(null);
				
				for(Blusas blusas : blusasDisponiveis) {
					blusas.exibirDetalhesBlusas();
				}
				
				System.out.println("Digite o código do produto que deseja selecionar: ");
				int codigo = leia.nextInt();
				System.out.println("Digite a quantidade desejada: ");
				int quantidade = leia.nextInt();
				Blusas ProdSele = null;
				for(Blusas blusas : blusasDisponiveis) {
					
				if(blusas.getCodigo()==codigo) {
					ProdSele = blusas;
					break;
				}				
				}
				if(ProdSele != null) {
					carrinhoCompras.adicionarItem(ProdSele,quantidade);
					ProdSele.setEstoque(ProdSele.getEstoque()-quantidade);
					System.out.println("O Produto foi adicionado ao carrinho!");
				}else {
					System.out.println("O código do produto é inválido!");
				}
			
				break;
			case 3:
				System.out.println(Cores.TEXT_BLACK_BOLD_BRIGHT+"MOLETONS\n\n");
				System.out.println("\nInsira o tamanho desejado:");
				System.out.println("1. Pequeno.");
				System.out.println("2. Médio.");
				System.out.println("3. Grande.");
				System.out.println("4. Extra Grande.");
				int tamSelect = leia.nextInt();
				
				System.out.println("\nInsira categoria desejada: ");
				System.out.println("1. Animes.");
				System.out.println("2. Games.");
				System.out.println("3.Filmes/Séries.");
				int catSelect = leia.nextInt();
				List<Moletons> moletonsDisponiveis = new ArrayList<>();

				Moletons m1 =  new Moletons (1,89.90f, 5,0,0, tamSelect, catSelect);
				Moletons m2 =  new Moletons (2,89.90f, 4,0,0, tamSelect, catSelect);
				Moletons m3 =  new Moletons (3,89.90f, 3,0,0, tamSelect, catSelect);	
				Moletons m4 =  new Moletons (4,89.90f, 2, 0,0,tamSelect, catSelect);
				Moletons m5 =  new Moletons (5,89.90f, 1, 0,0,tamSelect, catSelect);
				moletonsDisponiveis.add(m1);
				moletonsDisponiveis.add(m2);
				moletonsDisponiveis.add(m3);
				moletonsDisponiveis.add(m4);
				moletonsDisponiveis.add(m5);
				for(Moletons moletons : moletonsDisponiveis) {
					moletons.exibirDetalhesMoletons();
				}

				System.out.println("Digite o código do produto que deseja selecionar: ");
				int Codigo = leia.nextInt();
				System.out.println("Digite a quantidade desejada: ");
				int Quantidade = leia.nextInt();
				Moletons prodSelec = null;
				for(Moletons moletons : moletonsDisponiveis) {
					if(moletons.getCodigo()==Codigo) {
						prodSelec = moletons;
						break;
					}
				}
				if(prodSelec != null) {
					carrinhoCompras.adicionarItem(prodSelec, Quantidade);
					prodSelec.setEstoque(prodSelec.getEstoque()-Quantidade);
					System.out.println("O Produto foi adicionado ao carrinho!");
				}else {
					System.out.println("Código de produto inválido!");
				}
				
				
				break;
			case 4:
				System.out.println(Cores.TEXT_BLACK_BOLD_BRIGHT+"CANECAS E ACESSÓRIOS DE COZINHA\n\n");
				System.out.println("\nInsira o modelo desejado:");
				System.out.println("1. Caneca.");
				System.out.println("2. Copo.");
				System.out.println("3. Prato.");
				System.out.println("4. Pano de Prato.");
				System.out.println("5. Quadros.");
				int modelSelect = leia.nextInt();
				System.out.println("\nInsira categoria desejada: ");
				System.out.println("1. Animes.");
				System.out.println("2. Games.");
				System.out.println("3.Filmes/Séries.");
				int CatSelect = leia.nextInt();
				List<CanecasAccCoz> canecasDisponiveis = new ArrayList<>();
				CanecasAccCoz cozinha1 = new CanecasAccCoz(1, 39.90f, 7,0,0, modelSelect, CatSelect);
				CanecasAccCoz cozinha2 = new CanecasAccCoz(2, 29.90f, 8,0,0, modelSelect, CatSelect);
				CanecasAccCoz cozinha3 = new CanecasAccCoz(3, 19.90f, 9,0,0, modelSelect, CatSelect);
				CanecasAccCoz cozinha4 = new CanecasAccCoz(4, 59.90f, 10,0,0, modelSelect, CatSelect);	
				CanecasAccCoz cozinha5 = new CanecasAccCoz(5, 9.90f, 11, 0, 0, modelSelect, CatSelect);
				
				canecasDisponiveis.add(cozinha1);
				canecasDisponiveis.add(cozinha2);
				canecasDisponiveis.add(cozinha3);
				canecasDisponiveis.add(cozinha4);
				canecasDisponiveis.add(cozinha5);
				for(CanecasAccCoz canecasAccCoz : canecasDisponiveis) {
					canecasAccCoz.exibirDetalhesCanecasEAcss();
				}
				
				System.out.println("Digite o código do produto que deseja selecionar: ");
				int Cod = leia.nextInt();
				System.out.println("Digite a quantidade desejada: ");
				int Quant = leia.nextInt();
				CanecasAccCoz productSelect = null;
			    for(CanecasAccCoz canecasAccCoz : canecasDisponiveis) {
			    	if(canecasAccCoz.getCodigo()==Cod) {
			    		productSelect = canecasAccCoz;
			    		break;
			    	}
			    }
			    if(productSelect !=null) {
			    	carrinhoCompras.adicionarItem(productSelect, Quant);
					productSelect.setEstoque(productSelect.getEstoque()-Quant);
					System.out.println("O Produto foi adicionado ao carrinho!");
			    }else {
			    	System.out.println("Código de produto inválido!");
			    }
				
												
				break;
			case 5:
				System.out.println(Cores.TEXT_BLACK_BOLD_BRIGHT+"BANHO E CAMA\n\n");
				System.out.println("\nInsira o modelo desejado: ");
				System.out.println("1. Fronha.");
				System.out.println("2. Lençol.");
				System.out.println("3. Cobertor.");
				System.out.println("4. Jogo de cama completo.");
				System.out.println("5. Toalhas.");
				int modeloSelect = leia.nextInt();
				
				System.out.println("\nInsira categoria desejada: ");
				System.out.println("1. Animes.");
				System.out.println("2. Games.");
				System.out.println("3.Filmes/Séries.");
				int CategoriaSelect = leia.nextInt();
				List<BanhoECama> banhoDisponiveis = new ArrayList<>();
				BanhoECama bec1 = new BanhoECama (1, 29.90f, 20,0,0, modeloSelect, CategoriaSelect);
				BanhoECama bec2 = new BanhoECama (2, 19.90f, 20,0,0, modeloSelect, CategoriaSelect);
				BanhoECama bec3 = new BanhoECama (3, 9.90f, 20,0,0, modeloSelect, CategoriaSelect);
				BanhoECama bec4 = new BanhoECama (4, 39.90f, 20,0,0, modeloSelect, CategoriaSelect);				
				BanhoECama bec5 = new BanhoECama (5, 23.90f, 20,0,0, modeloSelect, CategoriaSelect);
				BanhoECama bec6 = new BanhoECama (6, 37.90f, 20,0,0, modeloSelect, CategoriaSelect);	
				BanhoECama bec7 = new BanhoECama (7, 79.90f, 20,0,0, modeloSelect, CategoriaSelect);				
				BanhoECama bec8 = new BanhoECama (8, 99.90f, 20,0,0, modeloSelect, CategoriaSelect);				
				BanhoECama bec9 = new BanhoECama (9, 9.90f, 20,0,0, modeloSelect, CategoriaSelect);				
				BanhoECama bec10 = new BanhoECama (10, 29.90f, 20,0,0, modeloSelect, CategoriaSelect);
				banhoDisponiveis.add(bec1);
				banhoDisponiveis.add(bec2);
				banhoDisponiveis.add(bec3);
				banhoDisponiveis.add(bec4);
				banhoDisponiveis.add(bec5);
				banhoDisponiveis.add(bec6);
				banhoDisponiveis.add(bec7);
				banhoDisponiveis.add(bec8);
				banhoDisponiveis.add(bec9);
				banhoDisponiveis.add(bec10);
				for(BanhoECama banhoECama : banhoDisponiveis) {
					banhoECama.exibirDetalhesBeC();
				}
				System.out.println("Digite o código do produto que deseja selecionar: ");
				int Codig = leia.nextInt();
				System.out.println("Digite a quantidade desejada: ");
				int Quantidad = leia.nextInt();
				
				BanhoECama ProdutoSelecio = null;
				for(BanhoECama banhoECama : banhoDisponiveis) {

				if(banhoECama.getCodigo()==Codig) {
					ProdutoSelecio = banhoECama;
					break;
				}
				}
				if(ProdutoSelecio != null) {
					carrinhoCompras.adicionarItem(ProdutoSelecio, Quantidad);
					ProdutoSelecio.setEstoque(ProdutoSelecio.getEstoque()-Quantidad);
					System.out.println("O Produto foi adicionado ao carrinho!");
				}else {
					System.out.println("Código de produto inválido!");
				}
				
				
				break;
			case 6:
				System.out.println(Cores.TEXT_BLACK_BOLD_BRIGHT+"DECORAÇÃO\n\n");
				System.out.println("\nInsira o modelo desejado: ");
				System.out.println("1. Quadro.");
				System.out.println("2. Tapetes.");
				System.out.println("3. Funko.");
				int ModSelect = leia.nextInt();
				System.out.println("\nInsira categoria desejada: ");
				System.out.println("1. Animes.");
				System.out.println("2. Games.");
				System.out.println("3.Filmes/Séries.");
				int CateSelect = leia.nextInt();
				List<Decoracao> decoracaoDisponiveis = new ArrayList<>();
				Decoracao dec1 = new Decoracao(1, 34.90f, 15,0,0, ModSelect, CateSelect);			
				Decoracao dec2 = new Decoracao(2, 24.90f, 10,0,0, ModSelect, CateSelect);
				Decoracao dec3 = new Decoracao(3, 348.90f, 5,0,0, ModSelect, CateSelect);
				Decoracao dec4 = new Decoracao(4, 14.90f, 25,0,0, ModSelect, CateSelect);
				Decoracao dec5 = new Decoracao(5, 64.90f, 5,0,0, ModSelect, CateSelect);
				decoracaoDisponiveis.add(dec1);
				decoracaoDisponiveis.add(dec2);
				decoracaoDisponiveis.add(dec3);
				decoracaoDisponiveis.add(dec4);
				decoracaoDisponiveis.add(dec5);
				System.out.println("Digite o código do produto que deseja selecionar: ");
				int Codi = leia.nextInt();
				System.out.println("Digite a quantidade desejada: ");
				int Quantida = leia.nextInt();
				Decoracao produtSelecionado = null;
				for(Decoracao decoracao:  decoracaoDisponiveis) {
					if(decoracao.getCodigo()==Codi) {
						produtSelecionado = decoracao;
						break;
					}
				}
				if(produtSelecionado != null) {
					carrinhoCompras.adicionarItem(produtSelecionado, Quantida);
					produtSelecionado.setEstoque(produtSelecionado.getEstoque()-Quantida);
					System.out.println("O Produto selecionado foi adicionado ao carrinho!");
				}else {
					System.out.println("Código de produto inválido!");
				}
				
					
				break;
			case 7:
				System.out.println(Cores.TEXT_BLACK_BOLD_BRIGHT+"ACESSÓRIOS\n\n");
				System.out.println("\nInsira o modelo desejado: ");
				System.out.println("1. Colar.");
				System.out.println("2. Brinco.");
				System.out.println("3. Chaveiro.");
				int ModeloSelect = leia.nextInt();
				System.out.println("\nInsira categoria desejada: ");
				System.out.println("1. Animes.");
				System.out.println("2. Games.");
				System.out.println("3.Filmes/Séries.");
				int CategoriASelect = leia.nextInt();
				List<Acessorios> acessoriosDisponiveis = new ArrayList<>();
				Acessorios Acc1 = new Acessorios (1, 12.90f, 3,0,0, ModeloSelect, CategoriASelect);				
				Acessorios Acc2 = new Acessorios (2, 10.90f, 2,0,0, ModeloSelect, CategoriASelect);
				Acessorios Acc3 = new Acessorios (3, 7.90f, 1,0,0, ModeloSelect, CategoriASelect);
				Acessorios Acc4 = new Acessorios (4, 9.90f, 23,0,0, ModeloSelect, CategoriASelect);
				Acessorios Acc5 = new Acessorios (5, 15.90f, 10,0,0, ModeloSelect, CategoriASelect);
				acessoriosDisponiveis.add(Acc1);
				acessoriosDisponiveis.add(Acc2);
				acessoriosDisponiveis.add(Acc3);
				acessoriosDisponiveis.add(Acc4);
				acessoriosDisponiveis.add(Acc5);
				for(Acessorios acessorios : acessoriosDisponiveis) {
					acessorios.exibirDetalhesAcess();
				}
				System.out.println("Digite o código do produto que deseja selecionar: ");
				int CodiG = leia.nextInt();
				System.out.println("Digite a quantidade desejada: ");
				int Quanti = leia.nextInt();
				produtoSelecionado = null;
				for(Acessorios acessorios : acessoriosDisponiveis) {
				if(acessorios.getCodigo()==CodiG) {
					produtoSelecionado = acessorios;
					break;
				}
				}
				if (produtoSelecionado != null) {
					carrinhoCompras.adicionarItem(produtoSelecionado, Quanti);
			        produtoSelecionado.setEstoque(produtoSelecionado.getEstoque()-Quanti);
			        System.out.println("O produto selecionado foi adicionado ao carrinho!");
			    } else {
			        System.out.println("Código de produto inválido.");
			    }
				
				break;
			case 8:
				System.out.println(Cores.TEXT_BLACK_BOLD_BRIGHT+"MEU CARRINHO DE COMPRAS\n\n");
				//vou colocar a opção de visualizar, add e del//
				System.out.println("\nSelecione uma opção:");
				System.out.println("1.Adicionar Item.");
				System.out.println("2. Excluir Item.");
				System.out.println("3. Visualizar carrinho.");
				 opcaoSelecionada = leia.nextInt();
				if(opcaoSelecionada==1) {
					System.out.println("Digite o código do produto que deseja adicionar: ");
				    codProduto = leia.nextInt();
					System.out.println("Digite a quantidade desejada: ");
					 quantidadeProduto = leia.nextInt();
					
				  produtoSelecionado = obterProdutoPorCodigo(codProduto);
					if (produtoSelecionado != null) {
				        carrinhoCompras.adicionarItem(produtoSelecionado, quantidadeProduto);
				        produtoSelecionado.setEstoque(produtoSelecionado.getEstoque() - quantidadeProduto);
				        adicionarItemAoCarrinho();
				        System.out.println("Produto adicionado ao carrinho!");
				    } else {
				        System.out.println("Código de produto inválido.");
				    }
				}
				if(opcaoSelecionada==2) {
				System.out.println("Digite o código do produto que você deseja remover: ");
				int codigoRemover = leia.nextInt();
				if(carrinhoCompras.removerItemPorCodigo(codigoRemover)) {
					System.out.println("O produto selecionado foi removido do carrinho!");
				}else {
					System.out.println("O produto não foi encontrado no carrinho!");
				}
				
				
				}else {
				carrinhoCompras.exibirCarrinho();
				}
				break;
			case 9:
				System.out.println(Cores.TEXT_BLACK_BOLD_BRIGHT+"FINALIZAR PEDIDOS\n\n");
				
				carrinhoCompras.finalizarPedido();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD+"Oooop! Parece que você digitou uma opção inválida...");
			
				break;
			

			}
		}
			
			
			
		}

	

	private Acessorios obterProdutoPorCodigo(int codProduto) {
			// TODO Auto-generated method stub
			return null;
		}

	private void adicionarItemAoCarrinho() {
			// TODO Auto-generated method stub
			
		}

	public void finalizarPedido() {
		
		
	}

}
