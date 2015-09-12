package ar.pablitar.arkanoid

import ar.pablitar.vainilla.commons.math.Vector2D

/**
 * @author pablitar
 */
case class Pared(puntoInterno: Vector2D, normal: Vector2D) {
  
  def circuloPasoDetras(centro: Vector2D, radio: Double) = {
    val proyecteVector = (centro - puntoInterno).proyectTo(normal)
    proyecteVector.module < radio
  }
}