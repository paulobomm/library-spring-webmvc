package br.com.bpkedu.library_spring_webmvc.repository;

import br.com.bpkedu.library_spring_webmvc.domain.Livro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class LivroRepositoryTests {

    @Autowired
    private LivroRepository livroRepository;

    @Test
    void testFindByTitulo() {
        // Salva um Livro de exemplo
        Livro livro = new Livro("Livro Teste", "Autor Teste", 2025, "123-4567890123", "Editora Teste");
        livroRepository.save(livro);

        // Testa buscar pelo título
        Optional<Livro> livroEncontrado = livroRepository.findByTitulo("Livro Teste");
        assertThat(livroEncontrado).isPresent(); // Verifica se o Livro foi encontrado
        assertThat(livroEncontrado.get().getTitulo()).isEqualTo("Livro Teste");
    }
}