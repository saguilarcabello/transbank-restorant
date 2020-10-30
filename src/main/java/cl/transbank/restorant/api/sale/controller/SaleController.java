package cl.transbank.restorant.api.sale.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.transbank.restorant.api.sale.Sale;
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
	
	@GetMapping("/{date}")
	public List<Sale> getSales(@PathVariable("date") String day) {
		return service.getSales(day);
	}
	
	
	@PostMapping("/concurrentLoad/{quantity}")
	public String concurrentLoad(@PathVariable("quantity") int quantity, @RequestBody Sale sale) {
		
		for(int x = 0; x < quantity; x++) {
			sale.setDiningRoomTable("" + x);
			service.saveNewSale(sale);
		}
		return "";
	}
}
