package com.ateasystems.common

import java.io.File
import spock.lang.Shared
import spock.lang.Specification

class DataFileMetaSpec extends Specification {

    @Shared testfile = File.newInstance("test.txt")
    //    @Shared dfile = DataFileMetaData.newInstance(1, "file", testfile )

    def "test getContents on test file"() {
        when:
        def metafile = new DataFileMetadata( 1,  "file", testfile)

        then:
        thrown DataFileUnavailableException
    }
}  
