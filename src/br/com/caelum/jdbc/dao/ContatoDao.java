package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.ConectionFactory;
import br.com.caelum.jdbc.modelo.Contato;

public class ContatoDao {

	private Connection con;

	public ContatoDao() {
		super();
		this.con = new ConectionFactory().getConection();
	}

	public List<Contato> getContatos() {

		try {

			List<Contato> contatos = new ArrayList<Contato>();

			String sql = "SELECT * FROM contatos";

			PreparedStatement stmt = this.con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("data_nascimento"));
				contato.setDataNascimento(data);

				contatos.add(contato);
			}

			rs.close();
			stmt.close();

			return contatos;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Contato getUltimoCadastrado() {

		try {

			String sql = "SELECT * FROM contatos ORDER BY id DESC LIMIT 1";

			PreparedStatement stmt = this.con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			rs.next();
			
			Contato contato = new Contato();
			contato.setId(rs.getLong("id"));
			contato.setNome(rs.getString("nome"));
			contato.setEmail(rs.getString("email"));
			contato.setEndereco(rs.getString("endereco"));

			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("data_nascimento"));
			contato.setDataNascimento(data);

			rs.close();
			stmt.close();

			return contato;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void adiciona(Contato contato) {

		try {

			StringBuilder sql = new StringBuilder();

			sql.append(" INSERT INTO contatos");
			sql.append(" (nome, email, endereco, data_nascimento)");
			sql.append(" VALUES (?, ?, ?, ?)");

			PreparedStatement stmt = this.con.prepareStatement(sql.toString());

			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void altera(Contato contato) {

		StringBuilder sql = new StringBuilder();

		sql.append(" UPDATE contatos");
		sql.append(" SET nome=?, email=?, endereco=?, data_nascimento=?");
		sql.append(" WHERE id=?");

		try {

			PreparedStatement stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());

			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void exclui(Long id) {

		try {

			PreparedStatement stmt = this.con.prepareStatement("DELETE FROM contatos WHERE id = ?");

			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
