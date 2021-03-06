/*
    Copyright 2018 Will Winder

    This file is part of Universal Gcode Sender (UGS).

    UGS is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    UGS is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with UGS.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.willwinder.universalgcodesender;

import java.util.HashSet;
import java.util.Set;

/**
 * Stores all capabilities supported by the implementation of the {@link IController}.
 *
 * @author wwinder
 * @author Joacim Breiler
 */
public class Capabilities {

    /**
     * The capabilities available for the current hardware
     */
    private Set<String> capabilities = new HashSet<>();

    /**
     * Adds a capability that is either defined in {@link CapabilitiesConstants} or a
     * special capability for the controller.
     *
     * @param capability the capability to add. Either defined in {@link CapabilitiesConstants}
     *                   or a specific defined by the controller.
     */
    public void addCapability(String capability) {
        capabilities.add(capability);
    }

    /**
     * Removes a capability that is either defined in {@link CapabilitiesConstants} or a
     * special capability for the controller.
     *
     * @param capability the capability to remove
     */
    public void removeCapability(String capability) {
        capabilities.remove(capability);
    }

    /**
     * Checks if the controller has the given capability is available.
     *
     * @param capability the capability as a string that we want to check. You may define
     *                   your own values, the generic capabilities are defined in
     *                   {@link CapabilitiesConstants}
     *
     * @return returns true if the capability is available
     */
    public boolean hasCapability(String capability) {
        return capabilities.contains(capability);
    }

    /**
     * Returns if the hardware have support for jogging. The capabilitiy is defined
     * by the capability {@link CapabilitiesConstants#JOGGING}. Jogging may be
     * emulated by the controller using GCode-commands.
     *
     * @return true if jogging is supported
     */
    public boolean hasJogging() {
        return hasCapability(CapabilitiesConstants.JOGGING);
    }

    /**
     * Returns if the hardware have support for overrides. The capabilitiy is defined
     * by the capability {@link CapabilitiesConstants#OVERRIDES}.
     *
     * @return true if overrides is supported
     */
    public boolean hasOverrides() {
        return hasCapability(CapabilitiesConstants.OVERRIDES);
    }

    /**
     * Returns if the hardware have support for continuous jogging. The capabilitiy
     * is defined by the capability {@link CapabilitiesConstants#CONTINUOUS_JOGGING}
     * *
     * @return true if continuous jogging is supported
     */
    public boolean hasContinuousJogging() {
        return hasCapability(CapabilitiesConstants.CONTINUOUS_JOGGING);
    }
}
