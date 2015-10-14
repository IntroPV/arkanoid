package ar.pablitar.vainilla.appearances.worldspace

import com.uqbar.vainilla.appearances.Animation
import ar.pablitar.vainilla.appearances.Camera
import ar.pablitar.vainilla.appearances.WorldSpaceAppearance
import java.awt.Graphics2D
import com.uqbar.vainilla.DeltaState

case class WorldSpaceAnimation(a: Animation)(implicit val camera: Camera) extends WorldSpaceAppearance {
  def height = a.getHeight
  def width = a.getWidth

  def doRenderAt(x: Double, y: Double, graphics: Graphics2D): Unit = {
    a.renderAt(x.toInt, y.toInt, graphics)
  }

  override def update(delta: Double) = {
    a.update(delta)
  }

  def doCopy = WorldSpaceAnimation(a)
}