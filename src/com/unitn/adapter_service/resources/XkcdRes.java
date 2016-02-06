package com.unitn.adapter_service.resources;

import com.unitn.adapter_service.services.ServiceGenerator;
import com.unitn.adapter_service.services.xkcd.XkcdComic;
import com.unitn.adapter_service.services.xkcd.XkcdService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.Random;

/**
 * Created by demiurgo on 2/6/16.
 */
@Path("xkcd")
public class XkcdRes {
    private static final int COMICS = 1639;
    private static final Random random = new Random();

    XkcdService xkcdService = ServiceGenerator.getXkcdService();

    @GET
    @Path("{Id}")
    @Produces({MediaType.APPLICATION_JSON })
    public XkcdComic getComic(@PathParam("Id") long comicId) throws IOException {
        return xkcdService.getComic(comicId).execute().body();
    }


    @GET
    @Path("random")
    @Produces({MediaType.APPLICATION_JSON })
    public XkcdComic getRandomComic() throws IOException {
        return xkcdService.getComic(random.nextInt(COMICS-1)+1).execute().body();
    }
}
