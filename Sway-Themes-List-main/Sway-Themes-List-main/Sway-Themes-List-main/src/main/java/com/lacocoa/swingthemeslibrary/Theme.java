
package com.kdesp.swaythemeslist;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;

/**
 *
 * @author Lacocoa
 */
public class Theme {

        private String name;
        private String json;
        private YamlFile yaml;

        private Color bg;
        private Color bg_2;
        private Color fg;
        private Color fg_2;
        private Color btn;
        private Color btn_fg;
        private Color textbox;
        private Color textbox_fg;
        private Color list;
        private Color list_fg;
        private Color list_focus;
        private Color scrollbar;
        private Color progress_bar;
        private Color extra_0;
        private Color extra_1;
        private Color extra_2;
        private Color extra_3;
        private Color extra_4;
        private Color extra_5;
        private Color extra_6;
        private Color extra_7;
        private Color extra_8;
        private Color extra_9;
        private Color[] extras;

        public Theme(JsonString json) {
                this.json = json.getJson();

                //Parse json into theme
                parseJson(json);
        }

        public Theme(YamlFile yaml) {
                this.yaml = yaml;

                try {
                        //Parse yaml into theme
                        parseYaml(yaml);
                } catch (KeyNotFoundException | IOException ex) {
                        Logger.getLogger(Theme.class.getName()).log(Level.SEVERE, null, ex);
                }
        }

        public Theme() {
        }

        public void parseYaml(YamlFile yaml) throws KeyNotFoundException, IOException {
                name = (String) yaml.getValue("name");
                bg = Utils.hexToColor(yaml.getValue("bg").toString());
                bg_2 = Utils.hexToColor(yaml.getValue("bg_2").toString());
                fg = Utils.hexToColor(yaml.getValue("fg").toString());
                fg_2 = Utils.hexToColor(yaml.getValue("fg_2").toString());
                btn = Utils.hexToColor(yaml.getValue("btn").toString());
                btn_fg = Utils.hexToColor(yaml.getValue("btn_fg").toString());
                textbox = Utils.hexToColor(yaml.getValue("textbox").toString());
                textbox_fg = Utils.hexToColor(yaml.getValue("textbox_fg").toString());
                list = Utils.hexToColor(yaml.getValue("list").toString());
                list_fg = Utils.hexToColor(yaml.getValue("list_fg").toString());
                list_focus = Utils.hexToColor(yaml.getValue("list_focus").toString());
                scrollbar = Utils.hexToColor(yaml.getValue("scrollbar").toString());
                progress_bar = Utils.hexToColor(yaml.getValue("progress_bar").toString());
                extra_0 = Utils.hexToColor(yaml.getValue("extra_0").toString());
                extra_1 = Utils.hexToColor(yaml.getValue("extra_1").toString());
                extra_2 = Utils.hexToColor(yaml.getValue("extra_2").toString());
                extra_3 = Utils.hexToColor(yaml.getValue("extra_3").toString());
                extra_4 = Utils.hexToColor(yaml.getValue("extra_4").toString());
                extra_5 = Utils.hexToColor(yaml.getValue("extra_5").toString());
                extra_6 = Utils.hexToColor(yaml.getValue("extra_6").toString());
                extra_7 = Utils.hexToColor(yaml.getValue("extra_7").toString());
                extra_8 = Utils.hexToColor(yaml.getValue("extra_8").toString());
                extra_9 = Utils.hexToColor(yaml.getValue("extra_9").toString());

                extras = new Color[]{extra_0, extra_1, extra_2, extra_3, extra_4, extra_5, extra_6, extra_7, extra_8, extra_9};

                this.yaml = yaml;
        }

