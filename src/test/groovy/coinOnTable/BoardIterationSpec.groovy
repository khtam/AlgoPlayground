package coinOnTable

import kotlin.Pair
import spock.lang.Specification

class BoardIterationSpec extends Specification {
    def "Should iterate through board correctly and calculate steps"() {
        given:
        char[][] board = input
        def iteration = new BoardIteration(board);

        when:
        def steps = iteration.nextStep(new Pair(0, 0), 0);

        then:
        steps == expectedNumberOfSteps;

        where:
        input                                                || expectedNumberOfSteps
        [[(char) 'R', (char) 'D'], [(char) '*', (char) 'L']] || 3
    }
}
