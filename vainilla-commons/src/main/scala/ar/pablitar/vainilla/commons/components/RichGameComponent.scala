package ar.pablitar.vainilla.commons.components

import com.uqbar.vainilla.GameScene
import com.uqbar.vainilla.GameComponent
import ar.pablitar.vainilla.commons.math.Vector2D
import ar.pablitar.vainilla.commons.math.Bounds
import ar.pablitar.vainilla.commons.math.InfiniteBounds

/**
 * @author pablitar
 */
class RichGameComponent[T <: GameScene] extends GameComponent[T] with Positionable {
  def width: Double = this.getAppearance.getWidth
  def height: Double = this.getAppearance.getHeight

  def movementBounds: Bounds = InfiniteBounds

  def position_=(v: Vector2D) = {
    val limited = movementBounds.limit(v, (width, height))
    this.setX(limited.x1)
    this.setY(limited.x2)
  }

  def position = Vector2D(getX, getY)

  def center = this.position + (this.width / 2, this.height / 2)

  def topLeft = this.position
  def bottomLeft = this.position + (0.0, this.height)
  def bottomRight = this.position + (this.width, this.height)
  def topRight = this.position + (this.width, 0.0)
}