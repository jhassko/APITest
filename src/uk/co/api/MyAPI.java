package uk.co.api;

import uk.co.api.APILondon;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

//Defines the base URI for all resource URIs.
@ApplicationPath("/")
public class MyAPI extends Application{
    @Override
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();
        h.add( APILondon.class );
        return h;
    }
}
