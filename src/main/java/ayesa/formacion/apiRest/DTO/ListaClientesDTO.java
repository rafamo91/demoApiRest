
package ayesa.formacion.apiRest.DTO;

import java.util.List;

import ayesa.formacion.apiRest.entities.Cliente;
import lombok.Data;

@Data
public class ListaClientesDTO {

	private Boolean error;
	private String message;
	private List<Cliente> clientes;

	public ListaClientesDTO(List<Cliente> clientes) {

		if (clientes == null) {
			error();
		}
		else if (clientes.size() <= 0) {
			this.error = false;
			this.message = "La lista esta vacía";
		}
		else {
			success(clientes);
		}
	}

	private void error() {

		this.error = true;
		this.message = "No existen datos";
	}

	private void success(List<Cliente> clientes) {

		this.error = false;
		this.message = "";
		this.clientes = clientes;
	}

}
