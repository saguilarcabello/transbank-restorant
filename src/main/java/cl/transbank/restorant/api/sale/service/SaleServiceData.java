package cl.transbank.restorant.api.sale.service;

import java.util.List;

import cl.transbank.restorant.api.sale.Sale;

public interface SaleServiceData {
	void saveNewSale(Sale sale);
	List<Sale> getSales(String day);
}
