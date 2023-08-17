package br.com.alura.screenmatch.domain.filme;

import org.springframework.data.jpa.repository.JpaRepository;

// Interface de persistência para manipular métodos CRUD

public interface FilmeRepository extends JpaRepository<Filme, Long> {
}
