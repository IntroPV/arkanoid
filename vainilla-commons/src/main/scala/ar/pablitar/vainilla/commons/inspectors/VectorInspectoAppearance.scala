package ar.pablitar.vainilla.commons.inspectors

import com.uqbar.vainilla.appearances.Appearance
import com.uqbar.vainilla.GameComponent
import java.awt.Graphics2D
import java.awt.Color

/**
 * @author pablitar
 */
class VectorInspectoAppearance(val vi: VectorSource) extends Appearance {
  def update(delta: Double): Unit = {
  }

  def copy[T](): T = {
    ???
  }

  def getHeight(): Double = {
    vi.difference.x2
  }

  def getWidth(): Double = {
    vi.difference.x1
  }

  def render(component: GameComponent[_], graphics: Graphics2D): Unit = {
    graphics.setColor(Color.WHITE)
    graphics.drawLine(vi.origin.x1.toInt, vi.origin.x2.toInt, vi.destination.x1.toInt, vi.destination.x2.toInt)
  }
}