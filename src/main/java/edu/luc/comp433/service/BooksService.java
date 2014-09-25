package edu.luc.comp433.service;

import java.math.BigDecimal;
import java.util.List;

import javax.jws.WebService;

import edu.luc.comp433.model.Book;

/**
 *
 * @author Thiago Vieira Puluceno
 *
 */
@WebService
public interface BooksService {
	public List<Book> listAll();

	public Book searchByTitle(String name);

	public Book searchByAuthor(String name);

	public Book searchByPrice(BigDecimal price);

}
