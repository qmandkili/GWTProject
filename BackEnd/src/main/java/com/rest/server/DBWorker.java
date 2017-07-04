package com.rest.server;

import java.awt.List;
import java.beans.Statement;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
			// TODO Auto-generated catch block
		}
	}

	public void addDevice(Device device) {
		String insertDeviceQuery = "insert into device(id, name, description)" + "values (?, ?, ?);";
		try {
			PreparedStatement statement = conn.prepareStatement(insertDeviceQuery);

			statement.setBigDecimal(1, BigDecimal.valueOf(device.getId().longValue()));
			statement.setString(2, device.getName());
			statement.setString(3, device.getDescription());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		/*
		 * session = sessionFactory.openSession(); session.beginTransaction();
		 * session.save(device); session.getTransaction().commit();
		 */
	}

	public List getAllDevices() {
		/*
		 * session = sessionFactory.openSession(); session.beginTransaction();
		 * List devices = (List) session.createQuery("from Device").list();
		 * session.getTransaction().commit(); return devices;
		 */
		return null;
	}

	public Device getDevice(BigInteger id) {
		Device device = null;
		String selectDeviceQuery = "select * from device where id = ?;";
		try {
			PreparedStatement statement = conn.prepareStatement(selectDeviceQuery);
			statement.setBigDecimal(1, new BigDecimal(id));
			ResultSet rs = statement.executeQuery(selectDeviceQuery);
			while (rs.next()) {
				device = new Device(rs.getBigDecimal("id").toBigInteger(), rs.getString("name"),
						rs.getString("description"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		/*
		 * session = sessionFactory.openSession(); session.beginTransaction();
		 * Device device = session.get(Device.class, id);
		 * session.getTransaction().commit(); return device;
		 */
		return device;
	}

	public void updateDevice(Device device) {
		/*
		 * session = sessionFactory.openSession(); session.beginTransaction();
		 * session.update(device); session.getTransaction().commit();
		 */
		String updateDeviceQuery = "update into device(id, name, description)" + "values (?, ?, ?);";
		try {
			PreparedStatement statement = conn.prepareStatement(updateDeviceQuery);
			statement.setBigDecimal(1, new BigDecimal(device.getId()));
			statement.setString(2, device.getName());
			statement.setString(3, device.getDescription());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
	}

	public void deleteDevice(Device device) {
		String deleteDeviceQuery = "delete from device " + "where id = ?;";
		try {
			PreparedStatement statement = conn.prepareStatement(deleteDeviceQuery);
			statement.setBigDecimal(1, new BigDecimal(device.getId()));
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
	}

}
