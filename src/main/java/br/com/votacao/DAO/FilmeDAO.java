package br.com.votacao.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.votacao.bean.Filme;

@Repository
@Transactional
public class FilmeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	

	@SuppressWarnings("unchecked")
	public List<Filme> listAll(int init, int max) {
		
		Criteria crit = getSession().createCriteria(Filme.class);
		
		crit.setFirstResult(init);
		crit.setMaxResults(max);
		
		return crit.list();
	}

	public void salvar(Filme filme) {
		getSession().save(filme);
		
	}

	public Filme getById(long idFilme) {
		return (Filme) getSession().get(Filme.class, idFilme);
	}

	@SuppressWarnings("unchecked")
	public List<Filme> listAll() {
		
		Criteria crit = getSession().createCriteria(Filme.class);
		
		crit.addOrder(Order.desc("pontuacao"));
		
		return crit.list();
	}

	public void update(Filme filme) {
		getSession().update(filme);		
	}


}