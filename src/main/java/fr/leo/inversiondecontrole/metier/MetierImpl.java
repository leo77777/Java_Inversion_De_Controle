package fr.leo.inversiondecontrole.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import fr.leo.inversiondecontrole.dao.IDao;

@Service("metier")
public class MetierImpl implements IMetier {
	
	// Il ne faut pas faire celà, 
	//  car on retombe dans un couplage fort !
	// private IDao dao = new DaoImpl();
	
	// Ci dessous la valeur par défaut est 'null'
	//  car on a pas encore créer l'objet !
	// Mais on ne veut pas créer cet objet maintenant
	//  car sinon mon applicatin sera foutue !
	
	@Autowired
	private IDao dao;

	@Override
	public double calcul() {
		double d = dao.getData();
		double res = d * 23;
		return res;
	}

	public void setDao(IDao dao) {
		this.dao = dao;
	}

}
