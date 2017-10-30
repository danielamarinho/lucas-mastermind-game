package component

import com.mastermind.game.GameApplication
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootContextLoader
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes = GameApplication.class,
        loader = SpringBootContextLoader.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HealthCheckTest extends Specification{

    @Autowired
    TestRestTemplate restTemplate;

    def 'should be return health UP when request'() {
        given:('My service is online')

        when:('I access the service')
        def entity = restTemplate.getForEntity('/healthcheck', String.class)

        then:('I show message: UP')
        entity.statusCode == HttpStatus.OK
        entity.body == 'UP'
    }

}

