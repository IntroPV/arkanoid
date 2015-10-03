package ar.pablitar.vainilla.commons.components

import com.uqbar.vainilla.GameScene
import com.uqbar.vainilla.GameComponent
import com.uqbar.vainilla.DeltaState

/**
 * @author pablitar
 */
class Cooldown[T <: GameScene](cooldown: Double, repeat: Boolean, action: () => Any) extends GameComponent[T] {
  var elapsed = 0.0

  override def update(state: DeltaState) = {
    this.elapsed += state.getDelta
    if (elapsed >= cooldown) {
      action()
      if (repeat)
        this.elapsed = 0.0
      else
        this.destroy()
    }
  }
}

object Cooldown {
  def apply(cooldown: Double, repeat: Boolean = true)(a: => Any) = new Cooldown(cooldown, repeat, () => a)
}