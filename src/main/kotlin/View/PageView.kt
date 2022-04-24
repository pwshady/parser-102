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

                item("Viev", expanded = true) {
                    this += ViewView(page.text)
                }

                item("Text") {
                }

                item("RawMask") {
                }

                item("Data") {
                }
            }
        }
        createDrawer()
    }
}