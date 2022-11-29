package fr.leo.inversiondecontrole.presentation;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;
import fr.leo.inversiondecontrole.dao.IDao;
import fr.leo.inversiondecontrole.metier.IMetier;

public class Presentation2 {

	public static void main(String[] args) {
		
		/**
		 * INJECTION DES DEPENDANCES PAR INSTANCIATION DYNAMIQUE !
		 */	
		
		try {
			
			Scanner scanner = new Scanner(new File("src/config.txt"));
			String daoClassName = scanner.nextLine();			
			Class cDao = Class.forName(daoClassName);			
			IDao dao =  (IDao) cDao.newInstance();	
			
			
			/**
			 * METIER
			 */
			String metierClassName = scanner.nextLine();	
			Class cMetier = Class.forName(metierClassName);
			IMetier metier =  (IMetier) cMetier.newInstance();
			
			/**
			 * INJECTION DES DEPENDANCES :
			 * Comment invoker DYNAMIQUEMENT une méthode
			 */
			Method m = cMetier.getMethod("setDao", IDao.class );
			m.invoke(metier, dao);
			System.out.println(metier.calcul());
			
		} catch (FileNotFoundException | ClassNotFoundException |
				InstantiationException | IllegalAccessException | 
				NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
