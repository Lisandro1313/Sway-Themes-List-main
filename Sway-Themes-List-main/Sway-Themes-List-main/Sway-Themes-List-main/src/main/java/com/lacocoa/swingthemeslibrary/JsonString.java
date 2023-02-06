
package com.kdesp.swaythemeslist;

/**
 *
 * @author Lacocoa
 */
public class JsonString {
        private String json;
        
        public JsonString(){
        }
        
        public JsonString(String json){
                this.json = json;
        }

        public String getJson() {
                return json;
        }

        public void setJson(String json) {
                this.json = json;
        }

        @Override
        public String toString() {
                return "JsonString{" + "json=" + json + '}';
        }
        
        
}
