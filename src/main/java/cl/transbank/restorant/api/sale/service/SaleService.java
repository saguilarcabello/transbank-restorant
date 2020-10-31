package cl.transbank.restorant.api.sale.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import cl.transbank.restorant.api.sale.Product;
import cl.transbank.restorant.api.sale.Sale;

@Service
public class SaleService implements SaleServiceData {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SaleService.class);
	private static List<Sale> SALES = new ArrayList<Sale>();
	private JmsTemplate jmsTemplate;
	
	/**
	 * Constructor
	 * @param jmsTemplate JMS template
	 */
	@Autowired
	public SaleService(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	/**
	 * Constructor
	 */
	public SaleService() {
		
	}
	

	/* (non-Javadoc)
	 * @see cl.transbank.restorant.api.sale.service.SaleServiceData#saveNewSale(cl.transbank.restorant.api.sale.Sale)
	 */
	@Override
	public void saveNewSale(Sale sale) {
		LOGGER.info("Sending Message");
		jmsTemplate.convertAndSend("jms.message.endpoint", sale);
	}

	/* (non-Javadoc)
	 * @see cl.transbank.restorant.api.sale.service.SaleServiceData#getSales(java.lang.String)
	 */
	@Override
	public List<Sale> getSales(String day) {
		LOGGER.info(String.format("retrieve data of date: %s", day));
		//used only for concurrency in-memory data
		List<Sale> salesSnapshot = new ArrayList<Sale>(SALES);
		
		List<Sale> salesOfDay = salesSnapshot.stream()
				.filter( (Sale sale) -> sale.getDateOfSale().equals(day) )
				.collect(Collectors.toList());
		return salesOfDay;
	}
	
	/* (non-Javadoc)
	 * @see cl.transbank.restorant.api.sale.service.SaleServiceData#receiveMessage(cl.transbank.restorant.api.sale.Sale)
	 */
	@Override
	@JmsListener(destination ="jms.message.endpoint")
	public void receiveMessage(Sale sale) {
		LOGGER.info("Receive Message");
		Integer total = sale.getProducts().stream()
				  .map((Product product) -> product.getPrice())
				  .reduce(0, Integer::sum);
		
		sale.setTotal(total);

		SALES.add(sale);
	}
}
