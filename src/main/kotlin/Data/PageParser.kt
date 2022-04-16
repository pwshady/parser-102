package Data

import org.jsoup.nodes.Element

data class PageParser (val name : String, val text : String, val html : Element, var rawJSONMask : RawJSONMask)