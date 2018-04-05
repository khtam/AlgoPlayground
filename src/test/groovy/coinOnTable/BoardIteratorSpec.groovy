package coinOnTable

import kotlin.Pair
import spock.lang.Specification

class BoardIteratorSpec extends Specification {
    def "Should iterate through board correctly and calculate steps"() {
        given:
        char[][] board = input;
        def iteration = new BoardIterator(board, destination);

        when:
        def steps = iteration.nextStep(new Pair(0, 0), 3);

        then:
        steps == expectedRemainingSteps;

        where:
        input                                                | destination    || expectedRemainingSteps
        [[(char) 'R', (char) 'D'], [(char) '*', (char) 'L']] | new Pair(1, 0) || 0
    }

    def "Should track all distances from destination"() {
        given:
        char[][] board = input;
        def iteration = new BoardIterator(board, destination);

        when:
        iteration.nextStep(new Pair(0, 0), 3);

        then:
        iteration.distancesFromDestination == expectedDistancesFromDestination;

        where:
        input                                                | destination    || expectedDistancesFromDestination
        [[(char) 'R', (char) 'D'], [(char) '*', (char) 'L']] | new Pair(1, 0) || [1,2,1,0]
    }
}
