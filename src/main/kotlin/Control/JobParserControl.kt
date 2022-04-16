package Control

import Data.PageParser
import Data.RawJSONMask
import Model.JobParserModel
import javafx.stage.FileChooser
import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import tornadofx.chooseFile
import java.io.File

class JobParserControl {
    object st {
        fun openPage(){
            val filter = arrayOf(FileChooser.ExtensionFilter("All files (*.*","*.*"))
            val fileList = chooseFile("",filter)
            if (fileList.isNotEmpty()){
                setPageParser(fileList[0].path)
            }
        }

        fun setPageParser(path : String)
        {
            val name = path.substringAfterLast("\\")
            val text = File(path).readText()
            var html = Jsoup.parse(text,"UTF-8")
            var rawJSONMask = setJSONMask(html)
            JobParserModel.jobParser.jobParserPage.add(PageParser(name,text,html,rawJSONMask))
            JobParserModel.jobParser.reCreateJobParser.add(true)
        }

        fun setJSONMask(html : Element) : RawJSONMask
        {
            var tecRawJSONMask = RawJSONMask()
            if (html.children().size == 0){
                return RawJSONMask(html.tagName(), html.toString(), mutableListOf(), "")
            }else{
                tecRawJSONMask.tagName = html.tagName()
                for (i in 0 until html.children().size){
                    tecRawJSONMask.children.add(setJSONMask(html.children()[i]))
                }
            }
            return tecRawJSONMask
        }
    }
}