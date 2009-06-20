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
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;


public class SpringBeanTest extends TestCase {
    public void test() throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        Object obj = context.getBean("factory");
        assertNotNull(obj);
        assertTrue(obj instanceof FormFieldStore);

        FormFieldStore store = (FormFieldStore) obj;
        assertEquals(1, store.getNumberForms());
        assertEquals(10, store.getLength(new TestForm(), "firstName"));
        assertEquals(1, store.getLength(TestForm.class, "middleInitial"));
        assertEquals(50, store.getLength(TestForm.class, "lastName"));
    }

}
