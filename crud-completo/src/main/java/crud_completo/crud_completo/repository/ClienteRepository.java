package crud_completo.crud_completo.repository;

import crud_completo.crud_completo.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
