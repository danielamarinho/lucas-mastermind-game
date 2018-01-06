package component

import com.mastermind.game.GameApplication
import com.mastermind.game.models.Game
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
class CreateNewGameTest extends Specification{

    @Autowired
    TestRestTemplate restTemplate;

    def 'create and return new game'() {
        given:('I have a new game to register')

        def game = new Game(null, 1L).toJson().toString()

        HttpHeaders headers = new HttpHeaders()
        headers.setContentType(MediaType.APPLICATION_JSON)
        HttpEntity<String> entity = new HttpEntity<String>(game, headers)

        when:('I give post in endpoint games')
        def response = restTemplate.postForEntity('/games', entity, String.class)

        then:('I show HttpStatus.CREATED')

        response.statusCode == HttpStatus.CREATED

        and:('I validate response body')

        def gameResponse =  new JSONObject(response.body)
        gameResponse.id == 1
        gameResponse.playerId == 1
        gameResponse.key != null
    }
}