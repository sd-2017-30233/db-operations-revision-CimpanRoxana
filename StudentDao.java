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



public class StudentDao extends Conexiune {

	public void insertStud(Student student) throws Exception {
		try {
			Connection conn = getConnection();
			PreparedStatement reg = conn.prepareStatement(
					"INSERT INTO `bazadedate1`.`students` (`student_name`, `birth_date`, `address`) VALUES " + "('"
							+ student.getNume() + "', '" + student.getDate() + "', '" + student.getAddr() + "');");
			reg.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void deleteStudent(Student student) throws Exception {
		try {
			Connection conn = getConnection();
			PreparedStatement reg = conn
					.prepareStatement("DELETE FROM `bazadedate1`.`students` WHERE student_name ='" + student.getNume() + "' ");
			reg.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void updateStudent(Student student, String address) throws Exception {
		try {
			Connection conn = getConnection();
			PreparedStatement reg = conn.prepareStatement("UPDATE `bazadedate1`.`students` SET address = '" + address
					+ "' WHERE student_id = '" + student.getStudentId() + "' ");
			reg.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void printAllStudents(int studentId) throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con
					.prepareStatement("SELECT * FROM bazadedate1.students WHERE student_id = '" + studentId + "' ");
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

	public List<Student> getAllStudents() throws Exception {
		final List<Student> studentList = new ArrayList<>();
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT * FROM bazadedate1.students");
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				int studentId = result.getInt(1);
				String name = result.getString(2);
				String birthdate = result.getString(3);
				String address = result.getString(4);
				studentList.add(new Student(studentId, name, birthdate, address));
			}
			return studentList;
		} catch (Exception e) {
			System.out.println(e);
		}
		return studentList;
	}

	public String getName(int studentId) throws Exception {
		String columnValue = null;
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement(
					"SELECT student_name FROM unidb.students WHERE student_id = '" + studentId + "' ");
			ResultSet result = statement.executeQuery();
			ResultSetMetaData rsmd = result.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			columnValue = result.getString(1);
			System.out.print(columnValue);
		} catch (Exception e) {
			System.out.println(e);
		}

		return columnValue;
	}
}

