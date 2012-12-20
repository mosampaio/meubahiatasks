package br.com.meubahiatasks.web;

import com.google.appengine.api.urlfetch.URLFetchService;
import com.google.appengine.api.urlfetch.URLFetchServiceFactory;
import java.io.IOException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RecacheServlet extends HttpServlet {
    
    private static final Logger log = LoggerFactory
			.getLogger(RecacheServlet.class);

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
            
            makeHttpRequest("http://meubahia.herokuapp.com/recache/tweets/");
            makeHttpRequest("http://meubahia.herokuapp.com/recache/news/");
            makeHttpRequest("http://meubahia.herokuapp.com/recache/blogs/");
            
    }
    
    private void makeHttpRequest(String url) {
        try {
            log.info("making request to >> ", url);
            URLFetchServiceFactory.getURLFetchService().fetch(new URL(url));
        } catch (Exception e) {
            log.error("making request error", e);
        }
    }
}
