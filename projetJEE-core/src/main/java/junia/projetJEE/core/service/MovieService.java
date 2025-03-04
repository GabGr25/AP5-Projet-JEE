package junia.projetJEE.core.service;

import jakarta.transaction.Transactional;
import junia.projetJEE.core.dao.MovieDAO;
import junia.projetJEE.core.entity.Movie;
import junia.projetJEE.core.entity.Phase;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MovieService extends GenericService<Movie> {

    private final PhaseService phaseService;

    protected MovieService(MovieDAO internalDAO, PhaseService phaseService) {
        super(internalDAO);
        this.phaseService = phaseService;
    }

    public Movie saveMovieInPhase(Movie movie, long phaseId) {
        Phase phase = phaseService.findOne(phaseId);
        movie.setPhase(phase);
        return getInternalDAO().save(movie);
    }
}
