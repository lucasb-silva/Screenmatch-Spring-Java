package br.com.alura.screenmatch.controller;

import br.com.alura.screenmatch.domain.filme.DadosCadastroFilme;
import br.com.alura.screenmatch.domain.filme.Filme;
import br.com.alura.screenmatch.domain.filme.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
// Mapeando a requisição
@RequestMapping("/filmes")
public class FilmeController {

    // Repositório que manipula o BD, anotado para que seja
    // instanciado e gerenciado pelo Spring
    @Autowired
    private FilmeRepository repository;

    // Retorno de uma requisição GET
    @GetMapping("/formulario")
    public String carregaPaginaFormulario(){
        return "filmes/formulario";
    }

    // Passando a lista de filmes para a página
    @GetMapping
    public String carregaPaginaListagem(Model model){
        model.addAttribute("lista", repository.findAll());
        return "filmes/listagem";
    }

    // Cadastra um filme e redireciona para a página de listagem
    @PostMapping
    public String cadastraFilme(DadosCadastroFilme dados) {
        var filme = new Filme(dados);

        repository.save(filme);

        return "redirect:/filmes";
    }
}
