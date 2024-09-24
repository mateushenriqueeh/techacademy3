package model;

import java.util.List;

public class Cena {
    private Integer idCena;
    private String titulo;
    private String descricao;
    private List<Itens>itens;

    public Integer getIdCena() {
        return idCena;
    }

    public void setIdCena(Integer idCena) {
        this.idCena = idCena;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Itens> getItens() {
        return itens;
    }

    public void setItens(List<Itens> itens) {
        this.itens = itens;
    }

    @Override
    public String toString() {
        return "Cena{" +
                "idCena=" + idCena +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", itens=" + itens +
                '}';
    }


}

