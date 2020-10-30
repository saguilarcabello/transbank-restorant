package cl.transbank.restorant.api.sale.service;

import java.util.List;

import cl.transbank.restorant.api.sale.Sale;
import cl.transbank.restorant.api.sale.SaleRequest;

public interface SaleServiceData {
	void saveNewSale(Sale sale);
	List<Sale> getSales(SaleRequest day);
}
