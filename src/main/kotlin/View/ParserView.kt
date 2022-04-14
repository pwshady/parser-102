package View

import javafx.scene.Parent
import tornadofx.View
import tornadofx.borderpane
import tornadofx.top

class ParserView : View(){
    init {

    }
    override val root: Parent = borderpane {

        top(){
            this += TopMenuView::class
        }

    }
}