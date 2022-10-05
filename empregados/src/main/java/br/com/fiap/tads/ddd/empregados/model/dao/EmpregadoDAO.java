package br.com.fiap.tads.ddd.empregados.model.dao;

import java.lang.invoke.MethodHandles;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import br.com.fiap.tads.ddd.empregados.model.Empregado;
import br.com.fiap.tads.ddd.empregados.model.repository.Repository;

public class EmpregadoDAO extends Repository {

	private static final Logger log = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

	public static List<Empregado> findAll() {

		log.info("Finding all Empregados.");
		
		List<Empregado> retorno = new ArrayList<>();
		String sql = "SELECT * from DDD_EMPREGADO";
		log.info(sql);

		PreparedStatement ps = null;

		ResultSet rs = null;

		try {
			ps = getConnection().prepareStatement(sql);
			rs = ps.executeQuery();

			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					// @formatter:off
 					retorno.add(new Empregado(
								rs.getLong("ID"),
								rs.getString("NOME"),
								rs.getDate("DATA_ADMISSAO")!=null?rs.getDate("DATA_ADMISSAO").toLocalDate():null, 
								rs.getDouble("SALARIO"),
								rs.getDate("DATA_DESLIGAMENTO")!=null? rs.getDate("DATA_DESLIGAMENTO").toLocalDate():null
								));
 					// @formatter:on
				}
			} else {
				log.info("Nao temos empregados cadastrados no banco de dados.");
			}
			return retorno;
		} catch (SQLException e) {
			log.info("Nao foi possivel consultar as empregados disponiveis:  " + retorno + "-" + e.getMessage());

		} finally {
			try {
				if (ps != null)
					ps.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				log.info("Erro ao tentar fechar o Statment ou o ResultSet");
			}
		}
		return retorno;
	}

	public static Empregado save(Empregado empregado) {

		log.info("Persisting the new empregado: " + empregado);

		// Colocando SQL numa transaaction para pegar o id da empregado inserida
		String sql = "begin INSERT INTO DDD_EMPREGADO(id, NOME, DATA_ADMISSAO, SALARIO, DATA_DESLIGAMENTO) VALUES (sq_empregado.nextval,?,?,?,?) returning id into ?;  end;";

		CallableStatement s = null;
		try {
			s = getConnection().prepareCall(sql);
			s.setString(1, empregado.getNome());
			s.setObject(2, empregado.getDataAdmissao());
			s.setDouble(3, empregado.getSalario());
			s.setObject(4, empregado.getNome());
			s.registerOutParameter(5, java.sql.Types.INTEGER);
			s.executeUpdate();
			empregado.setId((long) s.getInt(5));
			return empregado;
		} catch (SQLException e) {
			log.info("Erro ao salvar a empregado o banco de dados: " + e.getMessage());
		} finally {
			try {
				if (s != null)
					s.close();
			} catch (SQLException e) {
				log.info("Erro ao tentar fechar o Statment ");
			}
		}
		return null;
	}

	public static Empregado findById(long id) {

		log.info("Finding Empregado by id: " + id);

		Empregado retorno = new Empregado();

		String sql = "SELECT * from DDD_EMPREGADO where ID=?";

		log.info(sql);

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = getConnection().prepareStatement(sql);
			ps.setLong(1, id);
			rs = ps.executeQuery();

			if (rs.isBeforeFirst()) {

				while (rs.next()) {

					// @formatter:off
 					retorno =new Empregado(
							rs.getLong("ID"),
							rs.getString("NOME"),
							rs.getDate("DATA_ADMISSAO")!=null?rs.getDate("DATA_ADMISSAO").toLocalDate():null, 
							rs.getDouble("SALARIO"),
							rs.getDate("DATA_DESLIGAMENTO")!=null? rs.getDate("DATA_DESLIGAMENTO").toLocalDate():null
							);
 					// @formatter:on
				}
			} else {
				log.info("Nao temos dados cadastrados no banco de dados.");
			}
			return retorno;
		} catch (SQLException e) {
			log.info("Nao foi possivel consultar as empregados disponiveis: \n" + retorno + "\n\n" + e.getMessage());
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				log.info("Erro ao tentar fechar o Statment ou o ResultSet");
			}
		}
		return retorno;
	}

}
