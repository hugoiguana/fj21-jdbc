package br.com.caelum.jdbc.teste;

import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;
import br.com.caelum.jdbc.modelo.Mensagem;

public class TestaExclui {

	public static void main(String[] args) {
		
		ContatoDao contatoDao = new ContatoDao();
		
		Contato contato = new Contato();
		contato.setNome("Teste");
		contato.setEmail("teste@gmail.com");
		contato.setEndereco("Rua Teste");
		contato.setDataNascimento(Calendar.getInstance());

		contatoDao.adiciona(contato);

		contato = contatoDao.getUltimoCadastrado();
		
		Mensagem.showMensagemContato(contato);
		
	}

}
