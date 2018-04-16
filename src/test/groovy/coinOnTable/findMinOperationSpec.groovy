package coinOnTable

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class findMinOperationSpec extends Specification {

    def "#input for #row X #column matrix in #rounds rounds needs #expectedChanges changes"() {
        given:
        def coinOnTableGame = new CoinOnTableGame(input, row, column);

        expect:
        coinOnTableGame.findMinOperation(rounds) == expectedMinChanges

        where:
        row | column | rounds | input       || expectedMinChanges
//        2   | 2      | 3      | "RD*L"      || 0
//        2   | 2      | 1      | "RD*L"      || 1
//        3   | 3      | 1      | "RDDDLDRR*" || -1
//        3   | 3      | 4      | "RRDDLLRR*" || 1
//        3   | 3      | 4      | "RRUDLLRR*" || 1
        3   | 3      | 4      | "RRUULLRR*" || 1
    }

}
