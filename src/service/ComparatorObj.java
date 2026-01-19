package service;

import java.util.Comparator;

import entity.Product;

public class ComparatorObj implements Comparator<Product>{

	@Override
	public int compare(Product o1, Product o2) {
		return o1.getName().toUpperCase().compareTo(o2.getName().toUpperCase());
	}

}
