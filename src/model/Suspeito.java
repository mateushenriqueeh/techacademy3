package model;

public class Suspeito {
    private Integer idSuspeito;
    private String nome;
    private String funcao;
    private String descricao;

    public Integer getIdSuspeito() {
        return idSuspeito;
    }

    public void setIdSuspeito(Integer idSuspeito) {
        this.idSuspeito = idSuspeito;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Suspeito{" +
                "idSuspeito=" + idSuspeito +
                ", nome='" + nome + '\'' +
                ", funcao='" + funcao + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
