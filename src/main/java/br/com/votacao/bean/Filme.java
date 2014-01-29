package br.com.votacao.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Filme {

	private long id;
	private String nome;
	private String categoria;
	private long pontuacao;
	private String nomeImagem;

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	@Column(length = 80)
	public String getNome() {
		return nome;
	}

	@Column(length = 50)
	public String getCategoria() {
		return categoria;
	}

	public long getPontuacao() {
		return pontuacao;
	}
	

	@Column(name = "nome_imagem", length = 70)
	public String getNomeImagem() {
		return nomeImagem;
	}
	

	public void setId(long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public void setPontuacao(long pontuacao) {
		this.pontuacao = pontuacao;
	}
	
	public void setNomeImagem(String nomeImage) {
		this.nomeImagem = nomeImage;
	}

}
