package View

import Data.RawJSONMask
import javafx.scene.Parent
import tornadofx.Fragment
import tornadofx.action
import tornadofx.button
import tornadofx.hbox

class TagEditorView(rawJSONMask: RawJSONMask) : Fragment() {
    override val root: Parent = hbox {
        button("tag")
        {
            action {
                println(rawJSONMask.tagName)
                rawJSONMask.jsonMask = "testJob"
            }
        }
    }
}