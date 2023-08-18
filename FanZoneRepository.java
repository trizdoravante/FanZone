package fan_zone.repository;
import java.util.List;

import fan_zone.model.produto;

import fan_zone.model.produto;
public interface FanZoneRepository {


public void adicionarProduto (int adcCarrinho);
public void verItens (int visualizar);
public void removerProduto (int quantidadeRemove);

void adicionarProduto(produto produto);

List<produto> verItens();


}
