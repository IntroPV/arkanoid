package ar.pablitar.arkanoid.components

import ar.pablitar.vainilla.commons.components.SpeedyComponent
import ar.pablitar.vainilla.commons.math.RandomUtils._
import ar.pablitar.arkanoid.ArkanoidLevelScene
import com.uqbar.vainilla.appearances.Circle
import java.awt.Color
import com.uqbar.vainilla.DeltaState
import com.uqbar.vainilla.colissions.CollisionDetector.{ INSTANCE => Collisions }
import ar.pablitar.arkanoid.Pared
import ar.pablitar.vainilla.commons.math.Vector2D
import ar.pablitar.vainilla.commons.math.PhysicsUtils
import ar.pablitar.arkanoid.Jugador
import ar.pablitar.vainilla.commons.components.Cooldown

/**
 * @author pablitar
 */
class Pelota(val jugador: Jugador) extends SpeedyComponent[ArkanoidLevelScene] {

  val radius = 15.0
  val diameter = radius * 2

  val speedMagnitued = 300

  val probabilidadGolpeCritico = 0.02

  this.setAppearance(new Circle(Color.RED, diameter.toInt))

  override def onSceneActivated = {
    this.alignHorizontalCenterTo(getGame.getDisplayWidth / 2)
    getScene.paleta.attach(this)
  }

  override def update(state: DeltaState) = {
    this.comprobarColisionConPaleta
    this.comprobarColisionConParedes

    this.comprobrarDebajoDePantalla
    
    super.update(state)
  }

  def comprobarColisionConPaleta = {
    val paleta = this.getScene.paleta
    if (this.colisionaCon(paleta)) {
      this.rebotaDesde(paleta)
    }
  }

  def colisionaCon(paleta: Paleta) = {
    Collisions.collidesCircleAgainstRect(getX, getY, radius, paleta.getX, paleta.getY, paleta.width, paleta.height)
  }

  def rebotaDesde(paleta: Paleta) = {
    val direccionReboteVersor = (this.center() - paleta.center()).versor

    speed = speed.module * direccionReboteVersor
  }

  def comprobarColisionConParedes = {
    getScene.paredes.foreach { pared =>
      if (pared.circuloPasoDetras(this.center(), radius)) {
        this.rebotaConPared(pared)
      }
    }
  }

  def rebotaConPared(pared: Pared) = {
    this.speed = PhysicsUtils.rebound(this.speed, pared.normal)
  }

  def isBelowTheScreen = {
    this.position.x2 >= this.getGame.getDisplayHeight
  }

  def comprobrarDebajoDePantalla = {
    if (isBelowTheScreen) {
      this.getScene.seFuePelota(this)
      this.destroy()
    }
  }

  def impacta(ladrillo: Ladrillo) = {
    if (this.golpeCritico) {
      ladrillo.destruir
      this.setColor(Color.BLUE, Some(0.5))
    } else {
      ladrillo.hacerRebotar(this)
      ladrillo.restaVida()
    }
  }

  def golpeCritico = {
    getScene.randomizer.success(probabilidadGolpeCritico)
  }

  def setColor(color: Color, duration: Option[Double] = None): Unit = {
    this.setAppearance(new Circle(color, diameter.toInt))
    duration.foreach { x =>
      this.getScene.addComponent(Cooldown(x) {
        this.setColor(Color.RED)
      })
    }
  }

}