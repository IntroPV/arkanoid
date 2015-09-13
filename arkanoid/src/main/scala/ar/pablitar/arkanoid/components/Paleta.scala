package ar.pablitar.arkanoid.components

import com.uqbar.vainilla.GameComponent
import ar.pablitar.arkanoid.ArkanoidLevelScene
import ar.pablitar.arkanoid.ArkanoidGame
import com.uqbar.vainilla.appearances.Rectangle
import java.awt.Color
import com.uqbar.vainilla.DeltaState
import com.uqbar.vainilla.events.constants.Key
import ar.pablitar.vainilla.commons.math.Vector2D
import ar.pablitar.vainilla.commons.math.Vector2D._
import ar.pablitar.vainilla.commons.math.Bounds
import ar.pablitar.vainilla.commons.math.HorizontalBounds
import ar.pablitar.vainilla.commons.components.SpeedyComponent
import scala.collection.mutable.ArrayBuffer

/**
 * @author pablitar
 */
class Paleta extends SpeedyComponent[ArkanoidLevelScene] {

  override val width = 100.0
  override val height = 40.0

  val speedMagnitude = 300
  val pelotasAttacheadas = ArrayBuffer.empty[Pelota]

  override lazy val movementBounds = new HorizontalBounds(0, this.getGame.getDisplayWidth)

  this.setAppearance(new Rectangle(Color.BLUE, width.toInt, height.toInt))

  override def onSceneActivated = {
    this.alignHorizontalCenterTo(this.getGame.getDisplayWidth / 2)
    this.alignVerticalCenterTo(0.9 * this.getGame.getDisplayHeight)
  }

  override def update(state: DeltaState) = {
    this.speed = (0, 0)

    if (state.isKeyBeingHold(Key.LEFT)) {
      this.speed += (-speedMagnitude, 0)
    }

    if (state.isKeyBeingHold(Key.RIGHT)) {
      this.speed += (speedMagnitude, 0)
    }
    
    if(state.isKeyPressed(Key.SPACE)) {
      lanzarPelotasAttacheadas()
    }
    
    super.update(state)
  }
  
  override def position_=(v: Vector2D) = {
    val posicionVieja = this.position
    super.position_=(v)
    desplazarPelotasAttacheadas(this.position - posicionVieja)
  }

  def attach(unaPelota: Pelota) = {
    unaPelota.speed = (0, 0)
    unaPelota.setY(getY - unaPelota.radius * 2)
    pelotasAttacheadas += unaPelota
  }

  def desplazarPelotasAttacheadas(desplazamiento: Vector2D) = {
    pelotasAttacheadas.foreach { _.position+=desplazamiento }
  }

  def lanzarPelotasAttacheadas() = {
    pelotasAttacheadas.clone.foreach { pelota => this.lanzar(pelota) }
  }

  def lanzar(pelota: Pelota) = {
    pelotasAttacheadas -= pelota
    pelota.speed = (0, pelota.speedMagnitued)
    pelota.rebotaDesde(this)
  }

}