package edu.aluismarte.diplomado.week5;

import edu.aluismarte.diplomado.model.week5.ChuckNorrisJoke;
import edu.aluismarte.diplomado.model.week5.SearchChuckNorrisJoke;
import edu.aluismarte.diplomado.utils.TestTags;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author aluis on 5/1/2022.
 */
class ChuckNorrisJokeServiceTest {

    @Nested
    class InternetTest {

        private final ChuckNorrisJokeService chuckNorrisJokeService = new ChuckNorrisJokeService();

        @Tag(TestTags.ONLINE_TEST)
        @Test
        void getRandomJokeTest() {
            ChuckNorrisJoke randomJoke = chuckNorrisJokeService.getRandomJoke();
            assertNotNull(randomJoke);
            System.out.println(randomJoke);
        }

        @Tag(TestTags.ONLINE_TEST)
        @Test
        void getRandomJokeFromCategoryTest() {
            List<String> jokesCategories = chuckNorrisJokeService.getJokesCategories();
            SecureRandom secureRandom = new SecureRandom();
            String categorySelected = jokesCategories.get(secureRandom.nextInt(jokesCategories.size()));
            assertNotNull(categorySelected);
            System.out.println("Category Selected: " + categorySelected);
            ChuckNorrisJoke randomJoke = chuckNorrisJokeService.getRandomJokeFromCategory(categorySelected);
            assertNotNull(randomJoke);
            System.out.println(randomJoke);
        }

        @Tag(TestTags.ONLINE_TEST)
        @Test
        void getJokeByTextTest() {
            SearchChuckNorrisJoke searchChuckNorrisJoke = chuckNorrisJokeService.getJokeByText("piano");
            assertNotNull(searchChuckNorrisJoke);
            assertTrue(searchChuckNorrisJoke.getTotal() > 0);
            assertNotNull(searchChuckNorrisJoke.getResult());
            assertEquals(searchChuckNorrisJoke.getTotal(), searchChuckNorrisJoke.getResult().size());
            System.out.println(searchChuckNorrisJoke);
            for (ChuckNorrisJoke chuckNorrisJoke : searchChuckNorrisJoke.getResult()) {
                System.out.println(chuckNorrisJoke);
            }
        }

        @Tag(TestTags.ONLINE_TEST)
        @Test
        void getCategoriesTest() {
            List<String> jokesCategories = chuckNorrisJokeService.getJokesCategories();
            assertNotNull(jokesCategories);
            System.out.println(Arrays.toString(jokesCategories.toArray()));
        }
    }

    @Nested
    class OfflineTest {

        private final ChuckNorrisJokeService chuckNorrisJokeServiceMock = Mockito.mock(ChuckNorrisJokeService.class);

        @Tag(TestTags.OFFLINE_TEST)
        @Test
        void getRandomJokeTest() {
            ChuckNorrisJoke chuckNorrisJokeReturn = ChuckNorrisJoke.builder()
                    .id("My ID")
                    .value("When Steven Seagal kills a ninja, he only takes its hide. When Chuck Norris kills a ninja, he uses every part.")
                    .build();
            Mockito.when(chuckNorrisJokeServiceMock.getRandomJoke()).thenReturn(chuckNorrisJokeReturn);
            ChuckNorrisJoke randomJoke = chuckNorrisJokeServiceMock.getRandomJoke();
            assertNotNull(randomJoke);
            assertEquals(chuckNorrisJokeReturn.getId(), randomJoke.getId());
            assertEquals(chuckNorrisJokeReturn.getValue(), randomJoke.getValue());
            System.out.println(randomJoke);
        }

        @Tag(TestTags.OFFLINE_TEST)
        @Test
        void getRandomJokeFromCategoryTest() {
            List<String> categories = List.of("religion", "science", "sport", "travel");
            Mockito.when(chuckNorrisJokeServiceMock.getJokesCategories()).thenReturn(categories);
            List<String> jokesCategories = chuckNorrisJokeServiceMock.getJokesCategories();
            for (int i = 0; i < categories.size(); i++) {
                assertEquals(categories.get(i), jokesCategories.get(i));
            }
            SecureRandom secureRandom = new SecureRandom();
            String categorySelected = jokesCategories.get(secureRandom.nextInt(jokesCategories.size()));
            assertNotNull(categorySelected);
            System.out.println("Category Selected: " + categorySelected);
            ChuckNorrisJoke chuckNorrisJokeReturn = ChuckNorrisJoke.builder()
                    .id("My ID")
                    .value("When Steven Seagal kills a ninja, he only takes its hide. When Chuck Norris kills a ninja, he uses every part.")
                    .build();
            Mockito.when(chuckNorrisJokeServiceMock.getRandomJokeFromCategory(ArgumentMatchers.anyString())).thenReturn(chuckNorrisJokeReturn);
            ChuckNorrisJoke randomJoke = chuckNorrisJokeServiceMock.getRandomJokeFromCategory(categorySelected);
            assertNotNull(randomJoke);
            assertEquals(chuckNorrisJokeReturn.getId(), randomJoke.getId());
            assertEquals(chuckNorrisJokeReturn.getValue(), randomJoke.getValue());
            System.out.println(randomJoke);
        }

        @Tag(TestTags.OFFLINE_TEST)
        @Test
        void getJokeByTextTest() {
            ChuckNorrisJoke chuckNorrisJokeReturn = ChuckNorrisJoke.builder()
                    .id("My ID")
                    .value("When Steven Seagal kills a ninja, he only takes its hide. When Chuck Norris kills a ninja, he uses every part.")
                    .build();
            SearchChuckNorrisJoke searchChuckNorrisJokeReturn = SearchChuckNorrisJoke.builder()
                    .result(List.of(chuckNorrisJokeReturn))
                    .total(1)
                    .build();
            Mockito.when(chuckNorrisJokeServiceMock.getJokeByText("demo")).thenReturn(searchChuckNorrisJokeReturn);
            SearchChuckNorrisJoke searchChuckNorrisJoke = chuckNorrisJokeServiceMock.getJokeByText("demo");
            assertNotNull(searchChuckNorrisJoke);
            assertTrue(searchChuckNorrisJoke.getTotal() > 0);
            assertNotNull(searchChuckNorrisJoke.getResult());
            assertEquals(searchChuckNorrisJoke.getTotal(), searchChuckNorrisJoke.getResult().size());
            System.out.println(searchChuckNorrisJoke);
            for (ChuckNorrisJoke chuckNorrisJoke : searchChuckNorrisJoke.getResult()) {
                System.out.println(chuckNorrisJoke);
            }
        }

        @Tag(TestTags.OFFLINE_TEST)
        @Test
        void getCategoriesTest() {
            Mockito.when(chuckNorrisJokeServiceMock.getJokesCategories()).thenReturn(List.of("religion", "science", "sport", "travel"));
            List<String> jokesCategories = chuckNorrisJokeServiceMock.getJokesCategories();
            assertNotNull(jokesCategories);
            System.out.println(Arrays.toString(jokesCategories.toArray()));
        }
    }

}