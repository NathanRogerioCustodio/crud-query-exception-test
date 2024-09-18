package crud_completo.crud_completo.repository;

import crud_completo.crud_completo.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query("SELECT p FROM Pedido p JOIN p.cliente c WHERE c.nome = :nomeCliente")

    List<Pedido> findPedidosByNomeCliente(String nomeCliente);
}
