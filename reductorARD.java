package reduccion;

import java.util.ArrayList;
import java.util.List;

public class reductorARD {

	public int[][] ReductorAFD(int [][] quintupla, int eAceptacion[], int estados){
	String c0 = "";
	String c1="";
	String c2="";
	String perron1 = "";
	String perron2 = "";
		boolean estatus = true;
		String [][] matriz2;
		int aceptacion [][];
		int transicion[];
		int noAcepta = 0;
		ArrayList<String> reducto = new ArrayList<String>();
		for( int i=0; i< quintupla.length; i++)
		{
		    estatus = true;
		    for(int j=0; j<quintupla[0].length; j++)
		        if(j>0)
		        {
		        if(quintupla[i][j-1] != quintupla[i][j])
		            estatus = false;
		        }
		    if(estatus == true)
		        noAcepta = i;
		}
		
		
		if(noAcepta==0) {
			aceptacion= new int [quintupla.length-1][quintupla[0].length];
			transicion=new int [estados];
			for(int i=0; i<estados;i++) {
			transicion[i]=i;
				
			}
		}
		else {
			aceptacion=quintupla;
			transicion= new int[estados-1];
			for(int i=0; i<estados; i++) {
				if(i!=noAcepta) {
					
					for(int j=0; j<eAceptacion.length; i++) {
						if(i!=eAceptacion[j]) {
							transicion[i]=i;
						}
					}
				
				}	
			}
				
		}
		
	for(int i=0; i<transicion.length;i++) {
		if(i==transicion.length-1) {
			c0+=transicion[i];
		}
		else {
			c0+=transicion[i]+',';
		}
		
	}
	
	
	
for(int i=0; i<eAceptacion.length;i++) {

	
		if(i==eAceptacion.length-1) {
			c2+=eAceptacion[i];
		}
		else {
			c2+=eAceptacion[i]+',';
		}
	}
		
		


		if(noAcepta>0) {
			c1=String.valueOf(noAcepta);
		}
		matriz2 = new String[estados][quintupla[0].length];
		
		for( int i=0; i< quintupla.length; i++)
		{
		    for(int j=0; j<quintupla[0].length; j++)
		    	for(int k=0; k<transicion.length; k++)
		    	{		    		
		    		if(quintupla[i][j] == transicion[k])
		    			matriz2[i][j] = c0;
		    		else if(quintupla[i][j] == noAcepta)
		    			matriz2[i][j] = c1;
		    		else
		    		{		    			
		    		for(int x=0; x<eAceptacion.length; x++)
		    			if(quintupla[i][j] == eAceptacion[x])
		    				matriz2[i][j] = c2;
		    		}
		    	}
		}

		for(int i=0; i<matriz2.length; i++)
		{
			perron1 = "";
	    	for(int j=0; j<matriz2[0].length; j++)
	    		if (j == matriz2[0].length -1)
	    			perron1 += matriz2[i][j] + ",";
	    		else
	    			perron1 += matriz2[i][j];
	    	for(int x=i+1; x<matriz2.length; i++) {
	    		boolean isPerron = false;
	    		perron2 ="";
	    		for(int k=0; k<matriz2[0].length; k++)    
	    			if (k == matriz2[0].length -1)
	    				perron2 += matriz2[x][k] + ",";
	    			else
	    				perron2 += matriz2[x][k];
	    		if(perron1 == perron2)
    			{
	    			reducto.add(perron1);
    			}
	    	}
		}
		
	/*
	q1 =	c0 c1   {q1}
	q2 =	c1 c2	{q2,q7}
	q3 =	c0 c0	{q3}
	q4 =	c1 c1	{q4,q6}
	q5 =	c2 c1	{q5}
	q6 =	c1 c1
	q7 =	c1 c2
	*/
	return quintupla;	
	}
}
