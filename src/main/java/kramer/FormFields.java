/**
 * Copyright to the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */
package kramer;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;


public class FormFields {
    private static final String COULD_NOT_FIND_FIELD = "Could not find length for field ({0}) on form {1}";
    private Class formClass;
    private Map<String, Integer> fields = new HashMap<String, Integer>();

    public void field(String name, int length) {
        fields.put(name, length);
    }

    public int lengthFor(String fieldName) {
        if (!hasField(fieldName)) {
            throw new IllegalArgumentException(MessageFormat.format(COULD_NOT_FIND_FIELD, fieldName, formClass.getName()));
        }
        return fields.get(fieldName);
    }

    public Class getFormClass() {
        return formClass;
    }

    public void setFormClass(Class clazz) {
        this.formClass = clazz;
    }

    public boolean hasField(String fieldName) {
        return fields.containsKey(fieldName);
    }
}
