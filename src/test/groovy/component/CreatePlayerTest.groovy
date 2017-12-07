package component

import com.mastermind.game.GameApplication
import com.mastermind.game.models.Player
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
class CreatePlayerTest extends Specification{

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    TestRestTemplate restTemplate;

    def 'create and return new player'() {
        given:('I have a new player to register')

        def player = Player.builder().name("Duda").build();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(player.toString(),headers);

        when:('I give post in endpoint creatingplayer')
        def response = restTemplate.postForEntity('/creatingplayer',entity, String.class)

        then:('I show HttpStatus.CREATED')
        response.statusCode == HttpStatus.CREATED
    }
}