package it.polito.tdp.IndovinaNumero.model;

import java.security.InvalidParameterException;
import java.util.HashSet;
import java.util.Set;

public class Model {
	
	//Ricopio i dati 
	private int segreto;
	private final int TMAX = 8;
	private final int NMAX = 100;
	private int tentativiFatti;
	private boolean inGioco=false;
	private Set<Integer> tentativi;
	
   /*	public Model()
	{
		tentativi=new HashSet<Integer>();
	} */
	public void nuovaPartita()
	{     
		 
		tentativi=new HashSet<Integer>();
		inGioco=true;
		//gestione di una nuova partita
		this.segreto = (int)((Math.random() * NMAX) +1);
    	this.tentativiFatti = 0;
    	
	}
	
	public int tentativo (int tentativo )
	{  
		
		if(!inGioco)
		{
			throw new IllegalStateException("HAI PERSO" + " La partita è terminata");
		}
	   if(!tentativoValido(tentativo))
	    throw new InvalidParameterException("DEVI INSERIRE UN NUMERO TRA 1 E "+NMAX +"Che non hai ancora utilizzato");
	    
	    this.tentativiFatti++;
	    this.tentativi.add(tentativo);
	    
		if(this.tentativiFatti==TMAX)
		{
			this.inGioco=false;
		} 
		
		if(tentativo==segreto)
		{
			return 0;
		}
		else if(tentativo<segreto)
		{
			return -1;
		}
		else
			return 1;
		
		
	}


	private boolean tentativoValido(int tentativo) {
	  if(tentativo<1 || tentativo >NMAX || tentativi.contains(tentativo))
		return false;
	  else 
		  return true;
	}

	public int getSegreto() {
		return segreto;
	}


	public int getTentativiFatti() {
		return tentativiFatti;
	}

      public int getTMAX() {
		return TMAX;
	}


	public int getNMAX() {
		return NMAX;
	}
}

