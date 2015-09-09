package ar.pablitar.arkanoid.components

import ar.pablitar.vainilla.commons.components.SpeedyComponent
import ar.pablitar.arkanoid.ArkanoidLevelScene
import com.uqbar.vainilla.appearances.Circle
import java.awt.Color
import com.uqbar.vainilla.DeltaState
import com.uqbar.vainilla.colissions.CollisionDetector.{ INSTANCE => Collisions }
import ar.pablitar.arkanoid.Pared

/**
 * @author pablitar
 */
class Pelota extends SpeedyComponent[ArkanoidLevelScene] {

  val radius = 30.0
  val diameter = radius * 2

  this.setAppearance(new Circle(Color.RED, diameter.toInt))

  speed = (0, 300)

  override def onSceneActivated = {
    this.alignHorizontalCenterTo(this.getGame.getDisplayWidth / 2)
  }

  override def update(state: DeltaState) = {
    this.comprobarColisionConPaleta
    this.comprobarColisionConParedes

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
    val direccionReboteVersor = (this.center - paleta.center).versor

    speed = speed.module * direccionReboteVersor
  }

  def comprobarColisionConParedes = {
    getScene.paredes.foreach { pared =>
      if (pared.circuloPasoDetras(this.center, radius)) {
        this.rebotaConPared(pared)
      }
    }
  }

  def rebotaConPared(pared: Pared) = {
    this.speed = (-2 * this.speed.proyectTo(pared.normal)) + this.speed
  }
}