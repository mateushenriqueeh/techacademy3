package repositorio;

import model.Acusacao;
import model.Suspeito;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AcusacaoDAO {

    public static Acusacao findById(Integer id) throws SQLException {
        String sql = "SELECT * FROM acusacoes WHERE id_acusacao = ?;";
        try (Connection connection = Mysql.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                Acusacao acusacao = new Acusacao();
                acusacao.setIdAcusacao(resultSet.getInt("id_acusacao"));
                acusacao.setDescricao(resultSet.getString("descricao"));
                acusacao.setVerdadeiro(resultSet.getBoolean("verdadeiro"));

                // Relacionamento com Suspeito
                Suspeito suspeito = SuspeitoDAO.findById(resultSet.getInt("id_suspeito"));
                acusacao.setSuspeito(suspeito);

                return acusacao;
            }

            return null;
        }
    }

    public static List<Acusacao> findAll() throws SQLException {
        String sql = "SELECT * FROM acusacoes;";
        try (Connection connection = Mysql.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet resultSet = ps.executeQuery()) {

            List<Acusacao> acusacoes = new ArrayList<>();
            while (resultSet.next()) {
                Acusacao acusacao = new Acusacao();
                acusacao.setIdAcusacao(resultSet.getInt("id_acusacao"));
                acusacao.setDescricao(resultSet.getString("descricao"));
                acusacao.setVerdadeiro(resultSet.getBoolean("verdadeiro"));

                // Relacionamento com Suspeito
                Suspeito suspeito = SuspeitoDAO.findById(resultSet.getInt("id_suspeito"));
                acusacao.setSuspeito(suspeito);

                acusacoes.add(acusacao);
            }
            return acusacoes;
        }
    }

    // Métodos adicionais como update, delete, etc.
}
