package ar.pablitar.vainilla.appearances.worldspace

import ar.pablitar.vainilla.appearances.WorldSpaceAppearance
import java.awt.Color
import ar.pablitar.vainilla.appearances.Camera
import java.awt.Graphics2D
import com.uqbar.vainilla.appearances.Appearance

case class Circle(val diameter: Double, color: Color)(implicit val camera: Camera) extends WorldSpaceAppearance {
  def doRenderAt(x: Double, y: Double, graphics: Graphics2D): Unit = {
    graphics.setColor(this.color);
    graphics.fillOval(x.toInt, y.toInt, this.diameter.toInt, this.diameter.toInt);
  }
  
  def height = diameter
  def width = diameter
  
  def doCopy = Circle(diameter, color)
}