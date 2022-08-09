package br.com.dominio.model;

import java.util.Arrays;
import java.util.List;

import br.com.medicamento.controller.AlunoController;
import br.com.medicamento.model.Aluno;

public class Program {

	public static void main(String[] args) {
		
		Aluno a1 = new Aluno();
		a1.setId(null);
		a1.setName("Matheus");

		Aluno a3 = new Aluno();
		a3.setId(null);
		a3.setName("Nazaré");
		
		AlunoController conn = new AlunoController();
		
		conn.begin();
		
		// salvando
//		conn.save(a1);
//		conn.save(a2);
//		conn.save(a3);
		
		
		// buscando por ID 
		Aluno aluno; 
		aluno = conn.findById(Aluno.class, 1);
		System.out.println("\n\n");
		System.out.println(aluno.getName());
		
		
		// buscando lista de alunos
		
		List<Aluno> alunos = conn.findAll();	
		
		System.out.println(Arrays.toString(alunos.toArray()));
		
		conn.carregar();
		System.out.println("lista: " + conn.getAlunos());
		
		conn.close();
	
	}
}
