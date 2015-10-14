package ar.pablitar.vainilla.appearances.worldspace

import ar.pablitar.vainilla.appearances.WorldSpaceAppearance
import java.awt.Color
import ar.pablitar.vainilla.appearances.Camera
import java.awt.Graphics2D
import com.uqbar.vainilla.appearances.SimpleAppearance
import com.uqbar.vainilla.appearances.Appearance

case class WorldSpaceSimpleAppearance(sp: SimpleAppearance[_])(implicit val camera: Camera = new Camera) extends WorldSpaceAppearance {
  def height = sp.getHeight
  def width = sp.getWidth
  
  def doRenderAt(x: Double, y: Double, graphics: Graphics2D): Unit = {
    sp.renderAt(x.toInt, y.toInt, graphics)
  }
  
  def doCopy = WorldSpaceSimpleAppearance(sp)
}