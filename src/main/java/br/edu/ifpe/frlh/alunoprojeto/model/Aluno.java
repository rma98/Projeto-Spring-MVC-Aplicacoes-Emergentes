package br.edu.ifpe.frlh.alunoprojeto.model;

import javax.persistence.*;

@Entity
@Table(name = "aluno") // opcional, pode deixar sem se quiser que o nome da tabela siga o nome da classe
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    private String nome;
    private String endereco;
    private String cidade;

    @Enumerated(EnumType.STRING)
    private UnidadeFederacao unidadeFederacao;

    private String uf;

    public Aluno() {
    }

    public Aluno(int codigo, String nome, String end, String cidade, String uf) {
        this.codigo = codigo;
        this.nome = nome;
        this.endereco = end;
        this.cidade = cidade;
        this.unidadeFederacao = UnidadeFederacao.fromUF(uf);
    }

    // Getters e setters abaixo

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public UnidadeFederacao getUnidadeFederacao() {
        return unidadeFederacao;
    }

    public void setUnidadeFederacao(UnidadeFederacao uf) {
        this.unidadeFederacao = uf;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        setUnidadeFederacao(UnidadeFederacao.fromSigla(uf));
        this.uf = uf;
    }

    @Override
    public String toString() {
        return this.nome + " " + this.endereco + " " + this.cidade;
    }
}
