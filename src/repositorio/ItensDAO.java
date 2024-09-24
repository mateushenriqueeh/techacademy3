package repositorio;

import model.Cena;
import model.Itens;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItensDAO {
    public static List<Itens> findItensByScene(Cena cena) throws SQLException {
        String sql = "SELECT * FROM itens WHERE id_cena = ?;";

        try (Connection connection = Mysql.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, cena.getIdCena());
            ResultSet resultSet = ps.executeQuery();

            List<Itens> itens = new ArrayList<>();

            while (resultSet.next()) {
                Itens item = new Itens();
                item.setIdInteracao(resultSet.getInt("id_interacao"));
                item.setItem(resultSet.getString("item"));
                item.setDescricao(resultSet.getString("descricao"));

                // Setando a cena
                Cena cenaAtual = new Cena();
                cenaAtual.setIdCena(resultSet.getInt("id_cena"));
                item.setCena(cenaAtual);

                // Adicionando o item à lista
                itens.add(item);
            }

            return itens;
        }
    }
}
