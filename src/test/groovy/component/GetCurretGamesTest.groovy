package component

import com.mastermind.game.GameApplication
import com.mastermind.game.models.Game
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
class GetCurretGamesTest extends Specification{

    @Autowired
    TestRestTemplate restTemplate;

    def 'Get current games'() {
        given:('I creted two news games')

        def gameOne = new Game(null, 1L)
        def gameTwo = new Game(null, 2L)

        HttpHeaders headers = new HttpHeaders()
        headers.setContentType(MediaType.APPLICATION_JSON)

        HttpEntity<Game> entityOne = new HttpEntity<>(gameOne, headers)
        HttpEntity<Game> entityTwo = new HttpEntity<>(gameTwo, headers)

        restTemplate.postForEntity('/games', entityOne, String.class)
        restTemplate.postForEntity('/games', entityTwo, String.class)

        when:('I give get in endpoint games')
        def response = restTemplate.getForEntity('/games', String.class)

        then:('I show HttpStatus.OK')

        response.statusCode == HttpStatus.OK
    }
}