        public void parseJson(JsonString jsonString) {
                String newJson = jsonString.getJson().replaceAll(",", ", ");

                name = Utils.getJsonValue(newJson, "name").replaceAll("\"", "");
                bg = Utils.hexToColor(Utils.getJsonValue(newJson, "bg").replaceAll("\"", ""));
                fg = Utils.hexToColor(Utils.getJsonValue(newJson, "fg").replaceAll("\"", ""));
                bg_2 = Utils.hexToColor(Utils.getJsonValue(newJson, "bg_2").replaceAll("\"", ""));
                fg_2 = Utils.hexToColor(Utils.getJsonValue(newJson, "fg_2").replaceAll("\"", ""));
                btn = Utils.hexToColor(Utils.getJsonValue(newJson, "btn").replaceAll("\"", ""));
                btn_fg = Utils.hexToColor(Utils.getJsonValue(newJson, "btn_fg").replaceAll("\"", ""));
                textbox = Utils.hexToColor(Utils.getJsonValue(newJson, "textbox").replaceAll("\"", ""));
                textbox_fg = Utils.hexToColor(Utils.getJsonValue(newJson, "textbox_fg").replaceAll("\"", ""));
                list = Utils.hexToColor(Utils.getJsonValue(newJson, "list").replaceAll("\"", ""));
                list_fg = Utils.hexToColor(Utils.getJsonValue(newJson, "list_fg").replaceAll("\"", ""));
                list_focus = Utils.hexToColor(Utils.getJsonValue(newJson, "list_focus").replaceAll("\"", ""));
                scrollbar = Utils.hexToColor(Utils.getJsonValue(newJson, "scrollbar").replaceAll("\"", ""));
                progress_bar = Utils.hexToColor(Utils.getJsonValue(newJson, "progress_bar").replaceAll("\"", ""));
                extra_0 = Utils.hexToColor(Utils.getJsonValue(newJson, "extra_0").replaceAll("\"", ""));
                extra_1 = Utils.hexToColor(Utils.getJsonValue(newJson, "extra_1").replaceAll("\"", ""));
                extra_2 = Utils.hexToColor(Utils.getJsonValue(newJson, "extra_2").replaceAll("\"", ""));
                extra_3 = Utils.hexToColor(Utils.getJsonValue(newJson, "extra_3").replaceAll("\"", ""));
                extra_4 = Utils.hexToColor(Utils.getJsonValue(newJson, "extra_4").replaceAll("\"", ""));
                extra_5 = Utils.hexToColor(Utils.getJsonValue(newJson, "extra_5").replaceAll("\"", ""));
                extra_6 = Utils.hexToColor(Utils.getJsonValue(newJson, "extra_6").replaceAll("\"", ""));
                extra_7 = Utils.hexToColor(Utils.getJsonValue(newJson, "extra_7").replaceAll("\"", ""));
                extra_8 = Utils.hexToColor(Utils.getJsonValue(newJson, "extra_8").replaceAll("\"", ""));
                extra_9 = Utils.hexToColor(Utils.getJsonValue(newJson, "extra_9").replaceAll("\"", ""));

                extras = new Color[]{extra_0, extra_1, extra_2, extra_3, extra_4, extra_5, extra_6, extra_7, extra_8, extra_9};

                this.json = newJson;
        }

