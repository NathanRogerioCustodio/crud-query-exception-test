package crud_completo.crud_completo.controller;

import crud_completo.crud_completo.entity.Pedido;
import crud_completo.crud_completo.repository.PedidoRepository;
import crud_completo.crud_completo.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<Pedido> listarPedidos(){
        return pedidoService.listarPedidos();
    }

    @PostMapping
    public Pedido adicionarPedido(@RequestBody Pedido pedido){
        return pedidoService.adicionarPedido(pedido);
    }

    @GetMapping("/buscar")
    public List<Pedido> buscarPedidosPorNomeCliente(@RequestParam String nomeCliente){
        return pedidoService.buscarPedidoPorNomeCliente(nomeCliente);
    }

    @DeleteMapping("/{id}")
    public void deletarPedido(@PathVariable Long id){
        pedidoService.deletarPedido(id);
    }
}
