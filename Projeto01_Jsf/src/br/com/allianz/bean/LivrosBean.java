package br.com.allianz.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.allianz.dao.LivrosDao;
import br.com.allianz.models.Livro;

@ManagedBean(name="beanLivro")
@RequestScoped
public class LivrosBean {

	private Livro livro;

	public LivrosBean() {
		if(livro==null) {
			livro = new Livro();
		}
	}
	
	
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	//method de a��o (action) que quando executado retorna o
//	redirecionamento conforme o resultado da execu��o
	public String incluirLivro() {
		try {
			new LivrosDao().IncluirLivro(livro);
			return "sucesso";
		} catch (Exception e) {
			return "erro";
		}
		
	}
	
	//apresentar os livros cadastrados
	 public List<Livro> getListaLivros() throws Exception{
		 List<Livro> lista =  new LivrosDao().listarLivros();
		 return lista;
	 }
}
