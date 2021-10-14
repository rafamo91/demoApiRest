
package ayesa.formacion.apiRest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ayesa.formacion.apiRest.entities.Cliente;
import ayesa.formacion.apiRest.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository cliRep;

	public List<Cliente> getAll() {

		return cliRep.findAll();
	}

	public Cliente updateClient(Cliente cliente) {

		return cliRep.save(cliente);
	}

	public void deleteClient(Cliente cliente) {

		cliRep.delete(cliente);
	}

	public Optional<Cliente> findById(Integer id) {

		return cliRep.findById(id);
	}
}
