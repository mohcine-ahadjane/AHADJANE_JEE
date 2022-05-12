package pres;

import dao.DaoImpl;
import extension.DaoImplVC;
import metier.MetierImpl;

public class Pres1 {

        public static void main(String[] args) {
            /*
            Injection des dependances par
            instanciation statique ==> new
             */
            DaoImpl dao=new DaoImpl();
            MetierImpl metier=new MetierImpl(dao);
            metier.setDao(dao);
            System.out.println("Resultat = " + metier.calcul());
        }
}
