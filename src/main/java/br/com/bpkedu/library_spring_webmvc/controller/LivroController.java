package br.com.bpkedu.library_spring_webmvc.controller;

import br.com.bpkedu.library_spring_webmvc.domain.Livro;
import br.com.bpkedu.library_spring_webmvc.dto.LivroDTO;
import br.com.bpkedu.library_spring_webmvc.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List; // Certifique-se de que esta linha está presente

@Controller
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping("/listar")
    public String listarLivros(Model model) {
        List<Livro> livros = livroService.listarTodos();
        List<LivroDTO> livrosDTO = livros.stream()
                .map(LivroDTO::fromLivro)
                .toList();
        model.addAttribute("livros", livrosDTO);
        return "livros/listar";
    }

    @GetMapping("/{id:\\d+}")
    public String detalharLivro(@PathVariable Long id, Model model) {
        Livro livro = livroService.buscarPorId(id);
        LivroDTO livroDTO = LivroDTO.fromLivro(livro);
        model.addAttribute("livro", livroDTO);
        return "livros/detalhar";
    }

    @GetMapping("/novo")
    public String formularioNovoLivro(Model model) {
        model.addAttribute("livro", new LivroDTO());
        return "livros/novo";
    }

    @PostMapping("/salvar")
    public String salvarLivro(@ModelAttribute LivroDTO livroDTO) {
        livroService.salvar(livroDTO);
        return "redirect:/livros/listar";
    }

    @GetMapping("/deletar/{id:\\d+}")
    public String deletarLivro(@PathVariable Long id) {
        livroService.deletarPorId(id);
        return "redirect:/livros/listar";
    }
}