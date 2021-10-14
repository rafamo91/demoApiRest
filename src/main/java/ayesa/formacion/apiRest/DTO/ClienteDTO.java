
package ayesa.formacion.apiRest.DTO;

import java.util.Optional;

import ayesa.formacion.apiRest.entities.Cliente;
import lombok.Data;

@Data
public class ClienteDTO {

	private Boolean error;
	private String message;
	private Cliente cliente;

	public ClienteDTO(Cliente cliente) {

		if (cliente == null) {
			error();
		}
		else {
			success(cliente);
		}
	}

	public ClienteDTO(Optional<Cliente> cliente) {

		if (!cliente.isPresent()) {
			error();
		}
		else {
			success(cliente.get());
		}
	}

	private void error() {

		this.error = true;
		this.message = "No existen datos";
	}

	private void success(Cliente cliente) {

		this.error = false;
		this.message = "";
		this.cliente = cliente;
	}
}
