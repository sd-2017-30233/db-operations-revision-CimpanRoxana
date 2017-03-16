/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentApplication;


   

public class StudentApplication {

	static Student stud1 = new Student("Sabau Diana", "1989-10-29", "Susani, nr 40");
	static Student stud2 = new Student("Marcus Laura", "1980-12-10", "A Iancu, nr 3");
	static Curs curs1 = new Curs("SPG", "Pop Antonia", 4);
	static Curs curs2 = new Curs("IIa", "Groza Adrian", 3);
	static Inrolare inr1 = new Inrolare(2, 3);
        static Inrolare inr2 = new Inrolare(4, 6);
	static Conexiune con;
        
	
	
	
	public static void main(String[] argc){
		StudentDao studentDao = new StudentDao();
		CursDao courseDao = new CursDao();
		InrolareDao enrollDao = new InrolareDao();
		try {
			//con.getConnection();	
			//studentDao.insertStud(stud1);
                        //studentDao.insertStud(stud2);
                        //studentDao.deleteStudent(stud2);
                        //studentDao.deleteStudent(stud1);
			//courseDao.insertCourse(curs1);
                        //courseDao.insertCourse(curs2);
			//studentDao.deleteStudent(stud1);
                        enrollDao.enrollStud(inr2);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}

    

