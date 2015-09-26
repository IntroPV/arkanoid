package ar.pablitar.arkanoid.components

import com.uqbar.vainilla.appearances.Rectangle
import java.awt.Color
import ar.pablitar.vainilla.commons.math.Vector2D
import ar.pablitar.vainilla.commons.components.RichGameComponent
import com.uqbar.vainilla.DeltaState
import ar.pablitar.arkanoid.ArkanoidLevelScene
import com.uqbar.vainilla.colissions.CollisionDetector.{ INSTANCE => Collisions }
import ar.pablitar.vainilla.commons.math.Rect
import com.uqbar.vainilla.appearances.Rectangle
import ar.pablitar.vainilla.commons.math.PhysicsUtils
import ar.pablitar.arkanoid.Pared

/**
 * @author pablitar
 */
class Ladrillo(c: Color*)(var vidas: Int = 1)(aPosition: Vector2D) extends RichGameComponent[ArkanoidLevelScene] {

  val maxVidas = vidas
  
  this.position = aPosition
  
  this.setAppearance(aparienciaActual);

  override def update(state: DeltaState) = {
    this.getScene.pelotas.foreach { pelota => this.comprobarColisionCon(pelota) }
  }

  def comprobarColisionCon(pelota: Pelota) = {
    //TODO: Las colisiones quizás queremos manejarlas con una abstración del estilo Body, o algo así
    if (Collisions.collidesCircleAgainstRect(pelota.getX, pelota.getY, pelota.radius, this.getX, this.getY, width, height)) {
      this.hacerRebotar(pelota)
      this.restaVida()
      this.sumaPuntos(pelota)
    }
  }

  def hacerRebotar(pelota: Pelota) = {
    pelota.speed = PhysicsUtils.rebound(pelota.speed, normalRebote(pelota))
  }

  def normalRebote(pelota: Pelota) = {
    paredes.find { p => !p.puntoEstaDetras(pelota.center) }.map(_.normal).getOrElse(Vector2D(0, -1))
  }

  lazy val paredes = {
    List(
      Pared(this.topLeft, (0, -1)),
      Pared(this.bottomRight, (0, 1)),
      Pared(this.topLeft, (-1, 0)),
      Pared(this.bottomRight, (1, 0)))
  }

  def restaVida() = {
    this.vidas -= 1
    if (vidas <= 0) {
      this.destroy()
    } else {
      this.setAppearance(aparienciaActual)
    }
  }

  def sumaPuntos(pelota: Pelota) = {
    pelota.jugador.sumaPuntos(this.puntaje)
  }

  def puntaje = {
    10
  }
  
  def aparienciaActual = {
    val colorActual = c((maxVidas - vidas) % c.length)
    new Rectangle(colorActual, Ladrillo.width, Ladrillo.height)
  }
}

object Ladrillo {
  val width = 80
  val height = 40
  
  val blanco = Some(new Ladrillo(Color.WHITE)()(_))
  val verde = Some(new Ladrillo(Color.GREEN, Color.RED)(2)(_))
}