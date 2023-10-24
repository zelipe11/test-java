package br.com.java.testjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.java.testjava.model.Cliente;

@Repository
public interface ClientRepository extends JpaRepository<Cliente, Long> {
	
}
