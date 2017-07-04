package com.rest.server;


import java.math.BigInteger;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.shared.Device;
import com.model.shared.TestDto;



/**
 * Created by InsideWorld on 15.06.2017.
 */
@RestController
public class RestExample {
	
	//private DBWorker dbWorker = new DBWorker();
	
	@RequestMapping(value = "/device/create", method = RequestMethod.POST)
	public Device addDevice(@RequestBody Device device)  {
		/*result.setName("aaaa");
		result.setDescription("bbbbbbbbb");*/
		DBWorker dbWorker = new DBWorker();
		dbWorker.addDevice(device);
		return device;
	}
	
	@RequestMapping(value = "/device/get", method = RequestMethod.GET)
	public Device getDevice(@RequestBody BigInteger id) {
		Device result = new Device(id, "idName", "idDesc");
		/*DBWorker dbWorker = new DBWorker();
		Device result = dbWorker.getDevice(device.getId());
		Device dev = new Device(device.getId(), "name", "desc");
		Device result = dbWorker.getDevice(device.getId());
		Device device = new Device();
		device.setId(1);
		device.setName("secondDevice");
		device.setDescription("secondDescription");*/
		//dbWorker.closeConnection();
		return result;		
	}
	
	@RequestMapping(value = "/device/delete", method = RequestMethod.DELETE)
	public Device deleteDevice(@RequestBody BigInteger id) {
		/*DBWorker dbWorker = new DBWorker();
		dbWorker.deleteDevice(device);
		device.setName("deviceName");*/
		//Device result = new Device(BigInteger.valueOf(obj.getLong("id")), obj.getString("name"), "");
		return new Device(id, "delete", "");
	}
	
	@RequestMapping(value = "/device/update", method = RequestMethod.PUT)
	public Device updateDevice(@RequestBody Device device) {
		/*DBWorker dbWorker = new DBWorker();
		dbWorker.updateDevice(device);*/
		return device;
	}

    @RequestMapping("/test")
    public TestDto test() {
        TestDto dto = createDto();
        dto.setMessage("It's a test string from server");
        return dto;
    }

    @RequestMapping("/test/{someText}")
    public TestDto testAdditional(@PathVariable String someText) {
        TestDto dto = createDto();
        dto.setMessage("It's a test string from server and you've given me " + someText);
        return dto;
    }

    //Это нужно будет создавать через фабрику сприга
    protected TestDto createDto() {
        return new TestDto();
    }

}
