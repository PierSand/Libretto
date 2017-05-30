package it.polito.tdp.libretto.model;

import java.util.*;

public class Model {
	private List<Esame> esami;
		
		public Model(){
			this.esami = new ArrayList<Esame>();
			
		}
		
		public boolean addEsame(Esame e){		
			if(!esami.contains(e)){
			esami.add(e);
			return true;
			}
			else 
				return false;
		}
		
		public Esame trovaEsame(String codice){
			int pos = this.esami.indexOf(new Esame(codice, null, null));
			if(pos==-1){
				return null;
			}
			else return esami.get(pos);
		}
}