        public YamlFile generateYaml(String target_dir) throws FileNotFoundException {
                try ( PrintWriter writer = new PrintWriter(new File(target_dir))) {
                        writer.write("name: " + name);
                        writer.write("\n");
                        writer.write("bg: \"" + Utils.ColorToHex(bg) + "\"");
                        writer.write("\n");
                        writer.write("fg: \"" + Utils.ColorToHex(fg) + "\"");
                        writer.write("\n");
                        writer.write("bg_2: \"" + Utils.ColorToHex(bg_2) + "\"");
                        writer.write("\n");
                        writer.write("fg_2: \"" + Utils.ColorToHex(fg_2) + "\"");
                        writer.write("\n");
                        writer.write("btn: \"" + Utils.ColorToHex(btn) + "\"");
                        writer.write("\n");
                        writer.write("btn_fg: \"" + Utils.ColorToHex(btn_fg) + "\"");
                        writer.write("\n");
                        writer.write("textbox: \"" + Utils.ColorToHex(textbox) + "\"");
                        writer.write("\n");
                        writer.write("textbox_fg: \"" + Utils.ColorToHex(textbox_fg) + "\"");
                        writer.write("\n");
                        writer.write("list: \"" + Utils.ColorToHex(list) + "\"");
                        writer.write("\n");
                        writer.write("list_fg: \"" + Utils.ColorToHex(list_fg) + "\"");
                        writer.write("\n");
                        writer.write("list_focus: \"" + Utils.ColorToHex(list_focus) + "\"");
                        writer.write("\n");
                        writer.write("scrollbar: \"" + Utils.ColorToHex(scrollbar) + "\"");
                        writer.write("\n");
                        writer.write("progress_bar: \"" + Utils.ColorToHex(progress_bar) + "\"");
                        writer.write("\n");
                        writer.write("extra_0: \"" + Utils.ColorToHex(extra_0) + "\"");
                        writer.write("\n");
                        writer.write("extra_1: \"" + Utils.ColorToHex(extra_1) + "\"");
                        writer.write("\n");
                        writer.write("extra_2: \"" + Utils.ColorToHex(extra_2) + "\"");
                        writer.write("\n");
                        writer.write("extra_3: \"" + Utils.ColorToHex(extra_3) + "\"");
                        writer.write("\n");
                        writer.write("extra_4: \"" + Utils.ColorToHex(extra_4) + "\"");
                        writer.write("\n");
                        writer.write("extra_5: \"" + Utils.ColorToHex(extra_5) + "\"");
                        writer.write("\n");
                        writer.write("extra_6: \"" + Utils.ColorToHex(extra_6) + "\"");
                        writer.write("\n");
                        writer.write("extra_7: \"" + Utils.ColorToHex(extra_7) + "\"");
                        writer.write("\n");
                        writer.write("extra_8: \"" + Utils.ColorToHex(extra_8) + "\"");
                        writer.write("\n");
                        writer.write("extra_9: \"" + Utils.ColorToHex(extra_9) + "\"");
                        writer.write("\n");
                }

                return new YamlFile(target_dir);
        }

        public JsonString generateJson() {
                JSONObject jsonObject = new JSONObject();

                jsonObject.put("name", name);
                jsonObject.put("bg", Utils.ColorToHex(bg));
                jsonObject.put("fg", Utils.ColorToHex(fg));
                jsonObject.put("bg_2", Utils.ColorToHex(bg_2));
                jsonObject.put("fg_2", Utils.ColorToHex(fg_2));
                jsonObject.put("btn", Utils.ColorToHex(btn));
                jsonObject.put("btn_fg", Utils.ColorToHex(btn_fg));
                jsonObject.put("textbox", Utils.ColorToHex(textbox));
                jsonObject.put("textbox_fg", Utils.ColorToHex(textbox_fg));
                jsonObject.put("list", Utils.ColorToHex(list));
                jsonObject.put("list_fg", Utils.ColorToHex(list_fg));
                jsonObject.put("scrollbar", Utils.ColorToHex(scrollbar));
                jsonObject.put("progress_bar", Utils.ColorToHex(progress_bar));
                jsonObject.put("extra_0", Utils.ColorToHex(extra_0));
                jsonObject.put("extra_1", Utils.ColorToHex(extra_1));
                jsonObject.put("extra_2", Utils.ColorToHex(extra_2));
                jsonObject.put("extra_3", Utils.ColorToHex(extra_3));
                jsonObject.put("extra_4", Utils.ColorToHex(extra_4));
                jsonObject.put("extra_5", Utils.ColorToHex(extra_5));
                jsonObject.put("extra_6", Utils.ColorToHex(extra_6));
                jsonObject.put("extra_7", Utils.ColorToHex(extra_7));
                jsonObject.put("extra_8", Utils.ColorToHex(extra_8));
                jsonObject.put("extra_9", Utils.ColorToHex(extra_9));

                return new JsonString(jsonObject.toString());
        }

