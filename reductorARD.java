package reduccion;

 public class reductorARD {

	public int[][] ReductorAFD(int [][] quintupla, int eAceptacion[], int estados){
	String c0 = "";
	String c1="";
	String c2="";
		boolean estatus = true;
		String [][] matriz2;
		int aceptacion [][];
		int transicion[];
		int noAcepta = 0;
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

		
		
		
	
		
		
	return quintupla;	
	}
}
