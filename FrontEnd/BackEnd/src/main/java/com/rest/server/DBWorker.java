package com.rest.server;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.model.shared.Device;

public class DBWorker {

	// private String driverName = "oracle.jdbc.driver.OracleDriver";
	private Connection conn = null;
	private String url = "jdbc:postgresql://localhost:5432/postgres";
	private String login = "postgres";
	private String password = "1234";

	public DBWorker() {
		connect();
	}

	public void connect() {
		try {
			Class.forName("org.postgresql.Driver");
			Locale.setDefault(Locale.US);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(url, login, password);
		} catch (SQLException e) {
			System.err.println("can not establish connection");
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return conn;
	}

	public void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
		}
	}

	public void addDevice(Device device) {
		String insertDeviceQuery = "insert into device(name, description)" + "values (?, ?);";
		try {
			PreparedStatement statement = conn.prepareStatement(insertDeviceQuery);
			statement.setString(1, device.getName());
			statement.setString(2, device.getDescription());
			statement.executeUpdate();
		} catch (SQLException e) {
		}
	}

	public List<Device> getAllDevices() {
		List<Device> result = new ArrayList<Device>();
		String selectAllDevicesQuery = "select * from device;";
		try {
			PreparedStatement statement = conn.prepareStatement(selectAllDevicesQuery);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				result.add(new Device(BigInteger.valueOf(Long.parseLong(rs.getString(1).toString())),
						rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException e) {
		}
		return result;
	}

	public Device getDevice(BigInteger id) {
		Device device = null;
		String selectDeviceQuery = "select * from device where id = ?;";
		try {
			PreparedStatement statement = conn.prepareStatement(selectDeviceQuery);
			statement.setInt(1, id.intValue());
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				device = new Device(id, 
						rs.getString(2), rs.getString(3));
			}
		} catch (SQLException e) {
		}
		return device;
	}

	public void updateDevice(Device device) {
		String updateDeviceQuery = "update device set name = ?, description = ? where id = ?;";
		try {
			PreparedStatement statement = conn.prepareStatement(updateDeviceQuery);			
			statement.setString(1, device.getName());
			statement.setString(2, device.getDescription());
			statement.setBigDecimal(3, new BigDecimal(device.getId()));
			statement.executeUpdate();
		} catch (SQLException e) {
		}
	}

	public void deleteDevice(BigInteger id) {
		String deleteDeviceQuery = "delete from device " + "where id = ?;";
		try {
			PreparedStatement statement = conn.prepareStatement(deleteDeviceQuery);
			statement.setInt(1, id.intValue());
			statement.executeUpdate();
		} catch (SQLException e) {
		}
	}

}
