package Model

import Control.TopMenuControl
import tornadofx.observable

class TopMenuModel {
    object menubar{
        var all = mutableListOf<Any>(
            mutableListOf("Test", false, { TopMenuControl.static.close() })
        )
        var file = mutableListOf<Any>(
            mutableListOf("Open", false, { TopMenuControl.static.close() }),
            mutableListOf("Close", false, { TopMenuControl.static.close() }),
            mutableListOf("All", true, all)
        ).observable()

        var about = mutableListOf<Any>(
            mutableListOf("About", false, { TopMenuControl.static.close() })
        ).observable()

        var menu = mutableListOf<Any>(
            mutableListOf("File", true, file),
            mutableListOf("About", true, about)
        ).observable()

    }
}