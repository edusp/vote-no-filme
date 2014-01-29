package br.com.votacao.repositorio;

import java.util.List;

import br.com.votacao.bean.Filme;

public interface FilmeService {
	
	public List<Filme> filmes(int init, int max);
	
	public List<Filme> listAll();
	
	public void salvar(Filme filme);
	
	public void votar(long idFilme);
	

}
