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

public class Inrolare extends Conexiune {

	int eId;
	int sId;
	int cId;
	
	public Inrolare(int eId, int sId, int cId){
		this.eId = eId;
		this.sId = sId;
		this.cId = cId;
	}
	
	public Inrolare(int sId, int cId){
		this.sId = sId;
		this.cId = cId;
	}

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cId;
		result = prime * result + eId;
		result = prime * result + sId;
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
		Inrolare other = (Inrolare) obj;
		if (cId != other.cId)
			return false;
		if (eId != other.eId)
			return false;
		if (sId != other.sId)
			return false;
		return true;
	}

}

