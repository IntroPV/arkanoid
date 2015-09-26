package ar.pablitar.arkanoid.misc

import java.awt.Color
import java.awt.Font
import com.uqbar.vainilla.appearances.Label

/**
 * @author pablitar
 */
object Styles {
  val defaultTextColor = Color.WHITE
  val defaultTextSize = 20
  def infoText(text: String, color: Color = defaultTextColor, textSize:Int = defaultTextSize) =
    new Label(new Font(Font.SANS_SERIF, Font.PLAIN, defaultTextSize), color, text)
}