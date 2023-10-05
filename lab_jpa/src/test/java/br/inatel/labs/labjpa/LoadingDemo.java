package br.inatel.labs.labjpa;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.inatel.labs.labjpa.entity.NotaCompra;
import br.inatel.labs.labjpa.entity.NotaCompraItem;
import br.inatel.labs.labjpa.service.NotaCompraService;


//@SpringBootTest
public class LoadingDemo {
	
	@Autowired
	private NotaCompraService service;
	
	@Test
	public void demoPlanejandoConsulta() {
		try {
			NotaCompra nota = service.buscarNotaCompraPeloIdComListaItem(1L);
			
			List<NotaCompraItem> listaNotaCompraItem = nota.getListaNotaCompraItem();
			int tamanho = listaNotaCompraItem.size();

			System.out.println(tamanho);
			System.out.println("Se chegou até aqui, o planejamento da consulta foi top");

		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void demoLazyLoading() {
		try {
			Optional<NotaCompra> opNota = service.buscarNotaCompraPeloId(1L);
			NotaCompra nota = opNota.get();
			
			List<NotaCompraItem> listaNotaCompraItem = nota.getListaNotaCompraItem();
			int tamanho = listaNotaCompraItem.size();

			System.out.println(tamanho);
		}
		catch(Exception e) {
			System.out.println("O carregamento foi LAZY e por isso lançou a braba");
			e.printStackTrace();
		}
	}
	
	@Test
	public void demoEagerLoading() {
		try {
			Optional<NotaCompraItem> opItem = service.buscarNotaCompraItemPeloId(1L);
			NotaCompraItem item = opItem.get();
			
			LocalDate dataEmissao = item.getNotaCompra().getDataEmissao();

			System.out.println(dataEmissao);
			
			System.out.println("Aconteceu o carregamento EAGER");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
