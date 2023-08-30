package no.experis.assignment3.services.character;

import jakarta.transaction.Transactional;
import no.experis.assignment3.models.Character;
import no.experis.assignment3.repositories.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

    @Service
    public class CharacterServiceImpl implements CharacterService {

        private final CharacterRepository characterRepository;

        public CharacterServiceImpl(CharacterRepository characterRepository) {
            this.characterRepository = characterRepository;
        }

        @Override
        public Character findById(Integer id) {
            return characterRepository
                    .findById(id)
                    .orElseThrow(() -> new characterNotFoundException(id));
        }

        @Override
        public Collection<Character> findAll() {
            return characterRepository.findAll();
        }

        @Override
        public Character add(Character entity) {
            return null;
        }

        @Override
        public Character add(Character entity) {
            return characterRepository.save(entity);
        }

        @Override
        public Character update(Character entity) {
            return characterRepository.save(entity);
        }

        @Override
        @Transactional
        public void deleteById(Integer id) {
            if(characterRepository.existsById(id)) {
                Character character = characterRepository.findById(id).get();
                character.setMovie(null);
                character.getMovie().setCharacter(null);
                characterRepository.delete(character);
            }
        }

        @Override
        @Transactional
        public void delete(Character entity) {
            if(characterRepository.existsById(entity.getId())) {
                Character character = characterRepository.findById(entity.getId()).get();
                character.setMovie(null);
                character.getMovie().setStudent(null);
                characterRepository.delete(character);
            }
        }

        @Override
        @Transactional
        public void updateMovie(int characterId, int movieId) {
            characterRepository.updateCharacterByMovieById(characterId,movieId);
        }
    }

}
