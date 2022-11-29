package fr.leo.inversiondecontrole.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

public class DaoImpl2 implements IDao{

	@Override
	public double getData() {
		/**
		 * je me connecte à un Webservice !
		 */
		System.out.println("version web service");
		double data = 12;
		return data;
	}

}
