package junia.projetJEE.data.service;


import jakarta.annotation.PostConstruct;
import junia.projetJEE.core.entity.Phase;
import junia.projetJEE.core.entity.Saga;
import junia.projetJEE.core.entity.Movie;
import junia.projetJEE.core.service.MovieService;
import junia.projetJEE.core.service.PhaseService;
import junia.projetJEE.core.service.SagaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


@Service
@Transactional
public class MCUDataService {

    private final SagaService sagaService;
    private final PhaseService phaseService;
    private final MovieService movieService;

    public MCUDataService(SagaService sagaService, PhaseService phaseService, MovieService movieService) {
        this.sagaService = sagaService;
        this.phaseService = phaseService;
        this.movieService = movieService;
    }


    @PostConstruct
    public void initData() throws Exception {
        cleanDB();
        final Map<String, Saga> sagas = registerSagas();
        final Map<String, Phase> phases = registerPhases(sagas);
        registerMovies(phases);
    }

    private void cleanDB() {
        movieService.deleteAll();
        phaseService.deleteAll();
        sagaService.deleteAll();
    }


    private Map<String, Saga> registerSagas() {
        Map<String, Saga> sagas = new HashMap<>();
        sagas.put("infinity", createSaga("The Infinity Saga" ));
        sagas.put("multiverse", createSaga("The Multiverse Saga" ));
        return sagas;
    }


    private Saga createSaga(String sagaName) {
        System.out.println("Registring " + sagaName);
        Saga saga = new Saga();
        saga.setName(sagaName);
        sagaService.save(saga);
        return saga;
    }


    private Map<String, Phase> registerPhases(Map<String,Saga> sagas) {
        Map<String, Phase> phases = new HashMap<>();
        phases.put("phase1", createPhase("Phase I",sagas.get("infinity")));
        phases.put("phase2", createPhase("Phase II",sagas.get("infinity")));
        phases.put("phase3", createPhase("Phase III",sagas.get("infinity")));
        phases.put("phase4", createPhase("Phase IV",sagas.get("multiverse")));
        phases.put("phase5", createPhase("Phase V",sagas.get("multiverse")));
        phases.put("phase6", createPhase("Phase VI",sagas.get("multiverse")));
        return phases;
    }


    private Phase createPhase(String name,Saga saga) {
        System.out.println("Registring " + name);
        Phase phase = new Phase();
        phase.setName(name);
        phase.setSaga(saga);
        phaseService.save(phase);
        return phase;
    }


    private void registerMovies(final Map<String, Phase> phases) {
        createMovie("Iron Man", LocalDate.of(2008, 5, 2), phases.get("phase1"));
        createMovie("The Incredible Hulk", LocalDate.of(2008, 6, 13), phases.get("phase1"));
        createMovie("Iron Man 2", LocalDate.of(2010, 5, 7), phases.get("phase1"));
        createMovie("Thor", LocalDate.of(2011, 5, 6), phases.get("phase1"));
        createMovie("Captain America: The First Avenger", LocalDate.of(2011, 7, 22), phases.get("phase1"));
        createMovie("The Avengers", LocalDate.of(2012, 5, 4), phases.get("phase1"));

        createMovie("Iron Man 3", LocalDate.of(2013, 5, 3), phases.get("phase2"));
        createMovie("Thor: The Dark World", LocalDate.of(2013, 11, 8), phases.get("phase2"));
        createMovie("Captain America: The Winter Soldier", LocalDate.of(2014, 4, 4), phases.get("phase2"));
        createMovie("Guardians of the Galaxy", LocalDate.of(2014, 8, 1), phases.get("phase2"));
        createMovie("Avengers: Age of Ultron", LocalDate.of(2015, 5, 1), phases.get("phase2"));
        createMovie("Ant-Man", LocalDate.of(2015, 7, 17), phases.get("phase2"));

        createMovie("Captain America: Civil War", LocalDate.of(2016, 5, 6), phases.get("phase3"));
        createMovie("Doctor Strange", LocalDate.of(2016, 11, 4), phases.get("phase3"));
        createMovie("Guardians of the Galaxy Vol. 2", LocalDate.of(2017, 5, 5), phases.get("phase3"));
        createMovie("Spider-Man: Homecoming", LocalDate.of(2017, 7, 7), phases.get("phase3"));
        createMovie("Thor: Ragnarok", LocalDate.of(2017, 11, 3), phases.get("phase3"));
        createMovie("Black Panther", LocalDate.of(2018, 2, 16), phases.get("phase3"));
        createMovie("Avengers: Infinity War", LocalDate.of(2018, 4, 27), phases.get("phase3"));
        createMovie("Ant-Man and the Wasp", LocalDate.of(2018, 7, 6), phases.get("phase3"));
        createMovie("Captain Marvel", LocalDate.of(2019, 3, 8), phases.get("phase3"));
        createMovie("Avengers: Endgame", LocalDate.of(2019, 4, 26), phases.get("phase3"));
        createMovie("Spider-Man: Far From Home", LocalDate.of(2019, 7, 2), phases.get("phase3"));

        createMovie("Black Widow", LocalDate.of(2021,7,9), phases.get("phase4"));
        createMovie("Shang-Chi and the Legend of the Ten Rings", LocalDate.of(2021,9,3), phases.get("phase4"));
        createMovie("Eternals", LocalDate.of(2024,11,5), phases.get("phase4"));
        createMovie("Spider-Man: No Way Home", LocalDate.of(2021,12,17), phases.get("phase4"));
        createMovie("Doctor Strange in the Multiverse of Madness", LocalDate.of(2022,5,6), phases.get("phase4"));
        createMovie("Thor: Love and Thunder", LocalDate.of(2022,7,8), phases.get("phase4"));
        createMovie("Black Panther: Wakanda Forever", LocalDate.of(2022,11,11), phases.get("phase4"));

        createMovie("Ant-Man and the Wasp: Quantumania", LocalDate.of(2023,2,17), phases.get("phase5"));
        createMovie("Guardians of the Galaxy Vol. 3", LocalDate.of(2023,5,5), phases.get("phase5"));
        createMovie("The Marvels", LocalDate.of(2023,11,10), phases.get("phase5"));
        createMovie("Deadpool 3", LocalDate.of(2024,7,26), phases.get("phase5"));
        createMovie("Captain America: Brave New World", LocalDate.of(2025,2,14), phases.get("phase5"));

        createMovie("Fantastic Four", LocalDate.of(2025,5,2), phases.get("phase6"));
        createMovie("Thunderbolts", LocalDate.of(2025,7,25), phases.get("phase6"));
        createMovie("Blade", LocalDate.of(2025,11,7), phases.get("phase6"));
        createMovie("Avengers 5", LocalDate.of(2026,5,1), phases.get("phase6"));
        createMovie("Avengers: Secret Wars", LocalDate.of(2027,5,7), phases.get("phase6"));

    }


    private Movie createMovie(String name, LocalDate releaseDate, Phase phase) {
        System.out.println("Registring " + name);
        Movie movie = new Movie();
        movie.setTitle(name);
        movie.setPhase(phase);
        movie.setReleaseDate(releaseDate);
        movieService.save(movie);
        return movie;
    }



}
