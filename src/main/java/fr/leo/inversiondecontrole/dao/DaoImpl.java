package fr.leo.inversiondecontrole.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("dao")
public class DaoImpl implements IDao{

	@Override
	public double getData() {
		/**
		 * je me connecte � la base de donn�es
		 */
		double data = 98;
		return data;
	}

}
