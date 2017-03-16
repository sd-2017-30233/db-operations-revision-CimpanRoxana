package studentApplication;




import java.util.List;

import org.junit.Test;



public class StudentTC {

	@Test
	public void testInsertStud() throws Exception {
		Student studentToInsert = new Student("Cimpan Denisa", "1996-05-20", "L Pretorian, nr 9");
		StudentDao studentDao = new StudentDao();
		studentDao.insertStud(studentToInsert);
		List<Student> listOfStudents = studentDao.getAllStudents();
		for (Student student : listOfStudents) 
			if(student.equals(studentToInsert)){
				System.out.println("Student inserat. Test!");
			}
	}
	
	 @Test
	 public void testDeleteStudent() throws Exception {
		Student studentToDelete = new Student("Cimpan Denisa", "1996-05-20", "L Pretorian, nr 9");
		StudentDao studentDao = new StudentDao();
		studentDao.deleteStudent(studentToDelete);
		List<Student> listOfStudents = studentDao.getAllStudents();
		int i = 0;
		for (Student student : listOfStudents) {
			if(student.equals(studentToDelete)) i = 1;
		}
		if (i == 0) System.out.println("Student sters. Test!");
	 }
	
	 @Test
	 public void testUpdateStudent() throws Exception {
		 Student studentToUpdate = new Student("Cimpan Denisa", "1996-05-20", "L Pretorian, nr 9");
		 StudentDao studentDao = new StudentDao();
		 studentDao.updateStudent(studentToUpdate, "L Pretorian, nr 10");
		 List<Student> listOfStudents = studentDao.getAllStudents();
		 int i = 0;
		 for (Student student : listOfStudents) {
				if(student.getNume().equals(studentToUpdate.getNume()) && student.getAddr().equals(studentToUpdate.getAddr()) ) i = 1;
			}
			if (i == 0) System.out.println("Student updatat. Test!");
	 }

}

