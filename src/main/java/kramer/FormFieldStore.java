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


public class FormFieldStore {
    private static final String COULD_NOT_FIND_FORM = "Could not find form ({0}) in the FormFieldStore. Are you sure you created field definitions for that form?";
    private Map<Class, FormFields> forms = new HashMap<Class, FormFields>();

    public int getLength(Object form, String fieldName) {
        return getLength(form.getClass(), fieldName);
    }

    public int getLength(Class formClass, String fieldName) {
        if (!forms.containsKey(formClass)) {
            throw new IllegalArgumentException(MessageFormat.format(COULD_NOT_FIND_FORM, formClass.getName()));
        }
        return forms.get(formClass).lengthFor(fieldName);
    }

    public void addFormFields(FormFields fields) {
        forms.put(fields.getFormClass(), fields);
    }
}
