/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backofficerobotsound.ws;

import com.backofficerobotsound.ejb.MusicianEJB;
import com.backofficerobotsound.javabeans.Musician;
import java.util.List;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author maxence
 */
@Path("/musician")
@RequestScoped
@Produces({"appplication/json"})
public class MusicianRest {
    
    private MusicianEJB musicianEjb;
    
    
    
    @GET
    @Path("/test")
    @Produces({"text/plain"})
    public String test() {
        return "Serveur OK";
    }

    @GET
    @Path("/all")
    public List<Musician> all() {
        return this.musicianEjb.all();
    }

    
    @POST
    @Produces({"application/json"})
    @Path("/add")
    public List<Musician> add(Musician Musician) {
        musicianEjb.edit(Musician);
        return musicianEjb.all();
    }

   
    @PUT
    @Path("/modify")
    @Consumes({"application/json"})
    public Response modify(Musician Musician) {
        musicianEjb.edit(Musician);
        Response response = Response.status(200).build();
        return response;
    }
    
  
    @DELETE
    @Path("delete/{idMusician:[0-9]+}")
    public Response delete(@PathParam("idMusician") int id)
    {
      Musician Musician  = musicianEjb.getById(id);
        musicianEjb.delete(Musician);
        Response reponse = Response.status(200).build();
        return reponse;
                
    }

    
    
}
