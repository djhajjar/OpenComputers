package li.cil.oc.server.driver.item

import li.cil.oc.api
import li.cil.oc.api.driver.Slot
import li.cil.oc.api.machine.Robot
import li.cil.oc.server.component
import net.minecraft.item.ItemStack

object UpgradeCrafting extends Item {
  override def worksWith(stack: ItemStack) = isOneOf(stack, api.Items.get("craftingUpgrade"))

  override def createEnvironment(stack: ItemStack, container: component.Container) =
    container.tileEntity match {
      case Some(robot: Robot) => new component.UpgradeCrafting(robot)
      case _ => null
    }

  override def slot(stack: ItemStack) = Slot.Upgrade
}
