package com.kdesp.swaythemeslist;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.yaml.snakeyaml.Yaml;

/**
 *
 * @author Lacocoa
 */
public class YamlFile {
        private String directory;
        private Map<String, Object> contents;

        public YamlFile(String directory) {
                this.directory = directory;
                this.contents = getYamlData(directory);
        }

        private static Map<String, Object> getYamlData(String fileDirectory) {
                InputStream inputStream = null;
                try {
                        inputStream = new FileInputStream(new File(fileDirectory));
                } catch (FileNotFoundException ex) {
                        Logger.getLogger(YamlFile.class.getName()).log(Level.SEVERE, null, ex);
                }

                Yaml yaml = new Yaml();
                Map<String, Object> data = yaml.load(inputStream);
                return data;
        }
        
        public Object getValue(String key) throws IOException, KeyNotFoundException{
                if(contents.get(key) == null) throw new KeyNotFoundException("Key Not Found");
                return contents.get(key);
        }

        public String getDirectory() {
                return directory;
        }

        public Map<String, Object> getContents() {
                return contents;
        }

        @Override
        public String toString() {
                return "YamlFile{" + "directory=" + directory + ", contents=" + contents + '}';
        }

        
}
