package View

import Data.PageParser
import javafx.geometry.Side
import javafx.scene.Parent
import tornadofx.*

import tornadofx.hbox

class PageView(page : PageParser) : Fragment() {
    override val root: Parent = hbox {
        fun createDrawer() {
            drawer(side = Side.LEFT, multiselect = false) {

                minWidth = 1600.0
                minHeight = 1000.0

                item("Viev", expanded = true) {
                    this += ViewView(page.text)
                }

                item("Text") {
                    this += TextView(page.text)
                }

                item("Html"){
                    this += HTMLView(page.rawJSONMask)
                }

                item("RawMask") {
                    this += RawMaskView(page.rawJSONMask)
                }

                item("Data") {
                }
            }
        }
        createDrawer()
    }
}