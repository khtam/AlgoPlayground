package coinOnTable

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class MinOpertationsSpec extends Specification {

    def "#input for #row X #column matrix in #rounds rounds needs #expectedChanges changes"() {
        expect:
        MinOperationsKt.minOperations(row, column, rounds, input) == expectedChanges

        where:
        row | column | rounds | input  || expectedChanges
        2   | 2      | 3      | "RD*L" || 0
        2   | 2      | 1      | "RD*L" || 1
    }

}
