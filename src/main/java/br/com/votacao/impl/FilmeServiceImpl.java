package br.com.votacao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.votacao.DAO.FilmeDAO;
import br.com.votacao.bean.Filme;
import br.com.votacao.repositorio.FilmeService;

@Service
public class FilmeServiceImpl implements FilmeService {

	@Autowired
	private FilmeDAO filmeDAO;

	
	
	public List<Filme> filmes(int init, int max){
		return filmeDAO.listAll(init, max);
	}
	

	public void salvar(Filme filme) {
		filmeDAO.salvar(filme);		
	}
	
	

	public void votar(long idFilme) {
		
		Filme filme = filmeDAO.getById(idFilme);
		
		long pontuacao = filme.getPontuacao();
		pontuacao += 1;
		
		filme.setPontuacao(pontuacao);
		
		filmeDAO.update(filme);
	}
	
	

	public List<Filme> listAll() {
		return filmeDAO.listAll();
	}

}
