package repositorio;

import model.Acusacao;
import model.Final;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FinalDAO {

    public static Final findById(Integer id) throws SQLException {
        String sql = "SELECT * FROM final WHERE id_final = ?;";
        try (Connection connection = Mysql.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                Final finalObj = new Final();
                finalObj.setIdFinal(resultSet.getInt("id_final"));
                finalObj.setDescricao(resultSet.getString("descricao"));
                finalObj.setResultado(resultSet.getString("resultado"));

                // Relacionamento com Acusacao
                Acusacao acusacao = AcusacaoDAO.findById(resultSet.getInt("id_acusacao"));
                finalObj.setAcusacao(acusacao);

                return finalObj;
            }

            return null;
        }
    }

    public static List<Final> findAll() throws SQLException {
        String sql = "SELECT * FROM final;";
        try (Connection connection = Mysql.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet resultSet = ps.executeQuery()) {

            List<Final> finais = new ArrayList<>();
            while (resultSet.next()) {
                Final finalObj = new Final();
                finalObj.setIdFinal(resultSet.getInt("id_final"));
                finalObj.setDescricao(resultSet.getString("descricao"));
                finalObj.setResultado(resultSet.getString("resultado"));

                // Relacionamento com Acusacao
                Acusacao acusacao = AcusacaoDAO.findById(resultSet.getInt("id_acusacao"));
                finalObj.setAcusacao(acusacao);

                finais.add(finalObj);
            }
            return finais;
        }
    }

    // Métodos adicionais como update, delete, etc.
}

