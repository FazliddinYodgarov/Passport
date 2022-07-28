package com.company.type;

public enum EquipmentType {
    ALL("Все"),SEPARATOR("Сепаратор и емкость"), EXCHANGER("Теплообменник"), RESERVOIR("Резервуар"),
    AVO("АВО"),COLUMN("Колонна"),GPA("ГПА"),PUMP("Насос"),COMPRESSOR("Компрессор"),
    AIR_COMPRESSOR("Воздушный компрессор"),PIPELINE("Трубопровод"),TORCH("Факел"),BOILER("Котел");

    private String name;

    EquipmentType(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

}
