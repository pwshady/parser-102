package View

import Control.TopMenuControl
import Model.TopMenuModel
import javafx.scene.Parent
import javafx.scene.control.Menu
import javafx.scene.control.MenuBar
import tornadofx.*
import java.lang.invoke.LambdaConversionException
import java.lang.invoke.LambdaMetafactory
import java.util.function.Function

class TopMenuView() : View(){

    private val myMenubar = TopMenuModel.menubar.menu

    override val root: Parent = vbox {
        var mb: MenuBar by singleAssign()
        mb = menubar{}
        fun addItemMenu(myMenu: Menu, myItemValue : List<Any>)
        {
            for (i in 0 until myItemValue.size){
                var myItem = myItemValue[i] as List<Any>
                if (myItem[1] == true){
                    var mm = myMenu.menu(myItem[0].toString())
                    addItemMenu(mm, myItem[2] as List<Any>)
                } else{
                    myMenu.item(myItem[0].toString()).action {
                        var op = myItem[2] as () -> Unit
                        op()
                    }
                }
            }
        }

        fun createMeny() {
            mb.menus.clear()
            for (i in 0 until myMenubar.size) {
                var myItem = myMenubar[i] as List<Any>
                var mm = mb.menu(myItem[0].toString())
                addItemMenu(mm, myItem[2] as List<Any>)
            }
        }

        createMeny()

        TopMenuModel.menubar.reCreateMenu.onChange {
            createMeny()
        }
    }
}