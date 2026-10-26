/*
 * Copyright © 2026 VenaNocta (venanocta@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jenkinsci.plugins.identifieddata.api;

import java.util.Comparator;

import edu.umd.cs.findbugs.annotations.CheckForNull;

public interface ReferenceableByName<T extends NamedRefUUID> {

	public static final Comparator<ReferenceableByName<?>> COMPARE_BY_NAME = //
			new IdentifierUtils.NameComparator<ReferenceableByName<?>>(ReferenceableByName::getName);
	public static final Comparator<ReferenceableByName<?>> COMPARE_BY_NAME_WITH_COMMENTS = //
			new IdentifierUtils.NameComparatorWithComments<ReferenceableByName<?>>(ReferenceableByName::getName);

	@CheckForNull
	public String getName();

	public T toNamedRef();

	public static boolean noComment(final ReferenceableByName<?> o) {
		final String name = o.getName();
		return name == null ? false : !IdentifierUtils.isComment(name);
	}
}
