package ma.enset.ahadjanemohcine.mohcineahadjaneexam.mappers;

import ma.enset.ahadjanemohcine.mohcineahadjaneexam.dtos.ModerateurDTO;
import ma.enset.ahadjanemohcine.mohcineahadjaneexam.dtos.SessionDTO;
import ma.enset.ahadjanemohcine.mohcineahadjaneexam.entities.Moderateur;
import ma.enset.ahadjanemohcine.mohcineahadjaneexam.entities.Session;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ConferenceMappers {
    public SessionDTO fromSession(Session session){
        SessionDTO sessionDTO = new SessionDTO();
        BeanUtils.copyProperties(session, sessionDTO);
        return  sessionDTO;
    }
    public Session fromSessionDT(SessionDTO sessionDTO) {
        Session session=new Session();
        BeanUtils.copyProperties(sessionDTO,session);
        return session;
    }

    public ModerateurDTO fromModerateur(Moderateur moderateur){
        ModerateurDTO moderateurDTO= new ModerateurDTO();
        BeanUtils.copyProperties(moderateur, moderateurDTO);
        return moderateurDTO;
    }
}
