package repositorio;

import model.Cena;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CenaDAO {
    // Método para buscar uma cena por ID
    public static Cena findCenaByid(int id) throws SQLException {
        String sql = "SELECT * FROM cenas WHERE id_cena = ?;";
        try (Connection connection = Mysql.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                Cena cena = new Cena();
                cena.setIdCena(resultSet.getInt("id_cena"));
                cena.setDescricao(resultSet.getString("descricao"));
                cena.setTitulo(resultSet.getString("titulo"));
                return cena;
            }

            return null;
        }
    }

    // Método para buscar todas as cenas
    public static List<Cena> findAll() throws SQLException {
        String sql = "SELECT * FROM cenas;";
        try (Connection connection = Mysql.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet resultSet = ps.executeQuery()) {

            List<Cena> cenas = new ArrayList<>();
            while (resultSet.next()) {
                Cena cena = new Cena();
                cena.setIdCena(resultSet.getInt("id_cena"));
                cena.setDescricao(resultSet.getString("descricao"));
                cena.setTitulo(resultSet.getString("titulo"));
                cenas.add(cena);
            }
            return cenas;
        }
    }
}
