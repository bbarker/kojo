/*
 * Copyright (C) 2012 Lalit Pant <pant.lalit@gmail.com>
 *
 * The contents of this file are subject to the GNU General Public License
 * Version 3 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of
 * the License at http://www.gnu.org/copyleft/gpl.html
 *
 * Software distributed under the License is distributed on an "AS
 * IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * rights and limitations under the License.
 *
 */
package net.kogics.kojo.livecoding

import javax.swing.text.JTextComponent
import java.awt.Color
import javax.swing.JFrame

trait ManipulationContext {
  def isRunningEnabled: Boolean
  def runIpmCode(code: String): Unit
  def codePane: JTextComponent
  def frame: JFrame
  def addManipulator(im: InteractiveManipulator)
  def removeManipulator(im: InteractiveManipulator)
  def activateEditor()
  def knownColors: List[String]
  def knownColor(name: String): Color
}

trait InteractiveManipulator {
  def isAbsent: Boolean
  def isPresent: Boolean
  def close(): Unit
  def inSliderChange: Boolean
  def isHyperlinkPoint(pane: JTextComponent, offset: Int): Boolean
  def getHyperlinkSpan(pane: JTextComponent, offset: Int): Array[Int]
  def activate(pane: JTextComponent, offset: Int)
}
