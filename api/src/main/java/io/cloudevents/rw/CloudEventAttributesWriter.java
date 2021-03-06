/*
 * Copyright 2018-Present The CloudEvents Authors
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package io.cloudevents.rw;

import io.cloudevents.types.Time;

import java.net.URI;
import java.time.OffsetDateTime;

/**
 * Interface to write the attributes from a {@link io.cloudevents.rw.CloudEventReader} to a new representation.
 */
public interface CloudEventAttributesWriter {

    /**
     * Set attribute with type {@link String}. This setter should not be invoked for specversion, because the built Visitor already
     * has the information through the {@link CloudEventWriterFactory}.
     *
     * @param name
     * @param value
     * @throws CloudEventRWException
     */
    void setAttribute(String name, String value) throws CloudEventRWException;

    /**
     * Set attribute with type {@link URI}.
     *
     * @param name
     * @param value
     * @throws CloudEventRWException
     */
    default void setAttribute(String name, URI value) throws CloudEventRWException {
        setAttribute(name, value.toString());
    }

    /**
     * Set attribute with type {@link OffsetDateTime} attribute.
     *
     * @param name
     * @param value
     * @throws CloudEventRWException
     */
    default void setAttribute(String name, OffsetDateTime value) throws CloudEventRWException {
        setAttribute(name, Time.writeTime(value));
    }

}
