/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentApplication;

/**
 *
 * @author Roxana
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;



public class InrolareDao extends Conexiune{

	public void enrollStud(Inrolare enroll) throws Exception {
		try {
			Connection conn = getConnection();
			PreparedStatement reg = conn
					.prepareStatement("INSERT INTO `bazadedate1`.`enrollment` (`student`, `curs`) VALUES ('" + enroll.getsId()
							+ "', '" + enroll.getcId() + "');");
			reg.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Student enrolled");
	}

	public static void getEnrolledStud(int courseId) throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement(
					"SELECT students.student_name FROM bazadedate1.enrollment JOIN bazadedate1.students ON students.student_id = enrollment.student JOIN bazadedate1.course ON course.course_id = enrollment.course WHERE course.course_id = '"
							+ courseId + "' ");
			ResultSet result = statement.executeQuery();
			ResultSetMetaData rsmd = result.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			while (result.next()) {
				for (int i = 1; i <= columnsNumber; i++) {
					String columnValue = result.getString(i);
					System.out.print(rsmd.getColumnName(i) + ": " + columnValue + "\n");
				}
				System.out.println("");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public List<Inrolare> getAllEnrollments() throws Exception {
		final List<Inrolare> enrollList = new ArrayList<>();
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT * FROM bazadedate1.enrollment");
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				int enrollId = result.getInt(1);
				int studId = result.getInt(2);
				int courseId = result.getInt(3);
				enrollList.add(new Inrolare(enrollId, studId, studId));
			}
			return enrollList;
		} catch (Exception e) {
			System.out.println(e);
		}
		return enrollList;
	}
}
