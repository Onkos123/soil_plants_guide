package br.keneitec.dio.trabalhobiologia.model;

import java.io.Serializable;

public class ClasseGeral implements Serializable {
    private int imagem;
    private String nome, apresentacao;
    private int tipo;

    public static final int TIPO_SOLO = 1;
    public static final int TIPO_PLANTA = 2;

    public ClasseGeral(int imagem, String nome, int tipo,String apresentacao) {
        this.imagem = imagem;
        this.nome = nome;
        this.apresentacao = apresentacao;
        this.tipo = tipo;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getApresentacao() {
        return apresentacao;
    }

    public void setApresentacao(String apresentacao) {
        this.apresentacao = apresentacao;
    }
}
