package com.bookshop.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/BookShopServlet", asyncSupported = true)
public class BookShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BookShopServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append(request.getParameter("name"));
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AsyncContext asyncContext = request.startAsync();

		asyncContext.start(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(5000);
					System.out.println("Print the response...");
					System.out.println("Resposne returned by: " + Thread.currentThread().getName());
					returnResponse(request, response);
					
					asyncContext.complete();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		System.out.println("Initial Request: " + Thread.currentThread().getName());
	}

	private void returnResponse(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		String manufacturer = request.getParameter("manufacturer");
		String sku = request.getParameter("sku");
		
		BookList.addItem(new BookItem(name, manufacturer, sku));
		
		response.setHeader("someHeader", "someHeaderValue");
		response.addCookie(new Cookie("someCookie", "someCookieValue"));
		
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head></head>");
		out.print("<body>");
		out.print("<table>");
		
		for (BookItem bookItem : BookList.getItems()) {
			out.print("<tr>");
			out.print("<td>");
			out.print(bookItem.getName());
			out.print("</td>");
			out.print("</tr>");
		}
		
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
	}

}
