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

/**
 * @author pablitar
 */
class Paleta extends GameComponent[ArkanoidLevelScene] {
  val width = 100
  val height = 50

  val speedMagnitude = 300

  var speed = Vector2D(0, 0)
  
  lazy val movementBounds = new HorizontalBounds(0, this.getGame.getDisplayWidth)

  this.setAppearance(new Rectangle(Color.BLUE, width, height))

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

    this.applySpeed(state)
  }

  def applySpeed(state: DeltaState) = {
    this.position += speed * state.getDelta
  }

  def position_=(v: Vector2D) = {
    val limited = movementBounds.limit(v, (width, height))
    this.setX(limited.x1)
    this.setY(limited.x2)
  }

  def position = Vector2D(getX, getY)

}