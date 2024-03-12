package br.edu.infnet.gestaocomanda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.infnet.gestaocomanda.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String>{

}
