package br.com.vendas.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.vendas.dao.DAO;
import br.com.vendas.model.Pessoa;
import br.com.vendas.utility.BusinessException;

public class PessoaService implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject // Ponto de injeção
	private DAO<Pessoa> pessoaDao;
	
	// propagando o tratamento da exceção para o managedBean(Controller)
	// try catch trata a exceção no mesmo local. throws propaga
	public void save(Pessoa pessoa) {
		if (pessoa.getNome().length() < 2) {
			throw new BusinessException("O Nome não pode ter menos que duas letras");
		}		
		pessoaDao.save(pessoa);		
	}
	
	public void remove(Pessoa pessoa) throws BusinessException {
		pessoaDao.remove(Pessoa.class, pessoa.getId()); // similar ao JpaRepository<E, Id>
	}
	
	// buscando todos as pessoas usando jpsql
	public List<Pessoa> findAll() {
		return pessoaDao.findAll("select p from Pessoa p order by p.nome"); // trata a Entidade de modelo ao invés da relacional = classe.
	}

}
