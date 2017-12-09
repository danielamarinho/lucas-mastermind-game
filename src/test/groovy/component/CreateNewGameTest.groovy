package component

import com.mastermind.game.GameApplication
import com.mastermind.game.models.Game
import com.mastermind.game.repositories.PlayerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootContextLoader
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes = GameApplication.class,
        loader = SpringBootContextLoader.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CreateNewGameTest extends Specification{

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    TestRestTemplate restTemplate;

    def 'create and return new game'() {
        given:('I have a new game to register')

        def game = Game.builder().id(1L).playerId(1L).build();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(game.toString(),headers);

        when:('I give post in endpoint creatinggame')
        def response = restTemplate.postForEntity('/creatinggame',entity, String.class)

        then:('I show HttpStatus.CREATED')
        response.statusCode == HttpStatus.CREATED
    }
}