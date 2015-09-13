package ar.pablitar.arkanoid

import com.uqbar.vainilla.Game
import java.awt.Dimension

/**
 * @author pablitar
 */
object ArkanoidGame extends Game {
  lazy val height = 600
  lazy val width = 800
  
  def getDisplaySize(): Dimension = {
    new Dimension(width, height)
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