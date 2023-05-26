package fr.jhoudu.demo.quarkus.service;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.container.PreMatching;
import jakarta.ws.rs.ext.Provider;

import java.io.IOException;

@Provider
public class CustomerResponseFilter implements ContainerResponseFilter {
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
            throws IOException {
        responseContext.getHeaders().add("Link", "<https://quarkus.io/favicon.ico>; REL=\"shortcut icon\"; TYPE=\"image/x-icon\"");
        responseContext.getHeaders().add("Link", "<https://quarkus.io/favicon.ico>; REL=\"icon\"; TYPE=\"image/x-icon\"");
        //responseContext.getHeaders().add("Content-Security-Policy", "img-src 'self' data:");
    }
}
