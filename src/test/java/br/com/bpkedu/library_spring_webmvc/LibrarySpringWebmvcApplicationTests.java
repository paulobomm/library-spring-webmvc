package br.com.bpkedu.library_spring_webmvc;

import br.com.bpkedu.library_spring_webmvc.controller.LivroController;
import br.com.bpkedu.library_spring_webmvc.service.LivroService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class LibrarySpringWebmvcApplicationTests {

    @Autowired
    private LivroController livroController;

    @Autowired
    private LivroService livroService;

    @Test
    void contextLoads() {
        // Verifica se o contexto da aplicação carrega corretamente
        assertThat(livroController).isNotNull();
        assertThat(livroService).isNotNull();
    }

    @Test
    void testSalvarLivro() {
        // Teste básico para salvar um livro no serviço
        var livroDTO = new br.com.bpkedu.library_spring_webmvc.dto.LivroDTO();
        livroDTO.setTitulo("Título de Teste");
        livroDTO.setAutor("Autor de Teste");
        livroDTO.setAnoPublicacao(2025);
        livroDTO.setIsbn("123-4567890123");
        livroDTO.setEditora("Editora de Teste");

        var livro = livroService.salvar(livroDTO);
        assertThat(livro).isNotNull();
        assertThat(livro.getId()).isNotNull();
        assertThat(livro.getTitulo()).isEqualTo("Título de Teste");
    }
}