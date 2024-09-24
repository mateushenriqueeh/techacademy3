package repositorio;

import model.Suspeito;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SuspeitoDAO {

    public static Suspeito findById(Integer id) throws SQLException {
        String sql = "SELECT * FROM suspeitos WHERE id_suspeito = ?;";
        try (Connection connection = Mysql.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                Suspeito suspeito = new Suspeito();
                suspeito.setIdSuspeito(resultSet.getInt("id_suspeito"));
                suspeito.setNome(resultSet.getString("nome"));
                suspeito.setFuncao(resultSet.getString("funcao"));
                suspeito.setDescricao(resultSet.getString("descricao"));

                return suspeito;
            }

            return null; // Caso não encontre o suspeito
        }
    }

    public static List<Suspeito> findAll() throws SQLException {
        String sql = "SELECT * FROM suspeitos;";
        try (Connection connection = Mysql.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet resultSet = ps.executeQuery()) {

            List<Suspeito> suspeitos = new ArrayList<>();
            while (resultSet.next()) {
                Suspeito suspeito = new Suspeito();
                suspeito.setIdSuspeito(resultSet.getInt("id_suspeito"));
                suspeito.setNome(resultSet.getString("nome"));
                suspeito.setFuncao(resultSet.getString("funcao"));
                suspeito.setDescricao(resultSet.getString("descricao"));

                suspeitos.add(suspeito);
            }
            return suspeitos;
        }
    }

    // Métodos adicionais como update, delete, etc.
}
