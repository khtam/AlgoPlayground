package coinOnTable

import kotlin.Pair
import spock.lang.Specification
import spock.lang.Unroll

class BoardEvaluatorKtTest extends Specification {
    def "should evaluate if goal is achieved"() {
        given:
        char[][] board = input;
        def result = BoardEvaluatorKt.isGoalAchieved(board, start, expectedNumberOfSteps, destination);

        expect:
        result == goalAchieved;

        where:
        input                                                | start          | destination    | expectedNumberOfSteps || goalAchieved
        [[(char) 'R', (char) 'D'], [(char) '*', (char) 'L']] | new Pair(0, 0) | new Pair(1, 0) | 3                     || true
    }

    @Unroll
    def "IsOutOfBounds"() {
        given:
        char[][] board = input;
        def result = BoardEvaluatorKt.isOutOfBounds(board, position);

        expect:
        result == outOfBounds;

        where:
        input                                                | position       || outOfBounds
        [[(char) 'R', (char) 'D'], [(char) '*', (char) 'L']] | new Pair(2, 2) || true
        [[(char) 'R', (char) 'D'], [(char) '*', (char) 'L']] | new Pair(0, 2) || true
        [[(char) 'R', (char) 'D'], [(char) '*', (char) 'L']] | new Pair(2, 0) || true
        [[(char) 'R', (char) 'D'], [(char) '*', (char) 'L']] | new Pair(0, 1) || false
    }
}
