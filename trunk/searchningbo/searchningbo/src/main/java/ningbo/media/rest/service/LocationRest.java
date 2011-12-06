package ningbo.media.rest.service;

import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ningbo.media.bean.Location;
import ningbo.media.service.LocationService;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Path("/location")
@Component
@Scope("request")
public class LocationRest {
	
	@Resource
	private LocationService locationService ;
	
	@Path("/showAll")
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_ATOM_XML})
	public List<Location> getAllLocations(){
		return locationService.getAll() ;
	}
	
	@Path("/show/{id : \\d+}")
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_ATOM_XML})
	public Location getLocationById(@PathParam("id")Integer id){
		return locationService.get(id) ;
	}

}
