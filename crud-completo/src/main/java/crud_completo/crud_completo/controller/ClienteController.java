package crud_completo.crud_completo.controller;

import crud_completo.crud_completo.entity.Cliente;
import crud_completo.crud_completo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> listarCliente (){
        return clienteService.listarClientes();
    }

    @PostMapping
    public Cliente adicionarCliente (@RequestBody Cliente cliente){
        return clienteService.adicionarCliente(cliente);
    }

    @GetMapping("/{id}")
    public Cliente buscarClientePorId(@PathVariable Long id){
        return clienteService.buscarClientePorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarCliente(@PathVariable Long id){
        clienteService.deletarCliente(id);
    }

}
