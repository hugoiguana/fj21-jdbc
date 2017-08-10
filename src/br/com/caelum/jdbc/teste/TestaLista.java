package br.com.caelum.jdbc.teste;

import java.util.List;

import javax.swing.JOptionPane;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaLista {

	public static void main(String[] args) {

		ContatoDao contatoDao = new ContatoDao();

		List<Contato> contatos = contatoDao.getContatos();

		contatos.forEach(c -> TestaLista.showContato(c));
	}

	private static void showContato(Contato contato) {

		StringBuilder mensagem = new StringBuilder();

		mensagem.append("Id = ").append(contato.getId()).append("\n");
		mensagem.append("Nome = ").append(contato.getNome()).append("\n");
		mensagem.append("Email = ").append(contato.getEmail()).append("\n");
		mensagem.append("Endereco = ").append(contato.getEndereco()).append("\n");
		mensagem.append("Data Nascimento = ").append(contato.getDataNascimento().getTime());
		
		JOptionPane.showMessageDialog(null, mensagem);
	}

}
