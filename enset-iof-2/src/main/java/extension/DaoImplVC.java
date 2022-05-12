package extension;

import dao.IDao;
import org.springframework.stereotype.Component;

@Component
public class DaoImplVC implements IDao {
    @Override
    public double getData() {
        System.out.println("Version des capteurs");
        double temp= 1000;
        return temp;
    }
}
