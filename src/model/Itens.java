package model;

public class Itens {
        private Integer idInteracao;
        private Cena cena;
        private Suspeito suspeito;
        private String item;
        private String descricao;

    public Integer getIdInteracao() {
        return idInteracao;
    }

    public void setIdInteracao(Integer idInteracao) {
        this.idInteracao = idInteracao;
    }

    public Cena getCena() {
        return cena;
    }

    public void setCena(Cena cena) {
        this.cena = cena;
    }

    public Suspeito getSuspeito() {
        return suspeito;
    }

    public void setSuspeito(Suspeito suspeito) {
        this.suspeito = suspeito;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Itens{" +
                "idInteracao=" + idInteracao +
                ", cena=" + cena +
                ", suspeito=" + suspeito +
                ", item='" + item + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
