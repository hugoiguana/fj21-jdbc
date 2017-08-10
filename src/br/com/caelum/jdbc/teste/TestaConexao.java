package br.com.caelum.jdbc.teste;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.caelum.jdbc.ConectionFactory;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {

		Connection con = new ConectionFactory().getConection();
		JOptionPane.showMessageDialog(null, "Conexão aberta!");
		con.close();

	}

}
