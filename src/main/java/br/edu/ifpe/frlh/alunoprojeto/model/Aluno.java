package br.edu.ifpe.frlh.alunoprojeto.model;



public class Aluno {

	private int codigo;
	
	private String nome;
	private String endereco;
	private String cidade;
	private UnidadeFederacao unidadeFederacao;
	private String uf;
	public Aluno(int codigo, String nome, String end, String cidade, String uf) {
		// TODO Auto-generated constructor stub
		this.codigo = codigo;
		this.nome = nome;
		this.endereco = end;
		this.cidade = cidade;
		this.unidadeFederacao = UnidadeFederacao.fromUF(uf);
	}
	public Aluno() {
		// TODO Auto-generated constructor stub
	}
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

    public void setUf(String uf) {
    	setUnidadeFederacao(UnidadeFederacao.fromSigla(uf));
		this.uf = uf;
	}
    public void setUf2(String uf) {
    	setUnidadeFederacao(UnidadeFederacao.fromSigla(uf));
		this.uf = uf;
	}
	public String getUf() {
		return uf;
	}
	@Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return this.nome + " " + 
    	this.endereco + " " +
    	this.cidade ;
    }

}
