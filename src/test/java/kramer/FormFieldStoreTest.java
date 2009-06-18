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

import junit.framework.TestCase;


public class FormFieldStoreTest extends TestCase {
    private FormFieldStore store;
    private FormFields fields;

    protected void setUp() throws Exception {
        super.setUp();
        store = new FormFieldStore();
        fields = new FormFields();
        fields.setFormClass(Form.class);
        store.addFormFields(fields);
    }

    public void test_getLength_FormNotFound() {
        try {
            store.getLength(String.class, "doesNotMatter");
            fail();
        } catch (IllegalArgumentException err) {
            assertEquals("Could not find form (java.lang.String) in the FormFieldStore. Are you sure you created field definitions for that form?", err.getMessage());
        }
    }

    public void test_getLength_WithClass() {
        fields.field("field2", 4);

        assertEquals(4, store.getLength(Form.class, "field2"));
    }

    public void test_getLength_WithObject() {
        fields.field("field1", 3);

        assertEquals(3, store.getLength(new Form(), "field1"));
    }

    private class Form {
    }
}
