package br.com.votacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.votacao.bean.Filme;
import br.com.votacao.repositorio.FilmeService;

@Controller
public class IndexController {
	
	@Autowired
	private FilmeService filmeService;
	
	
	@RequestMapping("/")
	public ModelAndView index(){
		ModelAndView view = new ModelAndView("index");
		view.addObject("filmes", filmeService.filmes(1,2));
		return view;
	}
	
	@RequestMapping("salvar")
	public String salvar(Filme filme){
		
		filmeService.salvar(filme);
		
		return "index";
	}
	
	
	@RequestMapping("ranking")
	public ModelAndView exibirRanking(){
		
		ModelAndView view = new ModelAndView("listar");
		view.addObject("filmes", filmeService.listAll());
		
		return view;
	}
	
	
	@RequestMapping(value = "listar", method = RequestMethod.GET)
	public @ResponseBody List<Filme> listar(@RequestParam int init, @RequestParam int max){
		return filmeService.filmes(init, max);
	}
	
	
	@RequestMapping(value = "votar", method = RequestMethod.POST)
	public @ResponseBody String votar(@RequestParam long idFilme){

		filmeService.votar(idFilme);
		
		return "success";
	}

	
	

}
