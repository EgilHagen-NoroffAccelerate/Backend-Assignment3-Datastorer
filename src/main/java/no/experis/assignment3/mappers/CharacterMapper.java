package no.experis.assignment3.mappers;

import no.experis.assignment3.models.Character;
import no.experis.assignment3.models.dto.character.CharacterDTO;
import no.experis.assignment3.models.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.springframework.web.bind.annotation.Mapping;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CharacterMapper {
    @Mapping(target = "movie", source = "movie.id")
    //@Mapping(target = "professor", source = "professor.id")
    //@Mapping(target = "subjects", qualifiedByName = "subjectsToSubjectsId")
    CharacterDTO MovieCharacterUpdateDTO(Character character);

    Collection<CharacterDTO> studentToStudentDTO(Collection<Character> characters);

    @Named(value = "movieToMovieId")
    default Set<Integer> map(Set<Movie> value) {
        if(value == null)
            return null;
        return value.stream()
                .map(s -> s.getId())
                .collect(Collectors.toSet());
    }
}
