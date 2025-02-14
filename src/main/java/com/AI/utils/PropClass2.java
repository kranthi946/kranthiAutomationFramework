package com.AI.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import com.AI.constants.FrameworkConstants;
import com.AI.enums.ConfigPropertiesEnum;

import com.AI.exceptions.PropertyFileUsageException;

/**
 * Utility class for reading properties file and storing key-value pairs in a map.
 * Can be extended to support JSON-based configuration as required.
 */
public final class PropClass2 {

    private static final Properties property = new Properties();


    private static final Map<String, String> CONFIGMAP = new HashMap<>();

    // Private constructor to prevent instantiation
    private PropClass2() {}

    // Static block to load properties from the file
    static {
        try (FileInputStream file = new FileInputStream(FrameworkConstants.getConfigfilepath())) {
            property.load(file);


        /*    * // Create an immutable map using Map.copyOf
            CONFIGMAP = Map.copyOf(
                property.entrySet().stream()
                    .collect(Collectors.toMap(
                        entry -> String.valueOf(entry.getKey()).toLowerCase(),  // Convert key to lowercase
                        entry -> String.valueOf(entry.getValue()).toLowerCase() // Convert value to lowercase
                    ))
            );

*/

  /*          Set<Map.Entry<Object, Object>> entrySet = [
    Map.Entry("URL", "http://example.com"),
    Map.Entry("OVERIDEREPORTS", "true")

]
   */         /*

stream = Stream<Map.Entry<String, String>>[
    Map.Entry("URL", "http://example.com"),
    Map.Entry("OVERIDEREPORTS", "true")
]
*/



            /*
            * Stream<Map.Entry<Object, Object>> stream =
    Stream<Map.Entry<Object, Object>>[
        Map.Entry("URL", "http://EXAMPLE.com"),
        Map.Entry("OVERIDEREPORTS", "TRUE")
    ];
*/


            /*Key: URL, Value: http://example.com
Key: OVERIDEREPORTS, Value: true

             */

          CONFIGMAP.putAll(property.entrySet().stream().collect(Collectors.toMap(


                    entry ->  String.valueOf(entry.getKey()).toLowerCase(),
                    entry -> String.valueOf(entry.getValue()).toLowerCase()
                  )


                  )

          );



            // Populate CONFIGMAP with property key-value pairs
         /*   CONFIGMAP.putAll(property.entrySet().stream()
                    .collect(Collectors.toMap(
                            entry -> String.valueOf(entry.getKey()).toLowerCase(),
                            entry -> String.valueOf(entry.getValue()).trim()))
            );*/


        } catch (IOException e) {
            throw new PropertyFileUsageException("Failed to load property file", e);
        }
    }



    /**
     * Retrieves a property value based on the provided key.
     *
     * @param key The property key to retrieve the value.
     * @return The property value.
     * @throws PropertyFileUsageException if the key is not found.
     */


    public static String get(ConfigPropertiesEnum key) {

        if (key == null || !CONFIGMAP.containsKey(key.name().toLowerCase())) {
            throw new PropertyFileUsageException(
                    "Property name '" + key + "' not found. Please check the config.properties file.");
        }
        return CONFIGMAP.get(key.name().toLowerCase());
    }
}
