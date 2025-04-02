package br.com.bpkedu.library_spring_webmvc.controller.api;

import br.com.bpkedu.library_spring_webmvc.domain.Livro;
import br.com.bpkedu.library_spring_webmvc.dto.LivroDTO;
import br.com.bpkedu.library_spring_webmvc.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/livros")
public class LivroRestController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public List<LivroDTO> listarLivros() {
        List<Livro> livros = livroService.listarTodos();
        return livros.stream()
                .map(LivroDTO::fromLivro) // Conversão correta de Livro para LivroDTO
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public LivroDTO buscarPorId(@PathVariable Long id) {
        Livro livro = livroService.buscarPorId(id);
        return LivroDTO.fromLivro(livro); // Conversão correta de Livro para LivroDTO
    }

    @PostMapping
    public LivroDTO salvarLivro(@RequestBody LivroDTO livroDTO) {
        Livro livro = livroDTO.toLivro(); // Conversão correta de LivroDTO para Livro
        Livro livroSalvo = livroService.salvar(livroDTO);
        return LivroDTO.fromLivro(livroSalvo); // Retornando o LivroDTO após salvar
    }
}