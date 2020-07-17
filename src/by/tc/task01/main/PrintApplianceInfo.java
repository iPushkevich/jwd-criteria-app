package tc.task01.main;

import tc.task01.entity.*;

import java.util.Set;

public class PrintApplianceInfo {

	public static void print(Set<Appliance> appliance) {
		if (appliance == null) {
			System.out.println("No result");
		} else {
			for (Appliance value : appliance) {
				if (value instanceof Laptop laptop) {
					String battery_capacity = laptop.getBattery_capacity();
					String OS = laptop.getOS();
					String memory_rom = laptop.getMemory_rom();
					String system_memory = laptop.getSystem_memory();
					String CPU = laptop.getCPU();
					String display_inches = laptop.getDisplay_inches();

					System.out.println("Laptop : BATTERY_CAPACITY=" + battery_capacity +
							" OS=" + OS +
							" MEMORY_ROM=" + memory_rom +
							" SYSTEM_MEMORY=" + system_memory +
							" CPU=" + CPU +
							" DISPLAY_INCHES=" + display_inches);
				}

				if (value instanceof Oven oven) {
					String powerConsumption = oven.getPowerConsumption();
					String weight = oven.getWeight();
					String capacity = oven.getCapacity();
					String depth = oven.getDepth();
					String height = oven.getHeight();
					String width = oven.getWidth();

					System.out.println("Laptop : POWER_CONSUMPTION=" + powerConsumption +
							" WEIGHT=" + weight +
							" CAPACITY=" + capacity +
							" DEPTH=" + depth +
							" HEIGHT=" + height +
							" WIDTH=" + width);
				}

				if (value instanceof Refrigerator refrigerator) {
					String powerConsumption = refrigerator.getPowerConsumption();
					String weight = refrigerator.getWeight();
					String freezeCapacity = refrigerator.getFreezerCapacity();
					String overallCapacity = refrigerator.getOverallCapacity();
					String height = refrigerator.getHeight();
					String width = refrigerator.getWidth();

					System.out.println("Refrigerator : POWER_CONSUMPTION=" + powerConsumption +
							" WEIGHT=" + weight +
							" FREEZE_CAPACITY=" + freezeCapacity +
							" OVERALL_CAPACITY=" + overallCapacity +
							" HEIGHT=" + height +
							" WIDTH=" + width);
				}

				if (value instanceof VacuumCleaner vacuumCleaner) {
					String powerConsumption = vacuumCleaner.getPowerConsumption();
					String filterType = vacuumCleaner.getFilterType();
					String bagType = vacuumCleaner.getBagType();
					String wandType = vacuumCleaner.getWandType();
					String motorSpeedRegulation = vacuumCleaner.getMotorSpeedRegulation();
					String cleaningWidth = vacuumCleaner.getCleaningWidth();

					System.out.println("VacuumCleaner : POWER_CONSUMPTION=" + powerConsumption +
							" FILTER_TYPE=" + filterType +
							" BAG_TYPE=" + bagType +
							" WAND_TYPE=" + wandType +
							" MOTOR_SPEED_REGULATION=" + motorSpeedRegulation +
							" CLEANING_WIDTH=" + cleaningWidth);
				}

				if (value instanceof TabletPC tabletPC) {
					String batteryCapacity = tabletPC.getBatteryCapacity();
					String displayInches = tabletPC.getDisplayInches();
					String memoryRom = tabletPC.getMemoryRom();
					String flashMemoryCapacity = tabletPC.getFlashMemoryCapacity();
					String color = tabletPC.getColor();

					System.out.println("TabletPC : BATTERY_CAPACITY=" + batteryCapacity +
							" DISPLAY_INCHES=" + displayInches +
							" MEMORY_ROM=" + memoryRom +
							" FLASH_MEMORY_CAPACITY=" + flashMemoryCapacity +
							" COLOR=" + color);
				}

				if (value instanceof Speakers speakers) {
					String powerConsumption = speakers.getPowerConsumption();
					String numberOfSpeakers = speakers.getNumberOfSpeakers();
					String frequencyRange = speakers.getFrequencyRange();
					String cordLength = speakers.getCordLength();

					System.out.println("Speakers : POWER_CONSUMPTION=" + powerConsumption +
							" NUMBER_OF_SPEAKERS=" + numberOfSpeakers +
							" FREQUENCY_RANGE=" + frequencyRange +
							" CORD_LENGTH=" + cordLength);

				}
			}
		}
	}
}
