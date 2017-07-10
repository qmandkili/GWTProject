package com.rest.server;


import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

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
	
	@RequestMapping(value = "/device/get/{id}", method = RequestMethod.GET)
	public Device getDevice(@PathVariable("id") BigInteger id) {
		DBWorker dbWorker = new DBWorker();
		return dbWorker.getDevice(id);		
	}
	
	@RequestMapping(value = "/device/get", method = RequestMethod.GET)
	public List<Device> getAllDevices() {
		DBWorker dbWorker = new DBWorker();
		return dbWorker.getAllDevices();
		/*List<Device> list = new ArrayList<Device>();
		list.add(new Device(BigInteger.valueOf(10), "testName", "testDesc"));
		return list;*/
	}
	
	@RequestMapping(value = "/device/delete", method = RequestMethod.DELETE)
	public String deleteDevice(@RequestBody BigInteger id) {
		DBWorker dbWorker = new DBWorker();
		dbWorker.deleteDevice(id);
		return "Device successfully deleted";
	}
	
	@RequestMapping(value = "/device/update", method = RequestMethod.PUT)
	public Device updateDevice(@RequestBody Device device) {
		DBWorker dbWorker = new DBWorker();
		dbWorker.updateDevice(device);
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
