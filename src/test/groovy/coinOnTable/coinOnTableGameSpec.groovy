package coinOnTable

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class coinOnTableGameSpec extends Specification {

    def "should initialize correctly given input as #input"() {
        given:
        def coinOnTableGame = new CoinOnTableGame(input, row, column);

        expect:
        coinOnTableGame.initialBoard == expectedArray;
        coinOnTableGame.destination.first == destinationX;
        coinOnTableGame.destination.second == destinationY; ;

        where:
        input  | row | column || expectedArray                      || destinationX || destinationY
        "RD*L" | 2   | 2      || [['R', 'D'], ['*', 'L']].toArray() || 1            || 0
    }

    def "should throw exception if input is invalid"() {
        when:
        def coinOnTableGame = new CoinOnTableGame(input, row, column);

        then:
        IllegalArgumentException exception = thrown();
        exception.message == expectedMessage;

        where:
        input    | row | column || expectedMessage
        "R*L"    | 2   | 2      || "Input does not match dimension!"
        "RRRR*L" | 2   | 2      || "Input does not match dimension!"
        "R**L"   | 2   | 2      || "Invalid number of destination defined!"
        "RRUL"   | 2   | 2      || "Invalid number of destination defined!"
    }
}
