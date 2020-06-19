/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.musicbv.services;

import com.udec.musicbv.modelo.Conexion;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Daniel Barreto, Julian vallejo
 */
@Stateless
@Path("service")
/**
 * clase encargada del servicio
 */
public class Servicio {
    
    Conexion conexion = new Conexion();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{cedula}")
    public Response servicioCliente(@PathParam("cedula") int cedula) {
        System.out.println("Llegó!!!!");
        return Response.ok(conexion.obtenerArtistas()).build();
    }
    
}
