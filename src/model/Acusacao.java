package model;

public class Acusacao {
    private Integer idAcusacao;
    private Suspeito suspeito;
    private String descricao;
    private Boolean verdadeiro;

    public Integer getIdAcusacao() {
        return idAcusacao;
    }

    public void setIdAcusacao(Integer idAcusacao) {
        this.idAcusacao = idAcusacao;
    }

    public Suspeito getSuspeito() {
        return suspeito;
    }

    public void setSuspeito(Suspeito suspeito) {
        this.suspeito = suspeito;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getVerdadeiro() {
        return verdadeiro;
    }

    public void setVerdadeiro(Boolean verdadeiro) {
        this.verdadeiro = verdadeiro;
    }

    @Override
    public String toString() {
        return "Acusacao{" +
                "idAcusacao=" + idAcusacao +
                ", suspeito=" + suspeito +
                ", descricao='" + descricao + '\'' +
                ", verdadeiro=" + verdadeiro +
                '}';
    }
}
