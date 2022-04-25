package View

import Data.RawJSONMask
import Data.TagEditor
import javafx.scene.Parent
import javafx.scene.layout.HBox
import tornadofx.*

class HTMLView(rawJSONMask: RawJSONMask) : Fragment() {
    private var tecRawJSONMask = mutableListOf<TagEditor>().observable()
    private fun reCreate(rawJSONMask: RawJSONMask){
        for (i in 0 until rawJSONMask.children.size){
            var tagEditor : HBox
            tagEditor = hbox {
                this += TagEditorView(rawJSONMask.children[i])
            }
            tecRawJSONMask.add(TagEditor(rawJSONMask.children[i].tagName, rawJSONMask.children[i], tagEditor))
        }

    }
    override val root: Parent = tableview(tecRawJSONMask) {
        minWidth = 1600.0
        minHeight = 1000.0
        reCreate(rawJSONMask)
        column("Tag", TagEditor::tagName)
        //column("Value", RawJSONMask::jsonMask)
        column("ttt", TagEditor::tagEditor)
        rowExpander(expandOnDoubleClick = true){
            paddingLeft = expanderColumn.width
            if (it.rawJSONMask.children.size > 0 ){
                this += HTMLView(it.rawJSONMask)
            } else{
                //this += TegEditorView(it.tegs)
            }
        }

    }
}