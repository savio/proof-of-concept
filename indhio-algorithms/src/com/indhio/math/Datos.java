package com.indhio.math;

import java.util.Iterator;

/*TODO en esta clase se hace todos los analisis de datos

 asi que se pueden aumentar las medidas e indices aqui,
 como por ejemplo, dimencion fractal*/

class Datos {
	/*
	 * en esta clase se calculan las propiedades de la matriz y shanon todas escritas para n Gradilla.especies
	

	static int x = Gradilla.x, y = Gradilla.y;
	static int[] proporciones;
	static double conectividad, unos, menosunos, divercidadMatriz, simetriaMatriz;
	// en este string se ponen todos los datos resultantes
	static String resultado;

	// variables que se utilizan para obtener los datos finales
	static Iterator iterador;
	static SimpleRegression regresion = new SimpleRegression();

	static public double sacaSimetria() throws Exception {
		// Este metodo te permite obtener la simnetria de la matriz 

		int sup = 0;
		int inf = 0;
		double max = 0;
		double simetria = 0;

		// corres for's del Gradilla.especies*Gradilla.especies tamaño para ver todas las relaciones
		for (int i = 0; i < Gradilla.especies; i++)
			for (int j = 0; j < Gradilla.especies; j++) {

				// cuentas los 1's o -1's de arriva o abajo de la lateral
				if (j < i)
					if (Relacion.relaciones[i][j] != 0)
						sup++;
				if (i < j)
					if (Relacion.relaciones[i][j] != 0)
						inf++;
			}
		// calculas el maximo posible de relaciones
		max = ((Gradilla.especies * Gradilla.especies) - Gradilla.especies) / 2;
		if (max == 0)
			simetria = 0;
		else
			// si el maximo no es sero obtienes el valanse
			simetria = ((inf / max) - (sup / max));
		return simetria;
	}

	static public double sacaConectividad() throws Exception {
		// Este metodo te permite obtener la conectividad de la matriz 

		double relaciones = 0;
		double conectivi = 0;
		// primero cuentas las relaciones diferentes de cero
		for (int i = 0; i < Gradilla.especies; i++)
			for (int j = 0; j < Gradilla.especies; j++) {
				if (Relacion.relaciones[i][j] != 0)
					relaciones++;
			}
		// luego calculas la conectividad en base a todas las posibles
		// conneciones y las igual a cero
		conectivi = relaciones / (Gradilla.especies * Gradilla.especies);
		return conectivi;
	}

	static public double sacaConectividadUnos() throws Exception {
		// Este metodo te permite obtener la conectividad de la matriz 

		double relaciones = 0;
		double conectividadUnos = 0;
		// primero cuentas las relaciones diferentes de cero
		for (int i = 0; i < Gradilla.especies; i++)
			for (int j = 0; j < Gradilla.especies; j++) {
				if (Relacion.relaciones[i][j] != 0)
					// y diferntes de -uno
					if (Relacion.relaciones[i][j] != -1)
						relaciones++;
			}
		// luego calculas la conectividad
		conectividadUnos = relaciones / (Gradilla.especies * Gradilla.especies);
		return conectividadUnos;
	}

	static public double sacaConectividadMenosUnos() throws Exception {
		 //Este metodo te permite obtener la conectividad de la matriz 

		double relaciones = 0;
		double conectividadMenosUnos = 0;
		// primero cuentas las relaciones diferentes de cero
		for (int i = 0; i < Gradilla.especies; i++)
			for (int j = 0; j < Gradilla.especies; j++) {
				if (Relacion.relaciones[i][j] != 0)
					// y diferntes de -uno
					if (Relacion.relaciones[i][j] != 1)
						relaciones++;
			}
		// luego calculas la conectividad
		conectividadMenosUnos = relaciones / (Gradilla.especies * Gradilla.especies);
		return conectividadMenosUnos;
	}

	static public double sacaMdiversidad() throws Exception {
		 //Este metodo calcula la dibersidad de la matriz 

		// primero crea un array para guardar el numero de relaciones por sp's
		double mdiversidad = 0, numero = 0;
		double[] vertices = new double[(int) Gradilla.especies];

		// despues cuenta cuantos valores de relacion tiene cada especie
		for (int i = 0; i < Gradilla.especies; i++)
			for (int j = 0; j < Gradilla.especies; j++)
				if (Relacion.relaciones[i][j] != 0)
					vertices[i] = vertices[i] + 1;
		// luego obten la diversidad de la matriz
		for (int i = 0; i < Gradilla.especies; i++) {
			if (vertices[i] != 0) {
				numero = vertices[i] / (Gradilla.especies * Gradilla.especies);
				mdiversidad = mdiversidad + numero * Math.log(numero);
			}
		}
		return mdiversidad;
	}

	static public double sacaSimpson() throws Exception {
		 * Este metodo calcula el indice de dominancia de Simpson, es importante recalcar que es necesario calcular antes la diversidad(Shanon) ya que ese metodo llama a obten_Sps_Proporciones si no se desea obtener la biodiversidad es nesesario llamar antes a obten_Sps_Proporciones explicitamente

		double simpson = 0, numero = 0;
		// para todas las especies
		for (int i = 0; i < proporciones.length; ++i) {
			// no tomando en cuenta las especies extintas
			if (proporciones[i] != 0.0) {
				if ((proporciones[i] - 1) != 0.0) {
					numero = (double) (proporciones[i] * (proporciones[i] - 1)) / (((x * y) - (double) proporciones[0]) * (((x * y) - (double) proporciones[0]) - 1));
					simpson = simpson + numero;
				}
			}
		}
		return simpson;
	}

	static public double sacaDiversidad() throws Exception {
		 * Este metodo calcula en indise de shanon de la biodiversidad para la matriz del autmoata
		// calculas las proporciones por especies primero
		obten_Sps_Proporciones(Gradilla.aA2);
		double diversidad = 0, numero = 0;
		// este metodo solo tiene un for para obtener la diversidad de la matriz de proporciones creada en otro metodo
		for (int i = 1; i < proporciones.length; ++i) {
			if (proporciones[i] != 0.0) {
				numero = (double) proporciones[i] / ((x * y) - (double) proporciones[0]);
				diversidad = diversidad + (numero * Math.log(numero));
			}
		}
		return (diversidad * (-1));
	}

	static public void obten_Sps_Proporciones(byte aA2[][]) throws Exception {
		// Esta funcion se encarga de calcular la matriz de proporciones la cual simplemente es una matriz en la cual cada reglon represanta la abundancia de una Gradilla.especies (el reglon 0 es de las casillas vacias)

		// primero inizializa la matriz
		proporciones = new int[Gradilla.automatas];
		// segundo cuenta cuantos individuos hay por cada especie
		for (int i = 0; i < x; ++i)
			for (int j = 0; j < y; ++j) {
				proporciones[(aA2[i][j]) - 1] = proporciones[(aA2[i][j]) - 1] + 1;
			}
	}

	static public void calculaPropiedadesMatriz() throws Exception {
		// * este metodo se utiliza para calcular todas las propiedades de la matriz, conectividad, cantidad de unos y menos unos en la matriz de relacion, todos esto en bunche
		conectividad = sacaConectividad();
		unos = sacaConectividadUnos();
		menosunos = sacaConectividadMenosUnos();
		divercidadMatriz = sacaMdiversidad();
		simetriaMatriz = sacaSimetria();
	}

	public void resultadosFinalesTotales() throws Exception {
		// * este metodo se encarga de jenerar los histogramas de distribucion y sus respectivas regresion lineales, ademas de obtener las propiedades de la matriz de interaccion y por ultimo escrivir esto en un archivo

		// debug
		// System.out.println("muertos");
		// System.out.println(Gradilla.frecMuertos.toString());
		// System.out.println("nacimientos");
		// System.out.println(Gradilla.frecNacimientos.toString());
		// System.out.println("inestavilidad");
		// System.out.println(Gradilla.frecInestavilidad.toString());

		resultado = Gradilla.nombre + ",";

		// primero se pone el numero de Gradilla.especies
		resultado = resultado + Gradilla.especies;

		// este iterador es necesario para obtener la frecuencia

		// -------------------------------muertos------------------------------------
		// -------------------------------muertos------------------------------------
		iterador = Gradilla.frecMuertos.valuesIterator();
		// los objetos para la regrecion normal y acumulada
		regresion.clear();
		// valor que representa la cantidad de veses que a sido encontrado un numero
		int numero;
		// esto inizializa el histograma de frecuencias
		while (iterador.hasNext()) {
			numero = (int) (((Long) iterador.next()).intValue());
			if (Gradilla.frecMuertos.getCount(numero) != 0) {
				regresion.addData(Math.log10(numero), Math.log10(Gradilla.frecMuertos.getCount(numero)));
			}
			iterador.remove();
		}
		resultado = resultado + ", " + regresion.getSlope() + ", " + regresion.getSlopeStdErr();
		// tambien calculas el promedio de muertes y su varianza
		resultado = resultado + ", " + Gradilla.muertosStats.getMean();
		resultado = resultado + ", " + Gradilla.muertosStats.getStandardDeviation();
		// --------------------fin-------muertos------------------------------------
		// --------------------fin--------muertos------------------------------------

		// -------------------------------nacimienotos-------------------
		// -------------------------------nacimienotos-------------------
		iterador = Gradilla.frecNacimientos.valuesIterator();

		// El objeto para la regrecion
		regresion.clear();
		// esto inizializa el histograma de frecuencias
		while (iterador.hasNext()) {
			numero = (int) (((Long) iterador.next()).intValue());
			if (Gradilla.frecNacimientos.getCount(numero) != 0) {
				regresion.addData(Math.log10(numero), Math.log10(Gradilla.frecNacimientos.getCount(numero)));
			}
			iterador.remove();
		}
		resultado = resultado + ", " + regresion.getSlope() + ", " + regresion.getSlopeStdErr();
		// tambien calculas el promedio de nacimientos y su varianza
		resultado = resultado + ", " + Gradilla.nacimientosStats.getMean();
		resultado = resultado + ", " + Gradilla.nacimientosStats.getStandardDeviation();

		// --------------------fin--------nacimienotos-------------------
		// --------------------fin--------nacimienotos-------------------

		// -------------------------------inestavilidad-------------------
		// -------------------------------inestavilidad-------------------

		iterador = Gradilla.frecInestavilidad.valuesIterator();
		// El objeto para la regrecion
		regresion.clear();
		// esto inizializa el histograma de frecuencias
		while (iterador.hasNext()) {
			numero = (int) (((Long) iterador.next()).intValue());
			if (Gradilla.frecInestavilidad.getCount(numero) != 0) {
				regresion.addData(Math.log10(numero), Math.log10(Gradilla.frecInestavilidad.getCount(numero)));
			}
			iterador.remove();
		}
		resultado = resultado + ", " + regresion.getSlope() + ", " + regresion.getSlopeStdErr();
		// tambien calculas el promedio de nacimientos y su varianza
		resultado = resultado + ", " + Gradilla.inestavilidadStats.getMean();
		resultado = resultado + ", " + Gradilla.inestavilidadStats.getStandardDeviation();
		// --------------------fin--------inestavilidad-------------------
		// --------------------fin--------inestavilidad-------------------

		// ---------------------------------Shanon-------------------------
		// ---------------------------------Shanon-------------------------

		// calculas las propiedades estadisticas del indice de shanon
		resultado = resultado + ", " + Gradilla.shanonStats.getMean();
		resultado = resultado + ", " + Gradilla.shanonStats.getStandardDeviation();
		// --------------------fin----------Shanon-------------------------
		// --------------------fin----------Shanon-------------------------

		// -------------------------------SIMSON----------------------------
		// -------------------------------SIMSON----------------------------
		// calculas las propiedades estadisticas del indice de simpson
		resultado = resultado + ", " + Gradilla.simpsonStats.getMean();
		resultado = resultado + ", " + Gradilla.simpsonStats.getStandardDeviation();
		// ---------------------FIN-------SIMSON----------------------------
		// ---------------------FIN-------SIMSON----------------------------

		// ------------------propiedades de la matriz-----------------------
		// ------------------propiedades de la matriz-----------------------
		// conectividad
		resultado = resultado + ", " + conectividad;
		// unos
		resultado = resultado + ", " + unos;
		// menosunos
		resultado = resultado + ", " + menosunos;
		// diagonal
		resultado = resultado + ", " + Gradilla.diagonal;
		// la diversidad de la matriz
		resultado = resultado + ", " + divercidadMatriz;
		// la simatria de la matriz
		resultado = resultado + ", " + simetriaMatriz;
		// -----------fin----propiedades de la matriz-----------------------
		// -----------fin----propiedades de la matriz-----------------------

		// -------------tipo de disturbio-----------------------------------
		// -------------tipo de disturbio-----------------------------------
		resultado = resultado + ", " + Gradilla.powerLaw;
		resultado = resultado + ", " + Gradilla.beta;
		resultado = resultado + ", " + Gradilla.disturbio_max;
		// --------fin-----tipo de disturbio-----------------------------------
		// --------fin-----tipo de disturbio-----------------------------------

		// cuantifica el numero de atractores encontrados
		resultado = resultado + ", " + Gradilla.atracEncontrados;

		// por ultimo escrives los datos
		Gradilla.BuferResultadosTot.write(resultado);
		Gradilla.BuferResultadosTot.newLine();

	}

	public void resultadosFinales1() throws Exception {
		// este metodo se encarga de jenerar los histogramas de distribucion y sus respectivas regresion lineales, ademas de obtener las propiedades de la matriz de interaccion de las primeras mil iteraciones del modelo y por ultimo escrivir esto en un archivo

		// debug
		// System.out.println("muertos");
		// System.out.println(Gradilla.frecMuertos.toString());
		// System.out.println("nacimientos");
		// System.out.println(Gradilla.frecNacimientos.toString());
		// System.out.println("inestavilidad");
		// System.out.println(Gradilla.frecInestavilidad.toString());

		resultado = Gradilla.nombre + ",";

		// primero se pone el numero de Gradilla.especies
		resultado = resultado + Gradilla.especies;

		// este iterador es necesario para obtener la frecuencia

		// -------------------------------muertos------------------------------------
		// -------------------------------muertos------------------------------------
		iterador = Gradilla.frecMuertos1.valuesIterator();
		// los objetos para la regrecion normal y acumulada
		regresion.clear();
		// valor que representa la cantidad de veses que a sido encontrado un numero
		int numero;
		// esto inizializa el histograma de frecuencias
		while (iterador.hasNext()) {
			numero = (int) (((Long) iterador.next()).intValue());
			if (Gradilla.frecMuertos1.getCount(numero) != 0) {
				regresion.addData(Math.log10(numero), Math.log10(Gradilla.frecMuertos1.getCount(numero)));
			}
			iterador.remove();
		}
		resultado = resultado + ", " + regresion.getSlope() + ", " + regresion.getSlopeStdErr();
		// tambien calculas el promedio de muertes y su varianza
		resultado = resultado + ", " + Gradilla.muertosStats1.getMean();
		resultado = resultado + ", " + Gradilla.muertosStats1.getStandardDeviation();
		// --------------------fin-------muertos------------------------------------
		// --------------------fin--------muertos------------------------------------

		// -------------------------------nacimienotos-------------------
		// -------------------------------nacimienotos-------------------
		iterador = Gradilla.frecNacimientos1.valuesIterator();

		// El objeto para la regrecion
		regresion.clear();
		// esto inizializa el histograma de frecuencias
		while (iterador.hasNext()) {
			numero = (int) (((Long) iterador.next()).intValue());
			if (Gradilla.frecNacimientos1.getCount(numero) != 0) {
				regresion.addData(Math.log10(numero), Math.log10(Gradilla.frecNacimientos1.getCount(numero)));
			}
			iterador.remove();
		}
		resultado = resultado + ", " + regresion.getSlope() + ", " + regresion.getSlopeStdErr();
		// tambien calculas el promedio de nacimientos y su varianza
		resultado = resultado + ", " + Gradilla.nacimientosStats1.getMean();
		resultado = resultado + ", " + Gradilla.nacimientosStats1.getStandardDeviation();

		// --------------------fin--------nacimienotos-------------------
		// --------------------fin--------nacimienotos-------------------

		// -------------------------------inestavilidad-------------------
		// -------------------------------inestavilidad-------------------

		iterador = Gradilla.frecInestavilidad1.valuesIterator();
		// El objeto para la regrecion
		regresion.clear();
		// esto inizializa el histograma de frecuencias
		while (iterador.hasNext()) {
			numero = (int) (((Long) iterador.next()).intValue());
			if (Gradilla.frecInestavilidad1.getCount(numero) != 0) {
				regresion.addData(Math.log10(numero), Math.log10(Gradilla.frecInestavilidad1.getCount(numero)));
			}
			iterador.remove();
		}
		resultado = resultado + ", " + regresion.getSlope() + ", " + regresion.getSlopeStdErr();
		// tambien calculas el promedio de nacimientos y su varianza
		resultado = resultado + ", " + Gradilla.inestavilidadStats1.getMean();
		resultado = resultado + ", " + Gradilla.inestavilidadStats1.getStandardDeviation();
		// --------------------fin--------inestavilidad-------------------
		// --------------------fin--------inestavilidad-------------------

		// ---------------------------------Shanon-------------------------
		// ---------------------------------Shanon-------------------------

		// calculas las propiedades estadisticas del indice de shanon
		resultado = resultado + ", " + Gradilla.shanonStats1.getMean();
		resultado = resultado + ", " + Gradilla.shanonStats1.getStandardDeviation();
		// --------------------fin----------Shanon-------------------------
		// --------------------fin----------Shanon-------------------------

		// -------------------------------SIMSON----------------------------
		// -------------------------------SIMSON----------------------------
		// calculas las propiedades estadisticas del indice de simpson
		resultado = resultado + ", " + Gradilla.simpsonStats1.getMean();
		resultado = resultado + ", " + Gradilla.simpsonStats1.getStandardDeviation();
		// ---------------------FIN-------SIMSON----------------------------
		// ---------------------FIN-------SIMSON----------------------------

		// ------------------propiedades de la matriz-----------------------
		// ------------------propiedades de la matriz-----------------------
		// conectividad
		resultado = resultado + ", " + conectividad;
		// unos
		resultado = resultado + ", " + unos;
		// menosunos
		resultado = resultado + ", " + menosunos;
		// diagonal
		resultado = resultado + ", " + Gradilla.diagonal;
		// la diversidad de la matriz
		resultado = resultado + ", " + divercidadMatriz;
		// la simatria de la matriz
		resultado = resultado + ", " + simetriaMatriz;
		// -----------fin----propiedades de la matriz-----------------------
		// -----------fin----propiedades de la matriz-----------------------

		// -------------tipo de disturbio-----------------------------------
		// -------------tipo de disturbio-----------------------------------
		resultado = resultado + ", " + Gradilla.powerLaw;
		resultado = resultado + ", " + Gradilla.beta;
		resultado = resultado + ", " + Gradilla.disturbio_max;
		// --------fin-----tipo de disturbio-----------------------------------
		// --------fin-----tipo de disturbio-----------------------------------

		// cuantifica el numero de atractores encontrados
		resultado = resultado + ", " + Gradilla.atracEncontrados1;

		// por ultimo escrives los datos
		Gradilla.BuferResultados1.write(resultado);
		Gradilla.BuferResultados1.newLine();

	}

	public void resultadosFinales2() throws Exception {
		 * este metodo se encarga de jenerar los histogramas de distribucion y sus respectivas regresion lineales, ademas de obtener las propiedades de la matriz de interaccion y por ultimo escrivir esto en un archivo

		// debug
		// System.out.println("muertos");
		// System.out.println(Gradilla.frecMuertos.toString());
		// System.out.println("nacimientos");
		// System.out.println(Gradilla.frecNacimientos.toString());
		// System.out.println("inestavilidad");
		// System.out.println(Gradilla.frecInestavilidad.toString());
		resultado = Gradilla.nombre + ",";

		// primero se pone el numero de Gradilla.especies
		resultado = resultado + Gradilla.especies;

		// este iterador es necesario para obtener la frecuencia

		// -------------------------------muertos------------------------------------
		// -------------------------------muertos------------------------------------
		iterador = Gradilla.frecMuertos2.valuesIterator();
		// los objetos para la regrecion normal y acumulada
		regresion.clear();
		// valor que representa la cantidad de veses que a sido encontrado un numero
		int numero;
		// esto inizializa el histograma de frecuencias
		while (iterador.hasNext()) {
			numero = (int) (((Long) iterador.next()).intValue());
			if (Gradilla.frecMuertos2.getCount(numero) != 0) {
				regresion.addData(Math.log10(numero), Math.log10(Gradilla.frecMuertos2.getCount(numero)));
			}
			iterador.remove();
		}
		resultado = resultado + ", " + regresion.getSlope() + ", " + regresion.getSlopeStdErr();
		// tambien calculas el promedio de muertes y su varianza
		resultado = resultado + ", " + Gradilla.muertosStats2.getMean();
		resultado = resultado + ", " + Gradilla.muertosStats2.getStandardDeviation();
		// --------------------fin-------muertos------------------------------------
		// --------------------fin--------muertos------------------------------------

		// -------------------------------nacimienotos-------------------
		// -------------------------------nacimienotos-------------------
		iterador = Gradilla.frecNacimientos2.valuesIterator();

		// El objeto para la regrecion
		regresion.clear();
		// esto inizializa el histograma de frecuencias
		while (iterador.hasNext()) {
			numero = (int) (((Long) iterador.next()).intValue());
			if (Gradilla.frecNacimientos2.getCount(numero) != 0) {
				regresion.addData(Math.log10(numero), Math.log10(Gradilla.frecNacimientos2.getCount(numero)));
			}
			iterador.remove();
		}
		resultado = resultado + ", " + regresion.getSlope() + ", " + regresion.getSlopeStdErr();
		// tambien calculas el promedio de nacimientos y su varianza
		resultado = resultado + ", " + Gradilla.nacimientosStats2.getMean();
		resultado = resultado + ", " + Gradilla.nacimientosStats2.getStandardDeviation();

		// --------------------fin--------nacimienotos-------------------
		// --------------------fin--------nacimienotos-------------------

		// -------------------------------inestavilidad-------------------
		// -------------------------------inestavilidad-------------------

		iterador = Gradilla.frecInestavilidad2.valuesIterator();
		// El objeto para la regrecion
		regresion.clear();
		// esto inizializa el histograma de frecuencias
		while (iterador.hasNext()) {
			numero = (int) (((Long) iterador.next()).intValue());
			if (Gradilla.frecInestavilidad2.getCount(numero) != 0) {
				regresion.addData(Math.log10(numero), Math.log10(Gradilla.frecInestavilidad2.getCount(numero)));
			}
			iterador.remove();
		}
		resultado = resultado + ", " + regresion.getSlope() + ", " + regresion.getSlopeStdErr();
		// tambien calculas el promedio de nacimientos y su varianza
		resultado = resultado + ", " + Gradilla.inestavilidadStats2.getMean();
		resultado = resultado + ", " + Gradilla.inestavilidadStats2.getStandardDeviation();
		// --------------------fin--------inestavilidad-------------------
		// --------------------fin--------inestavilidad-------------------

		// ---------------------------------Shanon-------------------------
		// ---------------------------------Shanon-------------------------

		// calculas las propiedades estadisticas del indice de shanon
		resultado = resultado + ", " + Gradilla.shanonStats2.getMean();
		resultado = resultado + ", " + Gradilla.shanonStats2.getStandardDeviation();
		// --------------------fin----------Shanon-------------------------
		// --------------------fin----------Shanon-------------------------

		// -------------------------------SIMSON----------------------------
		// -------------------------------SIMSON----------------------------
		// calculas las propiedades estadisticas del indice de simpson
		resultado = resultado + ", " + Gradilla.simpsonStats2.getMean();
		resultado = resultado + ", " + Gradilla.simpsonStats2.getStandardDeviation();
		// ---------------------FIN-------SIMSON----------------------------
		// ---------------------FIN-------SIMSON----------------------------

		// ------------------propiedades de la matriz-----------------------
		// ------------------propiedades de la matriz-----------------------
		// conectividad
		resultado = resultado + ", " + conectividad;
		// unos
		resultado = resultado + ", " + unos;
		// menosunos
		resultado = resultado + ", " + menosunos;
		// diagonal
		resultado = resultado + ", " + Gradilla.diagonal;
		// la diversidad de la matriz
		resultado = resultado + ", " + divercidadMatriz;
		// la simatria de la matriz
		resultado = resultado + ", " + simetriaMatriz;
		// -----------fin----propiedades de la matriz-----------------------
		// -----------fin----propiedades de la matriz-----------------------

		// -------------tipo de disturbio-----------------------------------
		// -------------tipo de disturbio-----------------------------------
		resultado = resultado + ", " + Gradilla.powerLaw;
		resultado = resultado + ", " + Gradilla.beta;
		resultado = resultado + ", " + Gradilla.disturbio_max;
		// --------fin-----tipo de disturbio-----------------------------------
		// --------fin-----tipo de disturbio-----------------------------------

		// cuantifica el numero de atractores encontrados
		resultado = resultado + ", " + Gradilla.atracEncontrados2;

		// por ultimo escrives los datos
		Gradilla.BuferResultados2.write(resultado);
		Gradilla.BuferResultados2.newLine();

	}

	public void resultadosFinales3() throws Exception {
		 * este metodo se encarga de jenerar los histogramas de distribucion y sus respectivas regresion lineales, ademas de obtener las propiedades de la matriz de interaccion y por ultimo escrivir esto en un archivo

		// debug
		// System.out.println("muertos");
		// System.out.println(Gradilla.frecMuertos.toString());
		// System.out.println("nacimientos");
		// System.out.println(Gradilla.frecNacimientos.toString());
		// System.out.println("inestavilidad");
		// System.out.println(Gradilla.frecInestavilidad.toString());
		resultado = Gradilla.nombre + ",";

		// primero se pone el numero de Gradilla.especies
		resultado = resultado + Gradilla.especies;

		// este iterador es necesario para obtener la frecuencia

		// -------------------------------muertos------------------------------------
		// -------------------------------muertos------------------------------------
		iterador = Gradilla.frecMuertos3.valuesIterator();
		// los objetos para la regrecion normal y acumulada
		regresion.clear();
		// valor que representa la cantidad de veses que a sido encontrado un numero
		int numero;
		// esto inizializa el histograma de frecuencias
		while (iterador.hasNext()) {
			numero = (int) (((Long) iterador.next()).intValue());
			if (Gradilla.frecMuertos3.getCount(numero) != 0) {
				regresion.addData(Math.log10(numero), Math.log10(Gradilla.frecMuertos3.getCount(numero)));
			}
			iterador.remove();
		}
		resultado = resultado + ", " + regresion.getSlope() + ", " + regresion.getSlopeStdErr();
		// tambien calculas el promedio de muertes y su varianza
		resultado = resultado + ", " + Gradilla.muertosStats3.getMean();
		resultado = resultado + ", " + Gradilla.muertosStats3.getStandardDeviation();
		// --------------------fin-------muertos------------------------------------
		// --------------------fin--------muertos------------------------------------

		// -------------------------------nacimienotos-------------------
		// -------------------------------nacimienotos-------------------
		iterador = Gradilla.frecNacimientos3.valuesIterator();

		// El objeto para la regrecion
		regresion.clear();
		// esto inizializa el histograma de frecuencias
		while (iterador.hasNext()) {
			numero = (int) (((Long) iterador.next()).intValue());
			if (Gradilla.frecNacimientos3.getCount(numero) != 0) {
				regresion.addData(Math.log10(numero), Math.log10(Gradilla.frecNacimientos3.getCount(numero)));
			}
			iterador.remove();
		}
		resultado = resultado + ", " + regresion.getSlope() + ", " + regresion.getSlopeStdErr();
		// tambien calculas el promedio de nacimientos y su varianza
		resultado = resultado + ", " + Gradilla.nacimientosStats3.getMean();
		resultado = resultado + ", " + Gradilla.nacimientosStats3.getStandardDeviation();

		// --------------------fin--------nacimienotos-------------------
		// --------------------fin--------nacimienotos-------------------

		// -------------------------------inestavilidad-------------------
		// -------------------------------inestavilidad-------------------

		iterador = Gradilla.frecInestavilidad3.valuesIterator();
		// El objeto para la regrecion
		regresion.clear();
		// esto inizializa el histograma de frecuencias
		while (iterador.hasNext()) {
			numero = (int) (((Long) iterador.next()).intValue());
			if (Gradilla.frecInestavilidad3.getCount(numero) != 0) {
				regresion.addData(Math.log10(numero), Math.log10(Gradilla.frecInestavilidad3.getCount(numero)));
			}
			iterador.remove();
		}
		resultado = resultado + ", " + regresion.getSlope() + ", " + regresion.getSlopeStdErr();
		// tambien calculas el promedio de nacimientos y su varianza
		resultado = resultado + ", " + Gradilla.inestavilidadStats3.getMean();
		resultado = resultado + ", " + Gradilla.inestavilidadStats3.getStandardDeviation();
		// --------------------fin--------inestavilidad-------------------
		// --------------------fin--------inestavilidad-------------------

		// ---------------------------------Shanon-------------------------
		// ---------------------------------Shanon-------------------------

		// calculas las propiedades estadisticas del indice de shanon
		resultado = resultado + ", " + Gradilla.shanonStats3.getMean();
		resultado = resultado + ", " + Gradilla.shanonStats3.getStandardDeviation();
		// --------------------fin----------Shanon-------------------------
		// --------------------fin----------Shanon-------------------------

		// -------------------------------SIMSON----------------------------
		// -------------------------------SIMSON----------------------------
		// calculas las propiedades estadisticas del indice de simpson
		resultado = resultado + ", " + Gradilla.simpsonStats3.getMean();
		resultado = resultado + ", " + Gradilla.simpsonStats3.getStandardDeviation();
		// ---------------------FIN-------SIMSON----------------------------
		// ---------------------FIN-------SIMSON----------------------------

		// ------------------propiedades de la matriz-----------------------
		// ------------------propiedades de la matriz-----------------------
		// conectividad
		resultado = resultado + ", " + conectividad;
		// unos
		resultado = resultado + ", " + unos;
		// menosunos
		resultado = resultado + ", " + menosunos;
		// diagonal
		resultado = resultado + ", " + Gradilla.diagonal;
		// la diversidad de la matriz
		resultado = resultado + ", " + divercidadMatriz;
		// la simatria de la matriz
		resultado = resultado + ", " + simetriaMatriz;
		// -----------fin----propiedades de la matriz-----------------------
		// -----------fin----propiedades de la matriz-----------------------

		// -------------tipo de disturbio-----------------------------------
		// -------------tipo de disturbio-----------------------------------
		resultado = resultado + ", " + Gradilla.powerLaw;
		resultado = resultado + ", " + Gradilla.beta;
		resultado = resultado + ", " + Gradilla.disturbio_max;
		// --------fin-----tipo de disturbio-----------------------------------
		// --------fin-----tipo de disturbio-----------------------------------

		// cuantifica el numero de atractores encontrados
		resultado = resultado + ", " + Gradilla.atracEncontrados3;

		// por ultimo escrives los datos
		Gradilla.BuferResultados3.write(resultado);
		Gradilla.BuferResultados3.newLine();

	}
	 */
}