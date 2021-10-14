
package ayesa.formacion.apiRest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ayesa.formacion.apiRest.DTO.ClienteDTO;
import ayesa.formacion.apiRest.DTO.ListaClientesDTO;
import ayesa.formacion.apiRest.entities.Cliente;
import ayesa.formacion.apiRest.services.ClienteService;

@RestController
public class ClienteController {

	@Autowired
	private ClienteService cliServi;

	@GetMapping("/cliente")
	public ListaClientesDTO getClientes() {

		List<Cliente> clientes = cliServi.getAll();
		ListaClientesDTO clientesDTO = new ListaClientesDTO(clientes);
		return clientesDTO;
	}

	@PostMapping("/cliente")
	public ClienteDTO updateCliente(@RequestBody Cliente cliente) {

		cliente = cliServi.updateClient(cliente);
		ClienteDTO clienteDTO = new ClienteDTO(cliente);
		return clienteDTO;
	}

	@GetMapping("/cliente/{id}")
	public ClienteDTO getCliente(@PathVariable Integer id) {

		ClienteDTO clienteDTO = new ClienteDTO(cliServi.findById(id));
		return clienteDTO;
	}

	@PutMapping("/cliente/{id}")
	public ClienteDTO updateById(
		@PathVariable Integer id, @RequestBody Cliente cliente) {

		ClienteDTO clienteDTO = new ClienteDTO(cliServi.findById(id));
		if (!clienteDTO.getError()) {
			clienteDTO.getCliente().setNombre(cliente.getNombre());
			clienteDTO.getCliente().setTlf(cliente.getTlf());
			cliServi.updateClient(clienteDTO.getCliente());
		}
		return clienteDTO;
	}

	@DeleteMapping("/cliente/{id}")
	public ClienteDTO deleteById(@PathVariable Integer id) {

		Optional<Cliente> cli = cliServi.findById(id);
		ClienteDTO clienteDTO = new ClienteDTO(cli);
		if (!clienteDTO.getError()) {
			cliServi.deleteClient(clienteDTO.getCliente());
		}

		return clienteDTO;
	}

}
