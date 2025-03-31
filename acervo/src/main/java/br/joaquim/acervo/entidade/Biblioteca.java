//Felipe Ferreira Melantonio RA:10443843
package br.joaquim.acervo.entidade;

import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Biblioteca {
    @Id
    private long id;
    private String nome;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "biblioteca")
    List<Livro> livros;
}
