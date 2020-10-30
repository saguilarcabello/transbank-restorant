package cl.transbank.restorant.api.sale.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.transbank.restorant.api.sale.Sale;
import cl.transbank.restorant.api.sale.SaleRequest;
import cl.transbank.restorant.api.sale.service.SaleServiceData;

@RestController
@RequestMapping("/api/sales")
public class SaleController {

	private SaleServiceData service;
	
	@Autowired
	public SaleController(SaleServiceData service) {
		this.service = service;
	}
	
	@PostMapping("")
	public String newSale(@RequestBody Sale sale) {
		service.saveNewSale(sale);
		return "";
	}
	
	@GetMapping("")
	public List<Sale> getSales(@RequestBody SaleRequest day) {
		return service.getSales(day);
	}
}
