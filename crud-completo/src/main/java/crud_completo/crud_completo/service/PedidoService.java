package crud_completo.crud_completo.service;

import crud_completo.crud_completo.entity.Pedido;
import crud_completo.crud_completo.exception.RecursoNaoEncontradoException;
import crud_completo.crud_completo.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> listarPedidos () {
        return pedidoRepository.findAll();
    }

    public Pedido adicionarPedido(Pedido pedido){
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> buscarPedidoPorNomeCliente (String nomeCliente) {
        return pedidoRepository.findPedidosByNomeCliente(nomeCliente);
    }

    public void deletarPedido(Long id){
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Pedido não encontrado ! "));
        pedidoRepository.delete(pedido);
    }
}
