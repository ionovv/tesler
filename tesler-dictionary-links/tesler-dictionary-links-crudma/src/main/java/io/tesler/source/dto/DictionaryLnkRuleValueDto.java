/*-
 * #%L
 * IO Tesler - Dictionary Links Implementation
 * %%
 * Copyright (C) 2018 - 2019 Tesler Contributors
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

package io.tesler.source.dto;

import static io.tesler.api.data.dictionary.DictionaryCache.dictionary;
import static io.tesler.core.util.filter.SearchParameterType.STRING;

import io.tesler.api.data.dto.DataResponseDTO;
import io.tesler.core.util.filter.SearchParameter;
import io.tesler.model.dictionary.links.entity.DictionaryLnkRuleValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DictionaryLnkRuleValueDto extends DataResponseDTO {

	@SearchParameter(type = STRING)
	private String value;

	@SearchParameter(type = STRING)
	private String valueCd;

	public DictionaryLnkRuleValueDto(DictionaryLnkRuleValue entity) {
		this.id = entity.getId().toString();
		this.valueCd = entity.getChildKey().getKey();
		this.value = dictionary().lookupValue(entity.getChildKey(), entity.getDictionaryLnkRule().getType());
	}

}
