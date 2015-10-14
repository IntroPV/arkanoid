package ar.pablitar.vainilla.commons.math

/**
 * @author pablitar
 */
case class Semiplane(puntoInterno: Vector2D, normal: Vector2D) {

  def circuloPasoDetras(centro: Vector2D, radio: Double) = {
    val proyectedVector = vectorDistanciaA(centro)
    proyectedVector.module < radio || proyectedVector.isOppositeTo(normal)
  }

  def vectorDistanciaA(punto: Vector2D) = {
    (punto - puntoInterno).proyectTo(normal)
  }

  def puntoEstaDetras(punto: Vector2D) = {
    vectorDistanciaA(punto).isOppositeTo(normal)
  }
}