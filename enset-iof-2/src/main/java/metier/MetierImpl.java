package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MetierImpl implements IMetier {
    //couplage faible
    @Autowired
    private IDao dao;

    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() {
        double tmp=dao.getData();
        double res=tmp*7658*Math.sin(tmp/Math.PI);
        return res;
    }
  /*
   injecter dans la variable dao un objet
   d'une classe qui implemente l'interface IDao
  */
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
