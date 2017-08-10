package br.com.caelum.jdbc.modelo;

import javax.swing.JOptionPane;

public class Mensagem {

	public static void showMensagemAdicionaContato(Contato contato) {
		showMensagemContato(contato, "Contado adicionado");
	}

	public static void showMensagemAlteraContato(Contato contato) {
		showMensagemContato(contato, "Contado alterado");
	}

	public static void showMensagemExcluiContato(Contato contato) {
		showMensagemContato(contato, "Contado excluído");
	}

	public static void showMensagemContato(Contato contato) {
		showMensagemContato(contato, "Contado");
	}

	public static void showMensagemContato(Contato contato, String titulo) {

		StringBuilder mensagem = new StringBuilder();

		mensagem.append(titulo.toUpperCase()).append("\n");
		mensagem.append("Id = ").append(contato.getId()).append("\n");
		mensagem.append("Nome = ").append(contato.getNome()).append("\n");
		mensagem.append("Email = ").append(contato.getEmail()).append("\n");
		mensagem.append("Endereco = ").append(contato.getEndereco()).append("\n");
		mensagem.append("Data Nascimento = ").append(contato.getDataNascimento().getTime());

		JOptionPane.showMessageDialog(null, mensagem);
	}

}
