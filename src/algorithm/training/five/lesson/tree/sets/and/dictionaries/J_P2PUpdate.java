package algorithm.training.five.lesson.tree.sets.and.dictionaries;

import java.util.*;

public class J_P2PUpdate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), k = scanner.nextInt();
        Map<Integer, Set<Integer>> partOfDevices = new HashMap<>();
        for (int device = 1; device <= n; device++) partOfDevices.put(device, new HashSet<>());

        Map<Integer, Integer> itIsFoundOnTheWeb = new HashMap<>();
        Map<Integer, List<Integer>> devisesContainsPart = new HashMap<>();
        for (int part = 1; part <= k; part++){
            partOfDevices.get(1).add(part);
            itIsFoundOnTheWeb.put(part, 1);
            devisesContainsPart.put(part, new ArrayList<>());
            devisesContainsPart.get(part).add(1);
        }

        HashMap<Integer, HashMap<Integer, Integer>> transmitFrequency = new HashMap<>();
        for (int deviceSelect = 1; deviceSelect <= n; deviceSelect++){
            transmitFrequency.put(deviceSelect, new HashMap<>());
            for (int deviceTransmit = 1; deviceTransmit <= n; deviceTransmit++){
                transmitFrequency.get(deviceSelect).put(deviceTransmit, 0);
            }
        }

        HashMap<Integer, Integer> timeOfLoad = new HashMap<>();

        int time = 0;
        while (timeOfLoad.size() < n - 1) {

            Map<Integer, Integer> devicesSelectedPart = new HashMap<>();
            for (int part = 1; part <= k; part++) {
                for (int keyDevice : partOfDevices.keySet()) {
                    if (!partOfDevices.get(keyDevice).contains(part)) {
                        if (!devicesSelectedPart.containsKey(keyDevice)) {
                            devicesSelectedPart.put(keyDevice, part);
                        } else {
                            if (itIsFoundOnTheWeb.get(part) < itIsFoundOnTheWeb.get(devicesSelectedPart.get(keyDevice)) ||
                                    (itIsFoundOnTheWeb.get(part) == itIsFoundOnTheWeb.get(devicesSelectedPart.get(keyDevice)) && part < devicesSelectedPart.get(keyDevice))) {
                                devicesSelectedPart.put(keyDevice, part);
                            }
                        }
                    }
                }
            }

            HashMap<Integer, List<Integer>> request = new HashMap<>();
            for (int keyDeviceSelect : devicesSelectedPart.keySet()) {
                int addressRequest = devisesContainsPart.get(devicesSelectedPart.get(keyDeviceSelect)).get(0);
                for (int keyDevice : devisesContainsPart.get(devicesSelectedPart.get(keyDeviceSelect))) {
                    if (partOfDevices.get(keyDevice).size() < partOfDevices.get(addressRequest).size() ||
                            (partOfDevices.get(keyDevice).size() == partOfDevices.get(addressRequest).size() && keyDevice < addressRequest)) {
                        addressRequest = keyDevice;
                    }
                }
                if (!request.containsKey(addressRequest)) request.put(addressRequest, new ArrayList<>());
                request.get(addressRequest).add(keyDeviceSelect);
            }

            HashMap<Integer, Integer> transfer = new HashMap<>();
            for (int keyDeviceRequest : request.keySet()) {
                for (int keyDeviceSelect : request.get(keyDeviceRequest)) {
                    if (transfer.containsKey(keyDeviceRequest)) {
                        if (transmitFrequency.get(keyDeviceRequest).get(keyDeviceSelect) > transmitFrequency.get(keyDeviceRequest).get(transfer.get(keyDeviceRequest)) ||
                                (transmitFrequency.get(keyDeviceRequest).get(keyDeviceSelect) == (transmitFrequency.get(keyDeviceRequest).get(transfer.get(keyDeviceRequest))) &&
                                        ((partOfDevices.get(keyDeviceSelect).size() < partOfDevices.get(transfer.get(keyDeviceRequest)).size()) ||
                                                (partOfDevices.get(keyDeviceSelect).size() == partOfDevices.get(transfer.get(keyDeviceRequest)).size()
                                                        && keyDeviceSelect < transfer.get(keyDeviceRequest))))) {
                            transfer.put(keyDeviceRequest, keyDeviceSelect);
                        }
                    } else transfer.put(keyDeviceRequest, keyDeviceSelect);
                }
            }
            time++;

            for (int keyTransfer : transfer.keySet()){
                partOfDevices.get(transfer.get(keyTransfer)).add(devicesSelectedPart.get(transfer.get(keyTransfer)));
                if (partOfDevices.get(transfer.get(keyTransfer)).size() == k) timeOfLoad.put(transfer.get(keyTransfer), time);

                devisesContainsPart.get(devicesSelectedPart.get(transfer.get(keyTransfer))).add(transfer.get(keyTransfer));
                itIsFoundOnTheWeb.put(devicesSelectedPart.get(transfer.get(keyTransfer)), itIsFoundOnTheWeb.get(devicesSelectedPart.get(transfer.get(keyTransfer))) + 1);
                transmitFrequency.get(transfer.get(keyTransfer)).put(keyTransfer, transmitFrequency.get(transfer.get(keyTransfer)).get(keyTransfer) + 1);
            }
        }

        for (int i = 2; i <= n; i++) System.out.print(timeOfLoad.get(i) + " ");

    }
}
