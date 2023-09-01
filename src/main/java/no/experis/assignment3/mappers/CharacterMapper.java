package no.experis.assignment3.mappers;

import no.experis.assignment3.models.Character;
import no.experis.assignment3.models.Movie;
import no.experis.assignment3.models.dto.character.CharacterDTO;
import no.experis.assignment3.services.movie.MovieService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CharacterMapper {


    @Mapping(target = "movies", source = "movies", qualifiedByName = "moviesToIds")
    CharacterDTO characterToCharacterDTO(Character character);
    Collection<CharacterDTO> characterToCharacterDTO(Collection<Character> characters);

    @Mapping(target = "movies", source = "movies", qualifiedByName = "movieIdsToMovies")
    public abstract Character characterDtoToCharacter(CharacterDTO characterDTO);

    @Named(value = "movieToMovieId")
    default Set<Integer> map(Set<Movie> value) {
        if (value == null)
            return null;
        return value.stream()
                .map(s -> s.getId())
                .collect(Collectors.toSet());
    }

}
