package ar.pablitar.vainilla.commons.math

/**
 * @author pablitar
 */

trait Bounds {
  def limit(v: Vector2D): Vector2D

  def limit(v: Vector2D, size: Vector2D): Vector2D
}

case class RectangularBounds(upperLeft: Vector2D, lowerRight: Vector2D) {
  def limit(v: Vector2D) = v.max(upperLeft).min(lowerRight)

  def limit(v: Vector2D, size: Vector2D): Vector2D = RectangularBounds(upperLeft, lowerRight - size).limit(v)
}

case class HorizontalBounds(left: Double, right: Double) extends Bounds {
  def limit(v: Vector2D) = Vector2D(v.x1.max(left).min(right), v.x2)

  def limit(v: Vector2D, size: Vector2D) = HorizontalBounds(left, right - size.x1).limit(v)
}

object InfiniteBounds extends Bounds {
  def limit(v: Vector2D) = v

  def limit(v: Vector2D, size: Vector2D) = v

}