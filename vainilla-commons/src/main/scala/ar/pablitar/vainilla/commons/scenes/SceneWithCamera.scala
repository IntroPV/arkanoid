package ar.pablitar.vainilla.commons.scenes

import com.uqbar.vainilla.GameScene
import ar.pablitar.vainilla.appearances.Camera
import java.awt.Graphics2D

class SceneWithCamera extends GameScene {
  val mainCamera = new Camera
  
  override def takeStep(g: Graphics2D) {
    g.translate(mainCamera.position.x1, mainCamera.position.x2)
  }
}