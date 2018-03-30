package coinOnTable

import spock.lang.Specification

class ParseInputSpec extends Specification {

    def setup() {
        def row1 = ['R', 'D'].toArray();
        def row2 = ['*', 'L'].toArray();
    }

    def "should parse string into 2D array"() {
        expect:
        MinOperationsKt.parseInput(input, row, column) == expectedArray;

        where:
        input  | row | column || expectedArray
        "RD*L" | 2   | 2      || [['R', 'D'], ['*', 'L']].toArray()
    }

}
