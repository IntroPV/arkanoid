package ar.pablitar.arkanoid

import ar.pablitar.arkanoid.levels.Level1

class Jugador {
  var vidas = 3
  var score = 0

  var level = Level1

  def reiniciar {
    vidas = 3
    score = 0
    level = Level1
  }

  def sumaPuntos(puntos: Int) = {
    score += puntos
  }
}

/**
 * @author pablitar
 */
object Jugador {
  val uno = new Jugador
}