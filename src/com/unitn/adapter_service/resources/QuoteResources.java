package com.unitn.adapter_service.resources;

import com.unitn.adapter_service.services.ServiceGenerator;
import com.unitn.adapter_service.services.quotes.Quote;
import com.unitn.adapter_service.services.quotes.QuotesService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * Created by demiurgo on 2/6/16.
 */

@Path("quotes")
public class QuoteResources {

    QuotesService quotesService = ServiceGenerator.getQuoteService();



    @GET
    @Path("famous")
    @Produces({MediaType.APPLICATION_JSON })
    public Quote getFamouseQuote(){
        try {
            return quotesService.getQuoteFromFamous().execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @GET
    @Path("movie")
    @Produces({MediaType.APPLICATION_JSON })
    public Quote getMovieQuote(){
        try {
            return quotesService.getQuoteFromMovies().execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
