package ar.pablitar.vainilla.commons.inspectors

import com.uqbar.vainilla.GameComponent
import com.uqbar.vainilla.GameScene
import ar.pablitar.vainilla.commons.math.Vector2D

/**
 * @author pablitar
 */

trait VectorSource {
  def origin: Vector2D
  def destination: Vector2D
  
  def difference = destination - origin
}


class VectorInspector(vectorGetter : () => Vector2D, originGetter: () => Vector2D = { () => Vector2D(0,0)})  extends GameComponent[GameScene] with VectorSource {
  this.setAppearance(new VectorInspectoAppearance(this))

  def destination = {
    vectorGetter()
  }

  def origin = {
    originGetter()
  }
}