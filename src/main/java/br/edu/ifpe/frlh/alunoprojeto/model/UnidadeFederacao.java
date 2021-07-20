package br.edu.ifpe.frlh.alunoprojeto.model;

public enum UnidadeFederacao {

	  AMAZONAS("Amazonas", "AM", "Manaus"),
	  ALAGOAS("Alagoas", "AL", "MaceiÃ³"),
	  ACRE("Acre", "AC", "Rio Branco"),
	  AMAPA("AmapÃ¡", "AP", "MacapÃ¡"),
	  BAHIA("Bahia", "BA", "Salvador"),
	  PARA("ParÃ¡", "PA", "BelÃ©m"),
	  MATO_GROSSO("Mato Grosso", "MT", "CuiabÃ¡"),
	  MINAS_GERAIS("Minas Gerais", "MG", "Belo Horizonte"),
	  MATO_GROSSO_DO_SUL("Mato Grosso do Sul", "MS", "Campo Grande"),
	  GOIAS("GoiÃ¡s", "GO", "GoiÃ¢nia"),
	  MARANHAO("MaranhÃ£o", "MA", "SÃ£o LuÃ­s"),
	  RIO_GRANDE_DO_SUL("Rio Grande do Sul", "RS", "Porto Alegre"),
	  TOCANTINS("Tocantins", "TO", "Palmas"),
	  PIAUI("PiauÃ­", "PI", "Teresina"),
	  SAO_PAULO("SÃ£o Paulo", "SP", "SÃ£o Paulo"),
	  RONDONIA("RondÃ´nia", "RO", "Porto Velho"),
	  RORAIMA("Roraima", "RR", "Boa Vista"),
	  PARANA("ParanÃ¡", "PR", "Curitiba"),
	  CEARA("CearÃ¡", "CE", "Fortaleza"),
	  PERNAMBUCO("Pernambuco", "PE", "Recife"),
	  SANTA_CATARINA("Santa Catarina", "SC", "FlorianÃ³polis"),
	  PARAIBA("ParaÃ­ba", "PB", "JoÃ£o Pessoa"),
	  RIO_GRANDE_DO_NORTE("Rio Grande do Norte", "RN", "Natal"),
	  ESPIRITO_SANTO("EspÃ­rito Santo", "ES", "VitÃ³ria"),
	  RIO_DE_JANEIRO("Rio de Janeiro", "RJ", "Rio de Janeiro"),
	  SERGIPE("Sergipe", "SE", "Aracaju"),
	  DISTRITO_FEDERAL("Distrito Federal", "DF", "BrasÃ­lia");

	  private final String nome;
	  private final String sigla;
	  private final String capital;

	  /**
	   * Construtor do enum
	   *
	   * @param nome    nome da unidade da federaÃ§Ã£o completo
	   * @param sigla   sigla da unidade da federaÃ§Ã£o
	   * @param capital nome da capital da unidade da federaÃ§Ã£o
	   */
	  UnidadeFederacao(final String nome, final String sigla, final String capital) {
	    this.nome = nome;
	    this.sigla = sigla;
	    this.capital = capital;
	  }

	  /**
	   * Converte a partir do nome da Unidade da Federacao, para o respectivo enum.
	   *
	   * @param nomeUf o nome da Unidade da FederaÃ§Ã£o. Exemplo: "SÃ£o Paulo"
	   * @return o enum da Unidade da FederaÃ§Ã£o
	   * @throws IllegalArgumentException caso nÃ£o ache o enum pelo nome da UF
	   */
	  public static UnidadeFederacao fromUF(final String nomeUf) {
	    for (final UnidadeFederacao uf : UnidadeFederacao.values()) {
	      if (uf.nome.equalsIgnoreCase(nomeUf)) {
	        return uf;
	      }
	    }

	    throw new IllegalArgumentException(nomeUf);
	  }

	  /**
	   * Converte a partir da Sigla da UF no parÃ¢metro, para o enum da Unidade da FederaÃ§Ã£o.
	   *
	   * @param sigla da Unidade da FederaÃ§Ã£o. Exemplo: "MG"
	   * @return a Unidade da FederaÃ§Ã£o
	   * @throws IllegalArgumentException caso a sigla da UF nÃ£o exista
	   */
	  public static UnidadeFederacao fromSigla(final String sigla) {
	    for (final UnidadeFederacao uf : UnidadeFederacao.values()) {
	      if (uf.sigla.equalsIgnoreCase(sigla)) {
	        return uf;
	      }
	    }

	    throw new IllegalArgumentException(sigla);
	  }

	  /**
	   * Converte, a partir do nome da capital da UF, para o Enum.
	   *
	   * @param capital da Unidade da FederaÃ§Ã£o. Exemplo: "Porto Alegre"
	   * @return a Unidade da Federacao com a capital passada no parÃ¢metro
	   * @throws IllegalArgumentException caso o nome da capital nÃ£o exista
	   */
	  public static UnidadeFederacao fromCapital(final String capital) {
	    for (final UnidadeFederacao uf : UnidadeFederacao.values()) {
	      if (uf.capital.equalsIgnoreCase(capital)) {
	        return uf;
	      }
	    }

	    throw new IllegalArgumentException(capital);
	  }

	  /**
	   * ObtÃ©m a sigla da UF
	   *
	   * @return a sigla da UF
	   */
	  public String sigla() {
	    return this.sigla;
	  }

	  /**
	   * Nome completo da UF
	   *
	   * @return nome completo da UF
	   */
	  public String nome() {
	    return this.nome;
	  }
  public String getNome() {
	  return this.nome;
  }
	  /**
	   * Nome da capital da UF
	   *
	   * @return nome da capital da UF
	   */
	  public String capital() {
	    return this.capital;
	  }

	  @Override
	  public String toString() {
	    final StringBuilder sb = new StringBuilder("UnidadeFederacao{");
	    sb.append("nome='").append(nome).append('\'');
	    sb.append(", sigla='").append(sigla).append('\'');
	    sb.append(", capital='").append(capital).append('\'');
	    sb.append('}');
	    return sb.toString();
	  }
	  
}
