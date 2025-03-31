package br.joaquim.acervo.entidade;

import org.springframework.context.annotation.Lazy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="livros")
public class Livro {
    @Id
    long id;
    String titulo;
    String autor;
    int anoPublicacao;
    String editora;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "biblioteca_id")

    Biblioteca biblioteca;
}
