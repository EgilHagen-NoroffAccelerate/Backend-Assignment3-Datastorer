package no.experis.assignment3.mappers;

import no.experis.assignment3.models.Character;
import no.experis.assignment3.models.Movie;
import no.experis.assignment3.models.dto.character.CharacterDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CharacterMapper {

    @Mapping(target = "movies", source = "movies")
    CharacterDTO characterToCharacterDto(Character character);

    Collection<CharacterDTO> characterToCharacterDto(Collection<Character> characters);


    @Mapping(target = "movies", source = "movies")
    Character characterDtoToCharacter(CharacterDTO characterDTO);

    @Named(value = "movieToMovieId")
    default Set<Integer> map(Set<Movie> value) {
        if (value == null)
            return null;
        return value.stream()
                .map(s -> s.getId())
                .collect(Collectors.toSet());
    }
}
