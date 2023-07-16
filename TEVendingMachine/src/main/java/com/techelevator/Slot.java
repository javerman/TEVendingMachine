package com.techelevator;

public class Slot {
    private static final int MAX_INVENTORY = 5;
    private String slotName;
    private StuffedAnimal currentAnimal;
    private int inventory;
    private VendingMachine vendingMachine;

    public Slot(String slotName, StuffedAnimal currentAnimal, VendingMachine vendingMachine) {
        this.vendingMachine =vendingMachine;
        this.currentAnimal = currentAnimal;
        this.slotName = slotName;
        this.inventory = MAX_INVENTORY;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
//TODO ***Change dispenseAnimal to only print message if it is in inventory, nest MakeSale in this method to avoid making sale if out of inventory
    public void dispenseAnimal(){
        if(vendingMachine.getInsertedFunds().compareTo(currentAnimal.getItemPrice()) >= 0) {
            if (inventory > 0) {
                vendingMachine.makeSale(currentAnimal.getItemPrice());
                this.inventory--;
                System.out.println(currentAnimal.getItemName() + " " + currentAnimal.getItemPrice() + " " + vendingMachine.getInsertedFunds());
                System.out.println(currentAnimal.getMessage());
            } else {
                System.out.println("Cannot make sale, item out of stock!");
            }
        } else {
            System.out.println("Cannot make sale, insufficient funds!");
        }
    }


    public static int getMaxInventory() {
        return MAX_INVENTORY;
    }

    public String getSlotName() {
        return slotName;
    }

    public void setCurrentAnimal(StuffedAnimal currentAnimal) {
        this.currentAnimal = currentAnimal;
    }

    public void setSlotName(String slotName) {
        this.slotName = slotName;
    }

    public StuffedAnimal getCurrentAnimal() {
        return currentAnimal;
    }

    public String getSlotInfo() {
        String slotInfo;
        if (inventory > 0) {
            slotInfo = slotName + " " + currentAnimal.getItemName() + " " + currentAnimal.getItemPrice();
        } else {
            slotInfo = slotName + " out of stock!";
        }
        return slotInfo;
    }
}
