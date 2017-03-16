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

public class Curs extends Conexiune {

	private int courseId;
	private String nume;
	private String teacher;
	private int year;
	
	public Curs(int courseId, String nume, String teacher, int year) {
		this.courseId = courseId;
		this.nume = nume;
		this.teacher = teacher;
		this.year = year;
	}
	
	public Curs(String nume, String teacher, int year) {
		this.nume = nume;
		this.teacher = teacher;
		this.year = year;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + courseId;
		result = prime * result + ((nume == null) ? 0 : nume.hashCode());
		result = prime * result + ((teacher == null) ? 0 : teacher.hashCode());
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curs other = (Curs) obj;
		if (courseId != other.courseId)
			return false;
		if (nume == null) {
			if (other.nume != null)
				return false;
		} else if (!nume.equals(other.nume))
			return false;
		if (teacher == null) {
			if (other.teacher != null)
				return false;
		} else if (!teacher.equals(other.teacher))
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	
}

