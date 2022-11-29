package fr.leo.inversiondecontrole.presentation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.leo.inversiondecontrole.metier.IMetier;



public class PresentationAvecSpring {

	public static void main(String[] args) {
		
		/**
		 * INJECTION DES DEPENDANCES VIA SPRING ! 
		 */	

		/**
		 * Pour utiliser Spring, qu'est ce que on va faire ?
		 * 
		 * On va cr�er un fichier de configuration, equivalent
		 *  de notre fichier texte, sauf que c'est un fichier xml
		 *  
		 *  Dans ce fichier il y a une balise <beans>
		 *   et dans cette balise vous allez d�clarer des beans  <bean>
		 *   <bean id="Nom" class="NomClasse"></bean>
		 *   
		 *   Quand Spring va d�marer,
		 *   	il va lire ce fichier xml, 
		 *   	et il va faire class.fornmame/newInstance
		 *   	de toutes les classes d�clar�es dans votre fichier xml,
		 *   	   ... et il va placer toutes les instances dans une collection
		 *   		de type Map (cl�/value) et la cl� sera l'Id d�clar� dans
		 *   		le fichier xml !
		 *   		La cl� sera 'id' et la valeur sera l'objet instance de la classe !
		 *   
		 *   	Donc on va �crire dans notre fichier :
		 *        <beans>
		 *   		<bean id="d" class="fr.leo.inversiondecontrole.dao.DaoImpl"></bean>
		 *   		<bean id="metier" class="fr.leo.inversiondecontrole.metier.MetierImpl"> 
		 *   			<property name="dao" ref="d"> </property>
		 *   		</bean>
		 *   	  </beans>
		 */
		
		//ApplicationContext Springcontext = new ClassPathXmlApplicationContext("config.xml");
		ApplicationContext Springcontext = new AnnotationConfigApplicationContext("fr.leo.inversiondecontrole.dao", "fr.leo.inversiondecontrole.metier");
		
		// Ici on lui pr�cise le nom du bean, c'est le nom 
		//  que on a pr�cis� dans l'annotation => IMetier metier = (IMetier) Springcontext.getBean("metier");
		IMetier metier =  Springcontext.getBean(IMetier.class);
		System.out.println(metier.calcul());
	}
}
