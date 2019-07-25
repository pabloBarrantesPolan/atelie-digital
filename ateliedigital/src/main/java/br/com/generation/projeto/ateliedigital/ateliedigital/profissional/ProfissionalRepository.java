package br.com.generation.projeto.ateliedigital.ateliedigital.profissional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {
    List<Profissional> findByRegiao(String regiao);
}
