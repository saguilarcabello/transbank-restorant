package cl.transbank.restorant.api.sale.service;

import java.util.List;

import cl.transbank.restorant.api.sale.Sale;

public interface SaleServiceData {
	/**
	 * creates a new Sale
	 * @param sale Object of sale
	 */
	void saveNewSale(Sale sale);
	
	/**
	 * List of sales
	 * @param day param that specify the date of sale
	 * @return List of Sales
	 */
	List<Sale> getSales(String day);
	
	/**
	 * JMS Listener that receive the message send
	 * @param sale the Sale object
	 */
	void receiveMessage(Sale sale);
}
