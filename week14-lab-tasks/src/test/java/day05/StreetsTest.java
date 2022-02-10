package day05;

import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class StreetsTest {
    @Test
    void testStreets(){
        Streets streets = new Streets();
        streets.readFile(Paths.get("src/main/resources/streets.txt"));
        System.out.println(streets);
    }
}