package br.inatel.labs.labjpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.inatel.labs.labjpa.entity.Endereco;
import br.inatel.labs.labjpa.service.EnderecoService;


//@SpringBootTest
public class EnderecoTeste {

	@Autowired
	private EnderecoService service;
	
	@Test
	public void testarUuidGeradoPeloJpaListener() {
		Endereco e = new Endereco();
		e.setRua("Rua Delcides Teles");
		e.setNumero("295-A");
		e.setCidade("Santa Rita do Sapucaí");
		e.setUf("MG");
		
		e = service.salvar(e);
		
		System.out.println(e);
	}
}
