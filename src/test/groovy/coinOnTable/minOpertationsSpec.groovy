package coinOnTable

import spock.lang.Specification

class minOpertationsSpec extends Specification {

    def "#expectedChanges changes for a #row X #column matrix under #rounds rounds given custom input"() {
        expect:
        MinOperationsKt.minOperations(row, column, rounds, inputArray) == expectedChanges

        where:
        row | column | rounds | inputArray | expectedChanges
    }

}
