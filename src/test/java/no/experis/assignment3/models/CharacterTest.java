package no.experis.assignment3.models;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

    private Character character;

    @BeforeEach
    public void init (){
      character = new Character();
    }

    @Test
    public void read_id_shouldReturnId(){
        assertEquals(0, character.getId());
    }

}