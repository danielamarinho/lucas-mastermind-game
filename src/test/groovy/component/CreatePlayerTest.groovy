package component

import com.mastermind.game.GameApplication
import com.mastermind.game.models.Player
import com.mastermind.game.repositories.PlayerRepository
import org.json.JSONObject
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

import javax.transaction.Transactional

@ContextConfiguration(classes = GameApplication.class,
        loader = SpringBootContextLoader.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
class CreatePlayerTest extends Specification{

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    TestRestTemplate restTemplate;

    def 'create and return new player'() {
        given:('I have a new player to register')

        def player = new Player("Batata").toJson().toString()

        HttpHeaders headers = new HttpHeaders()
        headers.setContentType(MediaType.APPLICATION_JSON)
        HttpEntity<String> entity = new HttpEntity<String>(player, headers)

        when:('I give post in endpoint players')
        def response = restTemplate.postForEntity('/players',entity, String.class)

        then:('I show HttpStatus.CREATED')
        response.statusCode == HttpStatus.CREATED

        and:('I validate response body')

        def playerResponse =  new JSONObject(response.body)
        playerResponse.id == 1
        playerResponse.name == "Batata"
    }
}