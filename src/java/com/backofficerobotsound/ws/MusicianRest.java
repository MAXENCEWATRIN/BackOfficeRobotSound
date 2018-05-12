/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backofficerobotsound.ws;

import com.backofficerobotsound.ejb.MusicianEJB;
import com.backofficerobotsound.javabeans.Musician;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author maxence
 */
@Path("/musicians")
@Produces(MediaType.APPLICATION_JSON)
public class MusicianRest {

    @EJB
    private MusicianEJB musicianEjb;

    @GET
    @Path("/test")
    @Produces({"text/plain"})
    public String test() {
        return "Serveur OK";
    }

    @GET
    public Response all() {
        return Response.ok(musicianEjb.all())
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET")
                .allow("OPTIONS")
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Musician musician) {
        musicianEjb.edit(musician);
        return successResponse();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Musician musician) {
        musicianEjb.edit(musician);
        return successResponse();
    }

    @DELETE
    @Path("/{idMusician:[0-9]+}")
    public Response supprimerMusicien(@PathParam("idMusician") int id) {
        
        Musician musician = musicianEjb.getById(id);
        musicianEjb.delete(musician);
        return successResponse();

    }

    private Response successResponse() {
        return Response.status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .allow("OPTIONS")
                .build();
    }

}
