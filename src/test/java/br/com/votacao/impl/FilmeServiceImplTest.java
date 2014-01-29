package br.com.votacao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.votacao.DAO.FilmeDAO;
import br.com.votacao.bean.Filme;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class FilmeServiceImplTest {


	@Autowired
	private FilmeDAO filmeDAO;

	
	@Test
	public void notNullTest() {
		assertNotNull(filmeDAO);
	}
	
	
	@Test
	public void savaTest(){

		Filme f1 = new Filme();
		f1.setNome("Gravidade");
		filmeDAO.salvar(f1);
		
		Filme f2 = new Filme();
		f1.setNome("Batman");
		filmeDAO.salvar(f2);
		
		Filme f3 = new Filme();
		f1.setNome("Atividade Paranormal");
		filmeDAO.salvar(f3);
		
		assertEquals(3, filmeDAO.listAll().size());
		
	}
	
	@Test
	public void listAllPaginadoTest(){
		assertEquals(2, filmeDAO.listAll(0, 2).size());
	}
	
	
	@Test
	public void getBayIdTest(){
		
		assertNotNull(filmeDAO.getById(1));
		
		assertEquals("Gravidade", filmeDAO.getById(1).getNome());
		
	}
	
	
	@Test
	public void updateTest(){

		Filme filme = filmeDAO.getById(1);
		
		assertEquals("Gravidade", filme.getNome());
		
		filme.setNome("Gravidade II");
		
		filmeDAO.update(filme);
		
		assertEquals("Gravidade II", filmeDAO.getById(1).getNome());
		
	}
	
	
	
	
}
