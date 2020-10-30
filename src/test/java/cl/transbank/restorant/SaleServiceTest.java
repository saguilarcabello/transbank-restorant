package cl.transbank.restorant;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsTemplate;

import cl.transbank.restorant.api.sale.Product;
import cl.transbank.restorant.api.sale.Sale;
import cl.transbank.restorant.api.sale.service.SaleService;
import cl.transbank.restorant.api.sale.service.SaleServiceData;

@SpringBootTest
public class SaleServiceTest {
	
	@Mock
	private JmsTemplate jmsTemplate ;

	@Test
	void postAndGetSaleOfDay() {
		SaleServiceData service = new SaleService(jmsTemplate);
		
		Sale sale = new Sale();
		sale.setDiningRoomTable("1");
		sale.setDateOfSale("30-10-2020");
		
		List<Product> products = new ArrayList<Product>();
		Product product1 = new Product(100, 2, "hamburger", 3990);
		Product product2 = new Product(200, 1, "coca-cola", 900);
		
		products.add(product1);
		products.add(product2);
		
		sale.setProducts(products);
		
		service.receiveMessage(sale);
		
		List<Sale> resultado = service.getSales("30-10-2020");
		
		Assertions.assertEquals(resultado.size(), 1);
		Assertions.assertEquals(resultado.get(0).getTotal(), 4890);
	}
}
