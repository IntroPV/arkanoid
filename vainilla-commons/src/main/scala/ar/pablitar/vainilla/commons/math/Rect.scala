package ar.pablitar.vainilla.commons.math

/**
 * @author pablitar
 */
case class Rect(pointFrom: Vector2D, pointTo: Vector2D) {
  lazy val direction = (pointTo - pointFrom).versor
  // (x,y) = pointFrom + k * direction
  // x = pointFrom.x + k direction.x
  // y = pointFrom.y + k direction.y
  // x - pointFrom.x = k direction.x
  // (x - pointFrom.x)/direction.x = (y - pointFrom.y)/direction.y
  // ((x - pointFrom.x) * direction.y )/direction.x = y - pointFrom.y
  // ((x - pointFrom.x) * direction.y )/direction.x + pointFrom.y = y
  def isBelow(v: Vector2D) = {
    //(v.x1 - pointFrom.x1) * direction.x2 / direction.x1 + point
  }
}