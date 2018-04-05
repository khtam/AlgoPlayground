package coinOnTable

import kotlin.Pair
import spock.lang.Specification

class BoardIteratorSpec extends Specification {
    def "Should iterate through board correctly and calculate steps"() {
        given:
        char[][] board = input;
        def iteration = new BoardIterator(board, destination);

        when:
        def steps = iteration.nextStep(new Pair(0, 0), 0);

        then:
        steps == expectedNumberOfSteps;

        where:
        input                                                | destination    || expectedNumberOfSteps
        [[(char) 'R', (char) 'D'], [(char) '*', (char) 'L']] | new Pair(1, 0) || 3
    }

    def "Should track all distances from destination"() {
        given:
        char[][] board = input;
        def iteration = new BoardIterator(board, destination);

        when:
        iteration.nextStep(new Pair(0, 0), 0);

        then:
        iteration.projectedMinSteps == expectedProjections;

        where:
        input                                                | destination    || expectedProjections
        [[(char) 'R', (char) 'D'], [(char) '*', (char) 'L']] | new Pair(1, 0) || [1,3,3,3]
    }
}
