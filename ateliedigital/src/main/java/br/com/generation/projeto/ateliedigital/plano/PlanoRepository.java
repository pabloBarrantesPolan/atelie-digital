package br.com.generation.projeto.ateliedigital.plano;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PlanoRepository extends JpaRepository<Plano, Long> {
    List<Plano> findByTipo(String tipo);

    List<Plano> findByNumero(Integer numero);
}
