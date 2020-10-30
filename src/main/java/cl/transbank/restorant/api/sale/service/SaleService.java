package cl.transbank.restorant.api.sale.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import cl.transbank.restorant.api.sale.Product;
import cl.transbank.restorant.api.sale.Sale;
import cl.transbank.restorant.api.sale.SaleRequest;

@Service
public class SaleService implements SaleServiceData {

	private static List<Sale> sales = new ArrayList<Sale>();
	
	@Override
	public void saveNewSale(Sale sale) {
		Integer total = sale.getProducts().stream()
				  .map((Product product) -> product.getPrice())
				  .reduce(0, Integer::sum);
		
		sale.setTotal(total);

		sales.add(sale);
	}

	@Override
	public List<Sale> getSales(SaleRequest day) {
		List<Sale> salesOfDay = sales.stream()
				.filter( (Sale sale) -> sale.getDateOfSale().equals(day.getDay()) )
				.collect(Collectors.toList());
		return salesOfDay;
	}
}
