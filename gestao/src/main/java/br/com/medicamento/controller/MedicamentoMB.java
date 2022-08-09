package br.com.medicamento.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.medicamento.model.Medicamento;
import br.com.medicamento.service.MedicamentoService;
import br.com.vendas.utility.Message;
import br.com.vendas.utility.NegocioException;

@Named
@ViewScoped
public class MedicamentoMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject 
	private Medicamento medicamento; // ao inserir no formulário é injetado um medicamento
	
	@Inject 
	private MedicamentoService service;
	
	private List<Medicamento> medicamentos;
	
	@PostConstruct // é um método que é invocado logo após a injeção de dependencia 
	public void carregar() {
		medicamentos = service.findAll();
	}
	
	
	public void adicionar() {
		try {
			service.save(medicamento); 
			medicamento = new Medicamento(); // limpa a variavel medicamento / formulário
			carregar(); // carrega a lista de medicamentos ao salvar
			
			Message.info("Salvo com sucesso");
		} catch (NegocioException e) {
			Message.erro(e.getMessage());
		}
	}
	
	
	public void excluir() {
		try {
			service.remove(medicamento);
			carregar();
			
			Message.info(medicamento.getName() + " foi removido");
			
		} catch (NegocioException e) {
			Message.erro(e.getMessage());
		}
	}


	public Medicamento getMedicamento() {
		return medicamento;
	}


	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}


	public List<Medicamento> getMedicamentos() {
		return medicamentos;
	}	
	
}
