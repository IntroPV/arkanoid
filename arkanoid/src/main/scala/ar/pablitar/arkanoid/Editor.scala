package ar.pablitar.arkanoid

import com.uqbar.vainilla.GameComponent
import ar.pablitar.arkanoid.components.Ladrillo
import java.awt.Color
import com.uqbar.vainilla.DeltaState
import com.uqbar.vainilla.events.constants.Key
import java.awt.Graphics2D
import com.uqbar.vainilla.events.constants.MouseButton

/**
 * @author pablitar
 */
class Editor extends GameComponent[ArkanoidLevelScene]{
  var editando = false
  var constructorLadrilloActual = new Ladrillo(Color.RED)()(_)
  def ladrilloActual = constructorLadrilloActual(0,0)
  override def update(state: DeltaState) = {
    if(state.isKeyPressed(Key.E)) {
       editando = !editando
    }
    
    this.setX(state.getCurrentMousePosition.getX)
    this.setY(state.getCurrentMousePosition.getY)
    
    if(editando && state.isMouseButtonPressed(MouseButton.LEFT)) {
      this.getScene.addComponent(constructorLadrilloActual(getX, getY))
    }
  }
  
  override def render(graphics: Graphics2D) {
    if(editando) {
      ladrilloActual.getAppearance.render(this, graphics)
    }
  }
}