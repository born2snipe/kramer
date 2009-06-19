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


public class IntFieldSizeResolverTest extends TestCase {
    private IntFieldSizeResolver resolver;

    protected void setUp() throws Exception {
        super.setUp();
        resolver = new IntFieldSizeResolver();
    }

    public void test_resolve() {
        assertEquals(1, resolver.resolveLength("1"));
        assertEquals(2, resolver.resolveLength(" 2 "));
    }

    public void test_isResolvable() {
        assertTrue(resolver.isResolvable("1"));
        assertFalse(resolver.isResolvable("1.1"));
        assertTrue(resolver.isResolvable(" 1 "));
    }

}
