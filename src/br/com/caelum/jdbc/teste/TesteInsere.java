package br.com.caelum.jdbc.teste;

import java.util.Calendar;

import javax.swing.JOptionPane;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TesteInsere {

	public static void main(String[] args) {

		ContatoDao contatoDao = new ContatoDao();
		
		Contato contato = new Contato();
		contato.setNome("Hugo");
		contato.setEmail("hugo.iguanaa@gmail.com");
		contato.setEndereco("Rua Franscisco silveira de andrade. N13");
		contato.setDataNascimento(Calendar.getInstance());

		contatoDao.adiciona(contato);
		
		contato = new Contato();
		contato.setNome("Aline");
		contato.setEmail("aline.lucia@gmail.com");
		contato.setEndereco("Rua Franscisco silveira de andrade. N13");
		contato.setDataNascimento(Calendar.getInstance());
		
		contatoDao.adiciona(contato);
		
		contato = new Contato();
		contato.setNome("Tiago");
		contato.setEmail("tiago.gomees@gmail.com");
		contato.setEndereco("Rua beleza. N13");
		contato.setDataNascimento(Calendar.getInstance());
		
		contatoDao.adiciona(contato);
		
		JOptionPane.showMessageDialog(null, "Contato inserido com sucesso!");
	}

}
