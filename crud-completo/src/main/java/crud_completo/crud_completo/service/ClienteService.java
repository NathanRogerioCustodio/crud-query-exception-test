package crud_completo.crud_completo.service;

import crud_completo.crud_completo.entity.Cliente;
import crud_completo.crud_completo.exception.RecursoNaoEncontradoException;
import crud_completo.crud_completo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarClientes () {
        return clienteRepository.findAll();
    }

    public Cliente buscarClientePorId (Long id){
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cliente não encontrado com"));
    }

    public Cliente adicionarCliente (Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public void deletarCliente (Long id){
        Cliente cliente = buscarClientePorId(id);
        clienteRepository.delete(cliente);
    }
}
