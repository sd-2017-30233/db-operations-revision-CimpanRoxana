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


public class CursDao extends Conexiune {

	public void insertCourse(Curs curs) throws Exception {
		try {
			Connection conn = getConnection();
			PreparedStatement reg = conn
					.prepareStatement("INSERT INTO `bazadedate1`.`course` (`course_name`, `teacher`, `study_year`) VALUES ('"
							+ curs.getNume() + "', '" + curs.getTeacher() + "', '" + curs.getYear() + "');");
			reg.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void deleteCourse(Curs curs) throws Exception {
		try {
			Connection conn = getConnection();
			PreparedStatement reg = conn
					.prepareStatement("DELETE FROM `bazadedate1`.`course` WHERE course_id ='" + curs.getCourseId() + "' ");
			reg.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void updateCourse(Curs curs, String teacher) throws Exception {
		try {
			Connection conn = getConnection();
			PreparedStatement reg = conn.prepareStatement(
					"UPDATE `bazadedate1`.`course` SET teacher = '" + teacher + "'   WHERE course_id = '" + curs.getCourseId() + "' ");
			reg.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void printCourse(int courseId) throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con
					.prepareStatement("SELECT * FROM bazadedate1.course WHERE course_id = '" + courseId + "' ");
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
	
	public List<Curs> getAllCourses() throws Exception {
		final List<Curs> courseList = new ArrayList<>();
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT * FROM bazadedate1.course");
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				int courseId = result.getInt(1);
				String name = result.getString(2);
				String teacher = result.getString(3);
				int year = result.getInt(4);
				courseList.add(new Curs(courseId, name, teacher, year));
			}
			return courseList;
		} catch (Exception e) {
			System.out.println(e);
		}
		return courseList;
	}
}

