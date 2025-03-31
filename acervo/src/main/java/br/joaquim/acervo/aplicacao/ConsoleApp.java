//Felipe Ferreira Melantonio RA:10443843
package br.joaquim.acervo.aplicacao;

import java.util.ArrayList;
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
        Biblioteca c = new Biblioteca(3,"felipe", new ArrayList<>());
        b = biblRepository.save(b);
        c = biblRepository.save(c);


        Livro l1 = new Livro(1, "A volta dos que não foram", "desconhecido", 2025, "Mundo da Lua", b);
        Livro l2 = new Livro(2, "A ida dos que não vieram", "desconhecido", 2024, "Mundo da Lua", b);

        livroRepository.save(l1);
        livroRepository.save(l2);


        

        

        List<Biblioteca> resposta = biblRepository.findAll();

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
