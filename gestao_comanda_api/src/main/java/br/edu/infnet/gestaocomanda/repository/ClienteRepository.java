package br.edu.infnet.gestaocomanda.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.infnet.gestaocomanda.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,String>{
	Optional<Cliente> findByCpfCnpj(String cpfCnpj);
}
