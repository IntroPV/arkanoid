package ar.pablitar.vainilla.appearances.worldspace

import ar.pablitar.vainilla.appearances.WorldSpaceAppearance
import java.awt.Color
import ar.pablitar.vainilla.appearances.Camera
import java.awt.Graphics2D
import com.uqbar.vainilla.appearances.Appearance

case class Rectangle(val width: Double, val height: Double, color: Color)(implicit val camera: Camera = new Camera) extends WorldSpaceAppearance {
  def doRenderAt(x: Double, y: Double, graphics: Graphics2D): Unit = {
    graphics.setColor(this.color);
    graphics.fillRect(x.toInt, y.toInt, this.width.toInt, this.height.toInt);
  }
  
  def doCopy = Rectangle(width, height, color)
}