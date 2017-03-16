package studentApplication;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Roxana
 */



import java.util.List;

import org.junit.Test;


public class InrolareTC {

	@Test
	public void test() throws Exception {
		Inrolare enrollToInsert = new Inrolare(5, 5);
		InrolareDao enrollDao = new InrolareDao();
		enrollDao.enrollStud(enrollToInsert);
		List<Inrolare> listOfEnrollments = enrollDao.getAllEnrollments();
		for (Inrolare enrollment : listOfEnrollments) {
			if(enrollment.equals(enrollToInsert)){
				System.out.println("Student inrolat. Test!");
			}
		}
	}

}
