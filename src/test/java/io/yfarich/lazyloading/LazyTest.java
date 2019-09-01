package io.yfarich.lazyloading;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

import java.util.List;
import org.junit.jupiter.api.Test;

class LazyTest {

  @Test
  void testGettingValue() {
    ActorsRepository actorsRepository = spy(ActorsRepository.class);
    Lazy<List<String>> actorsList = Lazy.of(actorsRepository::getActors);

    // Verify that the getActors has not been called
    verifyZeroInteractions(actorsRepository);

    // Get list of actors
    List<String> actorsListValues = actorsList.getValue();
    assertNotNull(actorsListValues);
    assertTrue(actorsListValues.contains("Jamie Foxx"));

    // Assert that getActors get has been called
    verify(actorsRepository).getActors();

  }

}