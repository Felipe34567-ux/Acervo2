package br.joaquim.acervo.aplicacao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.joaquim.acervo.entidade.Biblioteca;
import br.joaquim.acervo.entidade.Livro;
import br.joaquim.acervo.repositorio.BibliotecaRepository;
import br.joaquim.acervo.repositorio.LivroRepository;

@Component
public class ConsoleApp {

    @Autowired
	private LivroRepository livroRepository;

    @Autowired
    private BibliotecaRepository biblRepository;

    public void iniciar() {
        System.out.println("Olá mundo");
		
		

        Biblioteca b = new Biblioteca(1, "Jocas", null);
        b = biblRepository.save(b);

        Livro l1 = new Livro(1, "A volta dos que não foram", "desconhecido", 2025, "Mundo da Lua", b);
        Livro l2 = new Livro(2, "A ida dos que não vieram", "desconhecido", 2024, "Mundo da Lua", b);

        livroRepository.save(l1);
        livroRepository.save(l2);

        Optional<Biblioteca> resp = biblRepository.findById(1l);
        if(resp.isPresent()) {
            b = resp.get();
        }
        b.getLivros().add(l1);
        b.getLivros().add(l2);

        

        

        List<Biblioteca> resposta = biblRepository.findAll();
        // List<Livro> livros = livroRepository.findAll();
		System.out.println("======= Bibliotecas =======");
		for(Biblioteca biblioteca: resposta) {
            System.out.println("///// " + biblioteca.getNome() + " //////");
            List<Livro> livros = biblioteca.getLivros();
            for(Livro livro: livros) {
                System.out.println(livro);
            }
            System.err.println("////////////////////////////////");
        }
		System.out.println("===========================");
    }
}
