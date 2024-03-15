import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class MovieTest {
    static String data1 , data2;
    static Movie movie;

    @BeforeAll
    static void setUp() throws IOException {
        movie = new Movie(new ArrayList<>(),"",0, "");
        data1 = movie.getMovieData("maze runner");  // movie
        data2 = movie.getMovieData("this is us");   // series
    }
    @Test
    void getImdbVotesViaApi1() {
        assertEquals(502247, movie.getImdbVotesViaApi(data1));
    }
    @Test
    void getImdbVotesViaApi2() {
        assertEquals(156396, movie.getImdbVotesViaApi(data2));
    }
    @Test
    void getRatingViaApi1() {
        assertEquals("6.8/10", movie.getRatingViaApi(data1));
    }
    @Test
    void getRatingViaApi2() {
        assertEquals("8.7/10",movie.getRatingViaApi(data2));
    }
}
