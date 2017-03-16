package studentApplication;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;



public class CursTC {

	@Test
	public void testInsertCourse() throws Exception {
		Curs courseToInsert = new Curs("POO", "Vatava Andrei", 2);
		CursDao courseDao = new CursDao();
		courseDao.insertCourse(courseToInsert);
		List<Curs> listOfCourses = courseDao.getAllCourses();
		for (Curs course : listOfCourses) {
			if(course.equals(courseToInsert)){
				System.out.println("Cursul a fost inserat. Test!");
			}
		}
	}

	@Test
	public void testDeleteCourse() throws Exception {
		Curs courseToInsert = new Curs("POO", "Vatava Andrei", 2);
		CursDao courseDao = new CursDao();
		courseDao.deleteCourse(courseToInsert);
		List<Curs> listOfCourses = courseDao.getAllCourses();
		int i = 0;
		for (Curs course : listOfCourses) {
			if(course.equals(courseToInsert)) i = 1;
		}
		if (i == 0) System.out.println("Cursul a fost sters. Test!");
	}

	@Test
	public void testUpdateCourse() throws Exception {
		Curs courseToInsert = new Curs("POO", "Vatava Andrei", 2);
		CursDao courseDao = new CursDao();
		courseDao.updateCourse(courseToInsert, "Vatavu Andrei");
		List<Curs> listOfCourses = courseDao.getAllCourses();
		int i = 0;
		for (Curs course : listOfCourses) {
			if(course.getNume().equals(courseToInsert.getNume()) && course.getTeacher().equals(courseToInsert.getTeacher()) ) i = 1;
		}
		if (i == 0) System.out.println("Course updatat. Test!");
		
	}

}
