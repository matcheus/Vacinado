package com.xpmets.vacinadoadm.Model;

public class Vacina {

    private String id;
    private String nome;
    private String informacoes;
    private int quantidadeDoses;
    private int dosesTomadas = 0;
    private String classificacao;

    public Vacina() {

    }

    public Vacina(String nome, int quantidadeDoses, String informacoes, String classificacao) {
        this.nome = nome;
        this.quantidadeDoses = quantidadeDoses;
        this.informacoes = informacoes;
        this.classificacao = classificacao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getInformacoes() {
        return informacoes;
    }

    public void setInformacoes(String informacoes) {
        this.informacoes = informacoes;
    }

    public int getQuantidadeDoses() {
        return quantidadeDoses;
    }

    public void setQuantidadeDoses(int quantidadeDoses) {
        this.quantidadeDoses = quantidadeDoses;
    }

    public int getDosesTomadas() {
        return dosesTomadas;
    }

    public void setDosesTomadas(int dosesTomadas) {
        this.dosesTomadas = dosesTomadas;
    }

}

