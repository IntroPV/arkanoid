package ar.pablitar.vainilla.appearances

import com.uqbar.vainilla.GameComponent
import java.awt.Graphics2D
import com.uqbar.vainilla.appearances.Appearance
import ar.pablitar.vainilla.commons.components.GameComponentExtensions._
import com.uqbar.vainilla.DeltaState

trait WorldSpaceAppearance extends Appearance {
  def camera: Camera
  def render(component: GameComponent[_], graphics: Graphics2D): Unit = {
    val screenPosition = camera.toLocalFromWorld(component.position)
    
    doRenderAt(screenPosition.x1, screenPosition.x2, graphics)
  }
  
  def height: Double
  def width: Double
  def getHeight = height
  def getWidth = width
  
  def update(delta: Double):Unit = {}

  def doRenderAt(x: Double, y: Double, graphics: Graphics2D)
  
  def copy[T<:Appearance]():T = {this.doCopy.asInstanceOf[T]}

  def doCopy: Appearance
}