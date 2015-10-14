package ar.pablitar.vainilla.commons.components

import com.uqbar.vainilla.GameComponent
import com.uqbar.vainilla.GameScene
import com.uqbar.vainilla.DeltaState
import ar.pablitar.vainilla.commons.math.Vector2D
import ar.pablitar.vainilla.commons.math.InfiniteBounds
import ar.pablitar.vainilla.commons.math.Vector2D.toVector2D
import ar.pablitar.vainilla.commons.math.Bounds

/**
 * @author pablitar
 */
trait SpeedyComponent[T <: GameScene] extends RichGameComponent[T] {
  
  var speed = Vector2D(0, 0)
  var acceleration = Option.empty[Vector2D]
  
  
  def applySpeed(state: DeltaState) = {
    this.position += speed * state.getDelta
  }
  
  def applyAcceleration(state:DeltaState) = {
    acceleration.foreach {
      speed += _ * state.getDelta
    }
  }
  
  override def update(state: DeltaState) = {
    this.getAppearance.update(state.getDelta)
    this.applySpeed(state)
    this.applyAcceleration(state)
  }  
}