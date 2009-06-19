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


public class FormFieldsTest extends TestCase {
    private FormFields fields;

    protected void setUp() throws Exception {
        super.setUp();
        fields = new FormFields();
        fields.setFormClass(String.class);
    }

    public void test_lengthFor_FieldExists() {
        fields.field("field", 2);

        assertEquals(2, fields.lengthFor("field"));
    }

    public void test_lengthFor_FieldDoesNotExist() {
        try {
            fields.lengthFor("field");
            fail();
        } catch (IllegalArgumentException err) {
            assertEquals("Could not find length for field (field) on form java.lang.String", err.getMessage());
        }
    }


}
