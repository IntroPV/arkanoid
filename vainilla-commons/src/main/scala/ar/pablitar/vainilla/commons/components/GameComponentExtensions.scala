package ar.pablitar.vainilla.commons.components

import com.uqbar.vainilla.GameComponent
import ar.pablitar.vainilla.commons.math.Vector2D

object GameComponentExtensions {
  implicit class ExtendedGameComponent(component: GameComponent[_]) {
    def position = Vector2D(component.getX, component.getY)
    def position_=(p: Vector2D): Unit = {
      component.setX(p.x1)
      component.setY(p.x2)
    }
  }
}