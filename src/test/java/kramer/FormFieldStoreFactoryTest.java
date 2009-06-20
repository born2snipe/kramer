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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import java.util.Arrays;
import java.util.List;


public class FormFieldStoreFactoryTest extends TestCase {
    private FieldSizeFileReader fileReader;

    protected void setUp() throws Exception {
        super.setUp();
        fileReader = mock(FieldSizeFileReader.class);
    }

    public void test_build_MultipleForms() {
        List<File> files = Arrays.asList(new File("test.properties"));
        List<FormFields> fields = Arrays.asList(form(String.class), form(Integer.class));

        when(fileReader.read(files)).thenReturn(fields);

        FormFieldStore fieldStore = FormFieldStoreFactory.build(fileReader, files);

        assertNotNull(fieldStore);
        assertEquals(2, fieldStore.getNumberForms());
    }


    public void test_build_SingleForm() {
        List<File> files = Arrays.asList(new File("test.properties"));
        List<FormFields> fields = Arrays.asList(form(String.class));

        when(fileReader.read(files)).thenReturn(fields);

        FormFieldStore fieldStore = FormFieldStoreFactory.build(fileReader, files);

        assertNotNull(fieldStore);
        assertEquals(1, fieldStore.getNumberForms());
    }

    private FormFields form(Class<?> clazz) {
        FormFields fields = new FormFields();
        fields.setFormClass(clazz);
        return fields;
    }
}
