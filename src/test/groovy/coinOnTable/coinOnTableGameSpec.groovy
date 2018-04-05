package coinOnTable

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class coinOnTableGameSpec extends Specification {

    def "should initialize correctly given input as #input"() {
        given:
        def coinOnTableGame = new CoinOnTableGame(input, row, column);

        expect:
        coinOnTableGame.initialState == expectedArray;
        coinOnTableGame.destination.first == destinationX;
        coinOnTableGame.destination.second == destinationY; ;

        where:
        input  | row | column || expectedArray                      || destinationX || destinationY
        "RD*L" | 2   | 2      || [['R', 'D'], ['*', 'L']].toArray() || 0            || 1
    }

}
