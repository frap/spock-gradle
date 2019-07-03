package com.ateasystems.common

import java.io.File
import spock.lang.Shared
import spock.lang.Specification

class DataFileMetaSpec extends Specification {

    @Shared testfile = File.newInstance("./src/test/resources/test.txt")
    @Shared noexistfile = File.newInstance("nonexistent")
    //    @Shared dfile = DataFileMetaData.newInstance(1, "file", testfile )

    def "getContents returns contents of test file"() {
        when:
        def metafile = new FileDataFileMetadata( 1,  "file", testfile)

        then:
        metafile.getContents() == "Hola pelotudo!\n"
    }

    def "Throws DataFileUnavailable Exception on no file"() {
        when:
        def metafile = new FileDataFileMetadata( 2, "file", noexistfile).getContents()

        then:
        thrown DataFileUnavailableException
    }

}  
