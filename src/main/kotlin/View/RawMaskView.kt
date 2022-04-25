package View

import Data.PageParser
import Data.RawJSONMask
import Model.JobParserModel
import javafx.scene.Parent
import javafx.scene.control.TextArea
import tornadofx.*

class RawMaskView(rawJSONMask : RawJSONMask) : Fragment() {
    var fulText : String = ""
    fun setText(rawJSONMask : RawJSONMask){
        fun addTag(rawJSONMask : RawJSONMask, preview : String){
            if (rawJSONMask.children.size == 0){
                fulText += "${preview}tag=${rawJSONMask.tagName}    json=${rawJSONMask.jsonMask}    value=${rawJSONMask.elementText}\n"
            }else{
                fulText += "${preview}tag=${rawJSONMask.tagName}    json=${rawJSONMask.jsonMask}\n"
                for (i in 0 until rawJSONMask.children.size){
                    addTag(rawJSONMask.children[i],"    ${preview}")
                }
            }
        }
        addTag(rawJSONMask,"")
    }
    override val root: Parent = hbox {
        setText(rawJSONMask)

        var ta: TextArea
        ta = textarea(fulText) {
            minWidth = 400.0
        }
        button("rc"){
            action {
                fulText = ""
                setText(rawJSONMask)
                ta.text = fulText
                //JobParserModel.jobParser.reCreateJobParser.add(true)
            }
        }
    }

}