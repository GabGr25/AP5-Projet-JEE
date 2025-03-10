package junia.projetJEE.core.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class IdGeneratorService {

    public long generateId(GenericService service){
        long sizeEntities = service.countAll();
        int dayOfMonth = LocalDate.now().getDayOfMonth();
        return (dayOfMonth <= sizeEntities) ? dayOfMonth : (dayOfMonth % sizeEntities) + 1;
    }
}
