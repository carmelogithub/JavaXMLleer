package com.campusfp.lectura;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import com.campusfp.modelo.Item;

public class StaXParser {
	static final String ITEM = "item";
	static final String DATE="date";
	static final String NOMBRE="nombre";
	static final String CIUDAD="ciudad";
	static final String SALARIO="salario";
	
	public List<Item> leer(String archivoXml) {
		List<Item> items = new ArrayList<Item>();
		try {
			
			XMLInputFactory factoria = XMLInputFactory.newInstance();
			InputStream entrada = new FileInputStream(archivoXml);
			XMLEventReader lector = factoria.createXMLEventReader(entrada);//eventReader
			Item item = null;//antes de while...
			while (lector.hasNext()) {
				XMLEvent event = lector.nextEvent();
				
				if(event.isStartElement()) {//primer if
					StartElement inicio = event.asStartElement();
					if(inicio.getName().getLocalPart().equals(ITEM)) {//segundo if
						item = new Item();
						System.out.println("me ha creado item");
						//no hago Iterator.. porque no busco atributos
					}//cierra segundo if
					if(event.isStartElement()) {
						if(event.asStartElement().getName().getLocalPart().equals(NOMBRE))
						{
							event=lector.nextEvent();
							item.setNombre(event.asCharacters().getData());
							continue;
						}//cierra if equals nombre
					}//cierra if nombre
					
					if(event.isStartElement()) {
						if(event.asStartElement().getName().getLocalPart().equals(CIUDAD))
						{
							event=lector.nextEvent();
							item.setCiudad(event.asCharacters().getData());
							continue;
						}//cierra if equals CIUDAD
					}//cierra if CIUDAD
					
					
					if(event.isStartElement()) {
						if(event.asStartElement().getName().getLocalPart().equals(SALARIO))
						{
							event=lector.nextEvent();
							item.setSalario(event.asCharacters().getData());
							continue;
						}//cierra if equals salario
					}//cierra if salario
					
					items.add(item);
					
				}//cierra if primero
				
				
				
			}//cierra while
		}//cierra try
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return items;
		
		
	}//cierra método leer
	
}//cierra clase




