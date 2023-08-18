package fan_zone.model;
import fan_zone.carrinho.CarrinhoCompras;


public class Usuario {
private String nomeDeLogin;

public Usuario(String nomeDeLogin) {
	this.nomeDeLogin = nomeDeLogin;
}

public String getNomeDeLogin() {
	return nomeDeLogin;
}

public void setNomeDeLogin(String nomeDeLogin) {
	this.nomeDeLogin = nomeDeLogin;
}

}
