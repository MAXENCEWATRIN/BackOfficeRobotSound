/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backofficerobotsound.ws;

import com.backofficerobotsound.ejb.PreferenceEJB;
import com.backofficerobotsound.javabeans.Preference;
import com.backofficerobotsound.utils.RestApiTools;
import java.util.List;
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
@Path("/preferences")
@Produces(MediaType.APPLICATION_JSON)
public class PreferenceRest {

    @EJB
    private PreferenceEJB preferenceEJB;

    @GET
    @Path("/test")
    @Produces({"text/plain"})
    public String test() {
        return "Serveur OK";
    }
    
    @GET
    @Path("/{idMusician:[0-9]+}")
    public List<Preference> all(@PathParam("idMusician") long id) {
        System.out.print(id);
        return preferenceEJB.allByMusician(id);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Preference preference) {
        preferenceEJB.edit(preference);
        return RestApiTools.successResponse();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Preference preference) {
        preferenceEJB.edit(preference);
        return RestApiTools.successResponse();
    }

    @DELETE
    @Path("/{idPreference:[0-9]+}")
    public Response delete(@PathParam("idPreference") long id) {
        Preference preference = preferenceEJB.getById(id);
        preferenceEJB.delete(preference);
        return RestApiTools.successResponse();
    }

}
