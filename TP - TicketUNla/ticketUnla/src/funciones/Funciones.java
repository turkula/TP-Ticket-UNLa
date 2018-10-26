package funciones;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Funciones {

	public static boolean esBisiesto(GregorianCalendar f) {

		boolean esBisiesto;

		if (f.get(Calendar.YEAR) % 4 == 0) {
			if ((f.get(Calendar.YEAR) % 100 == 0) && (f.get(Calendar.YEAR) % 400 != 0))
				esBisiesto = false;
			else
				esBisiesto = true;
		} else
			esBisiesto = false;

		return esBisiesto;

	}// End esBisiesto()

	public static int traerAnio(GregorianCalendar f) {
		return f.get(Calendar.YEAR);
	}// End traerAnio()

	public static int traerMes(GregorianCalendar f) {
		return f.get(Calendar.MONTH) + 1;
	}// End traerMes()

	public static int traerDia(GregorianCalendar f) {
		return f.get(Calendar.DAY_OF_MONTH);
	}// End traerDia()

	public static boolean esFechaValida(int anio, int mes, int dia) {

		boolean esValido = true;
		GregorianCalendar f = new GregorianCalendar(anio, mes - 1, dia);

		if ((mes != traerMes(f)) || (dia != traerDia(f)))
			esValido = false;

		return esValido;

	}// End esFechaValida()
	
	public static boolean esMesValido(int mes){
		boolean esValido=false;
		if(mes>=1 && mes<=12) esValido=true;
		return esValido;
	}

	public static GregorianCalendar traerFecha(int anio, int mes, int dia) {

		return new GregorianCalendar(anio, mes - 1, dia);

	}// End traerFecha()

	public static GregorianCalendar traerFecha(String f) {

		int dia = Integer.parseInt(f.substring(0, 2));
		int mes = Integer.parseInt(f.substring(3, 5));
		int anio = Integer.parseInt(f.substring(6, 10));

		return new GregorianCalendar(anio, mes - 1, dia);

	}// End traerFecha()

	public static String traerFechaCorta(GregorianCalendar f) {
		String fechaCorta = "";

		if (traerDia(f) < 10)
			fechaCorta += "0";
		fechaCorta += traerDia(f) + "/";
		if (traerMes(f) < 10)
			fechaCorta += "0";
		fechaCorta += traerMes(f) + "/";
		fechaCorta += traerAnio(f) + "";

		return fechaCorta;

	}// End traerFechaCorta()

	public static String traerFechaCortaHora(GregorianCalendar f) {
		String fechaCortaHora = "";

		if (traerDia(f) < 10)
			fechaCortaHora += "0";
		fechaCortaHora += traerDia(f) + "/";
		if (traerMes(f) < 10)
			fechaCortaHora += "0";
		fechaCortaHora += traerMes(f) + "/";
		fechaCortaHora += traerAnio(f) + " ";

		if (f.get(Calendar.HOUR_OF_DAY) < 10)
			fechaCortaHora += "0";
		fechaCortaHora += f.get(Calendar.HOUR_OF_DAY) + ":";
		if (f.get(Calendar.MINUTE) < 10)
			fechaCortaHora += "0";
		fechaCortaHora += f.get(Calendar.MINUTE) + ":";
		if (f.get(Calendar.SECOND) < 10)
			fechaCortaHora += "0";
		fechaCortaHora += f.get(Calendar.SECOND) + "";

		return fechaCortaHora;

	}// End traerFechaCortaHora()

	public static GregorianCalendar traerFechaProximo(GregorianCalendar fecha, int cantDias) {

		GregorianCalendar fechaProxima = new GregorianCalendar(traerAnio(fecha), traerMes(fecha), traerDia(fecha));
		fechaProxima.add(Calendar.DAY_OF_MONTH, cantDias);
		return fechaProxima;

	}// End traerFechaProximo()

	public static boolean esDiaHabil(GregorianCalendar fecha) {

		if ((fecha.get(Calendar.DAY_OF_WEEK) == 1) || (fecha.get(Calendar.DAY_OF_WEEK) == 7))
			return false;

		return true;

	}// End esDiaHabil()

	public static String traerDiaDeLaSemana(GregorianCalendar fecha) {

		String sDia = "";
		int iDia = fecha.get(Calendar.DAY_OF_WEEK);

		if (iDia == 1)
			sDia = "Domingo";
		if (iDia == 2)
			sDia = "Lunes";
		if (iDia == 3)
			sDia = "Martes";
		if (iDia == 4)
			sDia = "Miercoles";
		if (iDia == 5)
			sDia = "Jueves";
		if (iDia == 6)
			sDia = "Viernes";
		if (iDia == 7)
			sDia = "Sabado";

		return sDia;

	}// End traerDiaDeLaSemana()

	public static String traerElMesEnLetras(GregorianCalendar fecha) {

		String sMes = "";
		int iMes = fecha.get(Calendar.MONTH);

		if (iMes == 0)
			sMes = "Enero";
		if (iMes == 1)
			sMes = "Febrero";
		if (iMes == 2)
			sMes = "Marzo";
		if (iMes == 3)
			sMes = "Abril";
		if (iMes == 4)
			sMes = "Mayo";
		if (iMes == 5)
			sMes = "Junio";
		if (iMes == 6)
			sMes = "Julio";
		if (iMes == 7)
			sMes = "Agosto";
		if (iMes == 8)
			sMes = "Septiembre";
		if (iMes == 9)
			sMes = "Octubre";
		if (iMes == 10)
			sMes = "Noviembre";
		if (iMes == 11)
			sMes = "Diciembre";

		return sMes;

	}// End traerElMesEnLetras()

	public static String traerFechaLarga(GregorianCalendar fecha) {

		String fechaLarga = "";

		fechaLarga += traerDiaDeLaSemana(fecha) + " " + fecha.get(Calendar.DAY_OF_MONTH);
		fechaLarga += " de " + traerElMesEnLetras(fecha);
		fechaLarga += " del " + fecha.get(Calendar.YEAR);

		return fechaLarga;

	}// End traerFechaLarga()

	public static boolean sonFechasIguales(GregorianCalendar fecha1, GregorianCalendar fecha2) {

		boolean sonIguales = false;

		String sFecha1 = traerFechaCorta(fecha1);
		String sFecha2 = traerFechaCorta(fecha2);

		if (sFecha1.compareTo(sFecha2) == 0)
			sonIguales = true;

		/*
		 * if( traerAnio(fecha1) == traerAnio(fecha2) ){ if( traerMes(fecha1) ==
		 * traerMes(fecha2) ){ if(traerDia(fecha1) == traerMes(fecha2) )
		 * sonIguales = true; } }
		 */

		return sonIguales;

	}// End sonFechasIguales()

	public static boolean sonFechasHorasIguales(GregorianCalendar fecha1, GregorianCalendar fecha2) {

		boolean sonIguales = false;

		String sFecha1 = traerFechaCortaHora(fecha1);
		String sFecha2 = traerFechaCortaHora(fecha2);

		if (sFecha1.compareTo(sFecha2) == 0)
			sonIguales = true;

		/*
		 * if( traerAnio(fecha1) == traerAnio(fecha2) ){ if( traerMes(fecha1) ==
		 * traerMes(fecha2) ){ if(traerDia(fecha1) == traerMes(fecha2) )
		 * if(fecha1.get(Calendar.HOUR_OF_DAY) ==
		 * fecha2.get(Calendar.HOUR_OF_DAY)) sonIguales = true; } }
		 */

		return sonIguales;

	}// End sonFechasHorasIguales()
	
	public static boolean fecha1Mayorfecha2 (GregorianCalendar fecha1, GregorianCalendar fecha2) {
		boolean esMayor = false;
		if (fecha1.compareTo(fecha2) == 1)
			esMayor = true;
		return esMayor;
	}
	
	public static boolean fecha1Menorfecha2 (GregorianCalendar fecha1, GregorianCalendar fecha2) {
		boolean esMenor = false;
		if (fecha1.compareTo(fecha2) == -1)
			esMenor = true;
		return esMenor;
	}
	
	public static boolean fecha1MayorIgualfecha2 (GregorianCalendar fecha1, GregorianCalendar fecha2) {
		boolean esMayorIgual = false;
		if (fecha1Mayorfecha2(fecha1,fecha2)||sonFechasIguales(fecha1,fecha2))esMayorIgual=true;
		return esMayorIgual;
	}

	public static boolean fecha1MenorIgualfecha2 (GregorianCalendar fecha1, GregorianCalendar fecha2) {
		boolean esMenorIgual = false;
		if (fecha1Menorfecha2(fecha1,fecha2)||sonFechasIguales(fecha1,fecha2))esMenorIgual=true;
		return esMenorIgual;
	}


	public static int traerCantDiasDeUnMes(int anio, int mes) {

		GregorianCalendar fecha = traerFecha(anio, mes, 1);

		return fecha.getActualMaximum(Calendar.DAY_OF_MONTH);

	}// End traerCantDiasDeUnMes()

	public static double aproximar2Decimales(double valor) {

		int iValor = (int) (valor * 1000);
		int tercerDec = iValor - ((iValor / 10) * 10);
		iValor = iValor / 10;

		if (tercerDec >= 5)
			iValor += 1;

		return ((double) iValor) / 100;

	}// End aproximar2Decimales()

	public static boolean esNumero(char c) {

		int i = (int) c;
		boolean esNumero = false;

		if (i >= 48 && i <= 57)
			esNumero = true;

		return esNumero;

	}// End esNumero()

	public static boolean esLetra(char c) {

		int i = (int) c;
		boolean esLetra = false;

		if ((i >= 65 && i <= 90) || (i >= 97 && i <= 122))
			esLetra = true;

		return esLetra;

	}// End esCaracter()

	public static boolean esCadenaNros(String cadena) {

		int i = 0;
		boolean esCadenaNros = true;

		while (esCadenaNros && i < cadena.length()) {
			if (!esNumero(cadena.charAt(i)))
				esCadenaNros = false;

			i++;
		}

		return esCadenaNros;

	}// Fin esCadenaNros()

	public static boolean esCadenaLetras(String cadena) {

		int i = 0;
		boolean esCadenaLetras = true;

		while (esCadenaLetras && i < cadena.length()) {
			if (!esLetra(cadena.charAt(i)))
				esCadenaLetras = false;
			i++;
		}

		return esCadenaLetras;
	}// Fin esCadenaLetras()

	public static double convertirADouble(int n) {
		return ((double) n);
	}// Fin convertirADouble()

}// Fin Clase Funciones