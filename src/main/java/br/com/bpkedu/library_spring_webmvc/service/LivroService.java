package br.com.bpkedu.library_spring_webmvc.service;

import br.com.bpkedu.library_spring_webmvc.domain.Livro;
import br.com.bpkedu.library_spring_webmvc.dto.LivroDTO;
import br.com.bpkedu.library_spring_webmvc.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }

    public Livro buscarPorId(Long id) {
        return livroRepository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado"));
    }

    public Livro salvar(LivroDTO livroDTO) {
        Livro livro = livroDTO.toLivro();
        return livroRepository.save(livro);
    }

    public void deletarPorId(Long id) {
        livroRepository.deleteById(id);
    }
}