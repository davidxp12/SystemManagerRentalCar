package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.AcessoBD;
import model.Cliente;
import model.PessoaFisica;


public class PessoaFisicaDao extends Cliente{
	
     public boolean cadastrar (PessoaFisica novo){
		
		String strSqlQuery = "INSERT INTO tb_clientepf( nome, telefone, email, endereco, cpf, rg, sexo, datanascimento, " +
            "cnh, datavalida, categoria, estadoemissor, passaporte)  VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		
		Connection conn = null;
		
		PreparedStatement stm = null;
			
		try
		{
			conn = AcessoBD.obtemConexao();
			
			stm = conn.prepareStatement(strSqlQuery);
			
			//stm.setInt(1,  novo.getId());
			stm.setString(1, novo.getNome());
			stm.setString(2, novo.getTelefone());
			stm.setString(3, novo.getEmail());
			stm.setString(4, novo.getEndereco());
			stm.setString(5, novo.getCpf());
			stm.setString(6, novo.getRg());			
			stm.setString(7, novo.getSexo());
			stm.setString(8, novo.getDtNascimento());
			stm.setString(9, novo.getCnh());
			stm.setString(10, novo.getDataValida());
			stm.setString(11, novo.getCategoria());
			stm.setString(12, novo.getEstadoEmissor());
			stm.setString(13, novo.getPassaporte());
			
			stm.executeUpdate();
			
			return true;
			
		}
		catch (Exception e)	
		{
			e.printStackTrace();
			
			try
			{
				conn.rollback();
				
				return false;
				
			}
			catch (SQLException sqlEx)
			{
								
				return false;
			}
		}
		finally
		{
			if (stm != null)
			{
				try
				{
					stm.close();
										
				}
				catch (SQLException sqlEx)
				{
					
					return false;
				}
			}
		}				
		
	}
	//
	public List<PessoaFisica> obterClientesFisicos(String nome, String cpf) {

		ArrayList<PessoaFisica> resultado = new ArrayList<PessoaFisica>();
		java.sql.Connection conn = null;

		String sqlSelect;

		PreparedStatement stm = null;
		ResultSet rs = null;

		sqlSelect = "SELECT * FROM tb_clientepf"
				+ " WHERE nome like  ? AND cpf  like ?";

		if (nome == "") {
			nome = "%";
		}
		if (cpf == "") {
			cpf = "%";
		}

		try {
			conn = AcessoBD.obtemConexao();

			stm = conn.prepareStatement(sqlSelect);
			stm.setString(1, nome);
			stm.setString(2, cpf);

			rs = stm.executeQuery();

			while (rs.next()) {

				PessoaFisica clientepf = new PessoaFisica();

				clientepf.setCategoria(rs.getString("categoria"));
				clientepf.setCnh(rs.getString("cnh"));
				clientepf.setId(rs.getInt("id"));
				clientepf.setCpf(rs.getString("cpf"));
				clientepf.setDtNascimento(rs.getString("datanascimento"));
				clientepf.setDtValidade(rs.getString("datavalida"));
				clientepf.setEmail(rs.getString("email"));
				clientepf.setEndereco(rs.getString("endereco"));
				clientepf.setEstadoEmissor(rs.getString("estadoemissor"));
				clientepf.setNome(rs.getString("nome"));
				clientepf.setPassaporte(rs.getString("passaporte"));
				clientepf.setRg(rs.getString("rg"));
				clientepf.setSexo(rs.getString("sexo"));
				clientepf.setTelefone(rs.getString("telefone"));

				resultado.add(clientepf);
			}

			return resultado;

		} catch (Exception e) {
			e.printStackTrace();
			return resultado;
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (Exception e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}
	}

	public boolean alterarClienteFisico(PessoaFisica pessoaFisicaAtualizada) {
		String sqlInsert =  "UPDATE tb_clientepf set nome = ? , telefone = ? , email = ?, endereco = ? , " +
				"cpf = ? ,rg = ? , sexo = ?, datanascimento = ? , cnh =? ,datavalidade = ? , categoria = ?," +
				"estadoemissor = ? ," +
				" passaporte = ?   where id = ?";

		Connection conn = null;
		PreparedStatement stm = null;

		try {
			// Obtem a conex�o
			conn = AcessoBD.obtemConexao();

			stm = conn.prepareStatement(sqlInsert);
 
		    stm.setString(1, pessoaFisicaAtualizada.getNome());
		    stm.setString(2, pessoaFisicaAtualizada.getTelefone());
		    stm.setString(3, pessoaFisicaAtualizada.getEmail());
		    stm.setString(4, pessoaFisicaAtualizada.getEndereco());
		    stm.setString(5, pessoaFisicaAtualizada.getCpf());
		    stm.setString(6, pessoaFisicaAtualizada.getRg());
		    stm.setString(7, pessoaFisicaAtualizada.getSexo());
		    stm.setString(8, pessoaFisicaAtualizada.getDtNascimento());
		    stm.setString(9, pessoaFisicaAtualizada.getCnh());
		    stm.setString(10, pessoaFisicaAtualizada.getDataValida());
		    stm.setString(11, pessoaFisicaAtualizada.getCategoria());
		    stm.setString(11, pessoaFisicaAtualizada.getEstadoEmissor());
		    stm.setString(12, pessoaFisicaAtualizada.getPassaporte());
		    stm.setInt(13, pessoaFisicaAtualizada.getId());
			
			stm.executeUpdate();

			return true;

		}

		catch (Exception e) {
			e.printStackTrace();

			try {
				conn.rollback();

				return false;

			} catch (SQLException sqlEx) {
				return false;
			}
		} finally {
			if (stm != null) {
				try {
					stm.close();

				} catch (SQLException sqlEx) {

					return false;
				}
			}
		}
	}

	
	public void excluirClienteFisico(int id) {
		
		String sqlDelete = "DELETE FROM tb_clientepf WHERE id = ?";

		java.sql.Connection conn = null;
		
		PreparedStatement stm = null;
		
		try
		{
			
			conn = AcessoBD.obtemConexao();
			
			stm = conn.prepareStatement(sqlDelete);
			
			stm.setInt(1, id);
			
			stm.execute();

		}
		
		catch (Exception e)
		{
			e.printStackTrace();
			try
			{
				conn.rollback();
			} 
			catch (SQLException e1)
			{
				System.out.print(e1.getStackTrace());
			}
		}
		finally 
		{
			if (stm != null)
			{
				try 
				{
					stm.close();
				}
				catch (SQLException e1)
				{
					System.out.print(e1.getStackTrace());
				}
			}
		}
	}

}