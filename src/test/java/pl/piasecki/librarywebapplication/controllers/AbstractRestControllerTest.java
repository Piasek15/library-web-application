package pl.piasecki.librarywebapplication.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by Patrick on 27 kwi 2018
 */
public abstract class AbstractRestControllerTest {
    public static String asJsonString(final Object object){
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
