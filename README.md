# Sway Themes List


### Themes

* Create a theme

  ```java
  Theme theme = new Theme(); //And insert each color by hand
  //or
  Theme theme_json = new Theme(new JsonString(your_json_string);
  //or
  Theme theme_yaml = new Theme(new YamlFile(full_file_directory]);
  ```
* Parse Yaml file
  ```java
  Theme theme = new Theme();
  
  theme.parseYaml(new YamlFile(full_file_directory);
  ```
* Parse Json
  ```java
  Theme theme = new Theme();
  
  theme.parseJson(new JsonString(your_json_string);
  ```
  
* Generate Yaml from Theme
  ```java
  YamlFile yaml = existing_theme.generateYaml(target_directory); //Creates .yml file in [targer directory]
  ```
  
* Generate Json from Theme
  ```java
  JsonString json = existing_theme.generateJson();
  ```
  
### ThemeCollection
* Create a ThemeCollection
  ```java
  ThemeCollection themes = new ThemeCollection(); // No other constructor exists
  ```
  
* Add a theme
  ```java
  themes.add(new Theme());
  ```
  
* Load themes
  ```java
  themes.load(new File(folder_path)); // Folder containing .yml files with wanted themes
  
  //or
  
  themes.load(new String[]{[strings with theme information]});
  ```
  
* Implement Theme on a container
  ```java
  JFrame frame = new JFrame();
  Theme theme = new Theme(); //non empty theme
  ThemeCollection.implementTheme(frame, theme);
  ```
## TODO
* Make dependency fully public on the Maven repository
