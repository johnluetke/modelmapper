/**
 * Copyright 2011 the original author or authors.
 *
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
 */
package org.modelmapper.spi;

import org.modelmapper.Converter;

/**
 * Converter that converts supported source objects to instances of destination type {@code D}.
 * 
 * @param <S> source type
 * @param <D> destination type
 * @author Jonathan Halterman
 */
public interface ConditionalConverter<S, D> extends Converter<S, D> {
  /**
   * Indicates whether the Converter supports conversion from the {@code sourceType} to the
   * {@code destinationType}. Implementors should only return true for source and destination types
   * that satisfy {@code S} and {@code D}.
   * 
   * <p>
   * For implementations that are not concerned with generic type information, support for the
   * conditional converter can be checked simply by examining the {@code sourceType} and
   * {@code destinationType}.
   * 
   * @param sourceType to match
   * @param genericSourceType from which generic type information can be retrieved
   * @param destinationType to match
   * @param genericDestinationType from which generic type information can be retrieved resolved
   * @return true if conversion is supported, else false
   */
  boolean supports(Class<?> sourceType, Class<?> destinationType);

  /**
   * Returns whether the Converter verifies the source type when
   * {@link ConditionalConverter#supports(Class, Class) supports} is called.
   */
  //boolean verifiesSource();
}
