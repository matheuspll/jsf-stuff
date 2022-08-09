package br.com.vendas.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

// Classe para buscar configurações do arquivo persistence.xml e criar uma instancia que gerencia os beans e reliza operações com o banco de dados
// O objetivo dessa classe é retornar um EntityManager
public class ConnectionFactory {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("vendasTest");
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
