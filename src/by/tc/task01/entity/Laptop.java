package tc.task01.entity;


import java.util.Objects;

public class Laptop implements Appliance{
    private String battery_capacity;
    private String OS;
    private String memory_rom;
    private String system_memory;
    private String CPU;
    private String display_inches;


    public Laptop(String batteryCapacity, String OS, String memoryRom, String systemMemory, String CPU, String displayInches) {
        this.battery_capacity = batteryCapacity;
        this.OS = OS;
        this.memory_rom = memoryRom;
        this.system_memory = systemMemory;
        this.CPU = CPU;
        this.display_inches = displayInches;
    }

    public Laptop() {
    }

    public String getBattery_capacity() {
        return battery_capacity;
    }

    public void setBattery_capacity(String battery_capacity) {
        this.battery_capacity = battery_capacity;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public String getMemory_rom() {
        return memory_rom;
    }

    public void setMemory_rom(String memory_rom) {
        this.memory_rom = memory_rom;
    }

    public String getSystem_memory() {
        return system_memory;
    }

    public void setSystem_memory(String system_memory) {
        this.system_memory = system_memory;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getDisplay_inches() {
        return display_inches;
    }

    public void setDisplay_inches(String display_inches) {
        this.display_inches = display_inches;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return Objects.equals(battery_capacity, laptop.battery_capacity) &&
                Objects.equals(OS, laptop.OS) &&
                Objects.equals(memory_rom, laptop.memory_rom) &&
                Objects.equals(system_memory, laptop.system_memory) &&
                Objects.equals(CPU, laptop.CPU) &&
                Objects.equals(display_inches, laptop.display_inches);
    }

    @Override
    public int hashCode() {
        return Objects.hash(battery_capacity, OS, memory_rom, system_memory, CPU, display_inches);
    }

}
