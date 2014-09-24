package edu.luc.comp433.client;

import java.util.List;

import org.apache.cxf.common.i18n.Exception;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import edu.luc.comp433.model.Book;
import edu.luc.comp433.service.ListBooks;

public final class BookClient {

	private BookClient() {
	}

	public static void main(String args[]) throws Exception {

		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();

		factory.getInInterceptors().add(new LoggingInInterceptor());
		factory.getOutInterceptors().add(new LoggingOutInterceptor());
		// the following line is to bind for regular XML format instead of SOAP
		// format
		factory.setBindingId("http://cxf.apache.org/bindings/xformat");
		factory.setServiceClass(ListBooks.class);
		factory.setAddress("http://localhost:8080/project2/ListBooks/listAll");
		ListBooks client = (ListBooks) factory.create();

		List<Book> books = client.listAll();
		for (Book book : books) {
			System.out.println("Book title: " + book.getTitle());
			System.out.println("Book author: " + book.getAuthor());
			System.out.println("Book price: " + book.getPrice());
		}
		System.exit(0);

	}

}