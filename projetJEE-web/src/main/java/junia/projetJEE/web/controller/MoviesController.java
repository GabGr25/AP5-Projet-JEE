package junia.projetJEE.web.controller;

import junia.projetJEE.core.entity.Movie;
import junia.projetJEE.core.entity.Phase;
import junia.projetJEE.core.service.MovieService;
import junia.projetJEE.core.service.PhaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/movies")
public class MoviesController {

    private final static Logger LOGGER = LoggerFactory.getLogger(MoviesController.class);

    private MovieService movieService;

    private PhaseService phaseService;

    public MoviesController(MovieService movieService, PhaseService phaseService) {
        this.movieService = movieService;
        this.phaseService = phaseService;
    }

    @GetMapping("/add")
    public String addMovieForm(ModelMap modelMap, @RequestParam("phase") long phaseId) {
        LOGGER.info("this is a log");
        Movie movie = new Movie();
        Phase phase = phaseService.findOne(phaseId);
        movie.setPhase(phase);
        modelMap.addAttribute("phase", phase);
        modelMap.addAttribute("movie", movie);
        return "MovieForm";
    }

    @PostMapping("/save")
    public String saveMovie(@ModelAttribute("movie") Movie movie, @RequestParam("phase") long phaseId) {
        movieService.saveMovieInPhase(movie, phaseId);
        return "redirect:../sagas/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable("id") long id) {
        movieService.deleteById(id);
        return "redirect:../../sagas/list";
    }

}
