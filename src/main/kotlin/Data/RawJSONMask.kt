package Data

data class RawJSONMask (var tagName : String = "", val elementText : String = "", var children : MutableList<RawJSONMask> = mutableListOf(), var jsonMask : String = "")