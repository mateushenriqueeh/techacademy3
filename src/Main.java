import com.google.gson.Gson;
import model.*;
import repositorio.*;
import spark.Spark;

import java.sql.SQLException;
import java.util.List;

public class Main {
    private static final Gson gson = new Gson();

    public static void main(String[] args) {
        Spark.port(4567); // Define a porta do servidor

        // Rota para obter todos os suspeitos
        Spark.get("/suspeitos", (req, res) -> {
            res.type("application/json");
            try {
                List<Suspeito> suspeitos = SuspeitoDAO.findAll();
                return gson.toJson(suspeitos);
            } catch (SQLException e) {
                res.status(500);
                return gson.toJson("Erro ao buscar suspeitos: " + e.getMessage());
            }
        });

        // Rota para obter um suspeito por ID
        Spark.get("/suspeito/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            res.type("application/json");
            try {
                Suspeito suspeito = SuspeitoDAO.findById(id);
                if (suspeito == null) {
                    res.status(404);
                    return gson.toJson("Suspeito não encontrado");
                }
                return gson.toJson(suspeito);
            } catch (SQLException e) {
                res.status(500);
                return gson.toJson("Erro ao buscar o suspeito: " + e.getMessage());
            }
        });

        // Rota para obter todas as acusações
        Spark.get("/acusacoes", (req, res) -> {
            res.type("application/json");
            try {
                List<Acusacao> acusacoes = AcusacaoDAO.findAll();
                return gson.toJson(acusacoes);
            } catch (SQLException e) {
                res.status(500);
                return gson.toJson("Erro ao buscar acusações: " + e.getMessage());
            }
        });

        // Rota para obter uma acusação por ID
        Spark.get("/acusacao/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            res.type("application/json");
            try {
                Acusacao acusacao = AcusacaoDAO.findById(id);
                if (acusacao == null) {
                    res.status(404);
                    return gson.toJson("Acusação não encontrada");
                }
                return gson.toJson(acusacao);
            } catch (SQLException e) {
                res.status(500);
                return gson.toJson("Erro ao buscar a acusação: " + e.getMessage());
            }
        });

        // Rota para obter todos os finais
        Spark.get("/finais", (req, res) -> {
            res.type("application/json");
            try {
                List<Final> finais = FinalDAO.findAll();
                return gson.toJson(finais);
            } catch (SQLException e) {
                res.status(500);
                return gson.toJson("Erro ao buscar finais: " + e.getMessage());
            }
        });

        // Rota para obter um final por ID
        Spark.get("/final/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            res.type("application/json");
            try {
                Final finalObj = FinalDAO.findById(id);
                if (finalObj == null) {
                    res.status(404);
                    return gson.toJson("Final não encontrado");
                }
                return gson.toJson(finalObj);
            } catch (SQLException e) {
                res.status(500);
                return gson.toJson("Erro ao buscar o final: " + e.getMessage());
            }
        });

        // Rota para obter todas as cenas
        Spark.get("/cenas", (req, res) -> {
            res.type("application/json");
            try {
                List<Cena> cenas = CenaDAO.findAll(); // Você precisará implementar o método findAll
                return gson.toJson(cenas);
            } catch (SQLException e) {
                res.status(500);
                return gson.toJson("Erro ao buscar cenas: " + e.getMessage());
            }
        });

        // Rota para obter uma cena por ID
        Spark.get("/cena/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            res.type("application/json");
            try {
                Cena cena = CenaDAO.findCenaByid(id);
                if (cena == null) {
                    res.status(404);
                    return gson.toJson("Cena não encontrada");
                }
                return gson.toJson(cena);
            } catch (SQLException e) {
                res.status(500);
                return gson.toJson("Erro ao buscar a cena: " + e.getMessage());
            }
        });

        // Rota para obter todos os itens de uma cena
        Spark.get("/itens/cena/:id", (req, res) -> {
            int idCena = Integer.parseInt(req.params(":id"));
            res.type("application/json");
            try {
                Cena cena = CenaDAO.findCenaByid(idCena);
                if (cena == null) {
                    res.status(404);
                    return gson.toJson("Cena não encontrada");
                }
                List<Itens> itens = ItensDAO.findItensByScene(cena);
                return gson.toJson(itens);
            } catch (SQLException e) {
                res.status(500);
                return gson.toJson("Erro ao buscar itens: " + e.getMessage());
            }
        });
    }
}
