package com.lexa.starter.sparkjava;

import static spark.Spark.*;

import com.lexa.starter.sparkjava.todo.TodoResource;
import com.lexa.starter.sparkjava.todo.TodoService;
import com.lexa.starter.sparkjava.utils.ConfigurationManager;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
	{
		ConfigurationManager config = new ConfigurationManager();

		exception(Exception.class, (e, req, res) -> e.printStackTrace()); // print all exceptions
		//staticFiles.location("/public");

		threadPool(config.getInt("server.maxThreads"), config.getInt("server.minThreads"), config.getInt("server.timeOutMillis"));
		port(config.getInt("server.port"));

		//Setup Router
		new TodoResource(new TodoService());
		
		//If you want to GZIP everything, you can use an after-filter
		after((request, response) -> {
		    response.header("Content-Encoding", "gzip");
		});
	}

}
