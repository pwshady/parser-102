package View

import javafx.scene.Parent
import tornadofx.Fragment
import tornadofx.hbox
import tornadofx.textarea

class TextView(html : String) : Fragment(){

    override val root: Parent = hbox {
        textarea {
            text = html
        }
    }
}