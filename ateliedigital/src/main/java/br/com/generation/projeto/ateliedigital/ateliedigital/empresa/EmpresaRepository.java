package br.com.generation.projeto.ateliedigital.ateliedigital.empresa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
        List<Empresa> findByRegiao(String regiao);
}
