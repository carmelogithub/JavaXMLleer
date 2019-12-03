package com.campusfp.lectura;

import java.util.List;

import com.campusfp.modelo.Item;

public class PruebaLeer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StaXParser parserLectura = new StaXParser();
		List<Item> solucion = parserLectura.leer("config.xml");
		
		for(Item item : solucion)
		{
			System.out.println(item);
		}
		
	}

}
