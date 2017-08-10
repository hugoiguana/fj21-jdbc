package br.com.caelum.jdbc.teste;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;
import br.com.caelum.jdbc.modelo.Mensagem;

public class TestaAltera {

	public static void main(String[] args) {

		ContatoDao contatoDao = new ContatoDao();
		Contato contato = contatoDao.getUltimoCadastrado();
		
		Mensagem.showMensagemContato(contato);
	
		contato.setEndereco("Rua teste");
		
		contatoDao.altera(contato);
		
		Mensagem.showMensagemContato(contato);
	}

}
