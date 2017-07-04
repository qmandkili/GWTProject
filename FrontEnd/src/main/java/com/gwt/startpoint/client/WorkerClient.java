package com.gwt.startpoint.client;



import com.model.shared.Device;
import com.model.shared.TestDto;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import java.math.BigInteger;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;


public interface WorkerClient extends RestService {

	@GET
	@Path("/test")
	void get(MethodCallback<TestDto> callback);
	
	@POST
	@Path("/device/create")
	void post(Device device, MethodCallback<Device> callback);
	
	@GET
	@Path("/device/get")
	void getById(BigInteger id, MethodCallback<Device> callback);
	
	@PUT
	@Path("/device/update")
	void update(Device device, MethodCallback<Device> callback);
	
	@DELETE
	@Path("/device/delete")
	void delete(BigInteger id, MethodCallback<Device> callback);

}
