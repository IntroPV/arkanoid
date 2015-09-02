package ar.pablitar.arkanoid

import com.uqbar.vainilla.Game
import java.awt.Dimension

/**
 * @author pablitar
 */
object ArkanoidGame extends Game {
  def getDisplaySize(): Dimension = {
    new Dimension(800, 600)
  }

  def getTitle(): String = {
    "Arkanoid"
  }

  def initializeResources(): Unit = {
    
  }

  def setUpScenes(): Unit = {
    this.setCurrentScene(new ArkanoidLevelScene())
  }
}