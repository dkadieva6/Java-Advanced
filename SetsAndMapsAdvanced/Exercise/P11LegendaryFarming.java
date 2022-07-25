package Advanced.SetsAndMapsAdvanced.Exercise;

import java.util.*;

public class P11LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> legendaryMaterials = new TreeMap<>();
        legendaryMaterials.put("shards", 0);
        legendaryMaterials.put("fragments", 0);
        legendaryMaterials.put("motes", 0);

        Map<String, String> legendaryItems = new LinkedHashMap<>();
        legendaryItems.put("shards", "Shadowmourne");
        legendaryItems.put("fragments", "Valanyr");
        legendaryItems.put("motes", "Dragonwrath");

        Map<String, Integer> materials = new LinkedHashMap<>();

        boolean haveWinner = false;
        while (!haveWinner) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int i = 0; i < input.length; i += 2) {
                int quality = Integer.parseInt(input[i]);
                String material = input[i + 1].toLowerCase(Locale.ROOT);
                if (legendaryMaterials.containsKey(material)) {
                    if (legendaryMaterials.get(material) + quality >= 250) {
                        legendaryMaterials.put(material, legendaryMaterials.get(material) + quality - 250);
                        haveWinner = true;
                        System.out.println(legendaryItems.get(material) + " obtained!");
                        break;
                    } else {
                        legendaryMaterials.put(material, legendaryMaterials.get(material) + quality);
                    }
                } else {
                    materials.putIfAbsent(material, 0);
                    materials.put(material, materials.get(material) + quality);
                }
            }
        }

        legendaryMaterials.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(s -> System.out.println(s.getKey() + ": " + s.getValue()));
        materials.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(s -> System.out.println(s.getKey() + ": " + s.getValue()));
    }
}