        private class Utils {

                static Color hexToColor(String hex) {
                        hex = "#" + hex;
                        return Color.decode(hex);
                }

                static String ColorToHex(Color c) {
                        return String.format("%02x%02x%02x", c.getRed(), c.getGreen(), c.getBlue());
                }

                static String getJsonValue(String JsonString, String tag) {
                        tag = "\"" + tag + "\"";
                        int tagIndex = JsonString.indexOf(tag);

                        if (tagIndex == -1) {
                                return null;
                        }

                        int begin = tagIndex + tag.length() + 2; // "+2" For space and comma
                        int end = JsonString.indexOf(',', begin);

                        if (end == -1) {
                                end = JsonString.indexOf('}', begin);
                        }

                        String value = JsonString.substring(begin, end);
                        return value.replaceAll("\\]", "").replaceAll("\\[", "").replaceAll("\\}", "").replaceAll("\n", "").strip();
                }

        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getJson() {
                return json;
        }

        public void setJson(String json) {
                this.json = json;
        }

        public YamlFile getYaml() {
                return yaml;
        }

        public void setYaml(YamlFile yaml) {
                this.yaml = yaml;
        }

        public Color getBg() {
                return bg;
        }

        public void setBg(Color bg) {
                this.bg = bg;
        }

        public Color getBg_2() {
                return bg_2;
        }

        public void setBg_2(Color bg_2) {
                this.bg_2 = bg_2;
        }

        public Color getFg() {
                return fg;
        }

        public void setFg(Color fg) {
                this.fg = fg;
        }

        public Color getFg_2() {
                return fg_2;
        }

        public void setFg_2(Color fg_2) {
                this.fg_2 = fg_2;
        }

        public Color getBtn() {
                return btn;
        }

        public void setBtn(Color btn) {
                this.btn = btn;
        }

        public Color getBtn_fg() {
                return btn_fg;
        }

        public void setBtn_fg(Color btn_fg) {
                this.btn_fg = btn_fg;
        }

        public Color getTextbox() {
                return textbox;
        }

        public void setTextbox(Color textbox) {
                this.textbox = textbox;
        }

        public Color getTextbox_fg() {
                return textbox_fg;
        }

        public void setTextbox_fg(Color textbox_fg) {
                this.textbox_fg = textbox_fg;
        }

        public Color getList() {
                return list;
        }

        public void setList(Color list) {
                this.list = list;
        }

        public Color getList_fg() {
                return list_fg;
        }

        public void setList_fg(Color list_fg) {
                this.list_fg = list_fg;
        }

        public Color getList_focus() {
                return list_focus;
        }

        public void setList_focus(Color list_focus) {
                this.list_focus = list_focus;
        }
        
        public Color getScrollbar() {
                return scrollbar;
        }

        public void setScrollbar(Color scrollbar) {
                this.scrollbar = scrollbar;
        }

        public Color getProgress_bar() {
                return progress_bar;
        }

        public void setProgress_bar(Color progress_bar) {
                this.progress_bar = progress_bar;
        }

        public Color[] getExtras() {
                return extras;
        }

        public void setExtras(Color[] extras) {
                this.extras = extras;
                extra_0 = extras[0];
                extra_1 = extras[1];
                extra_2 = extras[2];
                extra_3 = extras[3];
                extra_4 = extras[4];
                extra_5 = extras[5];
                extra_6 = extras[6];
                extra_7 = extras[7];
                extra_0 = extras[8];
                extra_9 = extras[9];
        }

        @Override
        public String toString() {
                String s = "";

                s = s + pair("Name", name);
                if (yaml != null) {
                        s = s + pair("YAML", yaml.getContents().toString());
                } else {
                        s = s + pair("YAML", null);
                }
                if (json != null) {
                        s = s + pair("JSON", json);
                } else {
                        s = s + pair("JSON", null);
                }

                return s;
        }

        private String pair(String key, String value) {
                return "" + key + ": " + value + "\n";
        }

}
