/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backofficerobotsound.utils;

import javax.ws.rs.core.Response;

/**
 *
 * @author christophe
 */
public class RestApiTools {

    public final static Response successResponse() {
        return Response.status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .allow("OPTIONS")
                .build();
    }

}
