/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backofficerobotsound.ws;

import com.backofficerobotsound.ejb.PreferenceEJB;
import com.backofficerobotsound.javabeans.Preference;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author maxence
 */
@Path("/preferences")
@Produces({"application/json"})
public class PreferenceRest {

    @EJB
    private PreferenceEJB preferenceEjb;

    @GET
    @Path("/test")
    @Produces({"text/plain"})
    public String test() {
        return "Serveur OK";
    }

    @GET
    public List<Preference> all() {
        return this.preferenceEjb.all();
    }

    @POST
    @Produces({"application/json"})
    public Response add(Preference preference) {
        preferenceEjb.edit(preference);
        Response response = Response.status(200).build();
        return response;
    }

    @PUT
    @Consumes({"application/json"})
    public Response update(Preference preference) {
        preferenceEjb.edit(preference);
        Response response = Response.status(200).build();
        return response;
    }

    @DELETE
    @Consumes({"application/json"})
    public Response delete(Preference preference) {
        Preference p = preferenceEjb.getPreferenceById(preference.getIdPreference());
        preferenceEjb.delete(p);
        Response reponse = Response.status(200).build();
        return reponse;
    }

}
