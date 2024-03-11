package lab07.web.gateway;

import lab07.web.data.Subject;
import lab07.web.dto.SubjectDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class SubjectGateway {

    public static final String URI = "/subjects/";

    private final RestClient restClient;

    public SubjectGateway(RestClient restClient) {
        this.restClient = restClient;
    }




    public Subject findById(long subjectId) {
        return fromDTO(restClient.get()
                .uri(URI + subjectId)
                .retrieve()
                .body(SubjectDTO.class));
    }

    private Subject fromDTO(SubjectDTO subjectDTO) {
        Subject subject = new Subject();
        subject.setId(subjectDTO.getId());
        subject.setName(subjectDTO.getName());
        subject.setWeight(subjectDTO.getWeight());
        return subject;
    }
}
