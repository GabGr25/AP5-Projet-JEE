package lab07.web.gateway;

import lab07.web.data.Subject;
import lab07.web.data.Type;
import lab07.web.dto.TypeDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TypeGateway {

    public static final String URI = "/types/";

    private final RestClient restClient;

    public TypeGateway(RestClient restClient) {
        this.restClient = restClient;
    }

    public List<Type> findAll() {
        List<TypeDTO> dtos = restClient.get()
                .uri(URI)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
        return dtos.stream().map(this::fromDTO).collect(Collectors.toList());
    }

    private Type fromDTO(TypeDTO typeDTO) {
        Type type = new Type();
        type.setId(typeDTO.getId());
        type.setName(typeDTO.getName());
        type.setWeight(typeDTO.getWeight());
        return type;
    }
}
