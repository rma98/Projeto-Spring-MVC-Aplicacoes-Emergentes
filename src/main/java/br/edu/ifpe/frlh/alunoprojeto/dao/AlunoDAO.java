package br.edu.ifpe.frlh.alunoprojeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.edu.ifpe.frlh.alunoprojeto.model.Aluno;



@Repository
public class AlunoDAO {

	public void adiciona(Aluno aluno) throws ClassNotFoundException, SQLException {
		 //conectamos no banco 
		 Connection connection = ConexaoMySQL.getConexaoMySQL();
       String sql = "INSERT INTO `aluno`"
       		+ "( `nome`, `endereco`, `cidade`, `uf`) "
       		+ "VALUES (  ? , ? , ? , ?)"; 	 
   	 //prepara��o da declara��o
       PreparedStatement stmt = connection.prepareStatement(sql);

      // stmt.setInt(1, aluno.getCodigo());
       stmt.setString(1, aluno.getNome());
       stmt.setString(2, aluno.getEndereco());
       stmt.setString(3, aluno.getCidade());
       stmt.setString(4, aluno.getUnidadeFederacao().sigla());

       stmt.execute();
       stmt.close();
       connection.close();
    }
	
	public List<Aluno> consultarTodosAlunos() throws ClassNotFoundException, SQLException{
		 Connection connection = ConexaoMySQL.getConexaoMySQL();
		 String sql = "SELECT `codigo`, `nome`, `endereco`, `cidade`, `uf` FROM `aluno`"; 
	     PreparedStatement stmt = connection.prepareStatement(sql);

	     ResultSet resultSet = stmt.executeQuery();

	     List<Aluno> listaTodosAlunos = new ArrayList<Aluno>();

	     while(resultSet.next()) {

	    	 Aluno aluno = new Aluno();  

	        int codigo = resultSet.getInt("codigo");
	        aluno.setCodigo(codigo);  	        
	        String nome = resultSet.getString(2);
	        aluno.setNome(nome);	        
	        aluno.setEndereco(resultSet.getString(3));
	        aluno.setCidade(resultSet.getString(4));
	        aluno.setUf(resultSet.getString(5));

	        listaTodosAlunos.add(aluno);
	     }	     
		 return listaTodosAlunos;

	 }
	 
	public Aluno consultarAluno(int codigo) throws ClassNotFoundException, SQLException {
		 Connection connection = ConexaoMySQL.getConexaoMySQL();
		 String sql = "SELECT * FROM `aluno` WHERE codigo = ? ";

		 PreparedStatement stmt = connection.prepareStatement(sql);
		 stmt.setInt(1, codigo);

		 ResultSet resultSet = stmt.executeQuery();

		 Aluno aluno = new Aluno(); 
		 if(resultSet.next()) {

			 aluno.setCodigo(resultSet.getInt(1));
			 aluno.setNome(resultSet.getString(2));
			 aluno.setEndereco(resultSet.getString(3));
			 aluno.setCidade(resultSet.getString(4));
			 aluno.setUf2(resultSet.getString(5));
		 }		 
		 return aluno;		 
	 }
	
	public void alterarAlunoDAO(Aluno aluno) throws ClassNotFoundException, SQLException {
		 Connection connection = ConexaoMySQL.getConexaoMySQL();
		 String sql = "UPDATE `aluno` SET `nome`= ?,`endereco`= ?,"
		 		+ "`cidade`= ?,`uf`= ? WHERE codigo = ?";

		 PreparedStatement stmt = connection.prepareStatement(sql);

	        stmt.setString(1, aluno.getNome());
	        stmt.setString(2, aluno.getEndereco());
	        stmt.setString(3, aluno.getCidade());
	        stmt.setString(4, aluno.getUf());
	        stmt.setInt(5, aluno.getCodigo());

	        stmt.executeUpdate();
	        stmt.close();
	        connection.close();

	 }
	
	public void deletarAlunoDAO(int codigo) throws ClassNotFoundException, SQLException {
		 Connection connection = ConexaoMySQL.getConexaoMySQL();
		 String sql = "DELETE FROM `aluno` WHERE codigo = ?";

		 PreparedStatement stmt = connection.prepareStatement(sql);

		 stmt.setInt(1, codigo);

		 stmt.execute();
		 stmt.close();
		 connection.close();

	 }
}
