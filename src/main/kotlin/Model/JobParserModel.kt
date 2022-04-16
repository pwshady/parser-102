package Model

import Data.PageParser
import tornadofx.observable

class JobParserModel {
    object jobParser{
        var reCreateJobParser = mutableListOf<Boolean>().observable()
        var jobParserPage = mutableListOf<PageParser>().observable()
    }
}