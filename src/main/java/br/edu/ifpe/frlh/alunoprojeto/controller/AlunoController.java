package br.edu.ifpe.frlh.alunoprojeto.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifpe.frlh.alunoprojeto.dao.AlunoDAO;
import br.edu.ifpe.frlh.alunoprojeto.model.Aluno;
import br.edu.ifpe.frlh.alunoprojeto.model.UnidadeFederacao;

@Controller
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	AlunoDAO alunoDAO;

	@PostMapping("/{id}/delete")
	public ModelAndView deleteAluno(@PathVariable Long id) {
		int codigo = id.intValue();
		try {
			alunoDAO.deletarAlunoDAO(codigo);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/alunos");
	}

	@PostMapping("/{id}")
	public ModelAndView update(@PathVariable Long id, @Validated Aluno aluno, BindingResult bindingResults) {
		if (bindingResults.hasErrors()) {
			ModelAndView mv = new ModelAndView("alunos/edit");
			mv.addObject("UnidadeFederacao", UnidadeFederacao.values());
			return mv;
		} else {
			int codigo = id.intValue();
			try {
				aluno.setCodigo(codigo);
				alunoDAO.alterarAlunoDAO(aluno);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				// Adicionar uma mensagem de erro ou log adequado
			}
			return new ModelAndView("redirect:/alunos");
		}
	}

	@GetMapping("/{id}/edit")
	public ModelAndView edit(@PathVariable Long id, Aluno aluno) {
		ModelAndView mv = new ModelAndView("alunos/edit");
		int codigo = id.intValue();

		try {
			aluno = alunoDAO.consultarAluno(codigo);

			if (aluno != null) {
				mv.addObject("aluno", aluno);
				mv.addObject("UnidadeFederacao", UnidadeFederacao.values());
				mv.addObject("alunoID", id);
				return mv;    
			} else {
				return new ModelAndView("redirect:/alunos"); // Caso não encontre o aluno, redireciona para a lista
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace(); // Adicione um tratamento adequado de erro
		}
		return mv;        
	}

	@PostMapping("")
	public ModelAndView createAluno(Aluno aluno, BindingResult bindingResults) {
		if (bindingResults.hasErrors()) {
			ModelAndView mv = new ModelAndView("alunos/new");
			mv.addObject("UnidadeFederacao", UnidadeFederacao.values());
			return mv;
		}

		try {
			alunoDAO.adiciona(aluno);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			// Talvez adicionar um feedback de erro ou redirecionar para uma página de erro
		}
		return new ModelAndView("redirect:/alunos");
	}

	@GetMapping("/new")
	public ModelAndView novoAluno() {
		ModelAndView mv = new ModelAndView("alunos/new");
		mv.addObject("aluno", new Aluno());        
		mv.addObject("UnidadeFederacao", UnidadeFederacao.values());
		return mv;
	}

	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("alunos/index");
		try {
			mv.addObject("alunos", alunoDAO.consultarTodosAlunos());
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace(); // Colocar um tratamento mais amigável
		}
		return mv;
	}
}
