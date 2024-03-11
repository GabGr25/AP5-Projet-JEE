package lab07.web.gateway;

import lab07.web.data.Grade;
import lab07.web.data.Subject;
import lab07.web.data.Type;
import lab07.web.dto.GradeDTO;
import lab07.web.dto.TypeDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class GradeGateway {


    public static final String URI = "/grades/";
    private final RestClient restClient;


    public GradeGateway(RestClient restClient) {
        this.restClient = restClient;
    }

    public void deleteGrade(long gradeId) {
        restClient.delete()
                .uri(URI + gradeId)
                .retrieve()
                .toBodilessEntity();
    }

    public Grade findById(long gradeId) {
        return fromDTO(restClient.get()
                .uri(URI + gradeId)
                .retrieve()
                .body(GradeDTO.class));
    }

    private Grade fromDTO(GradeDTO gradeDTO) {
        Type type = new Type();
        type.setId(gradeDTO.getType().getId());
        type.setName(gradeDTO.getType().getName());
        type.setWeight(gradeDTO.getType().getWeight());

        Subject subject = new Subject();
        subject.setId(gradeDTO.getSubject().getId());
        subject.setWeight(gradeDTO.getSubject().getWeight());
        subject.setName(gradeDTO.getSubject().getName());

        Grade grade = new Grade();
        grade.setId(gradeDTO.getId());
        grade.setGrade(gradeDTO.getGrade());
        grade.setDate(gradeDTO.getDate());
        grade.setType(type);
        grade.setSubject(subject);

        return grade;
    }

    public void updateGrade(Grade grade) {
        GradeDTO gradeDTO = new GradeDTO();
        gradeDTO.setId(grade.getId());
        gradeDTO.setGrade(grade.getGrade());
        gradeDTO.setDate(grade.getDate());
        gradeDTO.setType(new TypeDTO(grade.getType().getId()));

        restClient.post()
                .uri(URI + grade.getId())
                .body(gradeDTO)
                .retrieve()
                .toBodilessEntity();
    }

    public void addGrade(Grade grade, long studentId, long subjectId) {
        GradeDTO gradeDTO = new GradeDTO();
        gradeDTO.setId(grade.getId());
        gradeDTO.setGrade(grade.getGrade());
        gradeDTO.setDate(grade.getDate());
        gradeDTO.setType(new TypeDTO(grade.getType().getId()));
        restClient.post()
                .uri(URI ,uriBuilder -> uriBuilder
                        .queryParam("studentId", studentId)
                        .queryParam("subjectId", subjectId)
                        .build())
                .body(gradeDTO)
                .retrieve()
                .toBodilessEntity();
    }
}
