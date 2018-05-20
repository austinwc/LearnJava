package com.austinwc.demos;

public class TowerOfHanoi {
    private int[] towers;
    private int numDisks;

    private TowerOfHanoi(int numD) {
        System.out.println("Creating towers with " + numD + " disks...");

        numDisks = numD;
        towers = new int[numDisks];

        for (int i = 0; i < numDisks; i++)
            towers[i] = 0;

        printTowers();
    }

    private void printTowers() {
        // Print two blank lines
        System.out.println("\n");

        // Print two empty lines
        printTowersRow(new int[] {-1, -1, -1});
        printTowersRow(new int[] {-1, -1, -1});

        /*
        for (int i = 0; i < numDisks; i++) {
            printTowersRow(i, towers[i]);
        }
        */
    }

    private void printTowersRow(int[] slots) {
        int maxDiskWidth = (numDisks - 1) * 2 + 3;

        // Empty slot
        StringBuilder empty = new StringBuilder();
        for (int i = 0; i <= maxDiskWidth / 2; i++)
            empty.append(' ');
        empty.append('|');
        for (int i = 0; i <= maxDiskWidth / 2; i++)
            empty.append(' ');

        // Print slots
        for (int diskValue : slots) {
            if (diskValue == -1) {
                System.out.print(empty);
            } else {
                // Disk
                int diskSize = diskValue * 2 + 3;
                int padding = (maxDiskWidth - diskSize) / 2;
                for (int i = 0; i <= padding; i++)
                    System.out.print(' ');
                for (int i = 0; i < diskSize; i++)
                    System.out.print('0');
                for (int i = 0; i <= padding; i++)
                    System.out.print(' ');
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TowerOfHanoi myTower = new TowerOfHanoi(3);
    }
}
