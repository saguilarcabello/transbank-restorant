package cl.transbank.restorant.api.sale;

import java.util.ArrayList;
import java.util.List;

public class Sale {
	private String diningRoomTable;
	private String dateOfSale;
	private Integer total;
	private List<Product> products = new ArrayList<Product>();

	/**
	 * @return the diningRoomTable
	 */
	public String getDiningRoomTable() {
		return diningRoomTable;
	}

	/**
	 * @param diningRoomTable the diningRoomTable to set
	 */
	public void setDiningRoomTable(String diningRoomTable) {
		this.diningRoomTable = diningRoomTable;
	}

	/**
	 * @return the dateOfSale
	 */
	public String getDateOfSale() {
		return dateOfSale;
	}

	/**
	 * @param dateOfSale the dateOfSale to set
	 */
	public void setDateOfSale(String dateOfSale) {
		this.dateOfSale = dateOfSale;
	}

	/**
	 * @return the total
	 */
	public Integer getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}

	/**
	 * @return the products
	 */
	public List<Product> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(List<Product> products) {
		this.products = products;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Sale [diningRoomTable=");
		builder.append(diningRoomTable);
		builder.append(", dateOfSale=");
		builder.append(dateOfSale);
		builder.append(", total=");
		builder.append(total);
		builder.append(", products=");
		builder.append(products);
		builder.append("]");
		return builder.toString();
	}
	
}
