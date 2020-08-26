/*
 * Copyright (c) 2018 Gomint team
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.world.block;

/**
 * @author geNAZt
 * @version 1.0
 * @stability 1
 */
public interface BlockElement extends Block {

    enum Type {
        UNKNOWN,
        HYDROGEN,
        HELIUM,
        LITHIUM,
        BERYLLIUM,
        BORON,
        CARBON,
        NITROGEN,
        OXYGEN,
        FLUORINE,
        NEON,
        SODIUM,
        MAGNESIUM,
        ALUMINUM,
        SILICON,
        PHOSPHORUS,
        SULFUR,
        CHLORINE,
        ARGON,
        POTASSIUM,
        CALCIUM,
        SCANDIUM,
        TITANIUM,
        VANADIUM,
        CHROMIUM,
        MANGANESE,
        IRON,
        COBALT,
        NICKEL,
        COPPER,
        ZINC,
        GALLIUM,
        GERMANIUM,
        ARSENIC,
        SELENIUM,
        BROMINE,
        KRYPTON,
        RUBIDIUM,
        STRONTIUM,
        YTTRIUM,
        ZIRCONIUM,
        NIOBIUM,
        MOLYBDENUM,
        TECHNETIUM,
        RUTHENIUM,
        RHODIUM,
        PALLADIUM,
        SILVER,
        CADMIUM,
        INDIUM,
        TIN,
        ANTIMONY,
        TELLURIUM,
        IODINE,
        XENON,
        CESIUM,
        BARIUM,
        LANTHANUM,
        CERIUM,
        PRASEODYMIUM,
        NEODYMIUM,
        PROMETHIUM,
        SAMARIUM,
        EUROPIUM,
        GADOLINIUM,
        TERBIUM,
        DYSPROSIUM,
        HOLMIUM,
        ERBIUM,
        THULIUM,
        YTTERBIUM,
        LUTETIUM,
        HAFNIUM,
        TANTALUM,
        TUNGSTEN,
        RHENIUM,
        OSMIUM,
        IRIDIUM,
        PLATINUM,
        GOLD,
        MERCURY,
        THALLIUM,
        LEAD,
        BISMUTH,
        POLONIUM,
        ASTATINE,
        RADON,
        FRANCIUM,
        RADIUM,
        ACTINIUM,
        THORIUM,
        PROTACTINIUM,
        URANIUM,
        NEPTUNIUM,
        PLUTONIUM,
        AMERICIUM,
        CURIUM,
        BERKELIUM,
        CALIFORNIUM,
        EINSTEINIUM,
        FERMIUM,
        MENDELEVIUM,
        NOBELIUM,
        LAWRENCIUM,
        RUTHERFORDIUM,
        DUBNIUM,
        SEABORGIUM,
        BOHRIUM,
        HASSIUM,
        MEITNERIUM,
        DARMSTADTIUM,
        ROENTGENIUM,
        COPERNICIUM,
        NIHONIUM,
        FLEROVIUM,
        MOSCOVIUM,
        LIVERMORIUM,
        TENNESSINE,
        OGANESSON;
    }

    /**
     * Get the type of element this block holds
     *
     * @return type of element
     */
    Type getType();

    /**
     * Set type of element for this block
     *
     * @param type of element
     */
    void setType(Type type);

}
