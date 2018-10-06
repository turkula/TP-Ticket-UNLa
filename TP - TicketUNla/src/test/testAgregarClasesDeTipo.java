package test;

import negocio.TipoAuditorioABM;
import negocio.TipoEventoABM;

public class testAgregarClasesDeTipo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TipoAuditorioABM taABM = new TipoAuditorioABM();
		TipoEventoABM teABM = new TipoEventoABM();
		
		try {
			 teABM.agregar("Pelicula");
			 teABM.agregar("Obra de teatro");
		     teABM.agregar("Concierto");
			
			taABM.agregar("Estadio");
			taABM.agregar("Teatro");
			taABM.agregar("Cine");
			

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage() );
		}
		
	}

}
