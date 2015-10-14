package ar.pablitar.vainilla.commons.components

import com.uqbar.vainilla.GameComponent
import com.uqbar.vainilla.GameScene
import ar.pablitar.vainilla.appearances.Camera
import com.uqbar.vainilla.DeltaState
import com.uqbar.vainilla.events.constants.Key

class CameraKeyboardMover(camera: Camera) extends GameComponent[GameScene]{
  
  override def update(state: DeltaState) = {
    val delta = 300 * state.getDelta
    if(state.isKeyBeingHold(Key.LEFT)) {
      camera.position -= (delta, 0.0)
    }
    
    if(state.isKeyBeingHold(Key.RIGHT)) {
      camera.position += (delta, 0.0)
    }
    
    if(state.isKeyBeingHold(Key.UP)) {
      camera.position -= (0.0, delta)
    }
    
    if(state.isKeyBeingHold(Key.DOWN)) {
      camera.position += (0.0, delta)
    }
  }
}