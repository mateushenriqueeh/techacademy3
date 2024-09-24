package model;

public class Final {

    private Integer idFinal;
    private Acusacao acusacao;
    private String descricao;
    private String resultado;

    public Integer getIdFinal() {
        return idFinal;
    }

    public void setIdFinal(Integer idFinal) {
        this.idFinal = idFinal;
    }

    public Acusacao getAcusacao() {
        return acusacao;
    }

    public void setAcusacao(Acusacao acusacao) {
        this.acusacao = acusacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "Final{" +
                "idFinal=" + idFinal +
                ", acusacao=" + acusacao +
                ", descricao='" + descricao + '\'' +
                ", resultado='" + resultado + '\'' +
                '}';
    }
}
