package crud_completo.crud_completo.service;

import crud_completo.crud_completo.entity.Cliente;
import crud_completo.crud_completo.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;


public class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    public ClienteServiceTest(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testBuscarClientePorId(){
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("Nathan");

        when(clienteRepository.findById(anyLong())).thenReturn(Optional.of(cliente));

        Cliente resultado = clienteService.buscarClientePorId(1L);
        assertEquals("Nathan", resultado.getNome());

        verify(clienteRepository, times(1)).findById(1L);
    }

}