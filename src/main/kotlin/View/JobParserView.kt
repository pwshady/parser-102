package View

import Control.JobParserControl
import Data.PageParser
import Model.JobParserModel
import javafx.scene.Parent
import javafx.scene.control.TabPane
import tornadofx.*

class JobParserView() : View() {
    override val root: Parent = vbox {
        var tp: TabPane by singleAssign()
        tp = tabpane() {}

        fun addLastTab(){
            tp.tab("+"){

            }
        }

        fun addTab(page : PageParser){
            tp.tab(page.name){

            }
        }

        fun createTabPane(){
            tp.tabs.clear()
            for (i in 0 until JobParserModel.jobParser.jobParserPage.size){
                addTab(JobParserModel.jobParser.jobParserPage[i])
            }
            tp.selectionModel.select(tp.tabs.size - 1)
        }

        createTabPane()
        JobParserModel.jobParser.reCreateJobParser.onChange {
            createTabPane()
        }
    }
}