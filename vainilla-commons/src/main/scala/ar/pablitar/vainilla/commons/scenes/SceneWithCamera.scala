package ar.pablitar.vainilla.commons.scenes

import com.uqbar.vainilla.GameScene
import ar.pablitar.vainilla.appearances.Camera
import java.awt.Graphics2D

class SceneWithCamera extends GameScene {
  val mainCamera = new Camera

  //This is another strategy to translate all the drawings according 
  //to a camera. The problem with this approach is that it doesn't 
  //allow multiple spaces, and if you want to put something directly 
  //on screen space (say, a HUD), or if you want to have multiple 
  //cameras, it is not easy, but harder than in a regular scene
  override def takeStep(g: Graphics2D) {
    g.translate(mainCamera.position.x1, mainCamera.position.x2)
  }
}