package dao;

import org.springframework.stereotype.Component;

@Component("metier")
public class DaoImpl implements IDao{
    @Override
    public double getData() {
        /*
        * Se connecter a la bdd pour recuperer la temperature
        *
        */
        System.out.println("version BDD");
        double temp=Math.random()*40;
        return temp;
    }
}
