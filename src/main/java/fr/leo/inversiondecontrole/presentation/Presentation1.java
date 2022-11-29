package fr.leo.inversiondecontrole.presentation;

import fr.leo.inversiondecontrole.dao.DaoImpl;
import fr.leo.inversiondecontrole.metier.MetierImpl;

public class Presentation1 {

	public static void main(String[] args) {
		
		/**
		 * INJECTION DES DEPENDANCES PAR INSTANCIATION STATIQUE : cad 'new' !
		 */
		
		// ci dessous couplage fort
		MetierImpl metierImpl = new MetierImpl();
	
		// Encore une fois un couplage fort !
		DaoImpl dao = new DaoImpl();
		
		// Injection des dependances
		metierImpl.setDao(dao);		
		double res = metierImpl.calcul();
		System.out.println(res);
	}
}
