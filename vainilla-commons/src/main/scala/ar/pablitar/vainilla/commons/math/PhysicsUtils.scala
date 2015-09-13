package ar.pablitar.vainilla.commons.math

/**
 * @author pablitar
 */
object PhysicsUtils {
  def rebound(v: Vector2D, n: Vector2D) = (-2 * v.proyectTo(n)) + v
}