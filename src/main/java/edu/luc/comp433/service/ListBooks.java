package edu.luc.comp433.service;

import java.math.BigDecimal;
import java.util.List;

import javax.jws.WebService;

import edu.luc.comp433.model.Book;

@WebService
public interface ListBooks {
	public List<Book> listAll();
	public List<Book> searchByTitle(String name);
	public List<Book> searchByAuthor(String name);
	public List<Book> searchByPrice(BigDecimal price);

}
