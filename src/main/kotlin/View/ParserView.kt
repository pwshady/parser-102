package View

import Control.JobParserControl
import Control.TopMenuControl
import Model.JobParserModel
import Model.TopMenuModel
import javafx.scene.Parent
import tornadofx.*

class ParserView : View(){
    init {

    }
    override val root: Parent = borderpane {

        top(){
            this += TopMenuView::class
        }
        center{
            this += JobParserView::class
        }
        right{
            button("t1"){
                action {
                    JobParserControl.st.openPage()
                }
            }
        }

    }
}